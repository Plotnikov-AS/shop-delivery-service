package ru.mai.shop.delivery.integration.sale.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.mai.shop.delivery.integration.sale.dto.NewSaleRequest;
import ru.mai.shop.delivery.integration.sale.dto.SaleDto;

import java.util.UUID;

@FeignClient(
        url = "${integration.sale.url}",
        path = "/v1"
)
public interface SaleClient {

    @PostMapping("/sales")
    SaleDto createNewSale(@RequestBody NewSaleRequest request);

    @DeleteMapping("/sales/{id}")
    void deleteSale(@PathVariable UUID id);
}
