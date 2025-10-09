package service;

import model.Account;
import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    void addAccount(Account account) throws SQLException;
    Account getAccountById(int id) throws SQLException;
    List<Account> getAllAccounts() throws SQLException;
    void updateAccount(Account account) throws SQLException;
    void deleteAccount(int id) throws SQLException;
}
