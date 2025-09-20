package daoImpl;

import dao.VendorDao;
import model.Vendor;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorDaoImpl implements VendorDao {
    private Connection conn;

    public VendorDaoImpl() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public boolean addVendor(Vendor vendor) throws SQLException {
        String sql = "INSERT INTO vendor(name, contact, address, account_num) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendor.getName());
        ps.setString(2, vendor.getContact());
        ps.setString(3, vendor.getAddress());
        ps.setInt(4, vendor.getAccountNum());
        int rows = ps.executeUpdate();
        return rows > 0;
    }

    @Override
    public Vendor getVendorById(int id) throws SQLException {
        String sql = "SELECT * FROM vendor WHERE vend_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Vendor(
                rs.getInt("vend_id"),
                rs.getString("name"),
                rs.getString("contact"),
                rs.getString("address"),
                rs.getInt("account_num")
            );
        }
        return null;
    }

    @Override
    public List<Vendor> getAllVendors() throws SQLException {
        List<Vendor> list = new ArrayList<>();
        String sql = "SELECT * FROM vendor";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            list.add(new Vendor(
                rs.getInt("vend_id"),
                rs.getString("name"),
                rs.getString("contact"),
                rs.getString("address"),
                rs.getInt("account_num")
            ));
        }
        return list;
    }

    @Override
    public boolean updateVendor(Vendor vendor) throws SQLException {
        String sql = "UPDATE vendor SET name=?, contact=?, address=?, account_num=? WHERE vend_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, vendor.getName());
        ps.setString(2, vendor.getContact());
        ps.setString(3, vendor.getAddress());
        ps.setInt(4, vendor.getAccountNum());
        ps.setInt(5, vendor.getVendId());
        int rows = ps.executeUpdate();
        return rows > 0;
    }

    @Override
    public boolean deleteVendor(int id) throws SQLException {
        String sql = "DELETE FROM vendor WHERE vend_id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        return rows > 0;
    }
}
