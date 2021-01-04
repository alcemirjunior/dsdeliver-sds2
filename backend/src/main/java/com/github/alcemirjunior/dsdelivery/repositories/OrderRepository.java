package com.github.alcemirjunior.dsdelivery.repositories;

import com.github.alcemirjunior.dsdelivery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
