package id.my.hendisantika.paymentdetailsservice.exception;

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
public class ReferenceNotFoundException extends RuntimeException {

    public ReferenceNotFoundException(String message) {
        super(message);
    }
}
