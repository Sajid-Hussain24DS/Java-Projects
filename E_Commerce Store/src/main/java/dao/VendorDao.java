package dao;

import java.sql.SQLDataException;
import java.sql.SQLException;
import model.Vendor;
import java.util.List;

public interface VendorDao {
    boolean addVendor(Vendor vendor) throws SQLException;
    Vendor getVendorById(int id) throws SQLException;
    List<Vendor> getAllVendors()throws SQLException;
    boolean updateVendor(Vendor vendor) throws SQLException;
    boolean deleteVendor(int id)throws SQLException;
}
