package com.md_5.fondue.protocol;

import com.md_5.fondue.protocol.packet.Packet0KeepAlive;
import com.md_5.fondue.protocol.packet.Packet10HeldItem;
import com.md_5.fondue.protocol.packet.Packet12Animation;
import com.md_5.fondue.protocol.packet.Packet13EntityAction;
import com.md_5.fondue.protocol.packet.Packet2Handshake;
import com.md_5.fondue.protocol.packet.Packet3ChatMessage;
import com.md_5.fondue.protocol.packet.Packet6AConfirmTransaction;
import com.md_5.fondue.protocol.packet.Packet6CEnchantItem;
import com.md_5.fondue.protocol.packet.Packet7UseEntity;
import com.md_5.fondue.protocol.packet.Packet82UpdateSign;
import com.md_5.fondue.protocol.packet.PacketAFlying;
import com.md_5.fondue.protocol.packet.PacketCAPlayerAbilities;
import com.md_5.fondue.protocol.packet.PacketCBTabComplete;
import com.md_5.fondue.protocol.packet.PacketCCClientInfo;
import com.md_5.fondue.protocol.packet.PacketCDClientStatus;
import com.md_5.fondue.protocol.packet.PacketEDig;
import com.md_5.fondue.protocol.packet.PacketFAPluginMessage;
import com.md_5.fondue.protocol.packet.PacketFCKeyResponse;
import com.md_5.fondue.protocol.packet.PacketFEServerPing;
import com.md_5.fondue.protocol.packet.PacketFFDisconnect;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class PacketHandler {

    /**
     * Method to determine whether this is a server handler, client handler or
     * other.
     *
     * @return the type of method interface this handler should accept
     */
    public abstract Class<? extends Annotation> getType();

    @Server
    public void handle(Packet0KeepAlive packet) {
    }

    @ServerLogin
    public void handle(Packet2Handshake packet) {
    }

    @Server
    public void handle(Packet3ChatMessage packet) {
    }

    @Server
    public void handle(Packet7UseEntity packet) {
    }

    @Server
    public void handle(PacketAFlying packet) {
    }

    @Server
    public void handle(PacketEDig packet) {
    }
    // @Server
    // public  void handle(PacketFPlace packet){}

    @Server
    public void handle(Packet10HeldItem packet) {
    }

    @Server
    public void handle(Packet12Animation packet) {
    }

    @Server
    public void handle(Packet13EntityAction packet) {
    }
    // @Server
    // public  void handle(Packet66WindowClick packet){}

    @Server
    public void handle(Packet6AConfirmTransaction packet) {
    }

    @Server
    public void handle(Packet6CEnchantItem packet) {
    }

    @Server
    public void handle(Packet82UpdateSign packet) {
    }

    // @Server
    // public  void handle(Packet6BSlot);
    @Server
    public void handle(PacketCAPlayerAbilities packet) {
    }

    @Server
    public void handle(PacketCBTabComplete packet) {
    }

    @Server
    public void handle(PacketCCClientInfo packet) {
    }

    @Server
    @ServerLogin
    public void handle(PacketCDClientStatus packet) {
    }

    @Server
    public void handle(PacketFAPluginMessage packet) {
    }

    @ServerLogin
    public void handle(PacketFCKeyResponse packet) {
    }

    @ServerLogin
    public void handle(PacketFEServerPing packet) {
    }

    @Server
    public void handle(PacketFFDisconnect packet) {
    }

    /**
     * Methods denoted by this annotation should be handled by a server
     * implementation of this class
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Server {
    }

    /**
     * Methods denoted by this annotation should be handled by the initial
     * server implementation of this class.
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface ServerLogin {
    }

    /**
     * Methods denoted by this method annotation be handled by a client
     * implementation of this class
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Client {
    }
}
