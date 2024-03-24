package ru.mai.shop.delivery.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mai.shop.delivery.entity.Delivery;
import ru.mai.shop.delivery.generated.dto.DeliveryDto;
import ru.mai.shop.delivery.generated.dto.NewDeliveryRequest;
import ru.mai.shop.delivery.generated.dto.PagedDeliveriesResponse;
import ru.mai.shop.delivery.integration.sale.service.SaleService;
import ru.mai.shop.delivery.repo.DeliveryRepo;
import ru.mai.shop.delivery.service.DeliveryService;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepo deliveryRepo;
    private final SaleService saleService;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public DeliveryDto createNewDelivery(NewDeliveryRequest request) {
        UUID saleId = saleService.createNewSale(request.getProducts());
        try {
            Delivery delivery = deliveryRepo.save(new Delivery()
                    .setProducts(request.getProducts())
                    .setAddress(request.getAddress())
                    .setSaleId(saleId));

            return mapper.map(delivery, DeliveryDto.class);
        } catch (Exception e) {
            log.error("Ошибка создания доставки", e);
            saleService.deleteSale(saleId);
            throw e;
        }
    }

    @Override
    public PagedDeliveriesResponse getAllDeliveries(Pageable pageable) {
        Page<Delivery> deliveries = deliveryRepo.findAll(pageable);

        return new PagedDeliveriesResponse()
                .content(deliveries.stream()
                        .map(delivery -> mapper.map(delivery, DeliveryDto.class))
                        .toList())
                .pageable(pageable)
                .last(deliveries.isLast())
                .first(deliveries.isFirst())
                .empty(deliveries.isEmpty())
                .number(deliveries.getNumber())
                .numberOfElements(deliveries.getNumberOfElements())
                .size(deliveries.getSize())
                .sort(deliveries.getSort())
                .totalElements(deliveries.getTotalElements())
                .totalPages(deliveries.getTotalPages());
    }

    @Override
    public DeliveryDto getDelivery(UUID id) {
        return deliveryRepo.findById(id)
                .map(delivery -> mapper.map(delivery, DeliveryDto.class))
                .orElseThrow(() -> new IllegalArgumentException("Не найдена доставка %s".formatted(id)));
    }
}
