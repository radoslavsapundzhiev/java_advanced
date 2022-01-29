import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String firstInputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String secondInputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results_6.txt";
        try(BufferedReader in = new BufferedReader(new FileReader(secondInputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            Path path = Path.of(firstInputPath);
            List<String> lines = Files.readAllLines(path);
            Map<String, Integer> wordCount = new LinkedHashMap<>();
            for (String line: lines) {
                String[] words = line.split("\\s+");
                for (String word: words) {
                    if(!wordCount.containsKey(word)) {
                        wordCount.put(word, 0);
                    }
                }
            }

            String line = in.readLine();
            while (line != null) {
                String[] words = line.split("\\s+");
                for (String word: words) {
                    if(wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }
                line = in.readLine();
            }
            wordCount
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach((e) -> {
                out.println(e.getKey() + " - " + e.getValue());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
