package ru.mai.shop.delivery.service;

import org.springframework.data.domain.Pageable;
import ru.mai.shop.delivery.generated.dto.DeliveryDto;
import ru.mai.shop.delivery.generated.dto.NewDeliveryRequest;
import ru.mai.shop.delivery.generated.dto.PagedDeliveriesResponse;

import java.util.UUID;

public interface DeliveryService {
    DeliveryDto createNewDelivery(NewDeliveryRequest newDeliveryRequest);

    PagedDeliveriesResponse getAllDeliveries(Pageable pageable);

    DeliveryDto getDelivery(UUID id);
}
