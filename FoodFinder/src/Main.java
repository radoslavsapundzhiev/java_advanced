import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> firstRow = Arrays.asList(scanner.nextLine().split("\\s+"));
        ArrayDeque<String> vowels = new ArrayDeque<>(firstRow);
        List<String> secondRow = Arrays.asList(scanner.nextLine().split("\\s+"));
        Collections.reverse(secondRow);
        ArrayDeque<String> consonants = new ArrayDeque<>(secondRow);
        Map<String, Integer> pear = getPear();
        Map<String, Integer> flour = getFlour();
        Map<String, Integer> pork = getPork();
        Map<String, Integer> olive = getOlive();
        while (!consonants.isEmpty()) {
            String currentVowel = vowels.peek();
            String currentConsonant = consonants.peek();

            if(pear.containsKey(currentVowel)) {
                pear.put(currentVowel, pear.get(currentVowel) + 1);
            }

            if(pear.containsKey(currentConsonant)) {
                pear.put(currentConsonant, pear.get(currentConsonant) + 1);
            }

            if(flour.containsKey(currentVowel)) {
                flour.put(currentVowel, flour.get(currentVowel) + 1);
            }

            if(flour.containsKey(currentConsonant)) {
                flour.put(currentConsonant, flour.get(currentConsonant) + 1);
            }

            if(pork.containsKey(currentVowel)) {
                pork.put(currentVowel, pork.get(currentVowel) + 1);
            }

            if(pork.containsKey(currentConsonant)) {
                pork.put(currentConsonant, pork.get(currentConsonant) + 1);
            }

            if(olive.containsKey(currentVowel)) {
                olive.put(currentVowel, olive.get(currentVowel) + 1);
            }

            if(olive.containsKey(currentConsonant)) {
                olive.put(currentConsonant, olive.get(currentConsonant) + 1);
            }

            consonants.pop();

            vowels.offer(vowels.poll());
        }

        boolean foundPear = false;
        if(!pear.values().contains(0)){
           foundPear = true;
        }

        boolean foundFlour = false;
        if(!flour.values().contains(0)){
            foundFlour = true;
        }

        boolean foundPork = false;
        if(!pork.values().contains(0)){
            foundPork = true;
        }

        boolean foundOlive = false;
        if(!olive.values().contains(0)){
            foundOlive = true;
        }

        List<String> foundWords = new ArrayList<>();
        if(foundPear) {
            foundWords.add("pear");
        }
        if(foundFlour) {
            foundWords.add("flour");
        }
        if(foundPork){
            foundWords.add("pork");
        }
        if(foundOlive){
            foundWords.add("olive");
        }
        System.out.printf("Words found: %d%n", foundWords.size());
        foundWords.forEach(w -> System.out.println(w));
    }

    private static Map<String, Integer> getOlive() {
        Map<String, Integer> olive = new HashMap<>();
        olive.put("o", 0);
        olive.put("l", 0);
        olive.put("i", 0);
        olive.put("v", 0);
        olive.put("e", 0);
        return olive;
    }

    private static Map<String, Integer> getPork() {
        Map<String, Integer> pork = new HashMap<>();
        pork.put("p", 0);
        pork.put("o", 0);
        pork.put("r", 0);
        pork.put("k", 0);
        return pork;
    }

    private static Map<String, Integer> getFlour() {
        Map<String, Integer> flour = new HashMap<>();
        flour.put("f", 0);
        flour.put("l", 0);
        flour.put("o", 0);
        flour.put("u", 0);
        flour.put("r", 0);
        return flour;
    }

    private static Map<String, Integer> getPear() {
        Map<String, Integer> pear = new HashMap<>();
        pear.put("p", 0);
        pear.put("e", 0);
        pear.put("a", 0);
        pear.put("r", 0);
        return pear;
    }

}
