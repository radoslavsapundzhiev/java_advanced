import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AllCapitals {
    public static void main(String[] args) {
        String inputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        try(BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new PrintWriter(outputPath))
        ) {
            String line = in.readLine();
            while (line != null) {
                String currentLine = line.toUpperCase();
                out.println(currentLine);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
