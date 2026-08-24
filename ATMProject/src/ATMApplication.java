public class ATMApplication {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("654321",
                "uday reddy","1143",50001);
        ATM atm = new ATM(bankAccount);
        atm.start();
    }
}
