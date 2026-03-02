package it.unibo.pps.e1;

public interface BankAccount {

    int getBalance();

    void deposit(int amount);

    void withdraw(int amount);

    int getWithdrawalFee(int amountToWithdraw);
}
