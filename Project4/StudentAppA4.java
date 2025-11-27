// StudentAppA4.java
import java.util.List;
import java.util.Scanner;

public class StudentAppA4 {
    private static final String FILENAME = "students.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagerA4 mgr = new StudentManagerA4();
        mgr.load(FILENAME);
        System.out.println("Loaded students from file: " + FILENAME);
        while (true) {
            System.out.println("1.Add 2.ViewAll 3.DeleteByName 4.SortByMarks 5.RandomRead 6.SaveAndExit");
            System.out.print("Choice: ");
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1":
                    try {
                        System.out.print("Roll: "); int r = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Name: "); String n = sc.nextLine().trim();
                        System.out.print("Email: "); String e = sc.nextLine().trim();
                        System.out.print("Course: "); String c = sc.nextLine().trim();
                        System.out.print("Marks: "); double m = Double.parseDouble(sc.nextLine().trim());
                        mgr.add(new StudentA4(r,n,e,c,m));
                        System.out.println("Added.");
                    } catch (Exception ex) { System.out.println("Error: " + ex.getMessage()); }
                    break;
                case "2":
                    for (StudentA4 s : mgr.getAll()) s.display();
                    break;
                case "3":
                    System.out.print("Enter name to delete: ");
                    String dn = sc.nextLine().trim();
                    System.out.println(mgr.deleteByName(dn) ? "Deleted." : "Not found.");
                    break;
                case "4":
                    List<StudentA4> sorted = mgr.sortByMarksDesc();
                    System.out.println("Sorted Student List by Marks:");
                    for (StudentA4 s : sorted) s.display();
                    break;
                case "5":
                    System.out.print("Enter line number to read: ");
                    int ln = Integer.parseInt(sc.nextLine().trim());
                    FileUtilA4.readRandomLine(FILENAME, ln);
                    break;
                case "6":
                    mgr.save(FILENAME);
                    System.out.println("Saved and exiting.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
