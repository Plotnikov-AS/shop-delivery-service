package ru.mai.shop.delivery.integration.sale.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import ru.mai.shop.delivery.generated.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Запрос создания новой продажи
 */

@Schema(name = "NewSaleRequest", description = "Запрос создания новой продажи")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-22T18:43:16.927815+03:00[Europe/Moscow]")
public class NewSaleRequest {

  private SaleType type;

  @Valid
  private List<@Valid ProductDto> products;

  public NewSaleRequest type(SaleType type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public SaleType getType() {
    return type;
  }

  public void setType(SaleType type) {
    this.type = type;
  }

  public NewSaleRequest products(List<@Valid ProductDto> products) {
    this.products = products;
    return this;
  }

  public NewSaleRequest addProductsItem(ProductDto productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Проданные товары
   * @return products
  */
  @Valid @Size(min = 1) 
  @Schema(name = "products", description = "Проданные товары", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("products")
  public List<@Valid ProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<@Valid ProductDto> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewSaleRequest newSaleRequest = (NewSaleRequest) o;
    return Objects.equals(this.type, newSaleRequest.type) &&
        Objects.equals(this.products, newSaleRequest.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewSaleRequest {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

