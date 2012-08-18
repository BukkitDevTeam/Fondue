package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import static org.junit.Assert.*;
import org.junit.Test;

public class PacketTest {

    /**
     * Check packets for the default Java toString
     */
    @Test
    public void testToString() {
        for (int i = 0; i < 256; i++) {
            Packet packet = Packet.newInstance(i);
            if (packet != null) {
                assertFalse(packet.toString().contains("@"));
            }
        }
    }

    /**
     * Check packets for the default Java hashCode
     */
    @Test
    public void testHashCode() {
        for (int i = 0; i < 256; i++) {
            Packet packet = Packet.newInstance(i);
            if (packet != null) {
                assertFalse(packet.hashCode() == System.identityHashCode(packet));
            }
        }
    }

    /**
     * Check packets for the default Java equals
     */
    @Test
    public void testEquals() {
        for (int i = 0; i < 256; i++) {
            Packet packet = Packet.newInstance(i);
            if (packet != null) {
                assertTrue(packet.equals(Packet.newInstance(i)));
            }
        }
    }

    /**
     * Checks that Strings are encoded and decoded correctly
     */
    @Test
    public void testStrings() {
        ByteBuf buf = Unpooled.dynamicBuffer();
        String test = "Hello World";
        Packet.writeString(buf, test);
        assertTrue(Packet.readString(buf).equals(test));
    }
}
