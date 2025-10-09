package model;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private int id;
    private String username;
    private String password;

    // Constructor
    public Admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", username=" + username + "]";
    }
}
