package frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class OrderDetails extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrderDetails.class.getName());
    public OrderDetails() {
        initComponents(); 
    setLocationRelativeTo(null);
     orderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {},
        new String [] {"Order ID", "Product Name", "Quantity", "Price", "Total"}
    ));
     loadOrderDetails("");
     searchField.addActionListener(e -> {
        String keyword = searchField.getText().trim();
        loadOrderDetails(keyword); // if keyword is empty, it will reload all orders
    });
}
   
    private void loadOrderDetails(String keyword) {
      try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT o.order_id, p.name, od.quantity, od.price, (od.quantity * od.price) AS total " +
                         "FROM order_details od " +
                         "JOIN products p ON od.product_id = p.p_id " +
                         "JOIN orders o ON od.order_id = o.order_id " +
                         "WHERE p.name LIKE ? OR CAST(o.order_id AS CHAR) LIKE ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) orderDetailsTable.getModel();
            model.setRowCount(0); // clear previous rows

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("order_id"),
                    rs.getString("name"),
                    rs.getInt("quantity"),
                    rs.getInt("price"),
                    rs.getInt("total")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading order details: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }

  
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderDetailsTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search");

        orderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        orderDetailsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderDetailsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderDetailsTable);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(180, 180, 180))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderDetailsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderDetailsTableMouseClicked
    
        int row = orderDetailsTable.getSelectedRow();

        if (row != -1) {
            String orderId = orderDetailsTable.getValueAt(row, 0).toString();
            String product = orderDetailsTable.getValueAt(row, 1).toString();
            JOptionPane.showMessageDialog(this,
                    "Order: " + orderId + "\nProduct: " + product,
                    "Order Detail", JOptionPane.INFORMATION_MESSAGE);
             
        }
    }//GEN-LAST:event_orderDetailsTableMouseClicked

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
    private javax.swing.JTable orderDetailsTable;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
