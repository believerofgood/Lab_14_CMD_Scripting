import java.io.*;
import java.nio.file.*;
import java.util.*;

import static java.nio.file.StandardOpenOption.CREATE;

public class Lab14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;   // auto-generate IDs like 000001, 000002, etc.
        String more;

        do {
            System.out.print("Enter First Name: ");
            String firstName = input.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = input.nextLine();

            String idNumber = String.format("%06d", idCounter);
            idCounter++;

            System.out.print("Enter Email: ");
            String email = input.nextLine();

            System.out.print("Enter Year of Birth: ");
            String yob = input.nextLine();

            // Build CSV record
            String record = firstName + "," + lastName + "," + idNumber + "," + email + "," + yob;
            records.add(record);

            System.out.print("Add another record? (y/n): ");
            more = input.nextLine();
        } while (more.equalsIgnoreCase("y"));

        // Prompt for file name
        System.out.print("Enter file name (include .csv): ");
        String fileName = input.nextLine();

        Path file = Paths.get(System.getProperty("user.dir") + "/src/" + fileName);

        try {
            BufferedWriter writer = Files.newBufferedWriter(file, CREATE);
            for (String rec : records) {
                writer.write(rec);
                writer.newLine();
            }
            writer.close();
            System.out.println("Data saved to " + file.toAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
