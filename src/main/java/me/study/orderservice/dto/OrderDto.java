package me.study.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import me.study.orderservice.vo.RequestOrder;

@Data
@Builder @AllArgsConstructor
public class OrderDto {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public OrderDto(RequestOrder requestOrder){
        this.productId = requestOrder.getProductId();
        this.qty = requestOrder.getQty();
    }
}
