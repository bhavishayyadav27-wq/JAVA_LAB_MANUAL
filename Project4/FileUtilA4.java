// FileUtilA4.java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileUtilA4 {
    public static List<StudentA4> loadFromFile(String filename) {
        List<StudentA4> list = new ArrayList<>();
        File f = new File(filename);
        if (!f.exists()) return list;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) list.add(StudentA4.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return list;
    }

    public static void saveToFile(String filename, List<StudentA4> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (StudentA4 s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // demonstrate RandomAccessFile read of a specific line: (simple approach)
    public static void readRandomLine(String filename, int lineNumber) {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "r")) {
            raf.seek(0);
            for (int i = 0; i < lineNumber - 1; i++) {
                if (raf.readLine() == null) return;
            }
            String line = raf.readLine();
            if (line != null) System.out.println("Random read line " + lineNumber + ": " + line);
            else System.out.println("No such line.");
        } catch (IOException e) {
            System.out.println("Random access error: " + e.getMessage());
        }
    }
}
