package spring.task1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "sku", nullable = false, unique = true, length = 50)
    private String sku;

    public Product(Long id, Set<Order> orders, BigDecimal price, String sku) {
        this.id = id;
        this.orders = orders;
        this.price = price;
        this.sku = sku;
    }

    public Product() {}

    @Override
    public boolean equals(Object product) {
        if (this == product) return true;
        if (product == null || !(product instanceof Product)) return false;

        Product typedProduct = (Product) product;
        return this.id != null && this.id.equals(typedProduct.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Long getId() {
        return id;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", orders=" + orders +
                ", price=" + price +
                ", sku='" + sku + '\'' +
                '}';
    }
}
