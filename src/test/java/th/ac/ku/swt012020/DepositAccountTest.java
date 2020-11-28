package th.ac.ku.swt012020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositAccountTest {
    @Test
    @DisplayName("Deposit with unsuspended account, result should be true")
    void deposit_with_unsuspended_account_result_should_be_true() {
        // Arrange
        float amountToDeposit = 8000.00f;
        Branch branch = new Branch();
        Person person = new Person("2003-10-29");
        Account account = new Account(person);

        // Act
        account.suspend();
        account.unsuspend();
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Deposit with suspended account, result should be false")
    void deposit_with_suspended_account_result_should_be_false() {
        // Arrange
        float amountToDeposit = 6000.00f;
        Branch branch = new Branch();
        Person person = new Person("2001-09-24");
        Account account = new Account(person);

        // Act
        account.suspend();
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertFalse(actual);
    }
}
