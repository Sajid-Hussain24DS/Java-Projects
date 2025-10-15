package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "dao",
        "daoimpl",
        "ui",
        "serviceImpl",
        "database",
        "model"

})
public class AppConfig {
}