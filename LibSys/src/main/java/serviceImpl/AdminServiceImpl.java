package serviceImpl;

import dao.AdminDao;
import daoimpl.AdminDaoImpl;
import model.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

    private final AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username, password);
    }

    @Override
    public void goBack() {
        System.out.println("Navigating back to Dashboard...");
    }
}
