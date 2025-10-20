package model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "lib_students")
public class Student {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "student_id")
    private int studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "roll_number")
    private String rollNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "contact")
    private String contact;

    // Getters and Setters
     
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setAge(int age){
        this.age= age; 
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Student [student_Id=" + studentId + ", name=" + name + ", age=" + age + ", roll_Number=" + rollNumber +
                ", email=" + email + ", contact=" + contact + "]";
    }

    

}