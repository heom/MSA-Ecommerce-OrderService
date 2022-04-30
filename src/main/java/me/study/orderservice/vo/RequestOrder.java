package me.study.orderservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder @AllArgsConstructor
public class RequestOrder {
    @NotNull(message = "productId cannot be null")
    private String productId;

    @Min(value = 1, message = "qty not be less than 1")
    private Integer qty;

    @Min(value = 1, message = "unitPrice not be less than 1")
    private Integer unitPrice;
}
