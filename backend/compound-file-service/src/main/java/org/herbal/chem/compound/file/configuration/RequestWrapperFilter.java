package org.herbal.chem.compound.file.configuration;

import org.springframework.web.filter.ForwardedHeaderFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestWrapperFilter extends ForwardedHeaderFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        HeaderMapRequestWrapper headerMapRequestWrapper = new HeaderMapRequestWrapper(request);

        filterChain.doFilter(headerMapRequestWrapper, response);
    }
}
