package serviceImpl;

import dao.AccountDao;
import daoImpl.AccountDaoImpl;
import model.Account;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() throws SQLException {
        this.accountDao = new AccountDaoImpl();
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        accountDao.addAccount(account);
    }

    @Override
    public Account getAccountById(int id) throws SQLException {
        return accountDao.getAccountById(id);
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException {
        return accountDao.getAllAccounts();
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(int id) throws SQLException {
        accountDao.deleteAccount(id);
    }
}
