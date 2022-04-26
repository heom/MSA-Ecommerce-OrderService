package me.study.orderservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserClientService {
    private final UserClient userClient;

    public void isUserValid(String userId){
        userClient.getUserByAuth(userId);
    }
}
