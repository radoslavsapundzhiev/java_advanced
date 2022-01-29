import java.io.*;
import java.util.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "E:\\java_advanced\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        try(BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            Map<String, Integer> characterCount = new LinkedHashMap<>();
            characterCount.put("vowels", 0);
            characterCount.put("consonants", 0);
            characterCount.put("punctuationMarks", 0);
            Set<Character> vowels = getVowels();
            Set<Character> punctuationMarks = getPunctuationMarks();

            String line = in.readLine();

            while (line != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    String currentWord = words[i];
                    for (int j = 0; j < currentWord.length(); j++) {
                        char currentChar = currentWord.charAt(j);
                        if(vowels.contains(currentChar)) {
                            int currentCount = characterCount.get("vowels");
                            characterCount.put("vowels", currentCount + 1);
                        } else if(punctuationMarks.contains(currentChar)) {
                            int currentCount = characterCount.get("punctuationMarks");
                            characterCount.put("punctuationMarks", currentCount + 1);
                        } else {
                            int currentCount = characterCount.get("consonants");
                            characterCount.put("consonants", currentCount + 1);
                        }
                    }
                }
                line = in.readLine();
            }
            characterCount.entrySet().forEach((e) -> {
                if(e.getKey().equals("vowels")) {
                    out.println("Vowels: " + e.getValue());
                } else if(e.getKey().equals("consonants")) {
                    out.println("Consonants: " + e.getValue());
                } else {
                    out.println("Punctuation: " + e.getValue());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<Character> getPunctuationMarks() {
        Set<Character> punctuationMarks = new HashSet<>();
        punctuationMarks.add('!');
        punctuationMarks.add(',');
        punctuationMarks.add('.');
        punctuationMarks.add('?');
        return punctuationMarks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
