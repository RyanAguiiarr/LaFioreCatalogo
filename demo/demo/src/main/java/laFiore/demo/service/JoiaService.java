package laFiore.demo.service;

import laFiore.demo.Dto.JoiaRequestDto;
import laFiore.demo.Dto.JoiaResponseDto;
import laFiore.demo.model.Joia;
import laFiore.demo.model.VarianteJoia;
import laFiore.demo.repository.JoiaRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class JoiaService {

    private JoiaRepository joiaRepository;
    private static final Logger log = LoggerFactory.getLogger(Class.class);

    public JoiaResponseDto cadastrarJoia(JoiaRequestDto req) throws Exception {

        try{
            log.info("Iniciando cadastro da joia: {}", req.nome());

            if (joiaRepository.findBySku(req.sku()).isPresent()) {
                throw new Exception("Sku (" + req.sku() + ") já cadastrado!");
            }

            Joia novaJoia = new Joia();
            novaJoia.setNome(req.nome());
            novaJoia.setSku(req.sku());
            novaJoia.setDescricao(req.descricao());
            novaJoia.setCategoria(req.categoria());
            novaJoia.setPreco(req.preco());
            novaJoia.setAtivo(true);
            novaJoia.setImagensUrl(req.imagenUrl());
            novaJoia.setDataCriacao(LocalDateTime.now());

            int estoqueTotal = 0;

            if (req.variantes() != null && !req.variantes().isEmpty()) {
                for (VarianteJoia variante : req.variantes()) {
                    variante.setJoia(novaJoia);

                    estoqueTotal += (variante.getEstoque() != null) ? variante.getEstoque() : 0;
                }

                novaJoia.setVariantes(req.variantes());
            }

            novaJoia.setEstoque(estoqueTotal > 0 ? estoqueTotal : req.estoque());

            Joia joiaSalva = joiaRepository.save(novaJoia);

            log.info("Joia salva com sucesso! ID: {}", joiaSalva.getId());

            return new JoiaResponseDto(
                    joiaSalva.getNome(),
                    joiaSalva.getSku(),
                    joiaSalva.getDescricao(),
                    joiaSalva.getCategoria(),
                    joiaSalva.getPreco(),
                    joiaSalva.getEstoque(),
                    joiaSalva.getAtivo(),
                    joiaSalva.getImagensUrl(),
                    joiaSalva.getDataCriacao(),
                    joiaSalva.getUpdateTime(),
                    joiaSalva.getVariantes()
            );
        }catch (Exception ex){
            throw new Exception("Erro ao cadastrar joia", ex);
        }
        
    }

}
