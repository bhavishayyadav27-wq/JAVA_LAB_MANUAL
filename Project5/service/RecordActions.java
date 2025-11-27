// service/RecordActions.java
package service;
import model.Student;
import java.util.List;
public interface RecordActions {
    boolean addStudent(Student s) throws IllegalArgumentException;
    boolean deleteStudentByName(String name);
    boolean updateStudent(int rollNo, Student newData);
    Student searchByName(String name);
    List<Student> viewAll();
    List<Student> sortByMarksDesc();
}
