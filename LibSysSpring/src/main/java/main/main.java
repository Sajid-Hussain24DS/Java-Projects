package Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import Config.AppConfig;
import ui.LoginForm;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("🚀 Spring Started Successfully!");

        LoginForm loginForm = context.getBean(LoginForm.class);
        loginForm.setVisible(true);

        System.out.println("✅ Login Form Opened!");
    }
}