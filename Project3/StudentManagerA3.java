// StudentManagerA3.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagerA3 {
    private Map<Integer, StudentA3> map = new HashMap<>();

    public void addStudent(StudentA3 s) {
        if (s.getMarks() < 0 || s.getMarks() > 100) throw new IllegalArgumentException("Marks out of range");
        if (map.containsKey(s.getRollNo())) throw new IllegalArgumentException("Duplicate roll");
        map.put(s.getRollNo(), s);
    }

    public StudentA3 getStudent(int roll) throws StudentNotFoundException {
        StudentA3 s = map.get(roll);
        if (s == null) throw new StudentNotFoundException("Student " + roll + " not found");
        return s;
    }

    public boolean deleteStudent(int roll) {
        return map.remove(roll) != null;
    }

    public List<StudentA3> getAll() { return new ArrayList<>(map.values()); }
}
