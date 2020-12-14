package com.jpeony.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbitmq配置类（队列声明，绑定交换机）
 *
 * @author yihonglei
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * ====== 直接交换机 ======
     */
    @Bean
    public DirectExchange jpeonyDirectExchange() {
        // 参数 durable:表示消息是否可持久化
        // autoDelete:表示若没有队列和此交换机绑定 就直接删除该交换机
        return new DirectExchange("jpeonyDirectExchange", true, false);
    }

    @Bean
    public Queue jpeonyDirectQueue() {
        return new Queue("jpeonyDirectQueue", true, false, false);
    }

    @Bean
    public Binding jpeonyDq2De() {
        return BindingBuilder.bind(jpeonyDirectQueue()).to(jpeonyDirectExchange()).with("jpeony.directkey");
    }

    /**
     * ====== 扇形交换机 ======
     */
    @Bean
    public FanoutExchange jpeonyFanoutExchange() {
        return new FanoutExchange("jpeonyFanoutExchange", true, false);
    }

    @Bean
    public Queue jpeonyfanoutQueue1() {
        return new Queue("jpeonyFanoutQueue1", true, false, false);
    }

    @Bean
    public Queue jpeonyfanoutQueue2() {
        return new Queue("jpeonyFanoutQueue2", true, false, false);
    }

    @Bean
    public Binding jpeonyBind1() {
        return BindingBuilder.bind(jpeonyfanoutQueue1()).to(jpeonyFanoutExchange());

    }

    @Bean
    public Binding jpeonyBind2() {
        return BindingBuilder.bind(jpeonyfanoutQueue2()).to(jpeonyFanoutExchange());
    }

    /**
     * ====== 主题交换机 ======
     */
    @Bean
    public TopicExchange jpeonyTopicExchange() {
        return new TopicExchange("jpeonyTopicExchange", true, false);
    }

    @Bean
    public Queue jpeonyTopicQueue() {
        return new Queue("jpeonyTopicQueue", true, false, false);
    }

    @Bean
    public Queue jpeonyTopicQueue2() {
        return new Queue("jpeonyTopicQueue2", true, false, false);
    }

    @Bean
    public Binding topicBind1() {
        return BindingBuilder.bind(jpeonyTopicQueue()).to(jpeonyTopicExchange()).with("topic.key.#");

    }

    @Bean
    public Binding topicBind2() {
        return BindingBuilder.bind(jpeonyTopicQueue2()).to(jpeonyTopicExchange()).with("#.key");

    }

}
