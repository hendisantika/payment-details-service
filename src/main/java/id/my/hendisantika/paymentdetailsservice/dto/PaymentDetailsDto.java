package id.my.hendisantika.paymentdetailsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * Time: 08:25
 * To change this template use File | Settings | File Templates.
 */
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record PaymentDetailsDto(@JsonProperty("sending_account") AccountDto sendingAccount,
                                @JsonProperty("receiving_account") AccountDto receivingAccount,
                                @NonNull @JsonProperty("reference") String reference,
                                @JsonProperty("amount") BigDecimal amount,
                                @JsonProperty("currency") String currency) {


    public static PaymentDetailsDto fromDomain(PaymentDetails paymentDetails) {
        return PaymentDetailsDto.builder()
                .sendingAccount(AccountDto.fromDomain(paymentDetails.sendingAccount()))
                .receivingAccount(AccountDto.fromDomain(paymentDetails.receivingAccount()))
                .reference(paymentDetails.reference())
                .amount(paymentDetails.amount())
                .currency(paymentDetails.currency())
                .build();
    }

    public PaymentDetails toModel() {
        return new PaymentDetails(sendingAccount.fromDto(),
                receivingAccount.fromDto(),
                reference,
                amount,
                currency,
                LocalDateTime.now());
    }
}
