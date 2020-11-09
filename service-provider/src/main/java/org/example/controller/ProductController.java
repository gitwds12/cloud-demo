package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.pojo.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Api(tags = "产品相关接口")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 查询商品列表
     *
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("查询商品列表")
    public List<Product> selectProductList() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        Integer.parseInt("cc");
        return "hello "+name+"，this is first message";
    }

}
