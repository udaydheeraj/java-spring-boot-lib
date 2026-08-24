public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String accountPin;
    private double balance;

    BankAccount(String accountNumber, String accountHolderName, String accountPin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountPin = accountPin;
        this.balance = balance;
    }

    public BankAccount() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getCurrentBalance() {
        return balance;
    }

    public boolean correctPin(String pin)
    {
        if(pin != null && pin.matches("\\d{4}"))
        {
            return this.accountPin.equals(pin);
        }
        return false;
    }

    public void deposit(double amount)
    {
        if( amount > 0 )
        {
            this.balance += amount;
            System.out.println("Deposited " + amount + "successfully");
        } else
        {
            System.out.println("Deposited " + amount + "failed");
        }
    }

    public void withdrawMoney(double amount)
    {
        if(amount > 0)
        {
            if(this.balance >= amount)
            {
                this.balance -= amount;
                System.out.println("Withdrawn " + amount + "successfully");
            }
            else
            {
                System.out.println("balance insufficient");
            }
        } else
        {
            System.out.println("enter valid amount");
        }
    }



}
