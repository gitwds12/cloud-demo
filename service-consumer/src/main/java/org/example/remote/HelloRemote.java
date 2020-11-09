package org.example.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "service-provider2", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/product/helloHystrix")
    String hello(@RequestParam(value = "name") String name);

}
