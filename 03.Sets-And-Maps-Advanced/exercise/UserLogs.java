package T3SetsAndMaps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();

        String input = scan.nextLine();
        while (!input.equals("end")) {

            String IP = input.substring(input.indexOf('=') + 1, input.indexOf(' '));
            String user = input.substring(input.lastIndexOf('=') + 1);

            data.putIfAbsent(user, new LinkedHashMap<>());
            if (!data.get(user).containsKey(IP)) {
                data.get(user).put(IP, 1);
            } else {
                data.get(user).put(IP, data.get(user).get(IP) + 1);
            }
            input = scan.nextLine();
        }
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + ": ");
            int counter = 1;
            for (Map.Entry<String, Integer> entry : e.getValue().entrySet()) {
                if (counter == e.getValue().entrySet().size()) {
                    System.out.println(entry.getKey() + " => " + entry.getValue() + ".");
                } else {
                    System.out.print(entry.getKey() + " => " + entry.getValue() + ", ");
                }
                counter++;
            }
        });
    }
}
