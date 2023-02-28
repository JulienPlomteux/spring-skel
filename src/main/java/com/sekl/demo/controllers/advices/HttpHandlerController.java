package com.sekl.demo.controllers.advices;

import com.sekl.demo.controllers.exceptions.ResourceNotFoundException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HttpHandlerController {
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ResponseBody
  public ResourceNotFoundException resourceNotFound() {
    return ResourceNotFoundException.builder()
        .code("resource-not-found")
        .message("No resource found for this id")
        .build();
  }
}
