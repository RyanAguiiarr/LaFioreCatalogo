package laFiore.demo.repository;

import laFiore.demo.model.Joia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoiaRepository extends JpaRepository<Joia, Long> {

    Optional<Joia> findBySku(String sku);
}
