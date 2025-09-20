package serviceImpl;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import model.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() throws SQLException {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean addUser(User user) throws SQLException {
       return userDao.addUser(user);
    }

    @Override
    public User getUserById(int id) throws SQLException {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userDao.getAllUsers();
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
      return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
       return userDao.deleteUser(id);
    }
}
