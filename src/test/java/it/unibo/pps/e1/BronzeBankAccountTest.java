package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    public void init(){
      this.account = new BronzeBankAccount();
    }
    @Test
    public void testCanWithdrawLowAmountWithoutFee() {
        final int withdrawAmount = 10;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(withdrawAmount);
        assertEquals(INITIAL_DEPOSIT - withdrawAmount, this.account.getBalance());
    }
    @Test
    public void testCanWithdrawHighAmountWithFee(){
        final int withdrawAmount = 200;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(withdrawAmount);
        assertEquals(INITIAL_DEPOSIT - withdrawAmount - 1, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        int excessWithdrawAmount = 200;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INITIAL_DEPOSIT + excessWithdrawAmount));
    }

}
