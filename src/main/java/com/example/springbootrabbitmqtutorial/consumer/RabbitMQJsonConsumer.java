package com.example.springbootrabbitmqtutorial.consumer;

import com.example.springbootrabbitmqtutorial.DTOs.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(UserDTO user) {
        LOGGER.info(String.format("Json message recived -> %s", user.toString()));
    }

}
