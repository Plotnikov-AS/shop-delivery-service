package ru.mai.shop.delivery.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.mai.shop.delivery.generated.api.DeliveryApi;
import ru.mai.shop.delivery.generated.dto.DeliveryDto;
import ru.mai.shop.delivery.generated.dto.NewDeliveryRequest;
import ru.mai.shop.delivery.generated.dto.PagedDeliveriesResponse;
import ru.mai.shop.delivery.service.DeliveryService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DeliveryController implements DeliveryApi {
    private final DeliveryService deliveryService;

    @Override
    public ResponseEntity<DeliveryDto> createNewDelivery(NewDeliveryRequest newDeliveryRequest) {
        return ResponseEntity.ok(deliveryService.createNewDelivery(newDeliveryRequest));
    }

    @Override
    public ResponseEntity<PagedDeliveriesResponse> getAllDeliveries(Pageable pageable) {
        return ResponseEntity.ok(deliveryService.getAllDeliveries(pageable));
    }

    @Override
    public ResponseEntity<DeliveryDto> getDeliveryById(UUID id) {
        return ResponseEntity.ok(deliveryService.getDelivery(id));
    }
}
