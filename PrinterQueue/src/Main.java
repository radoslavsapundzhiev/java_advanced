import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (true) {
            String line = scanner.nextLine();
            if(line.equals("print")){
                break;
            } else if(line.equals("cancel")){
                if(!queue.isEmpty()){
                    System.out.println("Canceled " + queue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(line);
            }
        }
        while (queue.size() > 0) {
            System.out.println(queue.pollFirst());
        }
    }
}
