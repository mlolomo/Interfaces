import javax.swing.*;
import java.io.*;
import java.util.*;

public class ShortLister {
    public static void main(String[] args) {
        // file chooser
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a text file");

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            // filter
            Filter filter = new ShortWordFilter();

            // Read and filter words
            try (Scanner scanner = new Scanner(selectedFile)) {
                System.out.println("Short words (length < 5) from " + selectedFile.getName() + ":");
                System.out.println("------------------------------------------");

                while (scanner.hasNext()) {
                    String word = scanner.next();
                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (!word.isEmpty() && filter.accept(word)) {
                        System.out.println(word);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}