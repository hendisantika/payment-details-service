package id.my.hendisantika.paymentdetailsservice.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

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
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiErrorResponse(int errorCode,
                               String description) {
}
