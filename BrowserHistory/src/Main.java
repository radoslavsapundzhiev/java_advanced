import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browser = new ArrayDeque<>();
        String current = "";
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Home")){
                break;
            } else if(line.equals("back")){
                if(!browser.isEmpty()){
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                if(!current.equals("")){
                    browser.push(current);
                }
                current = line;
            }
            System.out.println(current);
        }
    }
}
