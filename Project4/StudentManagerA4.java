// StudentManagerA4.java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagerA4 {
    private List<StudentA4> students = new ArrayList<>();

    public void load(String filename) { this.students = FileUtilA4.loadFromFile(filename); }

    public void save(String filename) { FileUtilA4.saveToFile(filename, students); }

    public void add(StudentA4 s) {
        for (StudentA4 st : students) if (st.getRollNo() == s.getRollNo()) throw new IllegalArgumentException("Duplicate roll.");
        students.add(s);
    }

    public boolean deleteByName(String name) {
        return students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }

    public List<StudentA4> sortByMarksDesc() {
        List<StudentA4> copy = new ArrayList<>(students);
        copy.sort(Comparator.comparingDouble(StudentA4::getMarks).reversed());
        return copy;
    }

    public List<StudentA4> getAll() { return new ArrayList<>(students); }
}
