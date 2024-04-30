package id.my.hendisantika.paymentdetailsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:24
 * To change this template use File | Settings | File Templates.
 */
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record AccountDto(@JsonProperty("bank_id") String bankId,
                         @JsonProperty("account_number") String accountNumber,
                         @JsonProperty("iban") String iban,
                         @JsonProperty("account_owner") String accountOwner) {

    public static AccountDto fromDomain(Account account) {
        return AccountDto.builder()
                .bankId(account.bankId())
                .accountNumber(account.accountNumber())
                .iban(account.iban())
                .accountOwner(account.accountOwner())
                .build();
    }

    public Account fromDto() {
        return new Account(bankId, accountNumber, iban, accountOwner);
    }
}
