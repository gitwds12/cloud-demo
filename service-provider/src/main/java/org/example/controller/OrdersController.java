package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.api.CommonResult;
import org.example.dto.CommonPage;
import org.example.dto.OrdersParam;
import org.example.pojo.Orders;
import org.example.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 订单管理Controller
 * Created on 2020/8/25.
 */
@Controller
@RequestMapping("/order")
@Api(tags = "订单管理")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有订单")
    public CommonResult<List<Orders>> getBrandList() {
        return CommonResult.success(ordersService.listAllOrders());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "创建订单")
    public CommonResult createBrand(@RequestBody OrdersParam ordersParam) {
        CommonResult commonResult;
        int count = ordersService.createOrders(ordersParam);
        if (count == 1) {
            commonResult = CommonResult.success(ordersParam);
            LOGGER.debug("createBrand success:{}", ordersParam);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", ordersParam);
        }
        return commonResult;
    }

    @ApiOperation(value = "更新订单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") Integer id,
                               @Validated @RequestBody OrdersParam ordersParam,
                               BindingResult result) {
        CommonResult commonResult;
        int count = ordersService.updateOrders(id, ordersParam);
        if (count == 1) {
            commonResult = CommonResult.success(count);
        } else {
            commonResult = CommonResult.failed();
        }
        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "删除订单")
    public CommonResult deleteBrand(@PathVariable("id") Integer id) {
        int count = ordersService.deleteOrders(id);
        if (count == 1) {
            LOGGER.debug("deleteOrders success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteOrders failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询订单")
    public CommonResult<CommonPage<Orders>> listBrand(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<Orders> ordersList = ordersService.listOrders(keyword, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(ordersList));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取订单")
    public CommonResult<Orders> orders(@PathVariable("id") Integer id) {
        return CommonResult.success(ordersService.getOrders(id));
    }

}
