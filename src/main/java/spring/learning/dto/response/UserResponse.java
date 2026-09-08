package spring.learning.dto.response;

import java.util.List;

public record UserResponse (
        Long id,
        String firstName,
        String secondName,
        String status,
        List<AddressResponse> addresses,
        List<OrderResponse> orders
) {}
