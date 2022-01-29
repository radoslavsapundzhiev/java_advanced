import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String inputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try(BufferedReader in = new BufferedReader(new FileReader(inputPath))) {
            String line = in.readLine();
            while (line != null) {
                long currentAsciiSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    currentAsciiSum += line.charAt(i);
                }
                System.out.println(currentAsciiSum);
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
