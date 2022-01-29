import java.io.File;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) {
        File file = new File("E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        long size = 0;
        if(file.exists()) {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f: files) {
                    size += f.length();
                }
            }
        }
        System.out.println("Folder size: " + size);
    }
}
