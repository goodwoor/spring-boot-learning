package spring.learning.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse (
        Long id,
        List<ProductResponse> products,
        String status,
        LocalDateTime createdAt
) {}
