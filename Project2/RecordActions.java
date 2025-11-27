// RecordActions.java
import java.util.List;

public interface RecordActions {
    boolean addStudent(StudentA2 s);
    boolean deleteStudent(int rollNo);
    boolean updateStudent(int rollNo, StudentA2 newData);
    StudentA2 searchStudent(int rollNo);
    List<StudentA2> viewAllStudents();
}
