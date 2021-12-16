package T3SetsAndMaps.lab;

import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String guest = scan.nextLine();
        TreeSet<String> vip = new TreeSet<>();
        TreeSet<String> regular = new TreeSet<>();
        while (!guest.equals("PARTY")) {
            if (Character.isDigit(guest.charAt(0))) {
                vip.add(guest);
            } else {
                regular.add(guest);
            }
            guest = scan.nextLine();
        }
        String comingGuest = scan.nextLine();
        while (!comingGuest.equals("END")) {
            if (Character.isDigit(comingGuest.charAt(0))) {
                vip.remove(comingGuest);
            } else {
                regular.remove(comingGuest);
            }

            comingGuest = scan.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        if (!vip.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), vip));
        }
        System.out.println(String.join(System.lineSeparator(), regular));
    }
}
