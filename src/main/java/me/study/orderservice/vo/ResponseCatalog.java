package me.study.orderservice.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer stock;
    private Integer unitPrice;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
