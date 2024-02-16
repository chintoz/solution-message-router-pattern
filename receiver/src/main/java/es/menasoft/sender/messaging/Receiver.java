package es.menasoft.sender.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Receiver {

  public void handleMessage(byte[] message) {
    System.out.println("Received <" + new String(message) + ">");
  }

}