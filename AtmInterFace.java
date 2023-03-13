import java.util.Scanner;


// Main class
public class AtmInterFace {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        int choice;

        System.out.println("Welcome to the SBI ATM!");
        do {
            System.out.println("Select a option:");    //Show Options
            System.out.println("1. Check Balance");            //Check bank balance
            System.out.println("2. Deposit");                  //Deposite money in bank 
            System.out.println("3. Withdraw");                 //Withdraw the money
            System.out.println("4. Exit");                     //Exit the process
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double balance = atm.checkBalance();
                    System.out.println("Your current balance is: $" + balance);
                    break;
                case 2:
                    System.out.println("Please enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;
                case 3:
                    System.out.println("Please enter withdraw amount:");
                    double withdrawAmount = scanner.nextDouble();
                    boolean success = atm.withdraw(withdrawAmount);
                    if (success) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient funds!");
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        } while (choice != 4);

        scanner.close();
    }

}

class ATM {
    private double balance;

    public ATM() {
        this.balance = 0.0;
    }

    public double checkBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
