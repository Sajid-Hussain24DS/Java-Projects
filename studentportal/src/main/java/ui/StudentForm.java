 
package ui;

 
import DAO.DepartmentDao;
import DAO.StudentDao;
import DATABASE.DepartmentDbManager;
import Model.Department;
import Model.Student;
import daoImpl.StudentDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

 
public class StudentForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentForm.class.getName());
    DepartmentDbManager departmentDBManager = new DepartmentDbManager();
    StudentDao studentDao = new StudentDaoImpl();
    public static int studentId =0;
        
    
   
    
    
    public StudentForm() {
        initComponents();
        buttonGroup1.add(maleradiobutton);
        buttonGroup1.add(femaleradiobutton);
        filldepartmentBox();
        fillStudentTable();
         
    }
    
    private void fillStudentTable(){
    String []columnNames = {"StudentId","Name","Age","Cnic","RollNumber","Email","Gender","Department"};
     DefaultTableModel studentTableModel = new DefaultTableModel(columnNames, 0);
    
    List<Student> students =  studentDao.getAllStudents();
    students.forEach(student->{
        Object [] row = {student.getStudentId(),student.getName(),student.getAge(),student.getCnic(),student.getRollNumber(),
        student.getEmail(),student.getGender(),student.getDepartment().getDeptName()};
        
        studentTableModel.addRow(row);
    });
    
     studentTable.setModel(studentTableModel);
    }
    
    private void filldepartmentBox(){
        List<Model.Department> departments = departmentDBManager.getAllDepartments();
        departments.forEach(dept->{
            deptBox.addItem(dept.getDeptName());
        });
    
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        cnicField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        rollNumberField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        femaleradiobutton = new javax.swing.JRadioButton();
        maleradiobutton = new javax.swing.JRadioButton();
        deptBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        deptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Roll_Number");

        jLabel4.setText("Cnic");

        jLabel5.setText("Email");

        jLabel6.setText("Gender");

        jLabel7.setText("Department");

        cnicField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnicFieldActionPerformed(evt);
            }
        });

        rollNumberField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        femaleradiobutton.setText(" Female");
        femaleradiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleradiobuttonActionPerformed(evt);
            }
        });

        maleradiobutton.setText("Male");
        maleradiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleradiobuttonActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

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

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        deptButton.setText("Department");
        deptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(234, 234, 234)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)))
                                .addGap(202, 202, 202)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(maleradiobutton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                                            .addComponent(femaleradiobutton))
                                        .addComponent(ageField)
                                        .addComponent(cnicField)
                                        .addComponent(rollNumberField)
                                        .addComponent(emailField)
                                        .addComponent(deptBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(submitButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(clearButton)
                                        .addGap(38, 38, 38)
                                        .addComponent(deptButton)))))
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cnicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rollNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5))
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(maleradiobutton))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(deptBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(femaleradiobutton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(clearButton)
                    .addComponent(submitButton)
                    .addComponent(deptButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );

        getAccessibleContext().setAccessibleParent(submitButton);

        setBounds(0, 0, 943, 648);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
      System.out.println("Button Clicked");
        String name = nameField.getText();
        Integer age = Integer.valueOf(ageField.getText().toString());
        String cnic = cnicField.getText();
        String rollNumber = rollNumberField.getText();
        String email = emailField.getText();
        String gender = null;
        if(maleradiobutton.isSelected()){
            gender= maleradiobutton.getText();
        }
        if(femaleradiobutton.isSelected()){
            gender= femaleradiobutton.getText();
        }
        String deptName = deptBox.getSelectedItem().toString();   
        Department d =  departmentDBManager.getDepartmentByDeptName(deptName);
         
        
        
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setCnic(cnic);
        student.setRollNumber(rollNumber);
        student.setEmail(email);
        student.setGender(gender);
        student.setDepartment(d);
        
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.addStudent(student);
         
        fillStudentTable();
        JOptionPane.showMessageDialog(this, "Student Added Successfully!");
               

    }//GEN-LAST:event_submitButtonActionPerformed

    private void femaleradiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleradiobuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleradiobuttonActionPerformed

    private void maleradiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleradiobuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleradiobuttonActionPerformed

    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formHierarchyChanged

    private void cnicFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnicFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnicFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        int row = studentTable.getSelectedRow();
        studentId = (int)studentTable.getValueAt(row, 0);
         System.out.println("Selected Student ID: " + studentId);
        Student student = studentDao.getStudentById(studentId);
        nameField.setText(student.getName());
        ageField.setText(String.valueOf(student.getAge()));
        cnicField.setText(student.getCnic());
        rollNumberField.setText(student.getRollNumber());
        emailField.setText(student.getEmail());
    if ("Male".equalsIgnoreCase(student.getGender())) {
    maleradiobutton.setSelected(true);
    } else {
    femaleradiobutton.setSelected(true);
    }
        deptBox.setSelectedItem(student.getDepartment().getDeptName()); 
        
    }//GEN-LAST:event_studentTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String name = nameField.getText();
        Integer age = Integer.valueOf(ageField.getText().toString());
        String cnic = cnicField.getText();
        String rollNumber = rollNumberField.getText();
        String email = emailField.getText();
        String gender = null;
        if(maleradiobutton.isSelected()){
            gender= maleradiobutton.getText();
        }
        if(femaleradiobutton.isSelected()){
            gender= femaleradiobutton.getText();
        }
        String deptName = deptBox.getSelectedItem().toString();   
        Department d =  departmentDBManager.getDepartmentByDeptName(deptName);
        Student student = new Student();
        student.setStudentId(studentId);
        student.setName(name);
        student.setAge(age);
        student.setCnic(cnic);
        student.setRollNumber(rollNumber);
        student.setEmail(email);
        student.setGender(gender);
        student.setDepartment(d);
        
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.updateStudent(student);
         
        fillStudentTable();
        JOptionPane.showMessageDialog(this, "Update Student Successfully!");
               
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    int row = studentTable.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Please select a student to delete.");
        return;
    }

    int studentId = (int) studentTable.getValueAt(row, 0);

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this student?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        studentDao.deleteStudent(studentId);
        JOptionPane.showMessageDialog(this, "Student deleted successfully!");
        fillStudentTable();

    }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

    nameField.setText("");
    rollNumberField.setText("");
    ageField.setText("");
    cnicField.setText("");
    emailField.setText("");
    buttonGroup1.clearSelection();
   
    if (deptBox.getItemCount() > 0) {
        deptBox.setSelectedIndex(0);
    }
    studentTable.clearSelection();

    }//GEN-LAST:event_clearButtonActionPerformed

    private void deptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptButtonActionPerformed
        DepartmentForm deptForm = new DepartmentForm();  
        deptForm.setVisible(true);  
        this.dispose();    
    }//GEN-LAST:event_deptButtonActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new StudentForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField cnicField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> deptBox;
    private javax.swing.JButton deptButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JRadioButton femaleradiobutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton maleradiobutton;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField rollNumberField;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
