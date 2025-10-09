package ui; // same package as LoginForm, ya alag package bhi ho sakta hai

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        // Spring context initialize
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.AppConfig.class);

        // LoginForm ko Spring context se get karo
        LoginForm loginForm = context.getBean(LoginForm.class);

        // Swing thread me display karo
        java.awt.EventQueue.invokeLater(() -> loginForm.setVisible(true));
    }
}
