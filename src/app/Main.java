package app;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = getBalance();
        double amount = getAmount();
        validateAmount(balance, amount);
    }

    private static double getBalance() {
        return 1000.00; // Наявні кошти на рахунку
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getUpdatedBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid.%n" +
                    "Balance is USD %.2f%n", balance);
        }
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    private static double getUpdatedBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}