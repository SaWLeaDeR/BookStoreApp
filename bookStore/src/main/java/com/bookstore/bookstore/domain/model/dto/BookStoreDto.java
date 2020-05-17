package com.bookstore.bookstore.domain.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class BookStoreDto implements Serializable {

    private String name;

    private BigDecimal additionalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookStoreDto that = (BookStoreDto) o;
        return Objects.equals(name, that.name) &&
            Objects.equals(additionalPrice, that.additionalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, additionalPrice);
    }

    @Override
    public String toString() {
        return "BookStoreDto{" +
            "name='" + name + '\'' +
            ", additionalPrice=" + additionalPrice +
            '}';
    }
}
