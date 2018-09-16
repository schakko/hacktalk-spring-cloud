package de.schakko.cloud.gateway.proxy.filter;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class TimestampTraceFilter implements GlobalFilter {

	public final static String HTTP_TRACE_HEADER = "x-trace-begin";

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		final ServerWebExchange exchange2 = exchange.mutate().request(
				exchange.getRequest().mutate().header(HTTP_TRACE_HEADER, "" + System.currentTimeMillis()).build())
				.build();

		return chain.filter(exchange2).then(Mono.fromRunnable(() -> {
			List<String> t = exchange2.getRequest().getHeaders().get(HTTP_TRACE_HEADER);

			if (t != null && (t.size() > 0)) {
				long delay = System.currentTimeMillis() - ((Long.valueOf(t.get(0))));

				// TODO: how to mutate body? see WebClientWriteResponseFilter as possible template
				// ClientResponse clientResponse = exchange.getAttribute(CLIENT_RESPONSE_ATTR);
				// clientResponse.body(BodyExtractors.toDataBuffers());
				
				exchange2.getResponse().getHeaders().add("x-delay", "" + delay);
			} else {
				exchange2.getResponse().getHeaders().add("x-error", "Missing trace key");

			}
		}));
	}
}
