package org.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 过滤器
 */
@Component
public class RoutingFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(RoutingFilter.class);

    @Override
    public String filterType() {
        logger.debug("routing....");
        return "routing";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.debug("routing run ....");
        return null;
    }
}
