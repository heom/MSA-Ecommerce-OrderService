package me.study.orderservice.controller;

import lombok.RequiredArgsConstructor;
import me.study.orderservice.dto.OrderDto;
import me.study.orderservice.messageque.KafkaProducer;
import me.study.orderservice.service.OrderService;
import me.study.orderservice.vo.RequestOrder;
import me.study.orderservice.vo.ResponseOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final KafkaProducer kafkaProducer;

    @GetMapping("/health-check")
    public String status(HttpServletRequest request){
        return String.format("Order service on PORT : %s", request.getServerPort());
    }

    @PostMapping("/orders")
    public ResponseEntity<ResponseOrder> createOrder(@RequestHeader("X-Authorization-Id") String userId
                                                    , @Valid @RequestBody RequestOrder requestOrder){
        OrderDto orderDto = new OrderDto(requestOrder);
        orderDto.setUserId(userId);
        ResponseOrder responseOrder = orderService.createOrder(orderDto);
        kafkaProducer.send("order-topic", orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
    }

    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrders(@PathVariable("userId") String userId){
        List<ResponseOrder> responseOrderList = orderService.getOrders(userId);
        return ResponseEntity.status(HttpStatus.OK).body(responseOrderList);
    }
}
