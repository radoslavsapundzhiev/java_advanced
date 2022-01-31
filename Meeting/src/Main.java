import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> males = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(males);
        ArrayDeque<Integer> stack = new ArrayDeque<>(males);
        List<Integer> females = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ArrayDeque<Integer> queue = new ArrayDeque<>(females);
        int matches = 0;
        while (!stack.isEmpty() && !queue.isEmpty()) {
            int currentFemale = queue.peek();
            int currentMale = stack.peek();

            if(currentFemale % 25 == 0) {
                queue.poll();
                if(!queue.isEmpty()) {
                    queue.poll();
                }
            } else if(currentMale % 25 == 0) {
                stack.pop();
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if(currentFemale == currentMale) {
                queue.poll();
                stack.pop();
                matches++;
            } else {
                queue.poll();
                stack.pop();
                currentMale = currentMale - 2;
                stack.push(currentMale);
            }

            stack = filterStack(stack);
            queue = filterQueue(queue);
        }
        System.out.println("Matches: " + matches);
        System.out.print("Males left: ");
        if(stack.isEmpty()) {
            System.out.print("none");
        } else {
            String result = stack.stream().map(e -> e.toString()).collect(Collectors.joining(", "));
            System.out.print(result);
        }
        System.out.println();
        System.out.print("Females left: ");
        if(queue.isEmpty()) {
            System.out.print("none");
        } else {
            String result = queue.stream().map(e -> e.toString()).collect(Collectors.joining(", "));
            System.out.print(result);
        }
    }

    private static ArrayDeque<Integer> filterQueue(ArrayDeque<Integer> queue) {
        List<Integer> queueAsList = new ArrayList<>(queue);
        queueAsList = queueAsList.stream().filter(m -> m > 0).collect(Collectors.toList());
        return new ArrayDeque<>(queueAsList);
    }

    private static ArrayDeque<Integer> filterStack(ArrayDeque<Integer> stack) {
        List<Integer> stackAsList = new ArrayList<>(stack);
        stackAsList = stackAsList.stream().filter(m -> m > 0).collect(Collectors.toList());
        return new ArrayDeque<>(stackAsList);
    }
}

/*
3 6 9 12
12 9 6 1 25 25
Matches: 3
Males left: 1
Females left: none
 */

/*
3 0 3 6 9 0 12
12 9 6 1 2 3 15 13 4
Matches: 4
Males left: none
Females left: 15, 13, 4
 */
