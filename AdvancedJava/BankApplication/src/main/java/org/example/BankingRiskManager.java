package org.example;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class ExceedsLimitException extends Exception {
    public ExceedsLimitException(String message) {
        super(message);
    }
}

class AccountInactiveException extends Exception {
    public AccountInactiveException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    private double balance;
    private boolean active;

    public Account(double balance, boolean active) {
        this.balance = balance;
        this.active = active;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void deduct(double amount) {
        balance -= amount;
    }
}

class BankingService {

    public void withdraw(Account account, double amount)
            throws InvalidAmountException, ExceedsLimitException,
            AccountInactiveException, InsufficientBalanceException {

        validateAmount(amount);
        validateLimit(amount);
        validateAccountStatus(account);
        validateBalance(account, amount);

        account.deduct(amount);
        System.out.println("Withdrawal successful. Remaining Balance: ₹" + account.getBalance());
    }

    private void validateAmount(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }
    }

    private void validateLimit(double amount) throws ExceedsLimitException {
        if (amount > 50000) {
            throw new ExceedsLimitException("Withdrawal amount exceeds ₹50,000 limit.");
        }
    }

    private void validateAccountStatus(Account account) throws AccountInactiveException {
        if (!account.isActive()) {
            throw new AccountInactiveException("Account is inactive.");
        }
    }

    private void validateBalance(Account account, double amount)
            throws InsufficientBalanceException {
        if (amount > account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient account balance.");
        }
    }
}

public class BankingRiskManager {
    public static void main(String[] args) {

        Account account = new Account(40000, true);
        BankingService service = new BankingService();

        try {
            service.withdraw(account, 60000);
        } catch (InvalidAmountException | ExceedsLimitException |
                 AccountInactiveException | InsufficientBalanceException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        } finally {
            System.out.println("Transaction process completed.");
        }
    }
}