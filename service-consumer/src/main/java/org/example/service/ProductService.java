package org.example.service;

import org.example.pojo.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// 声明需要调用的服务
@FeignClient("service-provider")
public interface ProductService {

    /**
     * 查询商品列表
     *
     * @return
     */
    // 配置需要调用的服务地址及参数
    @GetMapping("/product/list")
    @Cacheable(cacheNames = "productService:product:list")
    List<Product> selectProductList();

    /**
     * 根据主键查询商品
     *
     * @return
     */
    @GetMapping("/product/{id}")
    @Cacheable(cacheNames = "productService:product:single", key = "#id")
    Product selectProductById(@PathVariable("id") Integer id);

}
