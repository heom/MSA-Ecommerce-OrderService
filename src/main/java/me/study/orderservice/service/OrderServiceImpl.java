package me.study.orderservice.service;

import lombok.RequiredArgsConstructor;
import me.study.orderservice.dto.OrderDto;
import me.study.orderservice.entity.OrderEntity;
import me.study.orderservice.repository.OrderRepository;
import me.study.orderservice.vo.ResponseOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public ResponseOrder createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

        OrderEntity orderEntity = orderRepository.save(new OrderEntity(orderDto));

        return new ResponseOrder(orderEntity);
    }

    @Override
    public List<ResponseOrder> getOrders(String userId) {
        Iterable<OrderEntity> orderEntityIterable = orderRepository.findByUserId(userId);

        List<ResponseOrder> responseOrderList = new ArrayList<>();
        orderEntityIterable.forEach(orderEntity -> {
            responseOrderList.add(new ResponseOrder(orderEntity));
        });

        return responseOrderList;
    }
}
