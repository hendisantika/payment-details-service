package id.my.hendisantika.paymentdetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "id.my.hendisantika.paymentdetailsservice", exclude = {DataSourceAutoConfiguration.class})
public class PaymentDetailsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentDetailsServiceApplication.class, args);
    }

}
