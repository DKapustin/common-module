package medical.common.core.repository;

import model.LogDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogDto, Long> {
    void addLogDebug(LogDto logDTO);
    void addLogException(LogDto logDTO);
}
