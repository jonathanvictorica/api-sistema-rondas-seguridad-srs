package com.utn.frba.srs.controller;

import com.utn.frba.srs.exception.SRSException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
@Log4j2
class GlobalExceptionHandler {


    public static final String ERROR = "error";
    public static final String ERROR_CODE = "errorCode";
    public static final String PATH = "path";
    public static final String STATUS = "status";
    public static final String TIMESTAMP = "timestamp";
    public static final String DEFAULT_MESSAGE = "default message ";




    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest req, Exception ex) {
        Map<String, Object> result = new HashMap<>();
        String[] messages = ex.toString().split(DEFAULT_MESSAGE);
        result.put(TIMESTAMP, LocalDateTime.now());
        result.put(STATUS, HttpStatus.BAD_REQUEST.value());
        result.put(ERROR, messages[messages.length - 1]);
        result.put(PATH, new UrlPathHelper().getPathWithinApplication(req));
        log.error(ERROR + ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SRSException.class)
    public ResponseEntity<Map<String, Object>> handleErrorBusinessException(HttpServletRequest req, SRSException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put(TIMESTAMP, LocalDateTime.now());
        result.put(STATUS, HttpStatus.BAD_REQUEST.value());
        result.put(ERROR_CODE, ex.getCode());
        result.put(ERROR, ex.getMessage());
        result.put(PATH, new UrlPathHelper().getPathWithinApplication(req));
        return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }

}
