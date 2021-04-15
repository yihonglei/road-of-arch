package com.jpeony.netty.client.handler;

import com.jpeony.ipc.udp.client.ChineseProverbClient;
import com.jpeony.netty.client.MessageDataBuilder;
import com.jpeony.netty.client.heart.NettyClient;
import com.jpeony.protobuf.Command;
import com.jpeony.protobuf.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import redis.clients.jedis.Protocol;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HeartHandler extends SimpleChannelInboundHandler<Message.MessageData> {
    public Logger log = LoggerFactory.getLogger(getClass());

    private final DateFormat sf = new SimpleDateFormat("HH:mm:ss");

    private NettyClient nettyClient;

    private int heartbeatCount = 0;

    public static final String CLIENTID = System.getProperty("spring.netty.clientId", "10010001");

    private long ccTime = 0L;

    private static final int MAX_UN_REC_PONG_TIMES = 3;

    private static final int WRITE_WAIT_SECONDS = 5;

    private static final int RE_CONN_WAIT_SECONDS = 5;

    private int unRecPongTimes = 0;

    public HeartHandler(NettyClient nettyClient) {
        this.nettyClient = nettyClient;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String type = "";
            if (event.state() == IdleState.READER_IDLE) {
                type = "read idle";
            } else if (event.state() == IdleState.WRITER_IDLE) {
                type = "write idle";
            } else if (event.state() == IdleState.ALL_IDLE) {
                type = "all idle";
            }
            if (this.unRecPongTimes < 3) {
                sendPingMsg(ctx, CLIENTID);
                this.unRecPongTimes++;
            } else {
                ctx.channel().close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    protected void sendPingMsg(ChannelHandlerContext context, String client) {
        this.heartbeatCount++;
        this.ccTime = System.currentTimeMillis();
        context.writeAndFlush(
                MessageDataBuilder.createData(client, Command.CommandType.PING, String.valueOf(this.ccTime)).build());
    }

    public static Long getmicTime() {
        Long cutime = Long.valueOf(System.currentTimeMillis() * 1000L);
        Long nanoTime = Long.valueOf(System.nanoTime());
        return Long.valueOf(cutime.longValue() + (nanoTime.longValue() - nanoTime.longValue() / 1000000L * 1000000L) / 1000L);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        this.log.info("检测到心跳服务器断开！！！准备新建连接。ip={}, port={}", NettyClient.HOST, Integer.valueOf(NettyClient.PORT));
        EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(() -> this.nettyClient.doConnect(new Bootstrap(), (EventLoopGroup) eventLoop), 10L, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message.MessageData msgData) throws Exception {
        if (msgData.getType() == Message.MessageData.DataType.MessageBase) {
            Message.MessageBase msg = msgData.getMessageBase();
            if (msg.getCmd().equals(Command.CommandType.AUTH_BACK)) {
                this.log.info(msg.getData());
                ctx.writeAndFlush(
                        MessageDataBuilder.createData(CLIENTID, Command.CommandType.PUSH_DATA, "发送业务数据中。。。").build());
            } else if (msg.getCmd().equals(Command.CommandType.PING)) {
                this.log.info(msg.getData());
            } else if (msg.getCmd().equals(Command.CommandType.PONG)) {
                this.unRecPongTimes = 0;
                long ping = (System.currentTimeMillis() - this.ccTime) / 2L;
                this.log.info("客户端和服务器的ping是" + ping + "ms");
            } else if (msg.getCmd().equals(Command.CommandType.PUSH_DATA)) {
                this.log.info("接收到server推送数据PUSH_DATA: {}", msg.getData());
            } else if (msg.getCmd().equals(Command.CommandType.PUSH_DATA_BACK)) {
                this.log.info(msg.getData());
            } else if (msg.getCmd().equals(Command.CommandType.UPLOAD_DATA_BACK)) {
                this.log.info(msg.getData());
            } else {
                this.log.info(msg.getData());
            }
        } else if (msgData.getType() == Message.MessageData.DataType.MessageGo) {
            this.log.info("开始调用ipc系统，执行go指令 message: {}", msgData.toString());
            (new ChineseProverbClient()).run(msgData);
        } else if (msgData.getType() == Message.MessageData.DataType.MessageGeneralBiz) {
            this.log.info("开始调用ipc系统，message: {}", msgData.toString());
            Message.MessageGeneralBiz messageGeneralBiz = msgData.getMessageGeneralBiz();
            if (messageGeneralBiz.getCmd().equals(Command.CommandType.CHANGE_IP)) {
                this.log.info("开始执行CHANGE_IP指令");
                ctx.writeAndFlush(
                        MessageDataBuilder.createGeneralBizData(CLIENTID, Command.CommandType.PUSH_DATA_BACK, "change_ip success").build());
                this.log.info("CHANGE_IP指令已关闭原有连接........{}", ctx.channel());
                String ipport = messageGeneralBiz.getData();
                String[] split = StringUtils.split(ipport, ":");
                NettyClient.HOST = split[0];
                NettyClient.PORT = Integer.valueOf(split[1]).intValue();
                ctx.close();
            } else if (messageGeneralBiz.getCmd().equals(Command.CommandType.UPLOAD_DATA_BACK)) {
                this.log.info("接收到server推送数据UPLOAD_DATA_BACK: {}", messageGeneralBiz.getData());
                MessageDataBuilder.serverResponse = msgData;
            } else {
                (new ChineseProverbClient()).run(msgData);
            }
        } else {
            this.log.info("服务器数据类型未知.............");
        }
    }

    public static String get(String key) {
        ClassPathResource classPathResource = new ClassPathResource("application.properties");
        Properties props = null;
        String property = "";
        try {
            props = PropertiesLoaderUtils.loadProperties((Resource) classPathResource);
            property = props.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
