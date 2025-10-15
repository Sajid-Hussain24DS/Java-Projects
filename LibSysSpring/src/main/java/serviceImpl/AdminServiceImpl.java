package serviceImpl;

import dao.AdminDao;
import daoimpl.AdminDaoImpl;
import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username, password);
    }

    @Override
    public void goBack() {
        System.out.println("Navigating back to Dashboard...");
    }
}
