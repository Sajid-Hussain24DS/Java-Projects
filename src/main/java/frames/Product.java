package frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class Product extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Product.class.getName());
 
    public Product() {
        initComponents();
        setLocationRelativeTo(null);
        loadCategories();
        loadProducts();
        clearFormFields();
    }
private void loadCategories() {
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT name FROM category";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

          // pehle clear karo
        while (rs.next()) {
            categoryBox.addItem(rs.getString("name"));
        }

        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading categories: " + e.getMessage());
    }
}
    private void loadProducts() {
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT p.p_id, p.name, p.price, p.quantity, c.name AS category_name " +
                     "FROM products p " +
                     "JOIN category c ON p.category_id = c.cat_id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Table Model banao with custom column names
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Quantity");
        model.addColumn("Category");

        // Rows add karo
        while (rs.next()) {
            Object[] row = {
                rs.getInt("p_id"),
                rs.getString("name"),
                rs.getInt("price"),
                rs.getInt("quantity"),
                rs.getString("category_name")
            };
            model.addRow(row);
        }

        // Model ko JTable par set karo
        productTable.setModel(model);

        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
    }




}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        categoryBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBorder(new javax.swing.border.LineBorder(java.awt.SystemColor.controlLtHighlight, 2, true));
        desktopPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desktopPaneMouseClicked(evt);
            }
        });

        jLabel1.setText("Product Detail");

        jLabel2.setText("Name");

        jLabel3.setText("Category");

        jLabel4.setText("Quantity");

        quantityField.setText(" ");

        jLabel5.setText("Price");

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        desktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(nameField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(categoryBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(quantityField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(priceField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(67, 67, 67)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton)
                    .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameField)
                        .addComponent(categoryBox, 0, 150, Short.MAX_VALUE)
                        .addComponent(quantityField)
                        .addComponent(priceField))
                    .addComponent(backButton))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton))
                .addGap(18, 18, 18)
                .addGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(backButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productTable.setBorder(new javax.swing.border.LineBorder(java.awt.SystemColor.controlLtHighlight, 3, true));
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        productTable.setGridColor(java.awt.SystemColor.activeCaptionText);
        productTable.setSelectionBackground(java.awt.SystemColor.controlLtHighlight);
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(desktopPane)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    String name = nameField.getText().trim();
    String priceText = priceField.getText().trim();
    String quantityText = quantityField.getText().trim();
    String category = (String) categoryBox.getSelectedItem();

    if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty() || category == null) {
        JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
 
 try {
    int price = Integer.parseInt(priceText);
    int quantity = Integer.parseInt(quantityText);

    Connection conn = DBConnection.getConnection();

    // Step 1: Category ID nikaalo
    String categoryName = (String) categoryBox.getSelectedItem();
    String getCategoryIdSQL = "SELECT cat_id FROM category WHERE name = ?";
    PreparedStatement ps1 = conn.prepareStatement(getCategoryIdSQL);
    ps1.setString(1, categoryName);
    ResultSet rs = ps1.executeQuery();

    int categoryId = -1;
    if (rs.next()) {
        categoryId = rs.getInt("cat_id");
    }
    rs.close();
    ps1.close();

    if (categoryId == -1) {
        JOptionPane.showMessageDialog(this, "Invalid category selected!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Step 2: Product insert karo category_id ke sath
    String sql = "INSERT INTO products (name, price, quantity, category_id) VALUES (?, ?, ?, ?)";
    PreparedStatement ps2 = conn.prepareStatement(sql);
    ps2.setString(1, name);
    ps2.setInt(2, price);
    ps2.setInt(3, quantity);
    ps2.setInt(4, categoryId);

    int rows = ps2.executeUpdate();
    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Product added successfully!");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        categoryBox.setSelectedIndex(0);
           loadProducts();
           clearFormFields();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to add product!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    ps2.close();
    conn.close();
} catch (NumberFormatException nfe) {
    JOptionPane.showMessageDialog(this, "Invalid number format for price or quantity!", "Error", JOptionPane.ERROR_MESSAGE);
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}


    }//GEN-LAST:event_addButtonActionPerformed

    private void desktopPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desktopPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_desktopPaneMouseClicked

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
                                               
    int selectedRow = productTable.getSelectedRow();
    if (selectedRow >= 0) {
        String name = productTable.getValueAt(selectedRow, 1).toString();  // name column
        String price = productTable.getValueAt(selectedRow, 2).toString(); // price column
        String quantity = productTable.getValueAt(selectedRow, 3).toString(); // quantity column
        String category = productTable.getValueAt(selectedRow, 4).toString(); // category name column

        nameField.setText(name);
        priceField.setText(price);
        quantityField.setText(quantity);
        categoryBox.setSelectedItem(category);
    
 
    }                                   
     
    if (selectedRow == -1) return; // agar koi row select nahi hai

    // JTable se product ka ID nikaal lo (maan lo pehla column product_id hai)
    int productId = (int) productTable.getValueAt(selectedRow, 0);

    try {
        Connection conn = DBConnection.getConnection();

        String sql = "SELECT p.name, p.price, p.quantity, c.name as category_name " +
                     "FROM products p " +
                     "JOIN category c ON p.category_id = c.cat_id " +
                     "WHERE p.p_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, productId);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            nameField.setText(rs.getString("name"));
            priceField.setText(String.valueOf(rs.getInt("price")));
            quantityField.setText(String.valueOf(rs.getInt("quantity")));

            // Category box me category select karna
            String categoryName = rs.getString("category_name");
            categoryBox.setSelectedItem(categoryName);
        }

        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error fetching product data: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_productTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
                                              
    int selectedRow = productTable.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a product from the table first!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String name = nameField.getText().trim();
    String priceText = priceField.getText().trim();
    String quantityText = quantityField.getText().trim();
    String categoryName = (String) categoryBox.getSelectedItem();

    if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty() || categoryName == null) {
        JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int price = Integer.parseInt(priceText);
        int quantity = Integer.parseInt(quantityText);
 
        int productId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());

        // Get category_id from category table
        Connection conn = DBConnection.getConnection();
        String getCategoryIdSQL = "SELECT cat_id FROM category WHERE name = ?";
        PreparedStatement ps1 = conn.prepareStatement(getCategoryIdSQL);
        ps1.setString(1, categoryName);
        ResultSet rs = ps1.executeQuery();

        int categoryId = -1;
        if (rs.next()) {
            categoryId = rs.getInt("cat_id");
        }
        rs.close();
        ps1.close();

        if (categoryId == -1) {
            JOptionPane.showMessageDialog(this, "Invalid category!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update query
        String updateSQL = "UPDATE products SET name=?, price=?, quantity=?, category_id=? WHERE p_id=?";
        PreparedStatement ps2 = conn.prepareStatement(updateSQL);
        ps2.setString(1, name);
        ps2.setInt(2, price);
        ps2.setInt(3, quantity);
        ps2.setInt(4, categoryId);
        ps2.setInt(5, productId);

        int rows = ps2.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Product updated successfully!");
            loadProducts();
            clearFormFields(); 
        } else {
            JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        ps2.close();
        conn.close();
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Invalid number format for price or quantity!", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
     int selectedRow = productTable.getSelectedRow();
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a product to delete!");
    return;
}

int productId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());

// Pehle check karo
if (!canDeleteProduct(productId)) return;

// Ab safe to delete
int confirm = JOptionPane.showConfirmDialog(this, 
        "Are you sure you want to delete this product?", 
        "Confirm Delete", JOptionPane.YES_NO_OPTION);

if (confirm == JOptionPane.YES_OPTION) {
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement("DELETE FROM products WHERE p_id = ?")) {
        
        ps.setInt(1, productId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Product deleted successfully!");
            loadProducts();      // Table refresh
            clearFormFields();   // Form fields clear
        }
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error deleting product: " + e.getMessage());
    }
}

    }
private void clearFormFields() {
    nameField.setText("");
    priceField.setText("");
    quantityField.setText("");

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    this.dispose();
    DashBoard dashBoard = new DashBoard();
    dashBoard.setVisible(true);
    dashBoard.setLocationRelativeTo(null);  


    }//GEN-LAST:event_backButtonActionPerformed

     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    private boolean canDeleteProduct(int productId) {
    String checkSQL = "SELECT COUNT(*) FROM order_details WHERE product_id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(checkSQL)) {
        
        ps.setInt(1, productId);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(this, 
                        "Cannot delete. Product is part of existing orders.");
                    return false; // Product delete nahi hoga
                }
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error checking product usage: " + e.getMessage());
        return false;
    }
    return true; // Safe to delete
}

}
