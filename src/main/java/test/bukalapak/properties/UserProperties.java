package test.bukalapak.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Data
@Configuration
@EnableConfigurationProperties({
        UserProperties.class
})
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private HashMap<String, String> customer;
}
