package medical.common.core.service;

import lombok.RequiredArgsConstructor;
import medical.common.core.repository.LogRepository;
import model.LogDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    public void addLogDebug(LogDto logDto) {
        logRepository.addLogDebug(logDto);
    }

    public void addLogException(LogDto logDto){
        logRepository.addLogException(logDto);
    }
}
