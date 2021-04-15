package com.jpeony.netty.client;

import com.jpeony.protobuf.Command;
import com.jpeony.protobuf.Message;

public class MessageDataBuilder {
    public static Message.MessageData.Builder createGoData(String clientId, Command.CommandType commandType, String data) {
        Message.MessageData.Builder msgData = Message.MessageData.newBuilder();
        msgData.setType(Message.MessageData.DataType.MessageGo);
        Message.MessageGo messageGo = Message.MessageGo.newBuilder().setClientId(clientId).setCmd(commandType).setLon("1111").setLat("22222").build();
        msgData.setMessageGo(messageGo);
        return msgData;
    }

    public static Message.MessageData.Builder createData(String clientId, Command.CommandType commandType, String data) {
        Message.MessageData.Builder msgData = Message.MessageData.newBuilder();
        msgData.setType(Message.MessageData.DataType.MessageBase);
        Message.MessageBase messageBase = Message.MessageBase.newBuilder().setClientId(clientId).setCmd(commandType).setData(data).build();
        msgData.setMessageBase(messageBase);
        return msgData;
    }

    public static Message.MessageData.Builder createGeneralBizData(String clientId, Command.CommandType commandType, String data) {
        if (data == null) {
            data = "";
        }
        Message.MessageData.Builder msgData = Message.MessageData.newBuilder();
        msgData.setType(Message.MessageData.DataType.MessageGeneralBiz);
        Message.MessageGeneralBiz messageGeneralBiz = Message.MessageGeneralBiz.newBuilder().setClientId(clientId).setCmd(commandType).setData(data).build();
        msgData.setMessageGeneralBiz(messageGeneralBiz);
        return msgData;
    }

    public static Object serverResponse = null;
}
