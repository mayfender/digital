package com.may.ple.dg.ricoh.action.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreeingController {

	@MessageMapping("/greeting")
	public String handle(String greeting) {
		System.out.println(greeting);
		return "[" + greeting +"]";
	}

}
