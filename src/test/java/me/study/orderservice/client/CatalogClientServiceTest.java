package me.study.orderservice.client;

import me.study.orderservice.dto.OrderDto;
import me.study.orderservice.exception.FeignException;
import me.study.orderservice.vo.ResponseCatalog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CatalogClientServiceTest {

    @Autowired
    CatalogClientService catalogClientService;

    @Test
    @DisplayName("minusStock")
    public void minusStock(){
        //given
        String productID = "CATALOG-0001";
        OrderDto orderDto = OrderDto.builder()
                .productId(productID)
                .qty(1)
                .build();

        //when
        ResponseCatalog responseCatalog = catalogClientService.minusStock(orderDto);

        //then
        assertThat(responseCatalog.getProductId()).isEqualTo(productID);
    }

    @Test
    @DisplayName("minusStock_not_found")
    public void minusStock_not_found(){
        //given
        OrderDto orderDto = OrderDto.builder()
                                    .productId("test")
                                    .qty(1)
                                    .build();

        //when & then
        assertThrows(FeignException.class, ()-> catalogClientService.minusStock(orderDto));
    }
}