package laFiore.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VarianteJoia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String dimensao;

    private Integer estoque;

    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "Joia_id")
    @JsonIgnore
    private Joia joia;
}
