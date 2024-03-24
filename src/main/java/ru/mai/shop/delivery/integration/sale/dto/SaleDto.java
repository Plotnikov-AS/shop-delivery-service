package ru.mai.shop.delivery.integration.sale.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import ru.mai.shop.delivery.generated.dto.ProductDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Продажа
 */

@Schema(name = "SaleDto", description = "Продажа")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-22T18:43:16.927815+03:00[Europe/Moscow]")
public class SaleDto {

  private UUID id;

  @Valid
  private List<@Valid ProductDto> products;

  private BigDecimal costTotal;

  private SaleType type;

  public SaleDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public SaleDto products(List<@Valid ProductDto> products) {
    this.products = products;
    return this;
  }

  public SaleDto addProductsItem(ProductDto productsItem) {
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
  @Valid 
  @Schema(name = "products", description = "Проданные товары", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("products")
  public List<@Valid ProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<@Valid ProductDto> products) {
    this.products = products;
  }

  public SaleDto costTotal(BigDecimal costTotal) {
    this.costTotal = costTotal;
    return this;
  }

  /**
   * Общая сумма продажи
   * @return costTotal
  */
  @Valid 
  @Schema(name = "costTotal", description = "Общая сумма продажи", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("costTotal")
  public BigDecimal getCostTotal() {
    return costTotal;
  }

  public void setCostTotal(BigDecimal costTotal) {
    this.costTotal = costTotal;
  }

  public SaleDto type(SaleType type) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaleDto saleDto = (SaleDto) o;
    return Objects.equals(this.id, saleDto.id) &&
        Objects.equals(this.products, saleDto.products) &&
        Objects.equals(this.costTotal, saleDto.costTotal) &&
        Objects.equals(this.type, saleDto.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, products, costTotal, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaleDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    costTotal: ").append(toIndentedString(costTotal)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

