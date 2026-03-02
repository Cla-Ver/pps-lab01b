package it.unibo.pps.e1;

public class GoldBankAccount extends CoreBankAccount {

    @Override
    public void withdraw(int amount) {
        int negativeBalanceLimit = -500;
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
