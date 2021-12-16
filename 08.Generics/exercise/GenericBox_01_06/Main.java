package T8Generics.exercise.GenericBox_01_06;

import T8Generics.exercise.GenericBox_01_06.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scan.nextLine());
            box.add(num);
        }

        double value = Double.parseDouble(scan.nextLine());

        System.out.println(box.countGreaterThan(value));

       /* int index1 = scan.nextInt();
        int index2 = scan.nextInt();
        scan.nextLine();

        box.swap(index1, index2);*/

        //System.out.println(box);

    }
}
