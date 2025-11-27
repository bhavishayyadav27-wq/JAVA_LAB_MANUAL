// StudentAppA1.java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentAppA1 {
    private static ArrayList<StudentA1> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Student Record Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1":
                    StudentA1 s = new StudentA1();
                    s.inputDetails(sc);
                    // validate marks between 0 and 100
                    if (s.getMarks() < 0 || s.getMarks() > 100) {
                        System.out.println("Invalid marks. Student not added.");
                    } else {
                        students.add(s);
                        System.out.println("Student added.");
                    }
                    break;
                case "2":
                    if (students.isEmpty()) {
                        System.out.println("No students to display.");
                    } else {
                        for (StudentA1 st : students) st.displayDetails();
                    }
                    break;
                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
