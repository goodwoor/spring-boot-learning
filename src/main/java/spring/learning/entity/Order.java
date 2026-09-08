package spring.learning.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //альтернатива - ручные запросы, соединить результат в сервисе
    @BatchSize(size = 50)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products = new HashSet<>();

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Order(Long id, User user, Set<Product> products, String status, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Order() {}

    @Override
    public boolean equals(Object order) {
        if (this == order) return true;
        if (order == null || this.getClass() != order.getClass()) return false;

        Order typedOrder = (Order) order;
        return this.id != null && this.id.equals(typedOrder.id);
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
