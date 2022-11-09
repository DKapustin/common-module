package medical.common.core.repository;

import medical.common.core.model.Exception;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepository extends CrudRepository<Exception, Long> {
}
