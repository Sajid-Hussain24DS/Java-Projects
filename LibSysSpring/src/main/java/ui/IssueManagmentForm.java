package ui;

import dao.BookDao;
import dao.IssuedBookDao;
import dao.StudentDao;
import daoImpl.BookDaoImpl;
import daoImpl.StudentDaoImpl;
import daoImpl.IssuedBookDaoImpl;
import database.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.Book;
import model.IssuedBook;
import model.Student;
import org.springframework.stereotype.Component;

@Component
public class IssueManagmentForm extends javax.swing.JFrame {

    private IssuedBookDao issuedBookDao;
    private BookDao bookDao;
    private StudentDao studentDao;
  JScrollPane pane; //= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 

    public IssueManagmentForm() {
        this.issuedBookDao = new IssuedBookDaoImpl();
        this.bookDao = new BookDaoImpl();
        this.studentDao = new StudentDaoImpl();
        initComponents();
        initializeForm();
          // Create scroll pane
    
    // Set frame size to something smaller than content
    this.setSize(800, 600);
        DefaultTableModel model = new DefaultTableModel(
    new Object[][] {}, 
    new String[] { "Issue ID", "Student ID", "Student Name", "Book ID", "Book Title", "Issue Date", "Due Date", "Return Date" }
);
issueBookTable.setModel(model);

        loadIssuedBooks();
    }

    private void initializeForm() {
        // Set issue and due dates
        java.util.Date currentDate = new java.util.Date();
        issueDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(currentDate));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 15);
        dueDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));

        // Load students and books
        loadStudents();
        loadBooks();

        // Auto-fill listeners
        studentComboBox.addActionListener(e -> {
            if (studentComboBox.getSelectedItem() != null && !studentComboBox.getSelectedItem().toString().isEmpty()) {
                fillStudentDetails(studentComboBox.getSelectedItem().toString());
            }
        });

        bookComboBox.addActionListener(e -> {
            if (bookComboBox.getSelectedItem() != null && !bookComboBox.getSelectedItem().toString().isEmpty()) {
                fillBookDetails(bookComboBox.getSelectedItem().toString());
            }
        });
    }

    private void loadStudents() {
        try {
            List<Student> students = studentDao.getAllStudents();
            studentComboBox.removeAllItems();
            studentComboBox.addItem("");
            for (Student s : students) {
                studentComboBox.addItem(s.getStudentId() + " - " + s.getName());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading students: " + e.getMessage());
        }
    }

    private void loadBooks() {
        try {
            List<Book> books = bookDao.getAllBooks();
            bookComboBox.removeAllItems();
            bookComboBox.addItem("");
            for (Book b : books) {
                String availability = (b.getQuantity() > 0) ? "Available" : "Out of Stock";
                bookComboBox.addItem(b.getBookId() + " - " + b.getTitle() + " (" + availability + ")");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }
    }

    private void fillStudentDetails(String selection) {
        try {
            if (selection.isEmpty()) {
                studentNameField.setText("");
                rollNumberField.setText("");
                contactField.setText("");
                return;
            }
            int id = Integer.parseInt(selection.split(" - ")[0]);
            Student s = studentDao.getStudentById(id);
            if (s != null) {
                studentNameField.setText(s.getName());
                rollNumberField.setText(s.getRollNumber());
                contactField.setText(s.getContact());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading student details: " + e.getMessage());
        }
    }

    private void fillBookDetails(String selection) {
        try {
            if (selection.isEmpty()) {
                bookTitleField.setText("");
                authorField.setText("");
                isbnField.setText("");
                availablityQuantityField.setText("");
                return;
            }
            int id = Integer.parseInt(selection.split(" - ")[0]);
            Book b = bookDao.getBookById(id);
            if (b != null) {
                bookTitleField.setText(b.getTitle());
                authorField.setText(b.getAuthor());
                isbnField.setText(b.getIsbn());
                availablityQuantityField.setText(String.valueOf(b.getQuantity()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading book details: " + e.getMessage());
        }
    }

    private void loadIssuedBooks() {
         
       String query = "SELECT ib.issue_id, s.student_id, s.name AS student_name, "
             + "b.book_id, b.title AS book_title, ib.issue_date, ib.due_date, ib.return_date "
             + "FROM lib_issued_books ib "
             + "JOIN lib_students s ON ib.student_id = s.student_id "
             + "JOIN lib_books b ON ib.book_id = b.book_id";

DefaultTableModel model = (DefaultTableModel) issueBookTable.getModel();
model.setRowCount(0);
try (Connection conn = DBConnection.getConnection();
     PreparedStatement ps = conn.prepareStatement(query);
     ResultSet rs = ps.executeQuery()) {

    while (rs.next()) {
        model.addRow(new Object[]{
            rs.getInt("issue_id"),
            rs.getInt("student_id"),      // store student_id
            rs.getString("student_name"),
            rs.getInt("book_id"),         // store book_id
            rs.getString("book_title"),
            rs.getDate("issue_date"),
            rs.getDate("due_date"),
            rs.getDate("return_date")
        });
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error loading issued books: " + e.getMessage());
}

  }
  
     



     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        studentComboBox = new javax.swing.JComboBox<>();
        studentNameField = new javax.swing.JTextField();
        rollNumberField = new javax.swing.JTextField();
        contactField = new javax.swing.JTextField();
        bookTitleField = new javax.swing.JTextField();
        bookComboBox = new javax.swing.JComboBox<>();
        authorField = new javax.swing.JTextField();
        isbnField = new javax.swing.JTextField();
        availablityQuantityField = new javax.swing.JTextField();
        issueDateField = new javax.swing.JTextField();
        returnDateField = new javax.swing.JTextField();
        issueBookButton = new javax.swing.JButton();
        viewAllIssueButton = new javax.swing.JButton();
        returnBookButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dueDateField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        issueBookTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Student");

        jLabel2.setText("Student Name");

        jLabel3.setText("Roll Number");

        jLabel4.setText("Contact");

        jLabel5.setText("Book");

        jLabel6.setText("Book Title");

        jLabel7.setText("Author");

        jLabel8.setText("ISBN");

        jLabel9.setText("Available Quantity");

        jLabel11.setText("Issue Date");

        jLabel12.setText("Return Date");

        studentNameField.setText(" ");
        studentNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameFieldActionPerformed(evt);
            }
        });

        rollNumberField.setText(" ");
        rollNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNumberFieldActionPerformed(evt);
            }
        });

        contactField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactFieldActionPerformed(evt);
            }
        });

        bookTitleField.setText(" ");

        bookComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookComboBoxActionPerformed(evt);
            }
        });

        authorField.setText(" ");

        isbnField.setText(" ");

        availablityQuantityField.setText(" ");

        issueDateField.setText(" ");

        returnDateField.setText(" ");
        returnDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnDateFieldActionPerformed(evt);
            }
        });

        issueBookButton.setText("Issue Book");
        issueBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueBookButtonActionPerformed(evt);
            }
        });

        viewAllIssueButton.setText("View All Issue");

        returnBookButton.setText("Return Book");
        returnBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBookButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Due Date");

        dueDateField.setText(" ");

        jScrollPane3.setViewportView(jScrollPane2);

        issueBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        issueBookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueBookTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(issueBookTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(issueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(availablityQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(262, 262, 262)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rollNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(issueBookButton)
                .addGap(18, 18, 18)
                .addComponent(viewAllIssueButton)
                .addGap(18, 18, 18)
                .addComponent(returnBookButton)
                .addGap(28, 28, 28)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(studentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rollNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(contactField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(availablityQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(issueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dueDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(returnDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueBookButton)
                    .addComponent(viewAllIssueButton)
                    .addComponent(returnBookButton)
                    .addComponent(deleteButton)
                    .addComponent(backButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNumberFieldActionPerformed
         
    }//GEN-LAST:event_rollNumberFieldActionPerformed

    private void issueBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueBookButtonActionPerformed
       try {
            if (studentComboBox.getSelectedItem() == null || studentComboBox.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select a student!");
                return;
            }
            if (bookComboBox.getSelectedItem() == null || bookComboBox.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select a book!");
                return;
            }
            int studentId = Integer.parseInt(studentComboBox.getSelectedItem().toString().split(" - ")[0]);
            int bookId = Integer.parseInt(bookComboBox.getSelectedItem().toString().split(" - ")[0]);

            Book book = bookDao.getBookById(bookId);
            if (book.getQuantity() <= 0) {
                JOptionPane.showMessageDialog(this, "Book not available!");
                return;
            }

            Date issueDate = Date.valueOf(issueDateField.getText().trim());
            Date dueDate = Date.valueOf(dueDateField.getText().trim());
            if (dueDate.before(issueDate)) {
                JOptionPane.showMessageDialog(this, "Due date before issue date!");
                return;
            }

            if (issuedBookDao.hasActiveIssue(studentId, bookId)) {
                JOptionPane.showMessageDialog(this, "This book already issued to this student!");
                return;
            }

            boolean success = issuedBookDao.issuedBook(studentId, bookId, issueDate, dueDate);
            if (success) {
                JOptionPane.showMessageDialog(this, "Book issued successfully!");
                bookDao.decreaseBookQuantity(bookId);
                fillBookDetails(bookComboBox.getSelectedItem().toString());
                loadIssuedBooks();
                clearDates();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_issueBookButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
         this.dispose();
        DashboardFrame dashboard = new DashboardFrame();
        dashboard.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void returnBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBookButtonActionPerformed
                                              
       try {
            int studentId = Integer.parseInt(studentComboBox.getSelectedItem().toString().split(" - ")[0]);
            int bookId = Integer.parseInt(bookComboBox.getSelectedItem().toString().split(" - ")[0]);
            if (!issuedBookDao.hasActiveIssue(studentId, bookId)) {
                JOptionPane.showMessageDialog(this, "Book not issued to this student!");
                return;
            }
            Date returnDate = Date.valueOf(returnDateField.getText().trim());
            boolean success = issuedBookDao.returnBook(studentId, bookId, returnDate);
            if (success) {
                JOptionPane.showMessageDialog(this, "Book returned successfully!");
                bookDao.increaseBookQuantity(bookId);
                fillBookDetails(bookComboBox.getSelectedItem().toString());
                loadIssuedBooks();
                clearDates();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_returnBookButtonActionPerformed

    private void returnDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnDateFieldActionPerformed

    private void contactFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactFieldActionPerformed

    private void studentNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameFieldActionPerformed

    private void issueBookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueBookTableMouseClicked
       
        int row = issueBookTable.getSelectedRow();
if (row == -1) return;

int studentId = (int) issueBookTable.getValueAt(row, 1); // student_id
int bookId = (int) issueBookTable.getValueAt(row, 3);    // book_id

issueDateField.setText(issueBookTable.getValueAt(row, 5).toString());
dueDateField.setText(issueBookTable.getValueAt(row, 6).toString());
returnDateField.setText(issueBookTable.getValueAt(row, 7) != null ? issueBookTable.getValueAt(row, 7).toString() : "");

// set ComboBoxes by ID
for (int i = 0; i < studentComboBox.getItemCount(); i++) {
    String item = studentComboBox.getItemAt(i);
    if (item.startsWith(studentId + " -")) {
        studentComboBox.setSelectedIndex(i);
        break;
    }
}
for (int i = 0; i < bookComboBox.getItemCount(); i++) {
    String item = bookComboBox.getItemAt(i);
    if (item.startsWith(bookId + " -")) {
        bookComboBox.setSelectedIndex(i);
        break;
    }
}

    }

    private void clearDates() {
        java.util.Date currentDate = new java.util.Date();
        issueDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(currentDate));
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 15);
        dueDateField.setText(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        returnDateField.setText("");
    

    }//GEN-LAST:event_issueBookTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
                                              
     int row = issueBookTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a record!");
            return;
        }
        int issueId = Integer.parseInt(issueBookTable.getValueAt(row, 0).toString());
        if (issuedBookDao.deleteIssuedBook(issueId)) {
            JOptionPane.showMessageDialog(this, "Deleted successfully!");
            loadIssuedBooks();
        }


    }//GEN-LAST:event_deleteButtonActionPerformed

    private void bookComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookComboBoxActionPerformed
 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorField;
    private javax.swing.JTextField availablityQuantityField;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> bookComboBox;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.JTextField contactField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField dueDateField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField isbnField;
    private javax.swing.JButton issueBookButton;
    private javax.swing.JTable issueBookTable;
    private javax.swing.JTextField issueDateField;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton returnBookButton;
    private javax.swing.JTextField returnDateField;
    private javax.swing.JTextField rollNumberField;
    private javax.swing.JComboBox<String> studentComboBox;
    private javax.swing.JTextField studentNameField;
    private javax.swing.JButton viewAllIssueButton;
    // End of variables declaration//GEN-END:variables

    private String getStudentName(int studentId) {
    Student student = studentDao.getStudentById(studentId);
    return student != null ? student.getName() : "Unknown";
}

private String getBookTitle(int bookId) {
    Book book = bookDao.getBookById(bookId);
    return book != null ? book.getTitle() : "Unknown";
}



}




