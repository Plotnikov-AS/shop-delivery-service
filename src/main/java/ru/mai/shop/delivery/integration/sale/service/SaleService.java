package ru.mai.shop.delivery.integration.sale.service;

import ru.mai.shop.delivery.generated.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface SaleService {
    UUID createNewSale(List<ProductDto> products);

    void deleteSale(UUID id);
}
