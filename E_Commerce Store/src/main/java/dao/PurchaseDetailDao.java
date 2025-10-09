package dao;

import java.sql.SQLException;
import model.PurchaseDetail;
import java.util.List;

public interface PurchaseDetailDao {
    boolean addPurchaseDetail(PurchaseDetail purchaseDetail) throws SQLException;
    PurchaseDetail getPurchaseDetailById(int id)throws SQLException;
    List<PurchaseDetail> getAllPurchaseDetails()throws SQLException;
    boolean updatePurchaseDetail(PurchaseDetail purchaseDetail)throws SQLException;
    boolean deletePurchaseDetail(int id)throws SQLException;
}
