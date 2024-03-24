package ru.mai.shop.delivery.integration.sale.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mai.shop.delivery.generated.dto.ProductDto;
import ru.mai.shop.delivery.integration.sale.client.SaleClient;
import ru.mai.shop.delivery.integration.sale.dto.NewSaleRequest;
import ru.mai.shop.delivery.integration.sale.dto.SaleDto;
import ru.mai.shop.delivery.integration.sale.dto.SaleType;
import ru.mai.shop.delivery.integration.sale.service.SaleService;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleClient saleClient;

    @Override
    public UUID createNewSale(List<ProductDto> products) {
        SaleDto newSale = saleClient.createNewSale(new NewSaleRequest()
                .products(products)
                .type(SaleType.DELIVERY));
        log.info("Создана новая продажа {}", newSale);

        return newSale.getId();
    }

    @Override
    public void deleteSale(UUID id) {
        saleClient.deleteSale(id);
        log.info("Продажа {} удалена", id);
    }
}
