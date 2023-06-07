package com.panvdev.apirest_prueba.chat;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageEndpoint {

	@MessageMapping("/request")
	@SendTo("/queue/responses")
	public String onMessage(String message){
		System.out.println(message);
		return message;
	}

}
