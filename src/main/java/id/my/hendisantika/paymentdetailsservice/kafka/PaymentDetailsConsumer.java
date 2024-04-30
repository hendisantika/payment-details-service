package id.my.hendisantika.paymentdetailsservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.paymentdetailsservice.service.PaymentDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:28
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@AllArgsConstructor
@Component
public class PaymentDetailsConsumer {

    private final ObjectMapper objectMapper;
    private final PaymentDetailsService paymentDetailsService;
}
