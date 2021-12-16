package T3SetsAndMaps.lab;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Double>> data = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            data.putIfAbsent(shop, new LinkedHashMap<>());
            data.get(shop).put(product, price);

            input = scan.nextLine();
        }
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(entry ->
                    System.out.printf("Product: %s, Price: %.1f%n", entry.getKey(), entry.getValue()));
        });
    }
}
