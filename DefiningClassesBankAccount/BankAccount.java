package DefiningClassesBankAccount;

public class BankAccount {
//това са променливите на класа BankAccount
    private static double interestRate = 0.02;
    private static int idCounter = 1;

  // това са променливите на обектите BankAccount
    private int id = 0;
    private double balance;


    public BankAccount() {
        this.balance = 0.00;
        this.id = idCounter++;
    }

    public static void setInterestRate(double interest) {
interestRate = interest;
    }

    public double getInterestRate(int years) {
        return balance*years*interestRate;
    }

    public void deposit(double amount) {

    }


}


