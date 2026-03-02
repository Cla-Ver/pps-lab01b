package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends CoreBankAccountTest {

    @BeforeEach
    public void init(){
      this.account = new SilverBankAccount();
    }
    @Test
    public void testCanWithdraw() {
        final int withdrawAmount = 200;
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(withdrawAmount);
        assertEquals(INITIAL_DEPOSIT - withdrawAmount - 1, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
