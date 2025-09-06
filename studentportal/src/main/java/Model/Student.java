package Model;

public class Student {
    private int studentId;
    private String name;
    private int age;
    private String cnic;
    private String rollNumber;
    private String email;
    private String gender;
    private Department department; // This should be a Department object, not just an ID

    public Student() {}

    public Student(String name, int age, String cnic, String rollNumber,
                   String email, String gender, Department department) {
        this.name = name;
        this.age = age;
        this.cnic = cnic;
        this.rollNumber = rollNumber;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getCnic() { return cnic; }
    public void setCnic(String cnic) { this.cnic = cnic; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", cnic='" + cnic + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                '}';
    }
}
