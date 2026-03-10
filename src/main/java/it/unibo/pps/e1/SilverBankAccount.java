package it.unibo.pps.e1;

public class SilverBankAccount extends CoreBankAccount {
    //BankAccount base;

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + getWithdrawalFee(amount) < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }

    @Override
    public int getWithdrawalFee(int amountToWithdraw) {
        return 1;
    }
}
