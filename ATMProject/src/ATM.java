import java.util.Scanner;

public class ATM {
    BankAccount bankAccount;
    ATM(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }

   /*public static void main() {
        ATM atm = new ATM();
        atm.start();

    }*/

    private void displayMenu()
    {
        System.out.println("===== ATM MENU =====");
        System.out.println("1. Balance Enquiry");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Exit");
        System.out.println("===================");
    }
    private void currentBalance()
    {
        System.out.println("current balance is " + bankAccount.getCurrentBalance());
    }
    private void withdrawCash(double amount)
    {
        bankAccount.withdrawMoney(amount);
        System.out.println("Amount withdrawn is  " + amount);
    }

    private void depositCash(double amount)
    {
        bankAccount.deposit(1000);
        System.out.println("Amount deposited is  " + amount);
    }

    private  void exit()
    {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    private double enterAmount(Scanner input)
    {
        System.out.println("Please enter the amount: ");
        return input.nextDouble();
    }


    public void start() {

        if (authenticateUser()) {
            boolean running = true;
            while (running) {

                displayMenu();
                System.out.println("Enter your choice 1-4 :");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        currentBalance();
                        break;
                    case 2:
                        withdrawCash(enterAmount(input));
                        break;
                    case 3:
                        depositCash(enterAmount(input));
                        break;
                    case 4:
                        exit();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice : please choose between 1 and 4");
                }

            }
        } else {
            System.out.println("Authentication failed. \n Try again ");
        }

    }

    private boolean authenticateUser()
    {
        System.out.println("Welcome to the ATM \n Enter PIN");

        Scanner input = new Scanner(System.in);
        int attempts = 0;
        while(attempts < 3)
        {
            int pin = input.nextInt();
            if(bankAccount.correctPin(Integer.toString(pin)))
            {
                System.out.println("Authentication Successful");
                return true;

            }
            else {
                attempts++;
                System.out.println("Invalid PIN \n Please enter correct PIN");
            }

        }
        return false;

    }


}
