package daoImpl;

import dao.AccountDao;
import model.Account;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private Connection conn;

    public AccountDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addAccount(Account account) throws SQLException {
        String sql = "INSERT INTO accounts(bank, account_number, total_balance) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, account.getBank());
        ps.setString(2, account.getAccountNumber());
        ps.setString(3, account.getTotalBalance());
        int rows = ps.executeUpdate();
        
        return rows>0;
    }
    @Override
    public Account getAccountById(int id) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE acc_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Account(
                rs.getInt("acc_id"),
                rs.getString("bank"),
                rs.getString("account_number"),
                rs.getString("total_balance")
            );
        }
        return null;
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM accounts";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Account(
                rs.getInt("acc_id"),
                rs.getString("bank"),
                rs.getString("account_number"),
                rs.getString("total_balance")
            ));
        }
        return list;
    }

    @Override
    public boolean updateAccount(Account account) throws SQLException {
        String sql = "UPDATE accounts SET bank=?, account_number=?, total_balance=? WHERE acc_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, account.getBank());
        ps.setString(2, account.getAccountNumber());
        ps.setString(3, account.getTotalBalance());
        ps.setInt(4, account.getAccId());
        int rows = ps.executeUpdate();
        return rows > 0;
         
    }
    @Override
    public boolean deleteAccount(int id) throws SQLException {
        String sql = "DELETE FROM accounts WHERE acc_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        return rows > 0;
    }
}
