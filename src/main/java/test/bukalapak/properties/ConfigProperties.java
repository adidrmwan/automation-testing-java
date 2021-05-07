package test.bukalapak.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties({
        ConfigProperties.class
})
@ConfigurationProperties(prefix = "config")
public class ConfigProperties {

    private Web web;

    @Data
    public static class Web {
        private String baseUrl;
    }
}
