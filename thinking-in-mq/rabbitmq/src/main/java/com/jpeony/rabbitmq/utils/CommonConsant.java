package com.jpeony.rabbitmq.utils;

/**
 * 常量
 * @author yihonglei
 * @date 2018/12/18 11:11
 */
public class CommonConsant {
    // ===================== 简单队列 =====================
    // 简单消息队列名称
    public final static String SIMPLE_QUEUE_NAME = "test-simple-queue";

    // ===================== 工作队列 =====================
    // 工作队列消息队列名称
    public final static String WORK_QUEUE_NAME = "test-work-queue";

    // ===================== S/P发布订阅模式-fanout(不处理路由键) =====================
    // 交换机名称
    public final static String EXCHANGE_NAME_FANOUT = "test-exchange-fanout";

    // 邮件队列名称
    public final static String EXCHANGE_NAME_FANOUT_EMAIL = "test-queue-email";

    // 短信队列名称
    public final static String EXCHANGE_NAME_FANOUT_SMS = "test-queue-sms";

    // ===================== Routing路由模式-direct（处理路由键） =====================
    // 交换机名称
    public final static String EXCHANGE_NAME_DIRECT = "test-exchange-direct";

    // 路由队列1
    public final static String DIRECT_QUEUE1_NAME = "test-queue-direct1";

    // 路由队列2
    public final static String DIRECT_QUEUE2_NAME = "test-queue-direct2";

    // RountingKey-error,info,warning
    public final static String ROUNTING_KEY_ERROR = "error";
    public final static String ROUNTING_KEY_INFO = "info";
    public final static String ROUNTING_KEY_WARNING = "warning";

    // ===================== Topic模式 =====================
    // 交换机名称
    public final static String EXCHANGE_NAME_TOPIC = "test-exchange-topic";

    // 路由队列1
    public final static String TOPIC_QUEUE1_NAME = "test-queue-topic1";

    // 路由队列2
    public final static String TOPIC_QUEUE2_NAME = "test-queue-topic2";

    // Topic-bidding-key
    public final static String TOPIC_KEY_GOODS_ADD = "goods.add";

    public final static String TOPIC_KEY_GOODS_ANY = "goods.#";

    // ===================== 消息确认机制 =====================
    public final static String TX_QUEUE_NAME = "test-queue-tx";
}
