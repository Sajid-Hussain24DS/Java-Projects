
package frames;
 
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.DBConnection;
import javax.swing.JFrame;

public class PaymentForm extends javax.swing.JFrame {
 private int acc_Id;              // orderId ya purchaseId
    private BigDecimal totalAmount; // amount to pay
    private String type;            // "ORDER" ya "PURCHASE"
    private JFrame parent;          // Orders ya Purchase form
 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaymentForm.class.getName());
  

public PaymentForm(int acc_Id, BigDecimal totalAmount, String type, JFrame parent) {
    initComponents();
     this.acc_Id = acc_Id;
        this.totalAmount = totalAmount;
        this.type = type;
        this.parent = parent;

        // amount dikhana
        amountField.setText(totalAmount.toString());

        // accounts load karna
        loadAccounts();

}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        accountBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        amountField = new javax.swing.JTextField();
        payButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Account");

        accountBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel2.setText("Amount To Pay ");

        payButton.setText("Pay Now");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(accountBox, 0, 132, Short.MAX_VALUE)
                    .addComponent(amountField))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(payButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accountBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(amountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(payButton)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
                                
    if (accountBox.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Please select an account");
        return;
    }

    // Parse selected account ID
    String selectedAccount = accountBox.getSelectedItem().toString();
    int selectedAccId;
    try {
        selectedAccId = Integer.parseInt(selectedAccount.split(" - ")[0].trim());
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Invalid account selected");
        return;
    }

    try (Connection conn = DBConnection.getConnection()) {
        conn.setAutoCommit(false); // Start transaction

        // 1. Verify account exists and sufficient balance
        String balanceSQL = "SELECT total_balance FROM accounts WHERE acc_id = ? FOR UPDATE";
        BigDecimal currentBalance;
        try (PreparedStatement balanceStmt = conn.prepareStatement(balanceSQL)) {
            balanceStmt.setInt(1, selectedAccId);
            try (ResultSet rs = balanceStmt.executeQuery()) {
                if (rs.next()) {
                    currentBalance = rs.getBigDecimal("total_balance");
                    if (currentBalance.compareTo(totalAmount) < 0) {
                        JOptionPane.showMessageDialog(this, "Insufficient funds in account");
                        return; // Stop payment
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Account not found");
                    return; // Stop payment
                }
            }
        }

        // 2. Deduct funds safely
        String updateSQL = "UPDATE accounts SET total_balance = total_balance - ? WHERE acc_id = ?";
        try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
            updateStmt.setBigDecimal(1, totalAmount);
            updateStmt.setInt(2, selectedAccId);
            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("Failed to deduct funds. Please try again.");
            }
        }

        conn.commit(); // Commit transaction
        JOptionPane.showMessageDialog(this, "Payment successful!");

        // Optionally, return to parent form
        this.dispose();
        if (parent != null) parent.setVisible(true);

    } catch (Exception e) {
        e.printStackTrace();
        try {
            // Rollback on error
            DBConnection.getConnection().rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "Payment failed: " + e.getMessage());
    }



    }//GEN-LAST:event_payButtonActionPerformed

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountBox;
    private javax.swing.JTextField amountField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton payButton;
    // End of variables declaration//GEN-END:variables

   private void loadAccounts() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT acc_id, bank, account_number FROM accounts";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("acc_id");
                String bank = rs.getString("bank");
                String accNum = rs.getString("account_number");
                accountBox.addItem(id + " - " + bank + " (" + accNum + ")");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading accounts: " + e.getMessage());
        }
}}
