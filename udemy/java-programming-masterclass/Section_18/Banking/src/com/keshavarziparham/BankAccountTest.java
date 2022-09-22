package com.keshavarziparham;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    //Once per run, not method
    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    //Will run everytime a test runs (run multiple times)
    @org.junit.Before
    public void setup(){
        account = new BankAccount("Parham", "Keshavarzi", 1000.000,
                BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        //Delta (third) parameter, allows leeway when comparing results
        assertEquals(1200.00, balance,0);
    }

    @org.junit.Test
    public void withdraw() {
        //fail("This test has yet to be implemented");
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception{
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test(expected = IllegalAccessException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");
        //assertEquals(400.00, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        double balance = account.deposit(200.00, true);
        //Delta (third) parameter, allows leeway when comparing results
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        double balance = account.withdraw(200.00, true);
        //Delta (third) parameter, allows leeway when comparing results
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true(){
        BankAccount account = new BankAccount("Parham", "Keshavarzi", 1000.00,
                BankAccount.CHECKING);
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after any test cases = " + count++);
    }

    @org.junit.After
    public void teardown(){
        System.out.println("Count = " + count++);
    }
}