package ExamPreparation;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowelsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(vowelsQueue::offer);
        ArrayDeque<String> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(consonantsStack::push);


        List<String> words = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        while (!consonantsStack.isEmpty()) {
            String vowel = vowelsQueue.peek();
            sb.append(vowel);
            String consonant = consonantsStack.pop();
            sb.append(consonant);
            StringBuilder letters = new StringBuilder();
            letters.append(vowel).append(consonant);
            vowelsQueue.offer(vowelsQueue.poll());
        }
        String firstWord = "pear";
        boolean allLettersFound = allLettersFound(sb,firstWord);
        if(allLettersFound){
            words.add(firstWord);
        }
        String secondWord = "flour";
      allLettersFound = allLettersFound(sb,secondWord);
        if(allLettersFound){
            words.add(secondWord);
        }
        String thirdWord = "pork";
        allLettersFound = allLettersFound(sb,thirdWord);
        if(allLettersFound){
            words.add(thirdWord);
        }
        String fourthWord = "olive";
        allLettersFound = allLettersFound(sb,fourthWord);
        if(allLettersFound){
            words.add(fourthWord);
        }
        System.out.printf("Words found: %d\n", words.size());
        System.out.println(String.join("\n", words));

    }

    public static boolean allLettersFound(StringBuilder sb, String word) {
        String wordString = sb.toString();
        for (int i = 0; i < word.length(); i++) {
            if (!wordString.contains(word.charAt(i) + "")) {
                return false;
            }
        }
        return true;
    }
}
