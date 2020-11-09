package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单传递参数
 * Created on 2020/8/25.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrdersParam {
    @ApiModelProperty(value = "用户id",required = true)
    private Integer userId;
    @ApiModelProperty(value = "订单数量",required = true)
    private String number;
    @ApiModelProperty(value = "订单重量")
    private Double weight;

}
