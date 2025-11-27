// StudentAppA2.java
import java.util.List;
import java.util.Scanner;

public class StudentAppA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagerA2 mgr = new StudentManagerA2();
        while (true) {
            System.out.println("===== Student Manager Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            String ch = sc.nextLine().trim();
            if (ch.equals("6")) { System.out.println("Bye"); break; }
            switch (ch) {
                case "1":
                    try {
                        System.out.print("RollNo: "); int r = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: "); String name = sc.nextLine().trim();
                        System.out.print("Email: "); String email = sc.nextLine().trim();
                        System.out.print("Course: "); String course = sc.nextLine().trim();
                        System.out.print("Marks: "); double marks = Double.parseDouble(sc.nextLine().trim());
                        StudentA2 s = new StudentA2(r, name, email, course, marks);
                        if (!mgr.addStudent(s)) System.out.println("Duplicate roll no. Not added.");
                        else System.out.println("Added.");
                    } catch (Exception ex) { System.out.println("Invalid input."); }
                    break;
                case "2":
                    System.out.print("Enter roll to delete: ");
                    int dr = Integer.parseInt(sc.nextLine().trim());
                    System.out.println(mgr.deleteStudent(dr) ? "Deleted." : "Not found.");
                    break;
                case "3":
                    try {
                        System.out.print("Enter roll to update: "); int ur = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("New name: "); String nn = sc.nextLine().trim();
                        System.out.print("New email: "); String ne = sc.nextLine().trim();
                        System.out.print("New course: "); String nc = sc.nextLine().trim();
                        System.out.print("New marks: "); double nm = Double.parseDouble(sc.nextLine().trim());
                        StudentA2 nd = new StudentA2(ur, nn, ne, nc, nm);
                        System.out.println(mgr.updateStudent(ur, nd) ? "Updated." : "Not found.");
                    } catch (Exception ex) { System.out.println("Invalid input."); }
                    break;
                case "4":
                    System.out.print("Enter roll to search: ");
                    int sr = Integer.parseInt(sc.nextLine().trim());
                    StudentA2 found = mgr.searchStudent(sr);
                    if (found != null) found.displayInfo();
                    else System.out.println("Not found.");
                    break;
                case "5":
                    List<StudentA2> list = mgr.viewAllStudents();
                    if (list.isEmpty()) System.out.println("No records.");
                    else list.forEach(StudentA2::displayInfo);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
