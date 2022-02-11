package com.springboot.ecommerce.common.error;

import com.springboot.ecommerce.common.exception.DefaultExceptionTranslator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ApiErrorControllerAdvice
{
    private final DefaultExceptionTranslator exceptionTranslator;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception cause) {
        log.trace("ApiErrorControllerAdvice caught exception", cause);
        return exceptionTranslator.translate(cause);
    }
}
