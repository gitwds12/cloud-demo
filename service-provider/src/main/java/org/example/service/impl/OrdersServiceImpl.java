package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import org.example.dto.OrdersParam;
import org.example.mapper.OrdersMapper;
import org.example.pojo.Orders;
import org.example.pojo.OrdersExample;
import org.example.service.OrdersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * OrdersService
 * Created on 2020/8/25.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> listAllOrders() {
        return ordersMapper.selectByExample(new OrdersExample());
    }

    @Override
    public int createOrders(OrdersParam ordersParam) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersParam, orders);
        return ordersMapper.insertSelective(orders);
    }

    @Override
    public int updateOrders(Integer id, OrdersParam ordersParam) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(ordersParam, orders);
        orders.setId(id);
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public int deleteOrders(Integer id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Orders> listOrders(String keyword, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.setOrderByClause("id desc");
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andNumberLike("%" + keyword + "%");
        }
        return ordersMapper.selectByExample(ordersExample);
    }

    @Override
    public Orders getOrders(Integer id) {
        return ordersMapper.selectByPrimaryKey(id);
    }


}
