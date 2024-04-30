package id.my.hendisantika.paymentdetailsservice.service;

import id.my.hendisantika.paymentdetailsservice.exception.ReferenceNotFoundException;
import id.my.hendisantika.paymentdetailsservice.model.PaymentDetails;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:27
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class PaymentDetailsService {

    private static final long TIME_TO_LIVE = 10;

    private final RMapCache<String, PaymentDetails> cache;

    public PaymentDetailsService(RedissonClient redissonClient) {
        cache = redissonClient.getMapCache("PaymentDetails");
    }

    public void store(PaymentDetails paymentDetails) {
        try {
            cache.put(paymentDetails.reference(), paymentDetails, TIME_TO_LIVE, TimeUnit.MINUTES);
        } catch (RuntimeException e) {
            log.warn("Could not store payment details {}", paymentDetails, e);
        }
    }

    public PaymentDetails get(String reference) {
        return Optional.ofNullable(cache.get(reference))
                .orElseThrow(() -> new ReferenceNotFoundException("No reference found with number " + reference));
    }
}
