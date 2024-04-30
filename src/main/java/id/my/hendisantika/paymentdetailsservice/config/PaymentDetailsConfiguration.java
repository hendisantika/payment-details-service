package id.my.hendisantika.paymentdetailsservice.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:22
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableConfigurationProperties({RedisProperties.class, KafkaProperties.class})
public class PaymentDetailsConfiguration {
}
