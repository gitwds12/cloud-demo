package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.elastic.EsUser;
import org.example.elastic.EsUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 为了演示，省略service
 * */
@RestController
@RequestMapping("/esUser")
@Api(tags = "ES搜索测试类")
public class EsUserController {
    @Autowired
    private EsUserDao userDao;

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public String addUser(String username, String password, Integer age) {
        try{
            EsUser user = new EsUser();
            user.setEs_username(username);
            user.setPassword(password);
            user.setAge(age);
            return String.valueOf(userDao.save(user).getId());// 返回id做验证
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/deleteUser")
    @ApiOperation(value = "根据id删除用户")
    public String deleteUser(Integer id) {
        userDao.deleteById(id);
        return "Success!";
    }

    @PutMapping("/updateUser")
    @ApiOperation(value = "更新用户")
    public String updateUser(Integer id, String username, String password, Integer age) {
        EsUser user = new EsUser();
        user.setId(id);
        user.setEs_username(username);
        user.setPassword(password);
        user.setAge(age);
        return String.valueOf(userDao.save(user).getId());// 返回id做验证
    }

    @GetMapping("/getUser")
    @ApiOperation(value = "获取单个用户")
    public EsUser getUser(Integer id) {
        return userDao.findById(id).get();
    }

    @GetMapping("/getAllUsers")
    @ApiOperation(value = "查询所有用户")
    public Iterable<EsUser> getAllUsers() {
        return userDao.findAll();
    }
}
