import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) {
        String pathString = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(pathString);
        try(BufferedReader reader = new BufferedReader(Files.newBufferedReader(path))) {
            long sumOfAllSymbolsInBytes = 0;
            String line = reader.readLine();
            while (line != null) {
                for (char symbol: line.toCharArray()) {
                    sumOfAllSymbolsInBytes += symbol;
                }
                line = reader.readLine();
            }
            System.out.println(sumOfAllSymbolsInBytes);
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
