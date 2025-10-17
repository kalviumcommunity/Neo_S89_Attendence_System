package com.school;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageService {

    /**
     * Save a list of Storable objects to the given filename (UTF-8, simple newline separated).
     */
    public void saveData(List<Storable> items, String filename) {
        if (items == null) {
            System.out.println("No data to save (items == null).");
            return;
        }

        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Storable s : items) {
                if (s != null) {
                    writer.write(s.toDataString());
                    writer.newLine();
                }
            }
            System.out.println("Data saved to " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error saving data to " + filename + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
