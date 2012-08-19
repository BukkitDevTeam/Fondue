package com.md_5.fondue;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class LanServerPingThread extends Thread {

    private final DatagramSocket socket;

    public LanServerPingThread() throws IOException {
        super("Lan Server Ping Thread");
        this.setDaemon(true);
        socket = new DatagramSocket();
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                byte[] broadcast = ("[MOTD]" + "Fondue Test Server" + "[/MOTD][AD]" + "127.0.0.1:25565" + "[/AD]").getBytes();

                InetAddress broadcastAddr = InetAddress.getByName("224.0.2.60");
                DatagramPacket packet = new DatagramPacket(broadcast, broadcast.length, broadcastAddr, 4445);

                socket.send(packet);
            } catch (IOException ex) {
                System.err.println("LanServerPinger aborted " + ex.getMessage());
                break;
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
            }
        }
    }
}
