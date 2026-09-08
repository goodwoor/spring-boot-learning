package spring.learning.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "street", nullable = false, length = 150)
    private String street;

    @Column(name = "home_number", nullable = false, length = 20)
    private String homeNumber;

    @Column(name = "apartment", nullable = true, length = 20)
    private String apartment;

    public Address(Long id, User user, String city, String street, String homeNumber, String apartment) {
        this.id = id;
        this.user = user;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.apartment = apartment;
    }

    public Address() {}

    @Override
    public boolean equals(Object address) {
        if (this == address) return true;
        if (address == null || this.getClass() != address.getClass()) return false;

        Address typedAddress = (Address) address;
        return this.id != null && this.id.equals(typedAddress.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
