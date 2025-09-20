package dao;

import java.sql.SQLException;
import model.Purchase;
import java.util.List;

public interface PurchaseDao {
    boolean addPurchase(Purchase purchase)throws SQLException;
    Purchase getPurchaseById(int id)throws SQLException;
    List<Purchase> getAllPurchases()throws SQLException;
    boolean updatePurchase(Purchase purchase)throws SQLException;
    boolean deletePurchase(int id)throws SQLException;
}
