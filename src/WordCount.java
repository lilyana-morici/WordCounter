import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the input file: ");
        String inputFile = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile)) ) {
            Map<String, Integer> wordCounts = new HashMap<>();

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                wordCounts.put(line, wordCounts.getOrDefault(line, 0) + 1);
            }

            System.out.print("Enter the path of the output file: ");
            String outputFile = scanner.nextLine();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                wordCounts.forEach((word, count) -> {
                    try {
                        writer.write(word + " " + count);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                System.out.println("Word count results have been written to " + outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
