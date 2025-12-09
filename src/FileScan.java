import javax.swing.*;
import java.io.*;

public class FileScan {
    public static void main(String[] args) {
        File selectedFile;

        if (args.length == 0) {
            // Interactive mode: JFileChooser
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
            } else {
                System.out.println("No file selected.");
                return;
            }
        } else {
            // Headless mode: use command-line argument
            selectedFile = new File(args[0]);
            if (!selectedFile.exists()) {
                System.out.println("File not found: " + args[0]);
                return;
            }
        }

        // Process the file (example: print contents)
        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
