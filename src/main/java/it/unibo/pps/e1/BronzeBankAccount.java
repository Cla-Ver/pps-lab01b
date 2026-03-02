package it.unibo.pps.e1;

public class BronzeBankAccount extends CoreBankAccount {
    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
    @Override
    public int getWithdrawalFee(int amountToWithdraw) {
        return amountToWithdraw < 100 ? 0 : 1;
    }
}