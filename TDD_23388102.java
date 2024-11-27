import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class TDD_23388102 {

    private BankAccountManagementSystem_23388102 account, account1;


    @BeforeEach
    public void setUp() {
        // Creating a new account with initial balance, this is just an example for the test.
         account = new BankAccountManagementSystem_23388102("12345","John", 100.0); // Account number 12345 with initial balance of 100
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

}