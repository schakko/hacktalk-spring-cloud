package de.schakko.cloud.zuulproxy.proxy.filter;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * This filter inspects the request header and checks for
 * {@link AddRequestHeaderFilter#HTTP_TRACE_HEADER} to calculate the lasted
 * duration of an HTTP request.
 * 
 * @author ckl
 *
 */
@Component
public class AddResponseHeaderFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();

		ctx.addOriginResponseHeader("X-Zuul-Outgoing", "outgoing");
		Map<String, String> requestHeaders = ctx.getZuulRequestHeaders();

		if (requestHeaders.containsKey(AddRequestHeaderFilter.HTTP_TRACE_HEADER)) {
			try {
				long delay = System.currentTimeMillis()
						- ((Long.valueOf(requestHeaders.get(AddRequestHeaderFilter.HTTP_TRACE_HEADER))));
				// ctx.getResponseBody is null at this point
				InputStream is = ctx.getResponseDataStream();
				String body = StreamUtils.copyToString(is, Charset.forName("UTF-8"));

				ctx.setResponseBody(body + String.format(" <br /><strong>Delay: %d ms</strong>", delay));
			} catch (Exception e) {
				ctx.setResponseBody(" Error: Delay could not be determined");
			}
		}

		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		/**
		 * if filterOder is >= 1000, setResponseBody won't result in setting the
		 * body as SendResponseFilter has already sent the response.
		 */
		return 1;
	}

	@Override
	public String filterType() {
		return "post";
	}
}
