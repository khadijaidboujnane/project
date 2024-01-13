package Control;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Gestion_donnee_fichier {
    public static void saveToFile(String fileName, List<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (String line : data) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> loadFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                data.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
