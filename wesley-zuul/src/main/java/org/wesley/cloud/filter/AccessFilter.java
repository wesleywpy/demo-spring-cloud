package org.wesley.cloud.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @author Created by Wesley on 2016/9/14.
 */
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
