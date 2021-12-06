package test.automation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@EnableConfigurationProperties({
        DriverWebProperties.class
})

@ConfigurationProperties(prefix = "driver.web.capabilities")
public class DriverWebProperties {
    private String browser;
    private boolean acceptInsecureCerts;
    private boolean headless;
}
