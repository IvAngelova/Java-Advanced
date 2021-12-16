package T3SetsAndMaps.exercise;

import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        TreeMap<Character, Integer> occurrences = new TreeMap<>();
        for (int index = 0; index < text.length(); index++) {
            char currentSymbol = text.charAt(index);
            if (!occurrences.containsKey(currentSymbol)) {
                occurrences.put(currentSymbol, 1);
            } else {
                occurrences.put(currentSymbol, occurrences.get(currentSymbol) + 1);
            }
        }
        occurrences.entrySet().forEach((entry) ->
                System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue()));
    }
}
