package dao;

import java.sql.SQLException;
import model.Account;
import java.util.List;

public interface AccountDao {
    boolean addAccount(Account account)throws SQLException ;
    Account getAccountById(int id)throws SQLException ;
    List<Account> getAllAccounts() throws SQLException ;
    boolean updateAccount(Account account) throws SQLException ;
    boolean deleteAccount(int id) throws SQLException ;
}
