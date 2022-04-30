package me.study.orderservice.service;

import me.study.orderservice.repository.OrderRepository;
import me.study.orderservice.vo.ResponseOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("getOrders")
    public void getOrders(){
        //given
        String userId = "test";

        //when
        List<ResponseOrder> orderList = orderService.getOrders(userId);

        //then
        assertThat(orderList.size()).isEqualTo(0);
    }
}