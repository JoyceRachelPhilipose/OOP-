
import java.util.Scanner;

// Custom exception for invalid ATM PIN
class InvalidATMPinException extends Exception {
	
    public InvalidATMPinException(String message) {
        super(message);
        
    }
}

// Custom exception for insufficient funds / no cash
class NoCashException extends Exception {
    public NoCashException(String message) {
        super(message);
    }
}

// The Account class
class Account {
    private String name;
    private double balance;
    private String atmPin;

    // Parameterized constructor
    public Account(String name, double balance, String atmPin) {
        this.name    = name;
        this.balance = balance;
        this.atmPin  = atmPin;
    }

    // Check if entered PIN is correct; if not, throw exception
    public void checkPin(String enteredPin) throws InvalidATMPinException {
        if (!this.atmPin.equals(enteredPin)) {
            throw new InvalidATMPinException("Invalid ATM PIN entered for account: " + this.name);
        }
        System.out.println("PIN validated successfully for account: " + this.name);
    }

    // Withdraw a given amount; if amount > balance, throw exception
    public void withdraw(double amount) throws NoCashException {
        if (amount > this.balance) {
            throw new NoCashException("Insufficient balance. Can't withdraw " + amount + " from account: " + this.name);
        }
        this.balance -= amount;
        System.out.println("Withdrawal of " + amount + " successful. Remaining balance: " + this.balance);
    }

    // Method to get current balance
    public double getBalance() {
        return this.balance;
    }

    //override
    public String toString() {
        return "Account[name=" + this.name + ", balance=" + this.balance + "]";
    }
}

// Main class to run the application
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create account by asking user input
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Set ATM PIN (a 4 digit string): ");
        String pin = scanner.nextLine();

        Account acct = new Account(name, initialBalance, pin);
        System.out.println("Account created: " + acct);

        // Loop to allow multiple operations
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("  1: Check PIN");
            System.out.println("  2: Withdraw amount");
            System.out.println("  3: Show balance");
            System.out.println("  4: Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ATM PIN to check: ");
                        String enteredPin = scanner.nextLine();
                        acct.checkPin(enteredPin);
                        break;

                    case 2:
                        System.out.print("Enter ATM PIN before withdrawal: ");
                        String enteredPin2 = scanner.nextLine();
                        acct.checkPin(enteredPin2); // require PIN check before withdrawal
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        acct.withdraw(amount);
                        break;

                    case 3:
                        System.out.println("Current balance for account " + name + ": " + acct.getBalance());
                        break;

                    case 4:
                        System.out.println("Exiting. Final account state: " + acct);
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice – please try again.");
                }
            } catch (InvalidATMPinException e) {
                System.err.println("PIN error: " + e.getMessage());
            } catch (NoCashException e) {
                System.err.println("Withdrawal error: " + e.getMessage());
            } catch (Exception e) {
                // catch any other unexpected exception
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
