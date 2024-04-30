package id.my.hendisantika.paymentdetailsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Project : payment-details-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/30/24
 * Time: 08:21
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties(prefix = "kafka")
public record KafkaProperties(String bootstrapServers,
                              boolean saslEnabled,
                              Consumer consumer) {

    public record Consumer(ConsumerProperties paymentDetails) {

    }

    public record ConsumerProperties(
            String groupId,
            String autoOffsetReset) {

    }
}
