package com.bookstore.bookstore.domain.model.entity;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookStoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "additional_price", nullable = false)
    private BigDecimal additionalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        BookStoreEntity that = (BookStoreEntity) o;
        return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(additionalPrice, that.additionalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, additionalPrice);
    }

    @Override
    public String toString() {
        return "BookStoreEntity{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", additionalPrice=" + additionalPrice +
            '}';
    }
}
