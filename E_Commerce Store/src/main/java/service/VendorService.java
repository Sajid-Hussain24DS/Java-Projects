package service;

import model.Vendor;
import java.sql.SQLException;
import java.util.List;

public interface VendorService {
    void addVendor(Vendor vendor) throws SQLException;
    Vendor getVendorById(int id) throws SQLException;
    List<Vendor> getAllVendors() throws SQLException;
    void updateVendor(Vendor vendor) throws SQLException;
    void deleteVendor(int id) throws SQLException;
}
