package spring.task1.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "second_name", nullable = false, length = 50)
    private String secondName;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public User(Long id, String firstName, String secondName, String status, List<Address> addresses, List<Order> orders) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.status = status;
        this.addresses = addresses;
        this.orders = orders;
    }

    public User() {}

    @Override
    public boolean equals(Object user) {
        if (this == user) return true;
        if (user == null || !(user instanceof User)) return false;

        User typedUser = (User) user;
        return this.id != null && this.id.equals(typedUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getStatus() {
        return status;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", status='" + status + '\'' +
                ", addresses=" + addresses +
                ", orders=" + orders +
                '}';
    }
}
