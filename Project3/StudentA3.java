// StudentA3.java
public class StudentA3 {
    private Integer rollNo; // wrapper class use
    private String name;
    private String email;
    private Double marks;

    public StudentA3(Integer rollNo, String name, String email, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    public Integer getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Double getMarks() { return marks; }

    public char calculateGrade() {
        double m = marks.doubleValue();
        if (m >= 85) return 'A';
        if (m >= 70) return 'B';
        if (m >= 50) return 'C';
        return 'D';
    }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
        System.out.println("------------------");
    }
}
