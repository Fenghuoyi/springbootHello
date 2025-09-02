package com.sun.springboothello;


import com.sun.springboothello.java.constants.MqConstants;
import com.sun.springboothello.java.entity.SendEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
@Slf4j
public class test {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    static AtomicInteger integer = new AtomicInteger(0);

    @Test
    public void testThread(){

        for(int i=1;i<=3;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    while(integer.get()<100){
                        System.out.println(Thread.currentThread().getName()+","+integer.getAndIncrement());
                    }
                }
            });
        }
    }

    @Test
    public void testRedis(){
        String str = String.valueOf(redisTemplate.opsForValue().getAndSet("b","111"));
        System.out.println(str);
    }

    @Test
    public void createExchange(){
        Exchange directExchange = new DirectExchange("my-exchange",true,false);
        amqpAdmin.declareExchange(directExchange);
        log.info("交换机创建成功");
    }

    @Test
    public void createQueue(){
        Queue queue = new Queue("my-queue",true,false,false);
        amqpAdmin.declareQueue(queue);
        log.info("创建队列成功");
    }

    @Test
    public void createBind(){
        Binding binding = new Binding("my-queue",
                Binding.DestinationType.QUEUE,
                "my-exchange",
                "hello",
                null);
        log.info("绑定路由成功");
    }

    @Test
    public void testRabbitMQ(){
        SendEntity sendEntity = new SendEntity();
        sendEntity.setId(3);
        sendEntity.setMsg("msg4");
        rabbitTemplate.convertAndSend(MqConstants.exchange, MqConstants.routing,
                sendEntity, new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {
                        message.getMessageProperties().setHeader("ta1","测试1");
                        message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
                        return message;
                    }
                });
        log.info("消息发送成功");
    }

    @Test
    public void testConsumer(){

    }

}
