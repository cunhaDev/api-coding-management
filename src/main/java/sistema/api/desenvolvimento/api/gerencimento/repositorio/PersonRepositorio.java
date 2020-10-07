package sistema.api.desenvolvimento.api.gerencimento.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.api.desenvolvimento.api.gerencimento.entity.Person;

public interface PersonRepositorio extends JpaRepository <Person, Long> {
}
