package org.example.service;

import org.example.api.CommonResult;
import org.springframework.transaction.annotation.Transactional;

public interface MqOmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(Long orderId);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}
