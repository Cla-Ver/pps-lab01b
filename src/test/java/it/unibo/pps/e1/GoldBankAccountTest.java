package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    public void init(){
      this.account = new GoldBankAccount();
    }
    @Test
    public void testCanWithdraw() {
        final int withdrawAmount = 200;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(withdrawAmount);
        assertEquals(INITIAL_DEPOSIT - withdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable(){
        final int excessWithdrawAmount = 100;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(INITIAL_DEPOSIT + excessWithdrawAmount);
        assertEquals(-excessWithdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCanNotHaveExcessiveNegativeBalance(){
        this.account.deposit(INITIAL_DEPOSIT);
        final int withdrawAmount = 1000;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(INITIAL_DEPOSIT + withdrawAmount));
    }

}
