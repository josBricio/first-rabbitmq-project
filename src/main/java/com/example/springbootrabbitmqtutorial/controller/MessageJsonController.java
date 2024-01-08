package com.example.springbootrabbitmqtutorial.controller;


import com.example.springbootrabbitmqtutorial.DTOs.UserDTO;
import com.example.springbootrabbitmqtutorial.publisher.RabbitMQJsonProducer;
import com.example.springbootrabbitmqtutorial.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/json")
public class MessageJsonController {

    @Autowired
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody UserDTO user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ");
    }

}
