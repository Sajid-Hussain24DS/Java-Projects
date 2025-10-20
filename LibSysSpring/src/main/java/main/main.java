package Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Config.AppConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import ui.LoginForm;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        System.out.println("Spring Started Successfully!");

        LoginForm loginForm = context.getBean(LoginForm.class);
        loginForm.setVisible(true);

        System.out.println("✅ Login Form Opened!");
    }
}