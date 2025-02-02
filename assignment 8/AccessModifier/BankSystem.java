class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount. Balance cannot be negative.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New Balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + ". New Balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccountInfo() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);  // Public - Accessible
        System.out.println("Account Holder: " + accountHolder);  // Protected - Accessible in subclass
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456789", "Alice Johnson", 5000.0);
        account1.displayAccountInfo();
        System.out.println();

        account1.deposit(1000);
        account1.withdraw(2000);
        System.out.println();

        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Bob Smith", 8000.0, 2.5);
        savingsAccount.displaySavingsAccountInfo();
    }
}
