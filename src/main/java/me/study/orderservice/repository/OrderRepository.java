package me.study.orderservice.repository;

import me.study.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Iterable<OrderEntity> findByUserId(String userId);
}
