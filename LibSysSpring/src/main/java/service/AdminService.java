package service;

import model.Admin;

public interface AdminService {
    Admin login(String username, String password);
    void goBack();
}
