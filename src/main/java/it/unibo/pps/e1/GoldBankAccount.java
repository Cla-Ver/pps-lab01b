package it.unibo.pps.e1;

public class GoldBankAccount extends CoreBankAccount {
    //private BankAccount base;
    private final int negativeBalanceLimit = -500;

    @Override
    public void withdraw(int amount) {
        if(getBalance() - amount < negativeBalanceLimit){
            throw new IllegalStateException("Balance limit reached");
        }
        super.withdraw(amount);
    }

    @Override
    public int getWithdrawalFee(int amountToWithdraw) {
        return 0;
    }
}
