package bot.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProceduresRepository extends CrudRepository<Procedures, Long> {
}
