package service;

import model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    boolean addUser(User user) throws SQLException;
    User getUserById(int id) throws SQLException;
    List<User> getAllUsers() throws SQLException;
    boolean updateUser(User user) throws SQLException;
    boolean deleteUser(int id) throws SQLException;
}
