package me.study.orderservice.entity;

import lombok.*;
import me.study.orderservice.dto.OrderDto;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder @AllArgsConstructor
@Table(name = "orders")
public class OrderEntity extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;

    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

    public OrderEntity(OrderDto orderDto){
        this.productId = orderDto.getProductId();
        this.qty = orderDto.getQty();
        this.unitPrice = orderDto.getUnitPrice();
        this.totalPrice = orderDto.getTotalPrice();
        this.userId = orderDto.getUserId();
        this.orderId = orderDto.getOrderId();
    }
}
