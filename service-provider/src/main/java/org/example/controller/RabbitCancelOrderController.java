package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.mq.reve.RabbitCancelOrderReceiver;
import org.example.service.MqOmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "Mq测试之订单管理")
@RequestMapping("/mqOrder")
public class RabbitCancelOrderController {
    private static Logger LOGGER = LoggerFactory.getLogger(RabbitCancelOrderController.class);
    @Autowired
    private MqOmsPortalOrderService mqOmsPortalOrderService;


    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(Long orderId) {
        return mqOmsPortalOrderService.generateOrder(orderId);
    }
}
