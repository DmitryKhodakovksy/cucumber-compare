package w3shools.configuration;

import com.epam.cucumber.compare.qa.common.gui.configuration.WebdriverConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({WebdriverConfig.class})
@ComponentScan("com.epam.cucumber.compare.qa.common")
@PropertySources({
        @PropertySource("classpath:env/${NG_ENV:dev}.properties"),
        @PropertySource("classpath:core/webdrivermanager.properties")
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Value("${rpEnabled:false}")
    private String reportPortalProviderEnabled;

    @Bean
    public Boolean reportPortalProviderEnabled() {
        return Boolean.valueOf(reportPortalProviderEnabled);
    }

}
