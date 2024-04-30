package id.my.hendisantika.paymentdetailsservice.controller;

import id.my.hendisantika.paymentdetailsservice.exception.ReferenceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:29
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class RestExceptionHandler {
    @ExceptionHandler(ReferenceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleReferenceNotFoundException(ReferenceNotFoundException e) {

        return ResponseEntity.status(NOT_FOUND).body(ApiErrorResponse.builder()
                .errorCode(NOT_FOUND.value())
                .description(e.getMessage())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnknownException(Exception e) {

        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ApiErrorResponse.builder()
                .errorCode(INTERNAL_SERVER_ERROR.value())
                .description(e.getMessage())
                .build());
    }
}
