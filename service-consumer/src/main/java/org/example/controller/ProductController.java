package org.example.controller;

import org.example.pojo.Product;
import org.example.remote.HelloRemote;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HelloRemote helloRemote;

    /**
     * 根据主键查询商品
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    public List<Product> list() {
        return productService.selectProductList();
    }

    /**
     * 根据主键查询商品
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") Integer id) {
        return productService.selectProductById(id);
    }

    /**
     * 测试熔断器
     *
     * @param name
     * @return
     */
    @GetMapping("/helloHystrix")
    public String helloHystrix(@RequestParam String name) {
        return helloRemote.hello(name);
    }
}
