import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TDD_23388102 {

    private BankAccountManagementSystem_23388102 account, account1, account3;


    @BeforeEach
    public void setUp() {
        // Creating a new account with initial balance, this is just an example for the test.
        account = new BankAccountManagementSystem_23388102("1001","john", 100.0);
    }
    @AfterEach
    public void tearDown() {
        account = null;
    }



    @Test
    public void testAccountCreationSuccess() {
        BankAccountManagementSystem_23388102 account = new BankAccountManagementSystem_23388102();
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testInitialBalancePositive() {
        BankAccountManagementSystem_23388102 account = new BankAccountManagementSystem_23388102("123", "john", -1);
        assertTrue(account.getBalance() > -1, "Initial balance should be positive");
    }

    @Test
    public void testCreateAccountWithDuplicateAccountNumber() {
        account = new BankAccountManagementSystem_23388102("1001","john", 500.0);
        account1 = new BankAccountManagementSystem_23388102("1001","john", 500.0);
        assertNull(account1.getAccountNumber(), "The account was created with a duplicate number.");    }

    @Test
    public void testSuccessfulDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), "Balance should increase by the deposited amount.");
    }

    @Test
    public void testDepositWithNegativeAmount() {
        account.deposit(-50.0);
        assertEquals(100.0, account.getBalance(), "Balance should not be changed.");
    }

    @Test
    public void testDepositWithZeroAmount() {
        account.deposit(0.0);
        assertEquals(100.0, account.getBalance(), "Balance should not change when depositing zero.");
    }

    @Test
    public void testSuccessfulWithdrawal() {
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), "Balance should decrease by the withdrawn amount.");
    }

    @Test
    public void testWithdrawalWithNegativeAmount() {
        account.withdraw(-50.0);
        assertEquals(100.0, account.getBalance(), "Balance should not change when withdrawal amount is negative.");
    }

    @Test
    public void testPreventNegativeBalance() {
        account.withdraw(150.0); // Overdraft attempt
        assertEquals(100.0, account.getBalance(), "Balance should remain unchanged when overdrawing.");
    }

    @Test
    public void testWithdrawalAmountOverBalance(){
        account.withdraw(150.0); // Overdraft attempt
        assertEquals(100.0, account.getBalance(), "Balance should remain unchanged when withdrawal amount > balance.");
    }

    @Test
    public void testBalanceInquiry() {
        BankAccountManagementSystem_23388102 account2 = new BankAccountManagementSystem_23388102();
        String expected = String.format("Account: %s | Balance: %.2f", account2.getAccountNumber(), account2.getBalance());
        assertEquals(expected, account2.inquireBalance(), "The balance inquiry should return the correct account balance.");
    }




}