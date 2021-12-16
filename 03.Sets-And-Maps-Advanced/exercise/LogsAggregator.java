package T3SetsAndMaps.exercise;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, Integer> usersLogsDuration = new TreeMap<>();
        Map<String, TreeSet<String>> usersIPAddresses = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String IP = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            if (!usersLogsDuration.containsKey(user)) {
                usersLogsDuration.put(user, duration);
            } else {
                usersLogsDuration.put(user, usersLogsDuration.get(user) + duration);
            }

            usersIPAddresses.putIfAbsent(user, new TreeSet<>());
            usersIPAddresses.get(user).add(IP);

        }
        usersLogsDuration.entrySet().stream().forEach(e ->
                System.out.printf("%s: %d [%s]%n", e.getKey(), e.getValue(),
                        String.join(", ", usersIPAddresses.get(e.getKey()))));
    }
}
