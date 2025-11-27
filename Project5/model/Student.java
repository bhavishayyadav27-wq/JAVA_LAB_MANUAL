// model/Student.java
package model;
public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name,email);
        this.rollNo = rollNo; this.course = course; this.marks = marks; calculateGrade();
    }
    public int getRollNo() { return rollNo; }
    public double getMarks() { return marks; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public char getGrade() { return grade; }
    public void calculateGrade() {
        if (marks >= 85) grade='A';
        else if (marks >=70) grade='B';
        else if (marks>=50) grade='C';
        else grade='D';
    }
    @Override
    public void displayInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("------------------");
    }
    public String toCSV() {
        return rollNo + "," + name.replace(",","\\,") + "," + email.replace(",","\\,") + "," + course.replace(",","\\,") + "," + marks;
    }
    public static Student fromCSV(String line) {
        String[] parts = line.split(",",5);
        int r = Integer.parseInt(parts[0]);
        String n = parts[1].replace("\\,",",");
        String e = parts[2].replace("\\,",",");
        String c = parts[3].replace("\\,",",");
        double m = Double.parseDouble(parts[4]);
        return new Student(r,n,e,c,m);
    }
}
