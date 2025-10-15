package ui;

import daoimpl.StudentDaoImpl;
import java.util.List;
import javax.swing.JOptionPane;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StudentManagment extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(StudentManagment.class.getName());

    @Autowired
    private ApplicationContext context;

    @Autowired
    private StudentDaoImpl studentDao;

    public static int studentId = 0;
    private String mode = "ADD";

    public StudentManagment() {
        initComponents();
        setupFormMode();

    }

    public void init() {
        loadStudentsIntoTable();
    }
 private void loadStudentsIntoTable() {
        try {
            List<Student> students = studentDao.getAllStudents();

        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Age", "Roll No", "Email", "Contact"});

            for (Student s : students) {
                model.addRow(new Object[]{
                    s.getStudentId(),
                    s.getName(),
                    s.getAge(),
                    s.getRollNumber(),
                    s.getEmail(),
                    s.getContact()
                });
            }
            studentTable.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading students: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Form reset
    private void clearForm() {
        nameField.setText("");
        ageField.setText("");
        rollNumberField.setText("");
        emailField.setText("");
        contactField.setText("");
        studentId = -1;
    }

    private void setupFormMode() {
        switch (mode) {
            case "Save":
                saveButton.setVisible(true);
                updateButton.setVisible(false);
                break;
            case "UPDATE":
                saveButton.setVisible(false);
                updateButton.setVisible(true);
                break;
            case "DELETE":
                saveButton.setVisible(false);
                updateButton.setText("Delete");
                updateButton.setVisible(true);
                break;
            case "VIEW":
                saveButton.setVisible(false);
                updateButton.setVisible(false);
                nameField.setEditable(false);
                ageField.setEditable(false);
                rollNumberField.setEditable(false);
                emailField.setEditable(false);
                contactField.setEditable(false);
                break;
        }
    
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        rollNumberField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        contactField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        allStudentButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Age");

        jLabel3.setText("Roll Number");

        jLabel4.setText("Email");

        jLabel5.setText("Contact");

        nameField.setText(" ");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 2, 18)); // NOI18N
        jLabel6.setText("Student Registration Form");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, javax.swing.UIManager.getDefaults().getColor("RadioButton.highlight")));

        rollNumberField.setText(" ");

        emailField.setText(" ");

        contactField.setText(" ");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
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

        allStudentButton.setText("View All Student");
        allStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allStudentButtonActionPerformed(evt);
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

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(saveButton)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(allStudentButton)
                                .addGap(18, 18, 18)
                                .addComponent(backButton))
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(184, 184, 184)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameField)
                                    .addComponent(ageField)
                                    .addComponent(rollNumberField)
                                    .addComponent(emailField)
                                    .addComponent(contactField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rollNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(allStudentButton)
                    .addComponent(backButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
         
        try {
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String rollNo = rollNumberField.getText().trim();
            String email = emailField.getText().trim();
            String phone = contactField.getText().trim();

            if (studentId == -1) {
                JOptionPane.showMessageDialog(this, "Please select a student to update!");
                return;
            }
            if (name.isEmpty() || rollNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Roll No are required!");
                return;
            }

            Student student = context.getBean(Student.class);
            student.setStudentId(studentId); 
            student.setName(name);
            student.setAge(age);
            student.setRollNumber(rollNo);
            student.setEmail(email);
            student.setContact(phone);

            studentDao.updateStudent(student);
            loadStudentsIntoTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Student Updated Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
         try {
            String name = nameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String rollNo = rollNumberField.getText().trim();
            String email = emailField.getText().trim();
            String phone = contactField.getText().trim();

            if (name.isEmpty() || rollNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name and Roll No are required!");
                return;
            }

            Student student = context.getBean(Student.class);
            student.setName(name);
            student.setAge(age);
            student.setRollNumber(rollNo);
            student.setEmail(email);
            student.setContact(phone);

            studentDao.addStudent(student);
            loadStudentsIntoTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Student Added Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
                                                
   if (studentId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this student?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                studentDao.deleteStudent(studentId);
                loadStudentsIntoTable();
                clearForm();
                JOptionPane.showMessageDialog(this, "Student deleted successfully.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting student: " + e.getMessage());
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_deleteButtonActionPerformed

    private void allStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allStudentButtonActionPerformed
        loadStudentsIntoTable();
    }//GEN-LAST:event_allStudentButtonActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
         int selectedRow = studentTable.getSelectedRow();
        if (selectedRow >= 0) {
            Object value = studentTable.getValueAt(selectedRow, 0);
            if (value != null) {
                studentId = Integer.parseInt(value.toString());
            }

            nameField.setText(studentTable.getValueAt(selectedRow, 1).toString());
            ageField.setText(studentTable.getValueAt(selectedRow, 2).toString());
            rollNumberField.setText(studentTable.getValueAt(selectedRow, 3).toString());
            emailField.setText(studentTable.getValueAt(selectedRow, 4).toString());
            contactField.setText(studentTable.getValueAt(selectedRow, 5).toString());
        }
    }//GEN-LAST:event_studentTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
     this.dispose();
        DashboardFrame dashboard = context.getBean(DashboardFrame.class);
        dashboard.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageField;
    private javax.swing.JButton allStudentButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField contactField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField rollNumberField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable studentTable;
    private javax.swing.JButton updateButton;

    public void setMode(String mode) {
    }
    // End of variables declaration//GEN-END:variables

    
}
