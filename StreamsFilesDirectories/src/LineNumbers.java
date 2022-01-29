import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_5.txt";
        try(BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath))
        ) {
            String line = in.readLine();
            int count = 1;
            while (line != null) {
                String newLine = count + ". " + line;
                out.println(newLine);
                count++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
