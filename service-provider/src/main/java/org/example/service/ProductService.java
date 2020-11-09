package org.example.service;

/**
 * 商品服务
 */
import org.example.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询商品列表
     *
     * @return
     */
    List<Product> selectProductList();

    /**
     * 根据主键查询商品
     *
     * @param id
     * @return
     */
    Product selectProductById(Integer id);
}
