package controller;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.TextModel;
import view.TextView;

public class TextController {
    private final TextModel model;
    private final TextView view;

    public TextController(TextModel model, TextView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        try {
            // Đọc file
            model.readInputFile("input.txt");

            // Chuẩn hóa file
            String normalizedText = model.normalizeText();

            // Trả về file output
            writeOutputFile("output.txt", normalizedText);

            view.displayMessage("Text normalization completed. Normalized text saved to output.txt.");
        } catch (IOException e) {
            view.displayMessage("An error occurred: " + e.getMessage());
        }
    }

    private void writeOutputFile(String filePath, String normalizedText) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        writer.write(normalizedText);
        writer.close();
    }
}