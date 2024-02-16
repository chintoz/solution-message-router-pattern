package es.menasoft.sender.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String topicExchangeName = "content-exchange";

    static final String carQueueName = "car-content-queue";

    static final String personQueueName = "person-content-queue";

    @Bean
    Queue carQueue() {
        return new Queue(carQueueName, false);
    }

    @Bean
    Queue personQueue() { return new Queue(personQueueName, false);}

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding bindingCar(Queue carQueue, TopicExchange exchange) {
        return BindingBuilder.bind(carQueue).to(exchange).with("car");
    }

    @Bean
    Binding bindingPerson(Queue personQueue, TopicExchange exchange) {
        return BindingBuilder.bind(personQueue).to(exchange).with("person");
    }

}
