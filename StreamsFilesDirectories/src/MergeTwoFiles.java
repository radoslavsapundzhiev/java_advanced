import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String firstInput = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondInput = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPathString = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output_7.txt";
        List<String> firstLines = Files.readAllLines(Path.of(firstInput));
        List<String> secondLines = Files.readAllLines(Path.of(secondInput));
        firstLines.addAll(secondLines);
        Path outPath = Path.of(outputPathString);
        Files.write(outPath, firstLines);
    }
}
