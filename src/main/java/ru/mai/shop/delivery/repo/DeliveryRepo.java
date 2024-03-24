package ru.mai.shop.delivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mai.shop.delivery.entity.Delivery;

import java.util.UUID;

public interface DeliveryRepo extends JpaRepository<Delivery, UUID> {
}
