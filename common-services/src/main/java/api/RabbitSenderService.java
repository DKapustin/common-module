package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.dto.MessageDto;

public interface RabbitSenderService {
    void sendMessage(MessageDto messageDTO, String names) throws JsonProcessingException;
    void sendError(String str);
}
