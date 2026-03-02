package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CoreBankAccountTest {
    protected static final int INITIAL_DEPOSIT = 1000;
    protected CoreBankAccount account;

    @Test
    void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }
}
