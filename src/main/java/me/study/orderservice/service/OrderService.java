package me.study.orderservice.service;

import me.study.orderservice.dto.OrderDto;
import me.study.orderservice.vo.ResponseOrder;

import java.util.List;

public interface OrderService {
    ResponseOrder createOrder(OrderDto orderDto);
    List<ResponseOrder> getOrders(String userId);
}
