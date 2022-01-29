import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> browserForwardHistory = new ArrayDeque<>();
        String current = "";
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("Home")){
                break;
            } else if(line.equals("back")){
                if(!browser.isEmpty()){
                    browserForwardHistory.addFirst(current);
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else if(line.equals("forward")) {
                if(!browserForwardHistory.isEmpty()){
                    current = browserForwardHistory.poll();
                } else {
                    System.out.println("no next URLs");
                    continue;
                }
            } else {
                if(!current.equals("")){
                    browser.push(current);
                    browserForwardHistory.clear();
                }
                current = line;
            }
            System.out.println(current);
        }
    }
}
