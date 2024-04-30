package id.my.hendisantika.paymentdetailsservice.controller;

import id.my.hendisantika.paymentdetailsservice.dto.PaymentDetailsDto;
import id.my.hendisantika.paymentdetailsservice.model.PaymentDetails;
import id.my.hendisantika.paymentdetailsservice.service.PaymentDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:30
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
public class PaymentDetailsController {

    private final PaymentDetailsService paymentDetailsService;

    public PaymentDetailsController(PaymentDetailsService paymentDetailsService) {
        this.paymentDetailsService = paymentDetailsService;
    }

    @GetMapping("/v1/payment-details/{reference}")
    public ResponseEntity<PaymentDetailsDto> getPaymentDetails(@PathVariable("reference") String reference) {
        log.debug("Received GET request: {}", reference);

        PaymentDetails paymentDetails = paymentDetailsService.get(reference);
        log.info("payment details {}", paymentDetails);
        var paymentDetailsDto = PaymentDetailsDto.fromDomain(paymentDetails);
        return ResponseEntity.ok().body(paymentDetailsDto);
    }
}
