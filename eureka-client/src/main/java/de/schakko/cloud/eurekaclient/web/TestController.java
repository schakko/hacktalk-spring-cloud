package de.schakko.cloud.eurekaclient.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
	@RequestMapping("/")
	public String index() {
		return "test";
	}
}
