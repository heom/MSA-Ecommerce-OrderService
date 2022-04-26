package me.study.orderservice.client;

import me.study.orderservice.vo.ResponseUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service")
public interface UserClient {

    @GetMapping("/users/{userId}")
    ResponseUser getUserByAuth(@PathVariable String userId);

}
