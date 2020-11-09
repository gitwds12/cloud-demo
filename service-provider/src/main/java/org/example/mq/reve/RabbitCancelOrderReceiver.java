package org.example.mq.reve;

import org.example.service.MqOmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 * Created on 2020/8/21.
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class RabbitCancelOrderReceiver {
    private static Logger LOGGER =LoggerFactory.getLogger(RabbitCancelOrderReceiver.class);
    @Autowired
    private MqOmsPortalOrderService portalOrderService;
    @RabbitHandler
    public void handle(Long orderId){
        LOGGER.info("receive delay message orderId:{}",orderId);
        portalOrderService.cancelOrder(orderId);
    }
}
