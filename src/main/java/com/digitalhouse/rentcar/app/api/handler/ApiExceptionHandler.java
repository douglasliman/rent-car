package com.digitalhouse.rentcar.app.api.handler;

import com.digitalhouse.rentcar.domain.exception.CategoryNotFoundException;
import com.digitalhouse.rentcar.domain.exception.CityNotFoundException;
import com.digitalhouse.rentcar.domain.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> categoryNotFoundExceptionHandler(CategoryNotFoundException e){
        return ResponseEntity.badRequest().body(
                """
                    {
                        "status"  : 400,
                        "message" : "%s"
                    }    \s
                """.formatted(e.getMessage())
        );
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<?> cityNotFoundExceptionHandler(CityNotFoundException e){
        return ResponseEntity.badRequest().body(
                """
                    {
                        "status"  : 400,
                        "message" : "%s"
                    }    \s
                """.formatted(e.getMessage())
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundExceptionHandler(ProductNotFoundException e){
        return ResponseEntity.badRequest().body(
                """
                    {
                        "status"  : 400,
                        "message" : "%s"
                    }    \s
                """.formatted(e.getMessage())
        );
    }
}
