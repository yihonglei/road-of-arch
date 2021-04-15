package com.jpeony.ipc.udp.server;

public class UDPServerStart {
    private void start() {
        try {
            ChineseProverbServer chineseProverbServer = new ChineseProverbServer();
            chineseProverbServer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
