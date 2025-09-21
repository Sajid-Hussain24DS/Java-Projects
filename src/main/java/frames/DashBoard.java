package frames;

import java.util.Locale;
import javax.swing.JOptionPane;

public class DashBoard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashBoard.class.getName());
 
    public DashBoard() {
        initComponents();
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accountButton = new javax.swing.JButton();
        productButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        purchaseDetailButton = new javax.swing.JButton();
        orderDetailButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        categoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accountButton.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        accountButton.setText("Account");
        accountButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        accountButton.setIconTextGap(8);
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        productButton.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        productButton.setText("Product");
        productButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        productButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButtonActionPerformed(evt);
            }
        });

        orderButton.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        orderButton.setText("Order");
        orderButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        jButton4.setText("Purchase");
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        purchaseDetailButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        purchaseDetailButton.setText("Purchase Detail");
        purchaseDetailButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        purchaseDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseDetailButtonActionPerformed(evt);
            }
        });

        orderDetailButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        orderDetailButton.setText("Order Details");
        orderDetailButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        orderDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDetailButtonActionPerformed(evt);
            }
        });

        logOutButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        categoryButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        categoryButton.setText("Category Managment");
        categoryButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        categoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel1.setText("DASHBOARD HOME");
        jLabel1.setAlignmentX(1.0F);
        jLabel1.setAlignmentY(1.0F);
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, java.awt.SystemColor.controlDkShadow));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setFocusTraversalPolicyProvider(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderDetailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(purchaseDetailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel1)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(accountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseDetailButton)
                    .addComponent(jButton4)
                    .addComponent(orderDetailButton))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOutButton)
                    .addComponent(categoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountButtonActionPerformed
      Account account = new Account();
        account.setVisible(true);
        account.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_accountButtonActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
        Orders orders = new Orders();
        orders.setVisible(true);
        orders.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_orderButtonActionPerformed

    private void productButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButtonActionPerformed
        Product addProduct = new Product();
        addProduct.setVisible(true);
        addProduct.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_productButtonActionPerformed

    private void categoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryButtonActionPerformed
        Category  category = new Category();
        category.setVisible(true);
        category.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_categoryButtonActionPerformed

    private void orderDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderDetailButtonActionPerformed
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setVisible(true);
        orderDetails.setLocationRelativeTo(null);
        this.dispose();
    
    }//GEN-LAST:event_orderDetailButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       Purchase purchase = new Purchase();
        purchase.setVisible(true);
        purchase.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void purchaseDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseDetailButtonActionPerformed
        PurchaseDetail pd = new PurchaseDetail();
        pd.setVisible(true);
        pd.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_purchaseDetailButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to log out?", 
            "Confirm Logout", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Open the login form
        LoginFrame login = new LoginFrame(); // replace with your login JFrame class
        login.setVisible(true);
        login.setLocationRelativeTo(null);

        // Close current dashboard/window
        this.dispose();
    }
    }//GEN-LAST:event_logOutButtonActionPerformed

     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JButton categoryButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logOutButton;
    private javax.swing.JButton orderButton;
    private javax.swing.JButton orderDetailButton;
    private javax.swing.JButton productButton;
    private javax.swing.JButton purchaseDetailButton;
    // End of variables declaration//GEN-END:variables
}
