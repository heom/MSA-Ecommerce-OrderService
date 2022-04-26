package me.study.orderservice.client;

import lombok.RequiredArgsConstructor;
import me.study.orderservice.dto.OrderDto;
import me.study.orderservice.vo.RequestCatalog;
import me.study.orderservice.vo.ResponseCatalog;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogClientService {
    private final CatalogClient catalogClient;

    public ResponseCatalog minusStock(OrderDto orderDto){
        RequestCatalog requestCatalog = new RequestCatalog();
        requestCatalog.setQty(orderDto.getQty());
        return catalogClient.minusStock(orderDto.getProductId(), requestCatalog);
    }
}
