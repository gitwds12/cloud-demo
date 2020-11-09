package org.example.service;

import org.example.dto.OrdersParam;
import org.example.pojo.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * OrdersService
 * Created on 2020/8/25.
 */
public interface OrdersService {

    /**
     * 查询所有订单
     */
    List<Orders> listAllOrders();

    /**
     * 创建订单
     */
    int createOrders(OrdersParam ordersParam);

    /**
     * 修改订单
     */
    @Transactional
    int updateOrders(Integer id, OrdersParam ordersParam);

    /**
     * 删除订单
     */
    int deleteOrders(Integer id);

    /**
     * 分页查询品牌
     */
    List<Orders> listOrders(String keyword, int pageNum, int pageSize);

    /**
     * 获取订单
     */
    Orders getOrders(Integer id);

}
