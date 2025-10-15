 

package ui;

import dao.BookDao;
import daoimpl.BookDaoImpl;
import  database.CategoryDbManager;
import model.Book;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import javax.swing.JOptionPane;

@Component
public class AddBookForm extends javax.swing.JFrame {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private ApplicationContext context;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddBookForm.class.getName());

    @Autowired
    private CategoryDbManager categoryDBManager;



    public static int bookId = 0;
    private String mode = "ADD";

    public AddBookForm() {
       initComponents();
    }
    public void init() {
        loadBooksTable();
        fillCategoryBox();
        System.out.println("✅ AddBookForm initialized with bookDao: " + (bookDao != null));
    }


    private void fillCategoryBox() {
        List<Category> categories = categoryDBManager.getAllCategories();
        categories.forEach(c -> categoryBox.addItem(c.getCategoryName()));
    }
    private void loadBooksTable() {
        try {
            List<Book> books = bookDao.getAllBooks();
            javax.swing.table.DefaultTableModel model =
                    new javax.swing.table.DefaultTableModel();
            model.setColumnIdentifiers(new String[]{
                    "ID", "Title", "Author", "Publisher", "ISBN", "Quantity", "Category"
            });

            for (Book book : books) {
                model.addRow(new Object[]{
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getPublisher(),
                        book.getIsbn(),
                        book.getQuantity(),
                        book.getCategoryName()
                });
            }

            bookTable.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading books: " + e.getMessage());
        }

}

     private void setupFormMode() {
        switch (mode) {
            case "ADD":
                saveButton.setVisible(true);
                updateButtton.setVisible(false);
                break;
            case "UPDATE":
                saveButton.setVisible(false);
                updateButtton.setVisible(true);
                break;
            case "DELETE":
                saveButton.setVisible(false);
                updateButtton.setText("Delete");
                updateButtton.setVisible(true);
                break;
            case "VIEW":
                saveButton.setVisible(false);
                updateButtton.setVisible(false);
                titleField.setEditable(false);
                authorField.setEditable(false);
                publisherField.setEditable(false);
                isbnField.setEditable(false);
                quantityField.setEditable(false);
                categoryBox.setEnabled(false);
                break;
        }
    }

    public void setMode(String mode) {
    if ("UPDATE".equalsIgnoreCase(mode)) {
        saveButton.setVisible(false);
        updateButtton.setVisible(true);
    } else { // default = ADD mode
        saveButton.setVisible(true);
        updateButtton.setVisible(false);
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
        jLabel6 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        authorField = new javax.swing.JTextField();
        publisherField = new javax.swing.JTextField();
        isbnField = new javax.swing.JTextField();
        categoryBox = new javax.swing.JComboBox<>();
        quantityField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        updateButtton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        viewAllBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Title");

        jLabel2.setText("Author");

        jLabel3.setText("Publisher");

        jLabel4.setText("ISBN");

        jLabel5.setText("Category ");

        jLabel6.setText("Quantity");

        titleField.setText(" ");

        isbnField.setText(" ");

        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        quantityField.setText(" ");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        updateButtton.setText("Update");
        updateButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButttonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        viewAllBook.setText("View All Book");

        bookTable.setModel(new javax.swing.table.DefaultTableModel(
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
        bookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleField)
                                    .addComponent(authorField)
                                    .addComponent(publisherField)
                                    .addComponent(isbnField)
                                    .addComponent(categoryBox, 0, 200, Short.MAX_VALUE)
                                    .addComponent(quantityField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(backButton)
                                .addGap(42, 42, 42)
                                .addComponent(updateButtton)
                                .addGap(49, 49, 49)
                                .addComponent(deleteButton)
                                .addGap(45, 45, 45)
                                .addComponent(viewAllBook))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(backButton)
                    .addComponent(updateButtton)
                    .addComponent(deleteButton)
                    .addComponent(viewAllBook))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
   
     
      
    try {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String isbn = isbnField.getText().trim();
        String publisher = publisherField.getText().trim();
        
         
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title, Author and ISBN are required fields!");
            return;
        }
        
        int quantity = Integer.parseInt(quantityField.getText().trim());
        
        // Category validation
        if (categoryBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select a category!");
            return;
        }
        
        String categoryName = categoryBox.getSelectedItem().toString();   
        Category category = categoryDBManager.getCategoryByName(categoryName);
        
        if (category == null) {
            JOptionPane.showMessageDialog(this, "Selected category not found!");
            return;
        }
        
        Book book = context.getBean(Book.class);
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublisher(publisher);
        book.setQuantity(quantity);
        book.setCategoryId(category.getCategoryId());
        
        bookDao.addBook(book);
          loadBooksTable();
        JOptionPane.showMessageDialog(this, "Book Added Successfully!");
        //clearForm();
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid quantity number!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        e.printStackTrace();
    }
      
    }//GEN-LAST:event_saveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        DashboardFrame dashboard = context.getBean(DashboardFrame.class);
        dashboard.setVisible(true);
    
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButttonActionPerformed
    try {
    String title = titleField.getText().trim();
    String author = authorField.getText().trim();
    String publisher = publisherField.getText().trim();
    String isbn = isbnField.getText().trim(); 
    
    if (title.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Title, Author and ISBN are required fields!");
        return;
    }
    
    int quantity = Integer.parseInt(quantityField.getText().trim());
    
    // Category validation
    if (categoryBox.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Please select a category!");
        return;
    }
    
    String categoryName = categoryBox.getSelectedItem().toString();   
    Category category = categoryDBManager.getCategoryByName(categoryName);
    
    if (category == null) {
        JOptionPane.showMessageDialog(this, "Selected category not found!");
        return;
    }
    

    Book book = context.getBean(Book.class);
    book.setBookId(bookId); 
    book.setTitle(title);
    book.setAuthor(author);
    book.setPublisher(publisher);
    book.setIsbn(isbn);
    book.setQuantity(quantity);
    book.setCategoryId(category.getCategoryId());
    
    // Update book in database
    bookDao.updateBook(book);
    loadBooksTable(); // Refresh table
    JOptionPane.showMessageDialog(this, "Book Updated Successfully!");
    clearForm(); // ✅ UNCOMMENT THIS to clear form after success
    
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Please enter a valid quantity number!");
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    e.printStackTrace();
}                                     
      
                 
    }//GEN-LAST:event_updateButttonActionPerformed

    private void bookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTableMouseClicked
      int selectedRow = bookTable.getSelectedRow();
    if (selectedRow >= 0) {
        // Get the ID from the first column
        Object idValue = bookTable.getValueAt(selectedRow, 0);
        if (idValue != null) {
            try {
                bookId = Integer.parseInt(idValue.toString());
            } catch (NumberFormatException e) {
                bookId = -1;
                System.out.println("Invalid ID: " + idValue);
            }
        }

        titleField.setText(bookTable.getValueAt(selectedRow, 1).toString());
        authorField.setText(bookTable.getValueAt(selectedRow, 2).toString());
        publisherField.setText(bookTable.getValueAt(selectedRow, 3).toString());
        isbnField.setText(bookTable.getValueAt(selectedRow, 4).toString());
        quantityField.setText(bookTable.getValueAt(selectedRow, 5).toString());
        categoryBox.setSelectedItem(bookTable.getValueAt(selectedRow, 6).toString());
    }
    }//GEN-LAST:event_bookTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (bookId <= 0) {
        JOptionPane.showMessageDialog(this, "Please select a book to delete first!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to delete this book?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            bookDao.deleteBook(bookId); // This returns void
            JOptionPane.showMessageDialog(this, "Book deleted successfully!");
            loadBooksTable(); // Refresh the table
            clearForm(); // Clear the form fields
            bookId = 0; // Reset the book ID
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to delete book: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    }//GEN-LAST:event_deleteButtonActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorField;
    private javax.swing.JButton backButton;
    private javax.swing.JTable bookTable;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField isbnField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField publisherField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField titleField;
    private javax.swing.JButton updateButtton;
    private javax.swing.JButton viewAllBook;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
    titleField.setText("");
    authorField.setText("");
    publisherField.setText("");
    isbnField.setText("");
    quantityField.setText("");
    categoryBox.setSelectedIndex(0); // Select the first item or empty
    bookId = 0; // Reset the book ID
}

    

} 

