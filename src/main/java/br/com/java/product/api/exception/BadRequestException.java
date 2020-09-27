package br.com.java.product.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request: Not a valid value")
public class BadRequestException extends RuntimeException{
}
