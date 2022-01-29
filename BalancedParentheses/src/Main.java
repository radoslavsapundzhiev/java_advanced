import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            Character currentBracket = brackets.charAt(i);
            if(currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openBrackets.push(currentBracket);
            } else if(currentBracket == ')'){
                if(!openBrackets.isEmpty()){
                    Character lastOpenBracket = openBrackets.pop();
                    if(lastOpenBracket != '(') {
                        isBalanced = false;
                        break;
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            } else if(currentBracket == '}'){
                if(!openBrackets.isEmpty()) {
                    Character lastOpenBracket = openBrackets.pop();
                    if (lastOpenBracket != '{') {
                        isBalanced = false;
                        break;
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            } else if(currentBracket == ']'){
                if(!openBrackets.isEmpty()) {
                    Character lastOpenBracket = openBrackets.pop();
                    if (lastOpenBracket != '[') {
                        isBalanced = false;
                        break;
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if(isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
