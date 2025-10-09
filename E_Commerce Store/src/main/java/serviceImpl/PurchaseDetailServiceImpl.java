package serviceImpl;

import dao.PurchaseDetailDao;
import daoImpl.PurchaseDetailDaoImpl;
import model.PurchaseDetail;
import service.PurchaseDetailService;

import java.sql.SQLException;
import java.util.List;

public class PurchaseDetailServiceImpl implements PurchaseDetailService {
    private PurchaseDetailDao purchaseDetailDao;

    public PurchaseDetailServiceImpl() throws SQLException {
        this.purchaseDetailDao = new PurchaseDetailDaoImpl();
    }

    @Override
    public void addPurchaseDetails(PurchaseDetail purchaseDetail) throws SQLException {
        purchaseDetailDao.addPurchaseDetail(purchaseDetail);
    }

    @Override
    public PurchaseDetail getPurchaseDetailsById(int id) throws SQLException {
        return purchaseDetailDao.getPurchaseDetailById(id);
    }

    @Override
    public List<PurchaseDetail> getAllPurchaseDetails() throws SQLException {
        return purchaseDetailDao.getAllPurchaseDetails();
    }

    @Override
    public void updatePurchaseDetails(PurchaseDetail purchaseDetail) throws SQLException {
        purchaseDetailDao.updatePurchaseDetail(purchaseDetail);
    }

    @Override
    public void deletePurchaseDetails(int id) throws SQLException {
        purchaseDetailDao.deletePurchaseDetail(id);
    }
}
