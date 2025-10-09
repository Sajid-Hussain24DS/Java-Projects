 
package frames;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class Account extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Account.class.getName());
 private int selectedAccountId = -1;
    public Account() {
        initComponents();
        loadAccountTable();
        setLocationRelativeTo(null);
    }
private void loadAccountTable() {
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM accounts";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Define table model with proper column headers
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {}, 
            new String[] {"ID", "Bank", "Account Number", "Balance"}
        );
        accountTable.setModel(model);

        // Add rows from ResultSet
        while (rs.next()) {
            int id = rs.getInt("acc_id");
            String bank = rs.getString("bank");
            String accNumber = rs.getString("account_number");
            double balance = rs.getDouble("total_balance"); // decimal type
            model.addRow(new Object[]{id, bank, accNumber, balance});
        }

        rs.close();
        ps.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading accounts: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void clearFields() {
    bankField.setText("");
    accountNumberField.setText("");
    balanceField.setText("");
    selectedAccountId = -1;  

}

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bankField = new javax.swing.JTextField();
        accountNumberField = new javax.swing.JTextField();
        balanceField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Bank");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Account Number");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Total Balance");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));

        bankField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        accountNumberField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        balanceField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        addButton.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        addButton.setText("ADD");
        addButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("BACK");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(bankField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(accountNumberField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(balanceField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(addButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(updateButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(deleteButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bankField)
                            .addComponent(accountNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(balanceField)))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(deleteButton))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(updateButton)))
                        .addGap(77, 77, 77)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(bankField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(accountNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(balanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(deleteButton))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        accountTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        accountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accountTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDesktopPane1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
  
   String bank = bankField.getText().trim();
        String accountNumber = accountNumberField.getText().trim();
        String balanceText = balanceField.getText().trim();

        if (bank.isEmpty() || accountNumber.isEmpty() || balanceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO accounts (bank, account_number, total_balance) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bank);
            ps.setString(2, accountNumber);
            ps.setBigDecimal(3, new BigDecimal(balanceText));

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Account added successfully!");
                clearFields();
                loadAccountTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add account!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 


    }//GEN-LAST:event_addButtonActionPerformed

    private void accountTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseClicked
      int selectedRow = accountTable.getSelectedRow();
        if (selectedRow >= 0) {
            selectedAccountId = Integer.parseInt(accountTable.getValueAt(selectedRow, 0).toString());
            bankField.setText(accountTable.getValueAt(selectedRow, 1).toString());
            accountNumberField.setText(accountTable.getValueAt(selectedRow, 2).toString());
            balanceField.setText(accountTable.getValueAt(selectedRow, 3).toString());
        }



    }//GEN-LAST:event_accountTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (selectedAccountId == -1) {
            JOptionPane.showMessageDialog(this, "Please select an account from the table!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String bank = bankField.getText().trim();
        String accountNumber = accountNumberField.getText().trim();
        String balanceText = balanceField.getText().trim();

        if (bank.isEmpty() || accountNumber.isEmpty() || balanceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE accounts SET bank = ?, account_number = ?, total_balance = ? WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bank);
            ps.setString(2, accountNumber);
            ps.setBigDecimal(3, new BigDecimal(balanceText));
            ps.setInt(4, selectedAccountId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Account updated successfully!");
                clearFields();
                loadAccountTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update account!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (selectedAccountId == -1) {
            JOptionPane.showMessageDialog(this, "Please select an account to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this account?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM accounts WHERE acc_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, selectedAccountId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Account deleted successfully!");
                clearFields();
                loadAccountTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete account!", "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JTextField accountNumberField;
    private javax.swing.JTable accountTable;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField balanceField;
    private javax.swing.JTextField bankField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
