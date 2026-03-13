package annotation_config.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@PropertySource(value= "classpath:di.property")
@Configuration
@ComponentScan(basePackages = "annotation_config")
public class AppConfig
{

}
