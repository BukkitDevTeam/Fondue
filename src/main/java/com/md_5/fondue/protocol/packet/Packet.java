package com.md_5.fondue.protocol.packet;

import gnu.trove.map.hash.TObjectIntHashMap;
import io.netty.buffer.ByteBuf;
import org.apache.commons.lang3.Validate;

public abstract class Packet {

    private static final Class[] byId = new Class[256];
    private static final TObjectIntHashMap<Class<? extends Packet>> byClass = new TObjectIntHashMap<Class<? extends Packet>>();
    private int id = -1;

    /**
     * Adds a new packet class to the known packet collections
     *
     * @param id of the packet to add
     * @param clazz of the packet
     */
    private static void addMapping(int id, Class<? extends Packet> clazz) {
        Validate.isTrue(byId[id] == null, "Packet with id 0x" + Integer.toHexString(id) + " already registered");
        Validate.isTrue(!byClass.containsKey(clazz), "Class " + clazz.getName() + " already registered");

        byId[id] = clazz;
        byClass.put(clazz, id);
    }

    /**
     * Constructs a new, empty packet based on the supplied id.
     *
     * @param id of the packet to construct
     * @return the constructed packet or null if unable to construct one
     */
    public static Packet newInstance(int id) {
        try {
            Class clazz = byId[id];
            return clazz == null ? null : (Packet) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Skipping packet with id 0x" + Integer.toHexString(id));
            return null;
        }
    }

    /**
     * @return this packet's id
     */
    public final int getId() {
        if (id == -1) {
            id = byClass.get(getClass());
        }
        return id;
    }

    /**
     * Populates the fields in this packet by reading them from the specified
     * {@link ByteBuf}
     *
     * @param in the ByteBuf to read from
     */
    public abstract void read(ByteBuf in);

    /**
     * Writes the fields in this packet to the specified {@link ByteBuf}.
     *
     * @param out the ByteBuf to write into
     */
    public abstract void write(ByteBuf out);

    /**
     * Writes the specified String, encoded in the Minecraft String format.
     *
     * @param out the ByteBuf to write into
     * @param str the String to write
     */
    public static void writeString(ByteBuf out, String str) {
        Validate.isTrue(str.length() < Short.MAX_VALUE, "String length too long!");

        out.writeShort(str.length());
        for (char c : str.toCharArray()) {
            out.writeChar(c);
        }
    }

    /**
     * Reads a String from the specified {@link ByteBuf}
     *
     * @param in the ByteBuf to read from
     * @return the read String
     */
    public static String readString(ByteBuf in) {
        short len = in.readShort();
        Validate.isTrue(len > 0, "String length less than 0, weird String!");

        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = in.readChar();
        }
        return new String(chars);
    }

    /**
     * Register all known packets
     */
    static {
        addMapping(0x02, Packet2Handshake.class);
        addMapping(0xFE, PacketFEServerPing.class);
        addMapping(0xFF, PacketFFDisconnect.class);
    }
}
