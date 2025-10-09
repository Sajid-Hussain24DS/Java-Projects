 
package frames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

 
public class Category extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Category.class.getName());

    private int selectedCategoryId = -1;
    public Category() {
        initComponents();
        loadCategoryTable();
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        categoryNameField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Category Name");

        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(categoryNameField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updateButton)
                    .addComponent(addButton))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(categoryNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addGap(39, 39, 39)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(updateButton))
                .addGap(29, 29, 29))
        );

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        categoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoryTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(385, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
                                           
    String categoryName = categoryNameField.getText().trim(); // Category ka field

    if (categoryName.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter category name!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        Connection conn = DBConnection.getConnection();

        // Check duplicate category
        String checkSQL = "SELECT * FROM category WHERE name = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
        checkStmt.setString(1, categoryName);
        ResultSet rs = checkStmt.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(this, "Category already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            rs.close();
            checkStmt.close();
            conn.close();
            return;
        }
        rs.close();
        checkStmt.close();
        loadCategoryTable();
        // Insert category
        String sql = "INSERT INTO category (name) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, categoryName);
        int rows = ps.executeUpdate();

        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Category added successfully!");
            categoryNameField.setText("");
            loadCategoryTable(); // Ye method table ko refresh karega
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add category!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        ps.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_addButtonActionPerformed

    private void categoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryTableMouseClicked
        int selectedRow = categoryTable.getSelectedRow();
    if (selectedRow >= 0) {
        selectedCategoryId = Integer.parseInt(categoryTable.getValueAt(selectedRow, 0).toString());
        String categoryName = categoryTable.getValueAt(selectedRow, 1).toString();
        categoryNameField.setText(categoryName);
    

        loadCategoryTable();
 
    }


    }//GEN-LAST:event_categoryTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
     if (selectedCategoryId == -1) {
    JOptionPane.showMessageDialog(this, "Please select a category from table!", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

String categoryName = categoryNameField.getText().trim();
if (categoryName.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Category name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    Connection conn = DBConnection.getConnection();
    String sql = "UPDATE category SET name = ? WHERE cat_id = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, categoryName);
    ps.setInt(2, selectedCategoryId); // use the selectedCategoryId

    int rows = ps.executeUpdate();
    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Category updated successfully!");
        categoryNameField.setText("");
        selectedCategoryId = -1; // reset after update
        loadCategoryTable();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to update category!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    ps.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    if (selectedCategoryId == -1) {
    JOptionPane.showMessageDialog(this, "Please select a category to delete!", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this category?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
if (confirm != JOptionPane.YES_OPTION) return;

try {
    Connection conn = DBConnection.getConnection();
    String sql = "DELETE FROM category WHERE cat_id = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setInt(1, selectedCategoryId);

    int rows = ps.executeUpdate();
    if (rows > 0) {
        JOptionPane.showMessageDialog(this, "Category deleted successfully!");
        categoryNameField.setText("");
        selectedCategoryId = -1; // reset selection
        loadCategoryTable();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to delete category!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    ps.close();
    conn.close();
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
 
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        DashBoard dashBoard = new DashBoard();
        dashBoard.setVisible(true);
    dashBoard.setLocationRelativeTo(null);  
    this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JTable categoryTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

  private void loadCategoryTable() {
    try {
        // Database connection
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM category";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // JTable ka model define karo aur set karo
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},      // Initially empty rows
            new String[] {"ID", "Name"} // Column headers
        );
        categoryTable.setModel(model);

        // ResultSet se data load karke model me add karo
        while (rs.next()) {
            int id = rs.getInt("cat_id");
            String name = rs.getString("name");
            model.addRow(new Object[]{id, name});
        }

        // Resources close karo
        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading categories: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

}
