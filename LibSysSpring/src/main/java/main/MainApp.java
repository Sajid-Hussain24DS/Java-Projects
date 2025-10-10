package main;

import Config.AppConfig;
import ui.LoginForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        try {
            System.out.println("🚀 Starting Application...");

            // ✅ Single Spring context creation
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

            System.out.println("✅ Spring Context Initialized!");

            SwingUtilities.invokeLater(() -> {
                LoginForm loginForm = context.getBean(LoginForm.class);
                loginForm.setVisible(true);
                System.out.println("🎯 Login Form Displayed!");
            });

        } catch (Exception e) {
            System.err.println("Application Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}