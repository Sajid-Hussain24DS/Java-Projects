package daoImpl;

import dao.PurchaseDao;
import model.Purchase;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDaoImpl implements PurchaseDao {
    private Connection conn;

    public PurchaseDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addPurchase(Purchase purchase) throws SQLException {
        String sql = "INSERT INTO purchase(purchase_no, total_amount, purchase_date, vendor_id) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, purchase.getPurchaseNo());
        ps.setInt(2, purchase.getTotalAmount());
        ps.setDate(3, purchase.getPurchaseDate());
        ps.setInt(4, purchase.getVendorId());
        int rows = ps.executeUpdate();
        return rows >0;
    }

    @Override
    public Purchase getPurchaseById(int id) throws SQLException {
        String sql = "SELECT * FROM purchase WHERE purchase_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Purchase(
                rs.getInt("purchase_id"),
                rs.getString("purchase_no"),
                rs.getInt("total_amount"),
                rs.getDate("purchase_date"),
                rs.getInt("vendor_id")
            );
        }
        return null;
    }

    @Override
    public List<Purchase> getAllPurchases() throws SQLException {
        List<Purchase> list = new ArrayList<>();
        String sql = "SELECT * FROM purchase";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Purchase(
                rs.getInt("purchase_id"),
                rs.getString("purchase_no"),
                rs.getInt("total_amount"),
                rs.getDate("purchase_date"),
                rs.getInt("vendor_id")
            ));
        }
        return list;
    }

    @Override
    public boolean updatePurchase(Purchase purchase) throws SQLException {
        String sql = "UPDATE purchase SET purchase_no=?, total_amount=?, purchase_date=?, vendor_id=? WHERE purchase_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, purchase.getPurchaseNo());
        ps.setInt(2, purchase.getTotalAmount());
        ps.setDate(3, purchase.getPurchaseDate());
        ps.setInt(4, purchase.getVendorId());
        ps.setInt(5, purchase.getPurchaseId());
         int rows = ps.executeUpdate();
        return rows >0;
    }

    @Override
    public boolean deletePurchase(int id) throws SQLException {
        String sql = "DELETE FROM purchase WHERE purchase_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
       int rows = ps.executeUpdate();
        return rows >0;
    }
}
