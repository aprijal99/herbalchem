package org.herbal.chem.util;

import lombok.extern.slf4j.Slf4j;
import org.herbal.chem.api.exception.InvalidInputException;
import org.herbal.chem.api.exception.NotFoundException;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerErrorException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Problem> notFoundExceptionHandler(NotFoundException e) {
        log.warn("Resource is not found");

        Problem compoundIsNotFound = Problem.create()
                .withStatus(HttpStatus.NOT_FOUND)
                .withTitle("Compound is not found")
                .withDetail(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(compoundIsNotFound);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Problem> invalidInputExceptionHandler(InvalidInputException e) {
        log.warn("Input value is invalid");

        Problem inputValueIsInvalid = Problem.create()
                .withStatus(HttpStatus.UNPROCESSABLE_ENTITY)
                .withTitle("Input value is invalid")
                .withDetail(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(inputValueIsInvalid);
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<Problem> serverErrorExceptionHandler(ServerErrorException e) {
        log.error(e.getMessage());

        Problem serverIsError = Problem.create()
                .withStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .withTitle("Server is error")
                .withDetail(e.getMessage());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE)
                .body(serverIsError);
    }
}
