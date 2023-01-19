package org.herbal.chem.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.herbal.chem.api.exception.InvalidInputException;
import org.herbal.chem.api.exception.NotFoundException;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class HttpClientErrorExceptionHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RuntimeException throwNewException(HttpClientErrorException e) {
        switch (e.getStatusCode()) {
            case NOT_FOUND:
                return new NotFoundException(getExceptionDetail(e));
            case UNPROCESSABLE_ENTITY:
                return new InvalidInputException(getExceptionDetail(e));
            default:
                return e;
        }
    }

    public String getExceptionDetail(HttpClientErrorException e) {
        try {
            return objectMapper.readValue(e.getResponseBodyAsString(), Problem.class).getDetail();
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
