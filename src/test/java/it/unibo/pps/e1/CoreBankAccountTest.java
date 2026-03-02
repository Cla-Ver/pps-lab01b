package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoreBankAccountTest {
    protected static final int INITIAL_DEPOSIT = 1000;
    protected BankAccount account;

    @BeforeEach
    void init() {
        this.account = new SilverBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }
}
