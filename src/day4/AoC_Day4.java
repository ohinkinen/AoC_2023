package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

public class AoC_Day4 {
    static HashMap<String, Integer> cardInstances = new HashMap<>();
    static void updateCardInstances(String card) {
        HashSet<String> winningNumbers = new HashSet<>(Arrays.asList(card.split(": +")[1].split("\\|")[0].split(" +")));
        HashSet<String> yourNumbers = new HashSet<>(Arrays.asList(card.split(":")[1].split("\\| +")[1].split(" +")));
        int cardIndex = Integer.parseInt(card.split(":")[0].split(" +")[1]);

        winningNumbers.retainAll(yourNumbers);

        if(cardInstances.containsKey("Card " + cardIndex)) {
            cardInstances.put("Card " + cardIndex, cardInstances.get("Card " + cardIndex) + 1);
        } else {
            cardInstances.put("Card " + cardIndex, 1);
        }

        for (int i = cardIndex+1; i <= cardIndex + winningNumbers.size(); i++) {
            if(cardInstances.containsKey("Card " + i)) {
                cardInstances.put("Card " + i, cardInstances.get("Card " + i) + cardInstances.get("Card " + cardIndex));
            } else {
                cardInstances.put("Card " + i, cardInstances.get("Card " + cardIndex));
            }
        }



    }
    static int getCardPoints(String card) {
        HashSet<String> winningNumbers = new HashSet<>(Arrays.asList(card.split(": +")[1].split("\\|")[0].split(" +")));
        HashSet<String> yourNumbers = new HashSet<>(Arrays.asList(card.split(":")[1].split("\\| +")[1].split(" +")));
        int cardPoints = 0;

        winningNumbers.retainAll(yourNumbers);

        cardPoints = (int)Math.pow(2, winningNumbers.size()-1);
        return cardPoints;
    }
    public static void main(String[] args) {
        String line;
        int totalPoints = 0;
        int totalCards = 0;
        try {
            File cardDoc = new File("public/day4_input.txt");
            Scanner scanner = new Scanner(cardDoc);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                totalPoints += getCardPoints(line);
                updateCardInstances(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (String i: cardInstances.keySet()
        ) {
            totalCards += cardInstances.get(i);
        }
        System.out.println("Answer to part 1: " + totalPoints);
        System.out.println("Answer to part 2: " + totalCards);
    }
}
