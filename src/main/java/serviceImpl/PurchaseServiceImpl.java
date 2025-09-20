package serviceImpl;

import dao.PurchaseDao;
import daoImpl.PurchaseDaoImpl;
import model.Purchase;
import service.PurchaseService;

import java.sql.SQLException;
import java.util.List;

public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseDao purchaseDao;

    public PurchaseServiceImpl() throws SQLException {
        this.purchaseDao = new PurchaseDaoImpl();
    }

    @Override
    public void addPurchase(Purchase purchase) throws SQLException {
        purchaseDao.addPurchase(purchase);
    }

    @Override
    public Purchase getPurchaseById(int id) throws SQLException {
        return purchaseDao.getPurchaseById(id);
    }

    @Override
    public List<Purchase> getAllPurchases() throws SQLException {
        return purchaseDao.getAllPurchases();
    }

    @Override
    public void updatePurchase(Purchase purchase) throws SQLException {
        purchaseDao.updatePurchase(purchase);
    }

    @Override
    public void deletePurchase(int id) throws SQLException {
        purchaseDao.deletePurchase(id);
    }
}
