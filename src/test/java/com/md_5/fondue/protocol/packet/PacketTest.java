package com.md_5.fondue.protocol.packet;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.Arrays;
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
                assertFalse("Packet 0x" + Integer.toHexString(i) + "( " + packet.getClass().getSimpleName() + ") does not properly override equals()", packet.toString().contains("@"));
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
                assertFalse("Packet 0x" + Integer.toHexString(i) + "( " + packet.getClass().getSimpleName() + ") does not properly override hashCode()", packet.hashCode() == System.identityHashCode(packet));
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
                assertTrue("Packet 0x" + Integer.toHexString(i) + "( " + packet.getClass().getSimpleName() + ") does not properly override hashCode()", packet.equals(Packet.newInstance(i)));
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

    /**
     * Checks that byte arrays are encoded and decoded correctly
     */
    @Test
    public void testBytes() {
        ByteBuf buf = Unpooled.dynamicBuffer();
        byte[] test = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Packet.writeBytes(buf, test);
        assertTrue(null, Arrays.equals(Packet.readBytes(buf), test));
    }
}
