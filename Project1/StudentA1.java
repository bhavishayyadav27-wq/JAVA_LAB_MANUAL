// StudentA1.java
public class StudentA1 {
    private int rollNo;
    private String name;
    private String course;
    private double marks;
    private char grade;

    public StudentA1() {}

    public StudentA1(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
    public char getGrade() { return grade; }

    public void inputDetails(java.util.Scanner sc) {
        System.out.print("Enter Roll No: ");
        this.rollNo = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Name: ");
        this.name = sc.nextLine().trim();
        System.out.print("Enter Course: ");
        this.course = sc.nextLine().trim();
        System.out.print("Enter Marks: ");
        this.marks = Double.parseDouble(sc.nextLine().trim());
        calculateGrade();
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------");
    }

    public void calculateGrade() {
        if (marks >= 85) grade = 'A';
        else if (marks >= 70) grade = 'B';
        else if (marks >= 50) grade = 'C';
        else grade = 'D';
    }
}
