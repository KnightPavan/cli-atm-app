package atm;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    public static Customer verifyAcNumberAndPin(int acNumber, int pin, HashMap<Integer, Customer> customers) {

        if (pin == customers.get(acNumber).pin) {
            return customers.get(acNumber);
        }
        return new Customer(acNumber, pin, "New", 1000);

    }

    public static void createSampleCustomers(String[] nameSet, int[] acNumberSet,
            HashMap<Integer, Customer> sampleCustomers) {
        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer(acNumberSet[i], 12345, nameSet[i], 1000);
            sampleCustomers.put(acNumberSet[i], customer);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Customer> sampleCustomers = new HashMap<>();

        int[] acNumberSet = { 1000, 1001, 1002, 1003, 1004, 1005 };
        String[] nameSet = { "James", "Harry", "Johnny", "Marques", "Ben" };
        createSampleCustomers(nameSet, acNumberSet, sampleCustomers);

        System.out.print("Enter Your Account Numb   er: ");
        int acNumber = sc.nextInt();

        System.out.print("Enter Pin: ");
        int pin = sc.nextInt();
        Customer loggedInCustomer = verifyAcNumberAndPin(acNumber, pin, sampleCustomers);
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            System.out.println("Please Choose From One Of The  Following Options\n");
            System.out.println("1. Withdraw");
            System.out.println("2. Balance Check");
            System.out.println("3. Deposit");
            System.out.println("4. Pin Change");
            System.out.println("5. Exit");
            System.out.print("Option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Amout to withdraw: ");
                    System.out.println(loggedInCustomer.withdraw(sc.nextInt()));
                    break;

                case 2:
                    System.out.println(loggedInCustomer.checkBalance());
                    break;

                case 3:
                    System.out.print("Amout To Deposit: ");
                    System.out.println(loggedInCustomer.deposit(sc.nextInt()));
                    break;

                case 4:
                    System.out.print("Enter New Pin: ");
                    System.out.println(loggedInCustomer.pinChange(sc.nextInt()));
                    break;

                case 5:
                    System.out.println("Logged Out Successfully");
                    isLoggedIn = false;
                    break;
            }
        }
    }

}
