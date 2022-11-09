package medical.common.core.repository;

import liga.medical.dto.LogType;

public interface LogRepository {
    void logMessage(LogType logType, long systemTypeId, String methodParams);
}
