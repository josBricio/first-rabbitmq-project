package com.example.springbootrabbitmqtutorial.publisher;

import com.example.springbootrabbitmqtutorial.DTOs.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonProducer.class);


    public void sendJsonMessage(UserDTO user){
        LOGGER.info(String.format("Json message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
    }

}
