package id.my.hendisantika.paymentdetailsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
@ConfigurationProperties(prefix = "payment-details.redis")
public record RedisProperties(String host,
                              String port,
                              RedisMode mode) {

    public enum RedisMode {SINGLE, CLUSTER}
}
