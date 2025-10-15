package dao;

import model.Admin;
public interface AdminDao {
    Admin login(String username, String password);
    void back();
}
