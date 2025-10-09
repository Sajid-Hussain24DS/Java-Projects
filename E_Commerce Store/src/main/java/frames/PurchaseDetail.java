 
package frames;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PurchaseDetail extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PurchaseDetail.class.getName());
 
    public PurchaseDetail() {
        initComponents();
        setLocationRelativeTo(null);
       purchaseDetailTable.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {},
    new String [] {"Purchase ID", "Product Name", "Quantity", "Price", "Total", "Vendor"}
));
     loadPurchaseDetails("");
     searchField.addActionListener(e -> {
        String keyword = searchField.getText().trim();
        loadPurchaseDetails(keyword); // if keyword is empty, it will reload all orders
    });
    }

      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseDetailTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        purchaseDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        purchaseDetailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseDetailTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseDetailTable);

        jLabel1.setText("Search");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(43, 43, 43)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseDetailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseDetailTableMouseClicked
     
 int row = purchaseDetailTable.getSelectedRow();

        if (row != -1) {
            String purchaseId = purchaseDetailTable.getValueAt(row, 0).toString();
            String product = purchaseDetailTable.getValueAt(row, 1).toString();
            String quantity = purchaseDetailTable.getValueAt(row, 2).toString();
            String price = purchaseDetailTable.getValueAt(row, 3).toString();
            String total = purchaseDetailTable.getValueAt(row, 4).toString();
            String vendor = purchaseDetailTable.getValueAt(row, 5).toString();

            JOptionPane.showMessageDialog(this,
                    "Purchase ID: " + purchaseId +
                            "\nProduct: " + product +
                            "\nQuantity: " + quantity +
                            "\nPrice: " + price +
                            "\nTotal: " + total +
                            "\nVendor: " + vendor,
                    "Purchase Detail", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_purchaseDetailTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
     DashBoard dashBoard = new DashBoard();
      dashBoard.setVisible(true);
      dashBoard.setLocationRelativeTo(null);  
      this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseDetailTable;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

   private void loadPurchaseDetails(String keyword) {
    DefaultTableModel model = (DefaultTableModel) purchaseDetailTable.getModel();
        model.setRowCount(0);

        String sql = "SELECT pd.purchase_id, p.name AS product_name, pd.quantity, pd.price, " +
                "(pd.quantity*pd.price) AS total, v.name AS vendor_name " +
                "FROM purchase_details pd " +
                "JOIN products p ON pd.product_id = p.p_id " +
                "JOIN purchase pu ON pd.purchase_id = pu.purchase_id " +
                "JOIN vendor v ON pu.vendor_id = v.vend_id ";

        if (!keyword.isEmpty()) {
            sql += "WHERE p.name LIKE ? OR pd.purchase_id LIKE ? OR v.name LIKE ? ";
        }

        try (Connection conn = util.DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (!keyword.isEmpty()) {
                ps.setString(1, "%" + keyword + "%");
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] row = {
                            rs.getInt("purchase_id"),
                            rs.getString("product_name"),
                            rs.getInt("quantity"),
                            rs.getInt("price"),
                            rs.getInt("total"),
                            rs.getString("vendor_name")
                    };
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error loading purchase details: " + e.getMessage());
        }}

}
