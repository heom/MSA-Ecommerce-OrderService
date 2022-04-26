package me.study.orderservice.service;

import me.study.orderservice.dto.OrderDto;
import me.study.orderservice.exception.FeignException;
import me.study.orderservice.repository.OrderRepository;
import me.study.orderservice.vo.ResponseOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("createOrder_not_found_user")
    public void createOrder_not_found_user(){
        //given
        OrderDto orderDto = OrderDto.builder()
                .productId("CATALOG-0001")
                .qty(1)
                .userId("test")
                .build();

        //when & then
        assertThrows(FeignException.class, ()-> orderService.createOrder(orderDto));
    }

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