package GGD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Handling {
    private String fileName;

    public Handling(String fileName) {
        this.fileName = fileName;
    }

    public Set getBSNs(String date) {
        Set<Integer> uniqueBSNs = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into parts using the ";" delimiter
                String[] parts = line.split(";");

                // Check if the date in the line matches the specified date
                if (parts.length == 2 && parts[1].contains(date)) {
                    // Parse the BSN to an integer and add it to the set
                    try {
                        int bsn = Integer.parseInt(parts[0].trim());
                        uniqueBSNs.add(bsn);
                    } catch (NumberFormatException e) {
                        // Handle the case where BSN is not a valid integer
                        System.err.println("Invalid BSN format: " + parts[0]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        return uniqueBSNs;
    }
}
