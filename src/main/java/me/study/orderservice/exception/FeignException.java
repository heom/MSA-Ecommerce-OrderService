package me.study.orderservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FeignException extends RuntimeException {

    private HttpStatus httpStatus;

    public FeignException(String methodKey, String message, HttpStatus httpStatus) {
        super(String.format("[%s] %s", methodKey, message));
        this.httpStatus = httpStatus;
    }
}
