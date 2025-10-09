package daoImpl;

import dao.PurchaseDetailDao;
import model.PurchaseDetail;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDetailDaoImpl implements PurchaseDetailDao {
    private Connection conn;

    public PurchaseDetailDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }
 
    @Override
public boolean addPurchaseDetail(PurchaseDetail purchaseDetail) throws SQLException {
    String sql = "INSERT INTO purchase_details(product_id, quantity, price, purchase_id) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, purchaseDetail.getProductId());
    ps.setInt(2, purchaseDetail.getQuantity());
    ps.setInt(3, purchaseDetail.getPrice());
    ps.setInt(4, purchaseDetail.getPurchaseId());
    int rows = ps.executeUpdate();
    return rows > 0;
}

@Override
public PurchaseDetail getPurchaseDetailById(int id) throws SQLException {
    String sql = "SELECT * FROM purchase_details WHERE pd_id=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        return new PurchaseDetail(
            rs.getInt("pd_id"),
            rs.getInt("product_id"),
            rs.getInt("quantity"),
            rs.getInt("price"),
            rs.getInt("purchase_id")
        );
    }
    return null;
}

@Override
public List<PurchaseDetail> getAllPurchaseDetails() throws SQLException {
    List<PurchaseDetail> list = new ArrayList<>();
    String sql = "SELECT * FROM purchase_details";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);
    while (rs.next()) {
        list.add(new PurchaseDetail(
            rs.getInt("pd_id"),
            rs.getInt("product_id"),
            rs.getInt("quantity"),
            rs.getInt("price"),
            rs.getInt("purchase_id")
        ));
    }
    return list;
}

@Override
public boolean updatePurchaseDetail(PurchaseDetail purchaseDetail) throws SQLException {
    String sql = "UPDATE purchase_details SET product_id=?, quantity=?, price=?, purchase_id=? WHERE pd_id=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, purchaseDetail.getProductId());
    ps.setInt(2, purchaseDetail.getQuantity());
    ps.setInt(3, purchaseDetail.getPrice());
    ps.setInt(4, purchaseDetail.getPurchaseId());
    ps.setInt(5, purchaseDetail.getPdId());
    int rows = ps.executeUpdate();
    return rows > 0;
}

@Override
public boolean deletePurchaseDetail(int id) throws SQLException {
    String sql = "DELETE FROM purchase_details WHERE pd_id=?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, id);
    int rows = ps.executeUpdate();
    return rows > 0;
}
}