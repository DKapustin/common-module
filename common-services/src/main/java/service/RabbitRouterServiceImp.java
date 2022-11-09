package service;

import api.RabbitRouterService;
import api.RabbitSenderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.MessageDto;
import liga.medical.dto.MessageType;
import liga.medical.dto.QueueNames;
import org.springframework.stereotype.Service;

@Service
public class RabbitRouterServiceImp implements RabbitRouterService {
    private final ObjectMapper objectMapper;
    private final RabbitSenderService rabbitSenderService;

    public RabbitRouterServiceImp(ObjectMapper objectMapper, RabbitSenderService rabbitSenderService) {
        this.objectMapper = objectMapper;
        this.rabbitSenderService = rabbitSenderService;
    }

    @Override
    public void routeMessage(String message) {
        try {
            MessageDto messageDto = objectMapper.readValue(message, MessageDto.class);
            MessageType messageType = messageDto.getMessageType();
            switch (messageType) {
                case DAILY:
                    rabbitSenderService.sendMessage(messageDto, QueueNames.DAILY_QUEUE_NAME);
                    break;
                case ALERT:
                    rabbitSenderService.sendMessage(messageDto, QueueNames.ALERT_QUEUE_NAME);
                    break;
                case ERROR:
                    rabbitSenderService.sendMessage(messageDto, QueueNames.ERROR_QUEUE_NAME);
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            rabbitSenderService.sendError(e.getMessage());
        }
    }
}
