package de.schakko.cloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class EchoApiController {
	@RequestMapping("/")
	public String index(WebRequest request) {
		StringBuilder sb = new StringBuilder();
		
		request.getHeaderNames().forEachRemaining(c -> sb.append(c).append(" -> ").append(request.getHeader(c)).append("<br />"));
		
		return sb.toString();
	}
}
