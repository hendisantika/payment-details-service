package id.my.hendisantika.paymentdetailsservice.model;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:26
 * To change this template use File | Settings | File Templates.
 */
@Builder(toBuilder = true)
public record PaymentDetails(Account sendingAccount,
                             Account receivingAccount,
                             String reference,
                             BigDecimal amount,
                             String currency,
                             LocalDateTime timestamp) {
}
