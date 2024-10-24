package com.beat.kafkaexample;


import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class KafkaListeners {

  @KafkaListener(
      topics = "beat",
      groupId="groupId"
  )
  void listener(String data){
    System.out.println("Listener received: " + data + " 👍");
  }
}
