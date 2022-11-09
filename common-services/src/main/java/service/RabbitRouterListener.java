package service;

import api.RabbitRouterService;
import liga.medical.dto.QueueNames;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitRouterListener {
    private final RabbitRouterService rabbitRouterService;

    public RabbitRouterListener(RabbitRouterService rabbitRouterService){
        this.rabbitRouterService = rabbitRouterService;
    }

    @RabbitListener(queues = QueueNames.QUEUE)
    public void receiveAndRedirectMessage(String message){
        rabbitRouterService.routeMessage(message);
    }
}
