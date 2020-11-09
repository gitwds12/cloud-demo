package org.example.service.impl;

import org.example.api.CommonResult;
import org.example.mq.send.RabbitCancelOrderSender;
import org.example.service.MqOmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqOmsPortalOrderServiceImpl implements MqOmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(MqOmsPortalOrderServiceImpl.class);
    @Autowired
    private RabbitCancelOrderSender rabbitCancelOrderSender;

    @Override
    public CommonResult generateOrder(Long orderId) {
        //todo 执行一系类下单操作，具体参考mall项目
        LOGGER.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(orderId);
        return CommonResult.success(null, "下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 10 * 1000;
        //发送延迟消息
        rabbitCancelOrderSender.sendMessage(orderId, delayTimes);
    }
}
