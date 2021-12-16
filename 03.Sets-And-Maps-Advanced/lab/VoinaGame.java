package T3SetsAndMaps.lab;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VoinaGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> firstDeck = readDeck(scan);
        LinkedHashSet<Integer> secondDeck = readDeck(scan);

        int rounds = 50;
        while (rounds-- > 0) {
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static int getFirst(LinkedHashSet<Integer> deck) {
//        for (Integer card : deck) {
//            return card;
//        }
//        return 0;

        // втори вариант:
//        return deck.stream().findFirst().orElse(0);

        //трети вариант:
        Iterator<Integer> iterator = deck.iterator();
        Integer next = iterator.next();
        return next;
    }

    private static LinkedHashSet<Integer> readDeck(Scanner scan) {
        return Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
