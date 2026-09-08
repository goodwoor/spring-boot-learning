package spring.learning.dto.response;

public record AddressResponse (
    Long id,
    String city,
    String street,
    String homeNumber,
    String apartment
) {}
