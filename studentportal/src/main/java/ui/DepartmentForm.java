 
package ui;

import Model.Department;
import daoImpl.DepartmentDaoImpl;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 
public class DepartmentForm extends javax.swing.JFrame {
    private DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DepartmentForm.class.getName());


    public DepartmentForm() {
        initComponents();
        fillDepartmentTable();
    }
    private void fillDepartmentTable() {
        String[] columns = {"Dept ID", "Dept Name", "Dept Code"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        List<Department> departments = departmentDao.getAllDepartments();
        for (Department d : departments) {
            Object[] row = {d.getDeptId(), d.getDeptName(), d.getDeptCode()};
            model.addRow(row);
        }

        departmentTable.setModel(model);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        departmentTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        deptNameField = new javax.swing.JTextField();
        deptCodeField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        departmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        departmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(departmentTable);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Department Name ");

        jLabel2.setText("Department Code");

        deptNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptNameFieldActionPerformed(evt);
            }
        });

        deptCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptCodeFieldActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(206, 206, 206)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(deptNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(deptCodeField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(updateButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(backButton)))
                        .addGap(169, 169, 169))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(deptNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(deptCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(backButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    StudentForm studentForm = new StudentForm();  
    studentForm.setVisible(true);  
    this.dispose(); 
    }//GEN-LAST:event_backButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = deptNameField.getText().trim();
        String code = deptCodeField.getText().trim();

        if (name.isEmpty() || code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Department Name and Code.");
            return;
        }

        Department dept = new Department();
        dept.setDeptName(name);
        dept.setDeptCode(code);

        departmentDao.addDepartment(dept);

        JOptionPane.showMessageDialog(this, "Department added successfully!");
        deptNameField.setText("");
        deptCodeField.setText("");

        fillDepartmentTable();
    

    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
      int row = departmentTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a department to update.");
            return;
        }

        int deptId = (int) departmentTable.getValueAt(row, 0);
        String name = deptNameField.getText().trim();
        String code = deptCodeField.getText().trim();

        if (name.isEmpty() || code.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both Department Name and Code.");
            return;
        }

        Department dept = new Department();
        dept.setDeptId(deptId);
        dept.setDeptName(name);
        dept.setDeptCode(code);

        departmentDao.updateDepartment(dept);

        JOptionPane.showMessageDialog(this, "Department updated successfully!");
        fillDepartmentTable();


    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    int row = departmentTable.getSelectedRow();
if (row == -1) {
    JOptionPane.showMessageDialog(this, "Please select a department to delete.");
    return;
}

int deptId = (int) departmentTable.getValueAt(row, 0);
int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this department?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);

if (confirm == JOptionPane.YES_OPTION) {
     
    if (departmentDao.canDelete(deptId)) {
        departmentDao.deleteDepartment(deptId);
        JOptionPane.showMessageDialog(this, "Department deleted successfully!");
        fillDepartmentTable();
    } else {
        JOptionPane.showMessageDialog(this,
                "This department is linked to a student, so it cannot be deleted.",
                "Delete Error",
                JOptionPane.WARNING_MESSAGE);
    }
}


    }//GEN-LAST:event_deleteButtonActionPerformed

    
    
     
    private void departmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentTableMouseClicked
    int row = departmentTable.getSelectedRow();
    if (row == -1) 
        return;

    deptNameField.setText((String) departmentTable.getValueAt(row, 1));
    deptCodeField.setText((String) departmentTable.getValueAt(row, 2));
    }//GEN-LAST:event_departmentTableMouseClicked
   

     
    private void deptCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptCodeFieldActionPerformed

    private void deptNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptNameFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        
}
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new DepartmentForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable departmentTable;
    private javax.swing.JTextField deptCodeField;
    private javax.swing.JTextField deptNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
