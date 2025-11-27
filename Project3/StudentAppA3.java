// StudentAppA3.java
import java.util.Scanner;

public class StudentAppA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagerA3 mgr = new StudentManagerA3();
        while (true) {
            System.out.println("1. Add Student  2. View  3. Get by Roll  4. Exit");
            System.out.print("Choice: ");
            String ch = sc.nextLine().trim();
            if (ch.equals("4")) { System.out.println("Exit"); break; }
            try {
                switch (ch) {
                    case "1":
                        System.out.print("Roll: "); Integer r = Integer.valueOf(sc.nextLine().trim());
                        System.out.print("Name: "); String name = sc.nextLine().trim();
                        System.out.print("Email: "); String email = sc.nextLine().trim();
                        System.out.print("Marks: "); Double m = Double.valueOf(sc.nextLine().trim());
                        // simulate loading using thread
                        Thread t = new Thread(new Loader("Loading", 800));
                        t.start();
                        StudentA3 s = new StudentA3(r, name, email, m);
                        mgr.addStudent(s);
                        t.join(); // wait so user sees loader
                        System.out.println("Student added.");
                        break;
                    case "2":
                        for (StudentA3 ss : mgr.getAll()) ss.display();
                        break;
                    case "3":
                        System.out.print("Enter roll: ");
                        int rr = Integer.parseInt(sc.nextLine().trim());
                        StudentA3 found = mgr.getStudent(rr);
                        found.display();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (StudentNotFoundException snfe) {
                System.out.println("ERROR: " + snfe.getMessage());
            } catch (IllegalArgumentException iae) {
                System.out.println("Invalid data: " + iae.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        sc.close();
    }
}
