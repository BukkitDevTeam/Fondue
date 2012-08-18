package com.md_5.fondue.protocol.packet;

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
}
