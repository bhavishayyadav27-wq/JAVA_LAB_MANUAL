// CapstoneApp.java
import java.util.List;
import java.util.Scanner;

import model.Student;
import service.StudentManager;
import util.FileUtil;
import util.Loader;

public class CapstoneApp {
    private static final String FILENAME = "students.txt";
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentManager mgr = new StudentManager();
        // load persisted students
        List<Student> loaded = FileUtil.load(FILENAME);
        mgr.setAllStudents(loaded);
        System.out.println("Loaded " + loaded.size() + " students from " + FILENAME);

        while (true) {
            System.out.println("===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1":
                    try {
                        System.out.print("Enter Roll No: "); int r = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Enter Name: "); String n = sc.nextLine().trim();
                        System.out.print("Enter Email: "); String e = sc.nextLine().trim();
                        System.out.print("Enter Course: "); String c = sc.nextLine().trim();
                        System.out.print("Enter Marks: "); double m = Double.parseDouble(sc.nextLine().trim());
                        Thread t = new Thread(new Loader("Loading", 700));
                        t.start();
                        Student s = new Student(r,n,e,c,m);
                        mgr.addStudent(s);
                        t.join();
                        System.out.println("Added.");
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;
                case "2":
                    for (Student s : mgr.viewAll()) s.displayInfo();
                    break;
                case "3":
                    System.out.print("Enter name to search: ");
                    String sn = sc.nextLine().trim();
                    Student found = mgr.searchByName(sn);
                    if (found != null) found.displayInfo();
                    else System.out.println("Not found.");
                    break;
                case "4":
                    System.out.print("Enter name to delete: ");
                    String dn = sc.nextLine().trim();
                    System.out.println(mgr.deleteStudentByName(dn) ? "Deleted." : "Not found.");
                    break;
                case "5":
                    System.out.println("Sorted Student List by Marks:");
                    for (Student s : mgr.sortByMarksDesc()) s.displayInfo();
                    break;
                case "6":
                    FileUtil.save(FILENAME, mgr.getAllStudents());
                    System.out.println("Saved and exiting.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
