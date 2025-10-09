package service;

import model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin login(String username, String password);
    void goBack();
}
