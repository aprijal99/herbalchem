package org.herbal.chem.compound.file.configuration;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
    @Value("${forwarded.host}")
    private String forwardedHost;

    public HeaderMapRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> headerNames = Collections.list(super.getHeaderNames());
        headerNames.remove("forwarded");
        headerNames.remove("x-forwarded-for");
        headerNames.remove("x-forwarded-proto");
        headerNames.remove("x-forwarded-port");
        headerNames.remove("host");

        return Collections.enumeration(headerNames);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        if (name.equals("x-forwarded-host")) {
            return Collections.enumeration(List.of(forwardedHost));
        }

        return super.getHeaders(name);
    }
}
