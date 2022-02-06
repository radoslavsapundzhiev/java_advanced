package custom_list;

import custom_list.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> customList = new CustomList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandTokens = input.split("\\s+");
            String command = commandTokens[0];
            switch (command) {
                case "Add":
                    String element = commandTokens[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandTokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String el = commandTokens[1];
                    System.out.println(customList.contains(el));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandTokens[1]);
                    int secondIndex = Integer.parseInt(commandTokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elem = commandTokens[1];
                    System.out.println(customList.countGreaterThan(elem));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    customList.print();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
