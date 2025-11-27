// service/StudentManager.java
package service;
import model.Student;
import java.util.*;
public class StudentManager implements RecordActions {
    private Map<Integer, Student> map = new HashMap<>();

    @Override
    public boolean addStudent(Student s) {
        if (map.containsKey(s.getRollNo())) throw new IllegalArgumentException("Duplicate roll");
        if (s.getMarks() < 0 || s.getMarks() > 100) throw new IllegalArgumentException("Marks invalid");
        map.put(s.getRollNo(), s);
        return true;
    }

    @Override
    public boolean deleteStudentByName(String name) {
        List<Integer> toRemove = new ArrayList<>();
        for (Student s : map.values()) if (s.getName().equalsIgnoreCase(name)) toRemove.add(s.getRollNo());
        for (int r : toRemove) map.remove(r);
        return !toRemove.isEmpty();
    }

    @Override
    public boolean updateStudent(int rollNo, Student newData) {
        if (!map.containsKey(rollNo)) return false;
        map.put(rollNo, newData);
        return true;
    }

    @Override
    public Student searchByName(String name) {
        for (Student s : map.values()) if (s.getName().equalsIgnoreCase(name)) return s;
        return null;
    }

    @Override
    public List<Student> viewAll() { return new ArrayList<>(map.values()); }

    @Override
    public List<Student> sortByMarksDesc() {
        List<Student> list = viewAll();
        list.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        return list;
    }

    // helper for persistence
    public List<Student> getAllStudents() { return viewAll(); }
    public void setAllStudents(List<Student> students) {
        map.clear();
        for (Student s : students) map.put(s.getRollNo(), s);
    }
}
