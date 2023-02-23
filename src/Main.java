import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFile = args[1];

        List<String> bytes = readFile(inputFile);

        writeFile(outputFile, bytes);
    }

    private static void writeFile(String outputFile, List<String> bytes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int i = bytes.size() - 1; i >= 0; i--) {
                writer.write(bytes.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File write error");
        }
    }

    private static List<String> readFile(String inputFile) {
        List<String> bytes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line = reader.readLine().replaceAll("\\s+", " ").trim();
            while (line != null) {
                bytes.addAll(List.of(line.split(" ")));
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File read error");
        }

        return bytes;
    }
}