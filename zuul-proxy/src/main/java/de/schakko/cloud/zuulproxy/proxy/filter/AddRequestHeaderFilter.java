package de.schakko.cloud.zuulproxy.proxy.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * A simple filter to add a few HTTP headers from incoming connections which
 * will be forwarded to the backend microservices.
 * 
 * @author ckl
 *
 */
@Component
public class AddRequestHeaderFilter extends ZuulFilter {

	public final static String HTTP_TRACE_HEADER = "x-trace-begin";

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();

		ctx.addZuulRequestHeader("X-Zuul-Incoming", "incoming");
		ctx.addZuulRequestHeader(HTTP_TRACE_HEADER, "" + System.currentTimeMillis());

		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1000;
	}

	@Override
	public String filterType() {
		return "pre";
	}
}
