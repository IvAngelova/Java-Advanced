package T6DefiningClasses.lab.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n", amount, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int interestId = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (bankAccounts.containsKey(interestId)) {
                        double interestForCurrId = bankAccounts.get(interestId).getInterest(years);
                        System.out.printf("%.2f%n", interestForCurrId);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

            input = scan.nextLine();
        }

    }
}
