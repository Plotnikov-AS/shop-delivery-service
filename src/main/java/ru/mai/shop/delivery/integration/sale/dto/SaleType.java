package ru.mai.shop.delivery.integration.sale.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Тип продажи: * `STORE` - Прямая продажа в магазине * `DELIVERY` - Продажа доставкой * `REFUND` - Возврат 
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-22T18:43:16.927815+03:00[Europe/Moscow]")
public enum SaleType {
  
  STORE("STORE"),
  
  DELIVERY("DELIVERY"),
  
  REFUND("REFUND");

  private String value;

  SaleType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SaleType fromValue(String value) {
    for (SaleType b : SaleType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

