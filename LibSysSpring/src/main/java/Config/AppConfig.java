package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
    "dao", 
    "daoImpl", 
    "database", 
    "model", 
    "service", 
    "serviceImpl", 
    "ui"
})
public class AppConfig {
    
}