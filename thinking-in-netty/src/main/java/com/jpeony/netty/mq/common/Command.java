package com.jpeony.netty.mq.common;

/**
 * @author yihonglei
 */
public class Command {
    /**
     * 验证
     */
    public static final int AUTH = 1;

    /**
     * ping
     */
    public static final int PING = 2;

    /**
     * pong
     */
    public static final int PONG = 3;

    /**
     * 上传数据
     */
    public static final int UPLOAD_DATA = 4;

    /**
     * 推送数据
     */
    public static final int PUSH_DATA = 5;

    /**
     * 验证返回
     */
    public static final int AUTH_BACK = 11;

    /**
     * 上传数据返回值
     */
    public static final int UPLOAD_DATA_BACK = 14;

    /**
     * 指令下发返回值
     */
    public static final int PUSH_DATA_BACK = 15;

    /**
     * 上行数据：PATH,//lon1,lat1;lon2,lat2;lon3,lat3;
     */
    public static final int PATH = 21;

    /**
     * 下行指令：如双闪-DOUBLE_FLASH，鸣笛-WHISTLE，解锁-UNLOCK，开门-OPEN_DOOR，改变服务端IP-CHANGE_IP
     */
    public static final int DOUBLE_FLASH = 31;

    public static final int WHISTLE = 32;

    public static final int UNLOCK = 33;

    public static final int OPEN_DOOR = 34;

    /**
     * 断线重连
     */
    public static final int RE_CONNECT = 100;
}
