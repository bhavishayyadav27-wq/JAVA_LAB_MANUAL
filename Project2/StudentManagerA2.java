// StudentManagerA2.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManagerA2 implements RecordActions {
    private Map<Integer, StudentA2> map = new HashMap<>();

    @Override
    public boolean addStudent(StudentA2 s) {
        if (map.containsKey(s.getRollNo())) return false;
        map.put(s.getRollNo(), s);
        return true;
    }

    @Override
    public boolean deleteStudent(int rollNo) {
        return map.remove(rollNo) != null;
    }

    @Override
    public boolean updateStudent(int rollNo, StudentA2 newData) {
        if (!map.containsKey(rollNo)) return false;
        map.put(rollNo, newData);
        return true;
    }

    @Override
    public StudentA2 searchStudent(int rollNo) {
        return map.get(rollNo);
    }

    @Override
    public List<StudentA2> viewAllStudents() {
        return new ArrayList<>(map.values());
    }
}
