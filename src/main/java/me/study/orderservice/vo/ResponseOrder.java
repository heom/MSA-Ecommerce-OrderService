package me.study.orderservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.study.orderservice.entity.OrderEntity;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    private String orderId;

    public ResponseOrder(OrderEntity orderEntity){
        this.productId = orderEntity.getProductId();
        this.qty = orderEntity.getQty();
        this.unitPrice = orderEntity.getUnitPrice();
        this.totalPrice = orderEntity.getTotalPrice();
        this.createdDate = orderEntity.getCreatedDate();
        this.lastModifiedDate = orderEntity.getLastModifiedDate();
        this.orderId = orderEntity.getOrderId();
    }
}
