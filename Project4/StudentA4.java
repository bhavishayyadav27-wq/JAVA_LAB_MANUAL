// StudentA4.java
public class StudentA4 {
    private int rollNo;
    private String name;
    private String email;
    private String course;
    private double marks;

    public StudentA4(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo; this.name = name; this.email = email; this.course = course; this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String toCSV() {
        return rollNo + "," + escape(name) + "," + escape(email) + "," + escape(course) + "," + marks;
    }
    public static StudentA4 fromCSV(String line) {
        String[] parts = line.split(",",5);
        int r = Integer.parseInt(parts[0]);
        String n = unescape(parts[1]);
        String e = unescape(parts[2]);
        String c = unescape(parts[3]);
        double m = Double.parseDouble(parts[4]);
        return new StudentA4(r,n,e,c,m);
    }
    private static String escape(String s) { return s.replace(",", "\\,"); }
    private static String unescape(String s) { return s.replace("\\,", ","); }

    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("------------------");
    }

    public double getMarks() { return marks; }
    public String getName() { return name; }
}
