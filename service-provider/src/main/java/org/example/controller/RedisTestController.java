package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.api.CommonResult;
import org.example.service.RedisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "redis测试接口")
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return redisTestService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return redisTestService.verifyAuthCode(telephone,authCode);
    }
}
