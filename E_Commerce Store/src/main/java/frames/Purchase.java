 
package frames;
 
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class Purchase extends javax.swing.JFrame {
     private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Purchase.class.getName());
  private BigDecimal totalAmount = BigDecimal.ZERO;

    public Purchase() {
        initComponents();
   loadProducts();
    loadVendors();
    setupTable();

    purchaseCodeField.setText(generatePurchaseCode());
    dateField.setText(getCurrentDate());
    grandTotalField.setText("0.00");

    // Remove auto-fill logic for price
    purchasePriceField.setEditable(true); // User can manually enter price

    }
    private void loadProducts() {
    try (Connection conn = DBConnection.getConnection();
         ResultSet rs = conn.createStatement().executeQuery("SELECT p_id, name FROM products")) {
        productBox.removeAllItems();
        while (rs.next()) {
            productBox.addItem(rs.getInt("p_id") + " - " + rs.getString("name"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadVendors() {
    try (Connection conn = DBConnection.getConnection();
         ResultSet rs = conn.createStatement().executeQuery("SELECT vend_id, name FROM vendor")) {
        vendorBox.removeAllItems();
        while (rs.next()) {
            vendorBox.addItem(rs.getInt("vend_id") + " - " + rs.getString("name"));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void updateGrandTotal() {
    DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
    BigDecimal total = BigDecimal.ZERO;
    for (int i = 0; i < model.getRowCount(); i++) {
        Object o = model.getValueAt(i, 4); // Total column index
        if (o != null) {
            try {
                String txt = o.toString().trim().replace(",", "");
                BigDecimal line = new BigDecimal(txt);
                total = total.add(line);
            } catch (NumberFormatException ex) {
                // ignore bad row but log
                ex.printStackTrace();
            }
        }
    }
    totalAmount = total; // class level
    grandTotalField.setText(totalAmount.toString());
}

private String generatePurchaseCode() {
    return "P-" + System.currentTimeMillis();
}
private void completePurchase() {
    int vendorId = Integer.parseInt(vendorBox.getSelectedItem().toString().split(" - ")[0]);
    double totalAmount = Double.parseDouble(grandTotalField.getText().trim());
    String purchaseCode = purchaseCodeField.getText();
    String date = dateField.getText();

    try (Connection conn = DBConnection.getConnection()) {
        conn.setAutoCommit(false);

        // Insert purchase
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO purchase(purchase_no, total_amount, purchase_date, vendor_id) VALUES(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, purchaseCode);
        ps.setDouble(2, totalAmount);
        ps.setString(3, date);
        ps.setInt(4, vendorId);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        int purchaseId = 0;
        if (rs.next()) purchaseId = rs.getInt(1);

        DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            int productId = Integer.parseInt(model.getValueAt(i, 0).toString().split(" - ")[0]);
            int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());

            // Insert purchase_details
            PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO purchase_details(product_id, quantity, price, purchase_id) VALUES(?,?,?,?)");
            ps2.setInt(1, productId);
            ps2.setInt(2, quantity);
            ps2.setDouble(3, price);
            ps2.setInt(4, purchaseId);
            ps2.executeUpdate();

            // Update product stock
            PreparedStatement ps3 = conn.prepareStatement(
                    "UPDATE products SET quantity = quantity + ? WHERE p_id = ?");
            ps3.setInt(1, quantity);
            ps3.setInt(2, productId);
            ps3.executeUpdate();
        }

        conn.commit();
        JOptionPane.showMessageDialog(this, "Purchase completed!");
        clearForm();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        purchaseCodeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        productBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        vendorBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dateField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        purchasePriceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        grandTotalField = new javax.swing.JTextField();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        purchaseNowButton = new javax.swing.JButton();
        newPurchaseButton = new javax.swing.JButton();
        cancelPurchaseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseItemTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Purchase Code");

        jLabel2.setText("Product");

        jLabel3.setText("Vendor");

        jLabel4.setText("Date");

        jLabel5.setText("Purchasing Price");

        purchasePriceField.setText(" ");

        jLabel6.setText("Quantity");

        quantityField.setText(" ");

        jLabel7.setText("Grand Total");

        grandTotalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grandTotalFieldActionPerformed(evt);
            }
        });

        jDesktopPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        addButton.setText("ADD ITEM");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update Item");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete Item");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(backButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        jDesktopPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        purchaseNowButton.setText("Purchase Now");
        purchaseNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseNowButtonActionPerformed(evt);
            }
        });

        newPurchaseButton.setText("New Purchase");
        newPurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPurchaseButtonActionPerformed(evt);
            }
        });

        cancelPurchaseButton.setText("Cancel Purchase");
        cancelPurchaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPurchaseButtonActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(purchaseNowButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(newPurchaseButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cancelPurchaseButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purchaseNowButton)
                    .addComponent(newPurchaseButton)
                    .addComponent(cancelPurchaseButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(purchaseNowButton)
                .addGap(18, 18, 18)
                .addComponent(newPurchaseButton)
                .addGap(18, 18, 18)
                .addComponent(cancelPurchaseButton)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(purchaseCodeField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(productBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(vendorBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dateField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(purchasePriceField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(quantityField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(grandTotalField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDesktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDesktopPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(purchaseCodeField)
                            .addComponent(productBox, 0, 149, Short.MAX_VALUE)
                            .addComponent(vendorBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateField)
                            .addComponent(purchasePriceField)
                            .addComponent(quantityField)
                            .addComponent(grandTotalField))))
                .addGap(29, 29, 29))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(purchaseCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(vendorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(purchasePriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane2)
                    .addComponent(jDesktopPane3))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        purchaseItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        purchaseItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseItemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseItemTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grandTotalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandTotalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grandTotalFieldActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
     int row = purchaseItemTable.getSelectedRow();
    if (row != -1) {
        DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
        model.removeRow(row);
        updateGrandTotal();
    } else {
        JOptionPane.showMessageDialog(this, "Select a row to delete");
    }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    
    try {
        Object sel = productBox.getSelectedItem();
        if (sel == null) {
            JOptionPane.showMessageDialog(this, "Select a product first!");
            return;
        }
        String selectedProduct = sel.toString();
        String[] parts = selectedProduct.split(" - ", 2);
        String productId = parts[0];
        String productName = parts.length > 1 ? parts[1] : selectedProduct;

        String qtyText = quantityField.getText().trim();
        if (qtyText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter quantity!");
            return;
        }
        int qty = Integer.parseInt(qtyText);

        // price: either from purchasePriceField (user may have edited) or DB
        String priceText = purchasePriceField.getText().trim().replace(",", "");
        if (priceText.isEmpty()) {
            priceText = String.valueOf(getProductPriceByName(productName));
        }
        BigDecimal price = new BigDecimal(priceText);

        BigDecimal total = price.multiply(new BigDecimal(qty));

        DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
        model.addRow(new Object[]{ productId, productName, qty, price.toString(), total.toString() });

        updateGrandTotal();

        quantityField.setText("");
        purchasePriceField.setText("");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid number format! Enter numeric values for price and quantity.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding item: " + e.getMessage());
        e.printStackTrace();
    }



  
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
     
    int row = purchaseItemTable.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Select a row to update");
        return;
    }

    try {
        Object sel = productBox.getSelectedItem();
        if (sel == null) {
            JOptionPane.showMessageDialog(this, "Select a product first!");
            return;
        }
        String selectedProduct = sel.toString();
        String[] parts = selectedProduct.split(" - ", 2);
        String productId = parts[0];
        String productName = parts.length > 1 ? parts[1] : selectedProduct;

        String priceText = purchasePriceField.getText().trim().replace(",", "");
        BigDecimal price = new BigDecimal(priceText);
        int quantity = Integer.parseInt(quantityField.getText().trim());
        BigDecimal total = price.multiply(new BigDecimal(quantity));

        DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
        model.setValueAt(productId, row, 0);
        model.setValueAt(productName, row, 1);
        model.setValueAt(quantity, row, 2);
        model.setValueAt(price.toString(), row, 3);
        model.setValueAt(total.toString(), row, 4);

        updateGrandTotal();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid numbers.");
    }
 




    }//GEN-LAST:event_updateButtonActionPerformed

    private void purchaseNowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseNowButtonActionPerformed
     
    try {
        DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No items to purchase.");
            return;
        }

        Object selVendor = vendorBox.getSelectedItem();
        if (selVendor == null) {
            JOptionPane.showMessageDialog(this, "Please select a vendor.");
            return;
        }
        int vendorId = Integer.parseInt(selVendor.toString().split(" - ")[0]);

        // compute grand total from model (already updated by updateGrandTotal)
        updateGrandTotal(); // ensures totalAmount is current

        // insert purchase as before (your existing code)
        Connection conn = DBConnection.getConnection();
        conn.setAutoCommit(false);

        String purchaseNo = "P-" + System.currentTimeMillis();
        // use totalAmount (BigDecimal) for DB double
        double grandTotalDouble = totalAmount.doubleValue();

        String sqlPurchase = "INSERT INTO purchase (purchase_no, total_amount, purchase_date, vendor_id) VALUES (?, ?, NOW(), ?)";
        PreparedStatement pstPurchase = conn.prepareStatement(sqlPurchase, Statement.RETURN_GENERATED_KEYS);
        pstPurchase.setString(1, purchaseNo);
        pstPurchase.setDouble(2, grandTotalDouble);
        pstPurchase.setInt(3, vendorId);
        pstPurchase.executeUpdate();

        ResultSet rs = pstPurchase.getGeneratedKeys();
        int purchaseId = 0;
        if (rs.next()) purchaseId = rs.getInt(1);

        String sqlDetails = "INSERT INTO purchase_details (product_id, quantity, price, purchase_id) VALUES (?, ?, ?, ?)";
        PreparedStatement pstDetails = conn.prepareStatement(sqlDetails);

        for (int i = 0; i < model.getRowCount(); i++) {
            int productId = Integer.parseInt(model.getValueAt(i, 0).toString());
            int qty = Integer.parseInt(model.getValueAt(i, 2).toString());
            BigDecimal price = new BigDecimal(model.getValueAt(i, 3).toString());

            pstDetails.setInt(1, productId);
            pstDetails.setInt(2, qty);
            pstDetails.setDouble(3, price.doubleValue());
            pstDetails.setInt(4, purchaseId);
            pstDetails.addBatch();

            // update product stock
            String sqlUpdate = "UPDATE products SET quantity = quantity + ? WHERE p_id = ?";
            try (PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate)) {
                pstUpdate.setInt(1, qty);
                pstUpdate.setInt(2, productId);
                pstUpdate.executeUpdate();
            }
        }
        pstDetails.executeBatch();
        conn.commit();

        JOptionPane.showMessageDialog(this, "Purchase saved successfully!");

        // clear table but keep purchaseId and total to pass to payment
        model.setRowCount(0);
        grandTotalField.setText("0.00");

        // open payment form and pass BigDecimal totalAmount
        PaymentForm pf = new PaymentForm(purchaseId, totalAmount, "PURCHASE", this);
        pf.setLocationRelativeTo(this);
        pf.setVisible(true);
        this.setVisible(false);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error while saving purchase: " + e.getMessage());
    }


    

    }//GEN-LAST:event_purchaseNowButtonActionPerformed

    private void newPurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPurchaseButtonActionPerformed
     clearForm();
}
private void clearForm() {
    purchaseCodeField.setText(generatePurchaseCode());
    dateField.setText(getCurrentDate());
    quantityField.setText("");
    purchasePriceField.setText("");
    grandTotalField.setText("0");
    DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
    model.setRowCount(0);


    }//GEN-LAST:event_newPurchaseButtonActionPerformed

    private void cancelPurchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPurchaseButtonActionPerformed
     int confirm = JOptionPane.showConfirmDialog(this, "Cancel this purchase?", "Confirm", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        clearForm();
    }
 
    }//GEN-LAST:event_cancelPurchaseButtonActionPerformed

    private void purchaseItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseItemTableMouseClicked
    
    int row = purchaseItemTable.getSelectedRow();
    if (row == -1) return;

    DefaultTableModel model = (DefaultTableModel) purchaseItemTable.getModel();
    String productId = model.getValueAt(row, 0).toString();
    String productName = model.getValueAt(row, 1).toString();
    String qty = model.getValueAt(row, 2).toString();
    String price = model.getValueAt(row, 3).toString();

    // set UI fields so user can update easily
    // find productBox entry that matches productId - productName and select it:
    for (int i = 0; i < productBox.getItemCount(); i++) {
        if (productBox.getItemAt(i).toString().startsWith(productId + " - ")) {
            productBox.setSelectedIndex(i);
            break;
        }
    }
    quantityField.setText(qty);
    purchasePriceField.setText(price);


    }//GEN-LAST:event_purchaseItemTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    this.dispose();
    DashBoard dashBoard = new DashBoard();
    dashBoard.setVisible(true);
    dashBoard.setLocationRelativeTo(null);
    }//GEN-LAST:event_backButtonActionPerformed

     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelPurchaseButton;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField grandTotalField;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newPurchaseButton;
    private javax.swing.JComboBox<String> productBox;
    private javax.swing.JTextField purchaseCodeField;
    private javax.swing.JTable purchaseItemTable;
    private javax.swing.JButton purchaseNowButton;
    private javax.swing.JTextField purchasePriceField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox<String> vendorBox;
    // End of variables declaration//GEN-END:variables

 private String getCurrentDate() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(new java.util.Date());
}


    private void setupTable() {
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(new Object[]{"Product ID", "Product Name", "Quantity", "Price", "Total"});
    purchaseItemTable.setModel(model);
}

   // Get product ID by name
private String getProductIdByName(String productName) {
    String id = "";
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT p_id FROM products WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, productName);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            id = rs.getString("p_id");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return id;
}

// Get product price by name
private double getProductPriceByName(String productName) {
    double price = 0;
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT price FROM products WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, productName);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            price = rs.getDouble("price");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return price;
}



}
