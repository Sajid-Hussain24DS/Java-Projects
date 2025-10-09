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

public class Orders extends javax.swing.JFrame {
   private BigDecimal totalAmount = BigDecimal.ZERO;


    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Orders.class.getName());
  private int selectedOrderId = -1;
    public Orders() {
        initComponents();
        setLocationRelativeTo(null);
        loadAvailableProducts();
        setupCartTable();
        loadProducts();
        setCurrentDate();
        generateOrderCode();
        
        setupProductPriceListener();   // <- ye add karo
    setupQuantityListener();       
}
    
    private int getProductIdByName(String productName) {
    int productId = -1;
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT p_id FROM products WHERE name = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, productName);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            productId = rs.getInt("p_id");
        }
         
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return productId;
}

    private void setupCartTable() {
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
        new Object[][] {},
        new String[] {"ProductID", "Product", "Price", "Quantity", "Subtotal"}
    ) {
        // make ProductID column non-editable and hide later if you want
        @Override public boolean isCellEditable(int row, int column) { return false; }
    };
    cartTable.setModel(model);
    // Optional: hide ProductID column visually (index 0)
    cartTable.getColumnModel().getColumn(0).setMinWidth(0);
    cartTable.getColumnModel().getColumn(0).setMaxWidth(0);
    cartTable.getColumnModel().getColumn(0).setWidth(0);
}
private int getCartTotal() {
    DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
    int total = 0;
    for (int r = 0; r < model.getRowCount(); r++) {
        Object o = model.getValueAt(r, 4);
        if (o != null) total += Integer.parseInt(o.toString());
    }
    return total;
}

private void recalcCartTotal() {
    int total = getCartTotal();
    grandTotalField.setText(String.valueOf(total));
}

   private void loadProducts() {
    try {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT name FROM products"; 
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        productBox.removeAllItems(); // pehle saaf karo
        while (rs.next()) {
            productBox.addItem(rs.getString("name")); // sirf product name
        }

        rs.close();
        ps.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
    }


    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        productBox = new javax.swing.JComboBox<>();
        customerPhoneField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        quantityField = new javax.swing.JTextField();
        grandTotalField = new javax.swing.JTextField();
        dateField = new javax.swing.JTextField();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        addItemButton = new javax.swing.JButton();
        updateItemButton = new javax.swing.JButton();
        deleteItemButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        newOrderButton = new javax.swing.JButton();
        orderNowButton = new javax.swing.JButton();
        cancelOrderButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableProductTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ORDERS");

        jLabel2.setText("ORDER");

        jLabel3.setText("Order Code");

        jLabel4.setText("Product");

        jLabel5.setText("Customer Phone");

        jLabel6.setText("Date");

        jLabel7.setText("Selling Price");

        jLabel8.setText("Quantity");

        jLabel9.setText("Grand Total");

        codeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeFieldActionPerformed(evt);
            }
        });

        productBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        customerPhoneField.setText(" ");

        priceField.setText(" ");
        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        quantityField.setText(" ");

        dateField.setText(" ");

        jDesktopPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        addItemButton.setText("ADD Item");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        updateItemButton.setText("Update Item");
        updateItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemButtonActionPerformed(evt);
            }
        });

        deleteItemButton.setText("Delete Item");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jDesktopPane2.setLayer(addItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(updateItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(deleteItemButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(backButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateItemButton)
                            .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteItemButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(addItemButton)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addItemButton)
                .addGap(18, 18, 18)
                .addComponent(updateItemButton)
                .addGap(18, 18, 18)
                .addComponent(deleteItemButton)
                .addGap(18, 18, 18)
                .addComponent(backButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jDesktopPane3.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 5, 5, 5, new java.awt.Color(0, 0, 0)));

        newOrderButton.setText("New Order");
        newOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderButtonActionPerformed(evt);
            }
        });

        orderNowButton.setText("Order Now");
        orderNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNowButtonActionPerformed(evt);
            }
        });

        cancelOrderButton.setText("Cancel Order");
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });

        jDesktopPane3.setLayer(newOrderButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(orderNowButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(cancelOrderButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newOrderButton)
                    .addComponent(orderNowButton)
                    .addComponent(cancelOrderButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newOrderButton)
                .addGap(18, 18, 18)
                .addComponent(orderNowButton)
                .addGap(18, 18, 18)
                .addComponent(cancelOrderButton)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel10.setText("ITEMS");

        jLabel11.setText("ORDERS");

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(codeField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(productBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(customerPhoneField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(priceField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(quantityField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(grandTotalField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(dateField, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDesktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jDesktopPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7))
                        .addGap(127, 127, 127)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(grandTotalField)
                            .addComponent(codeField)
                            .addComponent(productBox, 0, 180, Short.MAX_VALUE)
                            .addComponent(customerPhoneField)
                            .addComponent(priceField)
                            .addComponent(quantityField)
                            .addComponent(dateField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(productBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(customerPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(51, 51, 51)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186))
        );

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(cartTable);

        availableProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        availableProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableProductTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(availableProductTable);

        jLabel12.setText("AVAILABLE PRODUCT");

        jDesktopPane4.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane4Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel12)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(510, 510, 510))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDesktopPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeFieldActionPerformed
         
    }//GEN-LAST:event_codeFieldActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
    try {
        String productName = (String) productBox.getSelectedItem();
        if (productName == null || productName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int price = Integer.parseInt(priceField.getText().trim());
        int qty = Integer.parseInt(quantityField.getText().trim());
        if (qty <= 0) {
            JOptionPane.showMessageDialog(this, "Quantity must be > 0", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int subtotal = price * qty;

        // ProductId fetch from DB
        int productId = getProductIdByName(productName);

        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.addRow(new Object[]{productId, productName, price, qty, subtotal});

        recalcCartTotal();
        quantityField.setText("");
        grandTotalField.setText(String.valueOf(getCartTotal()));

    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Invalid price or quantity.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
 

                                         
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void orderNowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNowButtonActionPerformed
       DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
if (model.getRowCount() == 0) {
    JOptionPane.showMessageDialog(this, "Cart is empty!");
    return;
}

String customerPhone = customerPhoneField.getText().trim();
if (customerPhone.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter customer phone!");
    return;
}

BigDecimal totalAmountBD = BigDecimal.valueOf(getCartTotal());
String orderNo = codeField.getText();

try (Connection conn = DBConnection.getConnection()) {
    conn.setAutoCommit(false); // Transaction start

    // 1. Check stock for each product
    String checkStockSQL = "SELECT quantity FROM products WHERE p_id = ? FOR UPDATE";
    try (PreparedStatement checkStmt = conn.prepareStatement(checkStockSQL)) {
        for (int i = 0; i < model.getRowCount(); i++) {
            int productId = Integer.parseInt(model.getValueAt(i, 0).toString());
            int qty = Integer.parseInt(model.getValueAt(i, 3).toString());
            String productName = model.getValueAt(i, 1).toString();

            checkStmt.setInt(1, productId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next() && rs.getInt("quantity") < qty) {
                    throw new Exception("Insufficient stock for product: " + productName);
                }
            }
        }
    }

    // 2. Insert order
    String sqlOrder = "INSERT INTO orders (customer_phone, total_price, order_no, date) VALUES (?, ?, ?, ?)";
    int orderId;
    try (PreparedStatement psOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)) {
        psOrder.setString(1, customerPhone);
        psOrder.setBigDecimal(2, totalAmountBD);
        psOrder.setString(3, orderNo);
        psOrder.setDate(4, new java.sql.Date(System.currentTimeMillis()));
        psOrder.executeUpdate();

        try (ResultSet rs = psOrder.getGeneratedKeys()) {
            if (rs.next()) orderId = rs.getInt(1);
            else throw new Exception("Failed to retrieve order ID");
        }
    }

    // 3. Insert order details and deduct stock
    String sqlDetail = "INSERT INTO order_details (product_id, price, quantity, order_id) VALUES (?, ?, ?, ?)";
    String updateSql = "UPDATE products SET quantity = quantity - ? WHERE p_id = ?";
    
    try (PreparedStatement psDetail = conn.prepareStatement(sqlDetail);
         PreparedStatement updatePs = conn.prepareStatement(updateSql)) {

        for (int i = 0; i < model.getRowCount(); i++) {
            int productId = Integer.parseInt(model.getValueAt(i, 0).toString());
            int price = Integer.parseInt(model.getValueAt(i, 2).toString());
            int qty = Integer.parseInt(model.getValueAt(i, 3).toString());

            // Insert order_details
            psDetail.setInt(1, productId);
            psDetail.setInt(2, price);
            psDetail.setInt(3, qty);
            psDetail.setInt(4, orderId);
            psDetail.addBatch();

            // Deduct stock
            updatePs.setInt(1, qty);
            updatePs.setInt(2, productId);
            updatePs.addBatch();
        }

        psDetail.executeBatch();
        updatePs.executeBatch();
    }

    conn.commit(); // Commit transaction

    JOptionPane.showMessageDialog(this, "Order placed successfully!");
    loadAvailableProducts();

    // Open payment form
    PaymentForm paymentForm = new PaymentForm(orderId, totalAmountBD, "ORDER", this);
    paymentForm.setVisible(true);
    paymentForm.setLocationRelativeTo(null);
    this.setVisible(false);

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
}



    }//GEN-LAST:event_orderNowButtonActionPerformed

    private void newOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderButtonActionPerformed
      DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
    model.setRowCount(0);
    codeField.setText("");
    customerPhoneField.setText("");
    priceField.setText("");
    quantityField.setText("");
    grandTotalField.setText("");
    setCurrentDate();
    generateOrderCode();
    }//GEN-LAST:event_newOrderButtonActionPerformed

    private void updateItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemButtonActionPerformed
        int selectedRow = cartTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select an item to update.");
        return;
    }

    try {
        int price = Integer.parseInt(priceField.getText().trim());
        int qty = Integer.parseInt(quantityField.getText().trim());
        int subtotal = price * qty;

        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setValueAt(price, selectedRow, 2);
        model.setValueAt(qty, selectedRow, 3);
        model.setValueAt(subtotal, selectedRow, 4);

        recalcCartTotal();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Invalid values.");
    }
    }//GEN-LAST:event_updateItemButtonActionPerformed

    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        int selectedRow = cartTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Select an item to delete.");
        return;
    }
    DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
    model.removeRow(selectedRow);
    recalcCartTotal();
    }//GEN-LAST:event_deleteItemButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
      DashBoard dashBoard = new DashBoard();
      dashBoard.setVisible(true);
      dashBoard.setLocationRelativeTo(null);  
      this.dispose();
            
    }//GEN-LAST:event_backButtonActionPerformed

    private void cancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderButtonActionPerformed
         DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
    model.setRowCount(0);
    grandTotalField.setText("");
    priceField.setText("");
    quantityField.setText("");

    }//GEN-LAST:event_cancelOrderButtonActionPerformed

    private void availableProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableProductTableMouseClicked
                                            
    int row = availableProductTable.getSelectedRow();
    if (row != -1) {
        String productName = availableProductTable.getValueAt(row, 1).toString();
        String price = availableProductTable.getValueAt(row, 2).toString();
        String quantity = availableProductTable.getValueAt(row, 3).toString();

        productBox.setSelectedItem(productName);
        priceField.setText(price);
        quantityField.setText(quantity);
        quantityField.setText("1");
    }


    }//GEN-LAST:event_availableProductTableMouseClicked

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JTable availableProductTable;
    private javax.swing.JButton backButton;
    private javax.swing.JButton cancelOrderButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JTextField codeField;
    private javax.swing.JTextField customerPhoneField;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JTextField grandTotalField;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newOrderButton;
    private javax.swing.JButton orderNowButton;
    private javax.swing.JTextField priceField;
    private javax.swing.JComboBox<String> productBox;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton updateItemButton;
    // End of variables declaration//GEN-END:variables

   private void setCurrentDate() {
    java.util.Date today = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    dateField.setText(sdf.format(today)); // dateField aapke order form ka JTextField hai
}


    private void generateOrderCode() {
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMM");
    String timestamp = sdf.format(new java.util.Date());
    String orderNo = "ORD-" + timestamp; 
    codeField.setText(orderNo); // orderNoField aapke order form ka JTextField hai
}
void loadAvailableProducts() {
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT p_id, name, price, quantity FROM products WHERE quantity > 0";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Yahan pe model initialize karo
        DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Name", "Price", "Quantity"}
        );

        // Data add karo
        while (rs.next()) {
            int id = rs.getInt("p_id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");

            model.addRow(new Object[]{id, name, price, quantity});
        }

        // Table ko model set karo
        availableProductTable.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

   private void setupProductPriceListener() {
    productBox.addActionListener(e -> {
        String selectedProduct = (String) productBox.getSelectedItem();
        if (selectedProduct != null && !selectedProduct.trim().isEmpty()) {
            try (Connection conn = DBConnection.getConnection()) {
                String sql = "SELECT price FROM products WHERE name = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, selectedProduct);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int price = rs.getInt("price");
                    priceField.setText(String.valueOf(price));
                    recalcGrandTotal(); // quantity ke hisaab se total update
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });
}


   private void setupQuantityListener() {
    quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
        @Override
        public void keyReleased(java.awt.event.KeyEvent e) {
            recalcGrandTotal();
        }
    });
}

private void recalcGrandTotal() {
    try {
        int price = Integer.parseInt(priceField.getText().trim());
        int qty = Integer.parseInt(quantityField.getText().trim());
        int total = price * qty;
        grandTotalField.setText(String.valueOf(total));
    } catch (NumberFormatException ex) {
        grandTotalField.setText("0");
    }
}



}
