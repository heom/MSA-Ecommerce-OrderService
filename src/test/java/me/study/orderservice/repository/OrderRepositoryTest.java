package me.study.orderservice.repository;

import me.study.orderservice.entity.OrderEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;
    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("save")
    public void save(){
        //given
        OrderEntity orderEntity = OrderEntity.builder()
                                            .productId("CATALOG-0001")
                                            .qty(10)
                                            .unitPrice(1500)
                                            .totalPrice(15000)
                                            .userId("test")
                                            .orderId("test")
                                            .build();

        //when
        OrderEntity savedOrderEntity = orderRepository.save(orderEntity);

        //then
        assertThat(orderEntity).isEqualTo(savedOrderEntity);
    }

    @Test
    @DisplayName("findByUserId")
    public void findByUserId(){
        //given
        String userId = "test";
        List<OrderEntity> orderEntityList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            OrderEntity orderEntity = OrderEntity.builder()
                                                .productId("CATALOG-0001")
                                                .qty(i)
                                                .unitPrice(1500)
                                                .totalPrice(i*1500)
                                                .userId(userId)
                                                .orderId("test"+i)
                                                .build();
            orderEntityList.add(orderEntity);
        }
        orderRepository.saveAll(orderEntityList);

        em.flush();
        em.clear();

        //when
        Iterable<OrderEntity> orderEntityIterable = orderRepository.findByUserId(userId);

        //then
        assertThat(orderEntityIterable).extracting("orderId")
                                        .containsExactly("test0","test1","test2", "test3");
    }
}