package com.tkd.kafka.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisherController {

	@Value("${kafka.topicName}")
	private String topicName;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@PostMapping("/pushMessage")
	public ResponseEntity<String> publishMessage(@RequestBody Map<String, String> request){
		String message = request.get("message");
		kafkaTemplate.send(topicName, message);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
