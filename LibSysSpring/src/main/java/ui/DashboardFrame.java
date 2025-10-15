package ui;

import daoimpl.BookDaoImpl;
import daoimpl.StudentDaoImpl;
import daoimpl.IssuedBookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DashboardFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DashboardFrame.class.getName());

    @Autowired
    private ApplicationContext context;

    private boolean processingEvent = false;
     
    public DashboardFrame() {
        initComponents();

    }


    public void init() {
        initializeComboBoxes();
        System.out.println("✅ DashboardFrame initialized with context: " + (context != null));
    }
    private void initializeComboBoxes() {
          disableActionListeners();
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Add Book");
        jComboBox1.addItem("Update Book");
        jComboBox1.addItem("Delete Book");
        jComboBox1.addItem("View All Books");
      
        jComboBox2.removeAllItems();
        jComboBox2.addItem("Add Student");
        jComboBox2.addItem("Update Student");
        jComboBox2.addItem("Delete Student");
        jComboBox2.addItem("View All Students");
        

        
        issueManagmentBox.removeAllItems();
        issueManagmentBox.addItem("Issue Book");
        issueManagmentBox.addItem("Update Issue");
        issueManagmentBox.addItem("Delete Issue");
        issueManagmentBox.addItem("View All Issues");
        issueManagmentBox.addItem("Return Book");
       enableActionListeners();
       }

private void disableActionListeners() {

    processingEvent = true;
}

private void enableActionListeners() {
    processingEvent = false;

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        issueManagmentBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel1.setText("WELECOME TO LIBRARY MANAGMENT SYSTEM");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(javax.swing.UIManager.getDefaults().getColor("List.dropCellBackground"));
        jLabel2.setText("Book Managment");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(javax.swing.UIManager.getDefaults().getColor("Menu.selectionBackground"));
        jLabel3.setText("Students Managment");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.selectionBackground"));
        jLabel4.setText("Issue Managment");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        issueManagmentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueManagmentBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(issueManagmentBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(issueManagmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(331, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    if (processingEvent) return;
        processingEvent = true;
        
        if (evt.getSource() != jComboBox1) {
            processingEvent = false;
            return;
        }
        
        String selected = (String) jComboBox1.getSelectedItem();
        System.out.println("Book ComboBox: " + selected);

        if(selected == null) {
            processingEvent = false;
            return;
        }

        switch(selected) {
            case "Add Book":
                openBookForm("Save");
                break;
            case "Update Book":
                openBookForm("Update");
                break;
            case "Delete Book":
                openBookForm("Delete");
                break;
            case "View All Books":
                openBookForm("View");
                break;
        }
        
        processingEvent = false;
    }

    private void openBookForm(String mode) {
        this.dispose();
        AddBookForm bookForm = context.getBean(AddBookForm.class);
        bookForm.init();
        bookForm.setVisible(true);
                                            


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
   if (processingEvent) return;
        processingEvent = true;
        
        if(evt.getSource() != jComboBox2) {
            processingEvent = false;
            return;
        }
        
        String selected = (String) jComboBox2.getSelectedItem();
        System.out.println("Student ComboBox: " + selected);
        if(selected == null || selected.isBlank()) {
            processingEvent = false;
            return;
        }

        switch(selected) {
            case "Add Student":
                openStudentForm("Save");
                break;
            case "Update Student":
                openStudentForm("Update");
                break;
            case "Delete Student":
                openStudentForm("Delete");
                break;
            case "View All Students":
                openStudentForm("View");
                break;
        }
        
        processingEvent = false;
    }

    private void openStudentForm(String mode) {
        this.dispose();
        StudentManagment studentForm = context.getBean(StudentManagment.class);
        studentForm.init();
        studentForm.setMode(mode);
        studentForm.setVisible(true);
    }

    private void issueManagmentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueManagmentBoxActionPerformed
       if (processingEvent) return;
        processingEvent = true;
        
        if (evt.getSource() != issueManagmentBox) {
            processingEvent = false;
            return;
        }
        
        String selected = (String) issueManagmentBox.getSelectedItem();
        System.out.println("Issue Management ComboBox: " + selected);

        if(selected == null) {
            processingEvent = false;
            return;
        }

        switch(selected) {
            case "Issue Book":
                openIssueForm("Save");
                break;
            case "Update Issue":
                openIssueForm("Update");
                break;
            case "Delete Issue":
                openIssueForm("Delete");
                break;
            case "View All Issues":
                openIssueForm("View");
                break;
            case "Return Book":
                openIssueForm("Return");
                break;
        }
        
        processingEvent = false;
    }

    private void openIssueForm(String mode) {
        this.dispose();
        IssueManagmentForm issueForm = context.getBean(IssueManagmentForm.class);
        issueForm.init();
        issueForm.setMode(mode);
        issueForm.setVisible(true);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> issueManagmentBox;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
