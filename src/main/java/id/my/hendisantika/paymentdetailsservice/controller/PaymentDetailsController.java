package id.my.hendisantika.paymentdetailsservice.controller;

import id.my.hendisantika.paymentdetailsservice.service.PaymentDetailsService;
import lombok.extern.slf4j.Slf4j;
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
}
