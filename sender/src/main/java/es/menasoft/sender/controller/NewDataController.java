package es.menasoft.sender.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.menasoft.sender.messaging.RabbitMqConfig;
import es.menasoft.sender.model.Car;
import es.menasoft.sender.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class NewDataController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/car")
    public ResponseEntity<Car> newCar(@RequestBody  Car car) throws JsonProcessingException {
        Message message = new Message(new ObjectMapper().writeValueAsString(car).getBytes());
        rabbitTemplate.convertAndSend(RabbitMqConfig.topicExchangeName, "car", message);
        return ResponseEntity.ok(car);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> newPerson(@RequestBody Person person) throws JsonProcessingException {
        Message message = new Message(new ObjectMapper().writeValueAsString(person).getBytes());
        rabbitTemplate.convertAndSend(RabbitMqConfig.topicExchangeName, "person", message);
        return ResponseEntity.ok(person);
    }

}
