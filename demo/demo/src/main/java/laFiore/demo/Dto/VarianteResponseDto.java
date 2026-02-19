package laFiore.demo.Dto;

import java.math.BigDecimal;

public record VarianteResponseDto(
        Long id,
        String dimensao,
        String sku,
        BigDecimal preco,
        Integer estoque
) {
}
