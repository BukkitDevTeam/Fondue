package com.md_5.fondue.protocol;

import com.md_5.fondue.protocol.packet.Packet0KeepAlive;
import com.md_5.fondue.protocol.packet.Packet10HeldItem;
import com.md_5.fondue.protocol.packet.Packet12Animation;
import com.md_5.fondue.protocol.packet.Packet13EntityAction;
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
import com.md_5.fondue.protocol.packet.PacketFFDisconnect;
import java.lang.annotation.Annotation;

public class ServerHandler extends PacketHandler {

    @Override
    public Class<? extends Annotation> getType() {
        return Server.class;
    }

    @Override
    public void handle(Packet0KeepAlive packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet3ChatMessage packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet7UseEntity packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketAFlying packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketEDig packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet10HeldItem packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet12Animation packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet13EntityAction packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet6AConfirmTransaction packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet6CEnchantItem packet) {
        super.handle(packet);
    }

    @Override
    public void handle(Packet82UpdateSign packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketCAPlayerAbilities packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketCBTabComplete packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketCCClientInfo packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketCDClientStatus packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketFAPluginMessage packet) {
        super.handle(packet);
    }

    @Override
    public void handle(PacketFFDisconnect packet) {
        super.handle(packet);
    }
}
