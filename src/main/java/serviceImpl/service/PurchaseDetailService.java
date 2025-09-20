package service;

import model.PurchaseDetail;
import java.sql.SQLException;
import java.util.List;

public interface PurchaseDetailService {
    void addPurchaseDetails(PurchaseDetail purchaseDetail) throws SQLException;
    PurchaseDetail getPurchaseDetailsById(int id) throws SQLException;
    List<PurchaseDetail> getAllPurchaseDetails() throws SQLException;
    void updatePurchaseDetails(PurchaseDetail purchaseDetails) throws SQLException;
    void deletePurchaseDetails(int id) throws SQLException;
}
