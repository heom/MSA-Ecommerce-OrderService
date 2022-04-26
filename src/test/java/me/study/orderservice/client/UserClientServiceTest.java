package me.study.orderservice.client;

import me.study.orderservice.exception.FeignException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserClientServiceTest {

    @Autowired
    UserClientService userClientService;

    @Test
    @DisplayName("isUserValid_not_found")
    public void isUserValid_not_found(){
        //given
        String userId = "test---";

        //when & then
        assertThrows(FeignException.class, ()-> userClientService.isUserValid(userId));
    }


}