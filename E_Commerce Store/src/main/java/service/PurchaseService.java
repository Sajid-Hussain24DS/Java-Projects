package service;

import model.Purchase;
import java.sql.SQLException;
import java.util.List;

public interface PurchaseService {
    void addPurchase(Purchase purchase) throws SQLException;
    Purchase getPurchaseById(int id) throws SQLException;
    List<Purchase> getAllPurchases() throws SQLException;
    void updatePurchase(Purchase purchase) throws SQLException;
    void deletePurchase(int id) throws SQLException;
}
