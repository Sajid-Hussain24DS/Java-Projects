package serviceImpl;

import dao.VendorDao;
import daoImpl.VendorDaoImpl;
import model.Vendor;
import service.VendorService;

import java.sql.SQLException;
import java.util.List;

public class VendorServiceImpl implements VendorService {
    private VendorDao vendorDao;

    public VendorServiceImpl() throws SQLException {
        this.vendorDao = new VendorDaoImpl();
    }

    @Override
    public void addVendor(Vendor vendor) throws SQLException {
        vendorDao.addVendor(vendor);
    }

    @Override
    public Vendor getVendorById(int id) throws SQLException {
        return vendorDao.getVendorById(id);
    }

    @Override
    public List<Vendor> getAllVendors() throws SQLException {
        return vendorDao.getAllVendors();
    }

    @Override
    public void updateVendor(Vendor vendor) throws SQLException {
        vendorDao.updateVendor(vendor);
    }

    @Override
    public void deleteVendor(int id) throws SQLException {
        vendorDao.deleteVendor(id);
    }
}
