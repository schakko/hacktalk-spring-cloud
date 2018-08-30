package de.schakko.cloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class AuthenticationApiController {
	@RequestMapping("/login")
	public String login(WebRequest request) {
		return "Hello";
	}

	@RequestMapping("/logout")
	public String logout(WebRequest request) {
		return "Aww :-/";
	}
}
