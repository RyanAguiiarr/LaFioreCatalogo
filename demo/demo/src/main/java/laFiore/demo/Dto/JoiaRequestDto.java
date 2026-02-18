package laFiore.demo.Dto;

import laFiore.demo.Categoria;
import laFiore.demo.model.VarianteJoia;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record JoiaRequestDto(
        String nome,
        String sku,
        String descricao,
        Categoria categoria,
        BigDecimal preco,
        Integer estoque,
        List<String> imagenUrl,
        List<VarianteJoia> variantes
) {
}
