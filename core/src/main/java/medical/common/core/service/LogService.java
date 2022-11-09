package medical.common.core.service;

import liga.medical.dto.LogType;
import lombok.extern.slf4j.Slf4j;
import medical.common.core.model.Debug;
import medical.common.core.model.Exception;
import medical.common.core.repository.DebugRepository;
import medical.common.core.repository.ExceptionRepository;
import medical.common.core.repository.LogRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogService implements LogRepository{

    private final DebugRepository debugRepository;
    private final ExceptionRepository exceptionRepository;

    public LogService(DebugRepository debugRepository, ExceptionRepository exceptionRepository) {
        this.debugRepository = debugRepository;
        this.exceptionRepository = exceptionRepository;
    }

    @Override
    public void logMessage(LogType logType, long systemTypeId, String methodParams) {
        switch (logType) {
            case DEBUG:
                Debug debug = new Debug();
                debug.setSystemTypeId(systemTypeId);
                debug.setMethodParams(methodParams);
                debugRepository.save(debug);
                log.info("DEBUG SystemTypeId =" +  systemTypeId +"; MethodParams = " + methodParams);
                break;
            case EXCEPTION:
                Exception exception = new Exception();
                exception.setSystemTypeId(systemTypeId);
                exception.setMethodParams(methodParams);
                exceptionRepository.save(exception);
                log.info("EXCEPTION SystemTypeId =" +  systemTypeId +"; MethodParams = " + methodParams);
                break;
            default:
                log.info("UNKNOWN SystemTypeId =" +  systemTypeId +"; MethodParams = " + methodParams);
        }
    }
}
