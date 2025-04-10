package com.hotel.auditoria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;

@Component
public class AuditoriaConsumer {

    @RabbitListener(queues = "hotel-auditoria")
    public void receiveMessage(byte[] message) {
        System.out.println("Auditoria recebeu: " + new String(message, StandardCharsets.UTF_8));
    }
}
