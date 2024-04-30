package id.my.hendisantika.paymentdetailsservice.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Optional;

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
    @Bean
    ConcurrentKafkaListenerContainerFactory<String, String> paymentDetailsKafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        var consumerProperties = kafkaProperties.consumer().paymentDetails();

        var props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.bootstrapServers());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, consumerProperties.groupId());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerProperties.autoOffsetReset());

    /*
    To ensure that messages are processed only once, we can use MANUAL_IMMEDIATE acknowledgment mode.
    With that being used, we must explicitly acknowledge each message that the listener receives.
    Otherwise, the message will be redelivered to the consumer.
     */
        var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(props, StringDeserializer::new, StringDeserializer::new));
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    @Bean()
    public RedissonClient redisson(RedisProperties properties, ObjectMapper objectMapper) {

        Config config = new Config()
                .setCodec(new TypedJsonJacksonCodec(new TypeReference<String>() {
                }, new TypeReference<PaymentDetails>() {
                }, objectMapper));
        String redisHost = "redis://" + properties.host() + ":" + properties.port();

        Optional.of(properties.mode())
                .filter(m -> m == RedisProperties.RedisMode.SINGLE)
                .ifPresentOrElse(
                        m -> config.useSingleServer().setAddress(redisHost),
                        () -> config.useClusterServers().addNodeAddress(redisHost));

        return Redisson.create(config);
    }

}
