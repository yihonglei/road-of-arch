package com.jpeony.ipc.tcp.client;

import com.jpeony.netty.client.handler.HeartHandler;
import com.jpeony.protobuf.Command;
import com.jpeony.protobuf.Message;

public class ClientBrokerStart {
    public static void main(String[] args) {
        try {
            NettyBrokerClient nettyBrokerClient = new NettyBrokerClient();
            Message.MessageData.Builder messageGo = createMessageGo(HeartHandler.CLIENTID, "125.172691", "43.833252");
            nettyBrokerClient.run(messageGo.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Message.MessageData.Builder createMessageGo(String clientId, String lon, String lat) {
        Message.MessageData.Builder msgData = Message.MessageData.newBuilder();
        msgData.setType(Message.MessageData.DataType.MessageGo);
        Message.MessageGo messageGo = Message.MessageGo.newBuilder().setClientId(clientId).setCmd(Command.CommandType.PUSH_DATA).setLon(lon).setLat(lat).build();
        msgData.setMessageGo(messageGo);
        return msgData;
    }
}
