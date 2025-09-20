package frames;
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
        jButton5 = new javax.swing.JButton();
        orderDetailButton = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        categoryButton = new javax.swing.JButton();

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

        jButton5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jButton5.setText("Purchase Detail");
        jButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));

        orderDetailButton.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        orderDetailButton.setText("Order Details");
        orderDetailButton.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));
        orderDetailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderDetailButtonActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jButton7.setText("Log Out");
        jButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, java.awt.SystemColor.controlDkShadow));

        categoryButton.setText("Category Managment");
        categoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderDetailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(productButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(accountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(orderDetailButton))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(categoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
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

     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JButton categoryButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton orderButton;
    private javax.swing.JButton orderDetailButton;
    private javax.swing.JButton productButton;
    // End of variables declaration//GEN-END:variables
}
