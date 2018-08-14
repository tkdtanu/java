package com.tkd.kafka.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageConsumerController {
	
	
	@KafkaListener(topics = "${kafka.topicName}", groupId = "${kafka.groupId}")
	public void receive(String payLoad) {
		System.out.println("******Message*******"+payLoad);
	}

}
