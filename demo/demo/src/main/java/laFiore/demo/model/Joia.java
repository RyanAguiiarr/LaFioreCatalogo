package laFiore.demo.model;

import jakarta.persistence.*;
import laFiore.demo.Categoria;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Joia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String sku;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private BigDecimal preco;

    private Integer estoque;

    private Boolean ativo;

    private List<String> imagensUrl;

    private LocalDateTime dataCriacao;

    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "joia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VarianteJoia> variantes;
}
