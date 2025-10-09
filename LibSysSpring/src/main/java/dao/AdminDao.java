package dao;

import model.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminDao {
    Admin login(String username, String password);
    void back();
}
