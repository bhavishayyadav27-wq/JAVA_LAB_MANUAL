// util/FileUtil.java
package util;
import model.Student;
import java.io.*;
import java.util.*;
public class FileUtil {
    public static List<Student> load(String filename) {
        List<Student> list = new ArrayList<>();
        File f = new File(filename);
        if (!f.exists()) return list;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
        return list;
    }

    public static void save(String filename, List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) { System.out.println("Save error: " + e.getMessage()); }
    }
}
