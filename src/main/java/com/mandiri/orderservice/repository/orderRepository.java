package com.mandiri.orderservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mandiri.orderservice.model.orderModel;

public interface orderRepository extends JpaRepository<orderModel, Long> {
    List<orderModel> findByNama(String nama);
}
