package me.study.orderservice.controller;

import me.study.orderservice.vo.RequestOrder;
import me.study.orderservice.vo.ResponseOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    private String getApiUrl(String url){
        StringBuffer sbf = new StringBuffer();
        return sbf.append("http://localhost:")
                .append(this.port)
                .append(url).toString();
    }

    @Test
    @DisplayName("createOrder_not_found_user")
    public void createOrder_not_found_user(){
        //given
        String url = getApiUrl("/orders");
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Authorization-Id", "test");
        RequestOrder requestOrder = RequestOrder.builder()
                .productId("CATALOG-0001")
                .qty(2)
                .build();

        //when
        ResponseEntity<ResponseOrder> responseEntity = this.restTemplate.exchange(url, HttpMethod.POST,  new HttpEntity<>(headers), ResponseOrder.class, requestOrder);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    @DisplayName("getOrders")
    public void getOrders(){
        //given
        String url = getApiUrl("/users/test/orders");

        //when
        ResponseEntity<ResponseOrder[]> responseEntity = this.restTemplate.getForEntity(url, ResponseOrder[].class);

        //then
        assertAll(
                () -> assertEquals(responseEntity.getStatusCode(), HttpStatus.OK),
                () -> assertEquals(responseEntity.getBody().length, 0)
        );

    }
}