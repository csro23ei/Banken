import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("Janne", "42");
        bank1.showMenu();

    }

}

class BankAccount {
    int balance;
    int previousTransaction;

    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount > 0) { // Only allow positive deposits
            balance = balance + amount;
            previousTransaction = amount;
        } else {
            System.out.println("Du kan inte lägga till pengar här");
        }
    }

    void withdraw(int amount) {
        if (amount > 0) { // Only allow positive withdrawals
            if (balance >= amount) {
                balance = balance - amount;
                previousTransaction = -amount;
            } else {
                System.out.println("Otillräckligt saldo för uttag.");
            }
        } else {
            System.out.println("Du kan inte ta ut mindre än noll kr");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("no transaction is occured");
        }

    }

    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Välkommen " + customerName);
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("A. Balance");
        System.out.println("B. Lägga in pengar");
        System.out.println("C. Ta ut pengar");
        System.out.println("D. Titigare transaktioner");
        System.out.println("E. Exit");

        do {
            System.out.println("===============================");
            System.out.println("Vad vill du göra idag");
            System.out.println("===============================");
            option = sc.next().charAt(0);

            switch (option) {
                case 'A', 'a':
                    System.out.println("===============================");
                    System.out.println("Du har " + balance + "kr");
                    System.out.println("===============================");
                    System.out.println();
                    break;

                case 'B', 'b':
                    System.out.println("===============================");
                    System.out.println("Hur mycket vill du lägga in? ");
                    System.out.println("===============================");
                    int belopp = sc.nextInt();

                    deposit(belopp);
                    System.out.println();
                    break;

                case 'C', 'c':
                    System.out.println("===============================");
                    System.out.println("Hur mycket vill du ta ut?");
                    System.out.println("===============================");
                    int belopp2 = sc.nextInt();
                    withdraw(belopp2);
                    System.out.println();
                    break;

                case 'D', 'd':
                    System.out.println("===============================");
                    getPreviousTransaction();
                    System.out.println("===============================");
                    System.out.println();
                    break;

                case 'E', 'e':
                    System.out.println("===============================");
                    break;

                default:
                    System.out.println("Invalid Option! Pleas try again");
                    break;
            }
        } while (option != 'E');
    }
}