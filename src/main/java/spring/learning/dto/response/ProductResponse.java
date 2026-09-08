package spring.learning.dto.response;

import java.math.BigDecimal;

public record ProductResponse (
        Long id,
        BigDecimal price,
        String sku
) {}
