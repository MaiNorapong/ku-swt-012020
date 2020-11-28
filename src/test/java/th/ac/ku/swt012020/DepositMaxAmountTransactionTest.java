package th.ac.ku.swt012020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepositMaxAmountTransactionTest {
    @Test
    @DisplayName("Deposit less than 30,000 THB per transaction per person, result should be true")
    void deposit_less_than_30000_result_should_be_true() {
        // Arrange
        float amountToDeposit = 29999.50f;
        Branch branch = new Branch();
        Person person = new Person("2004-01-25");
        Account account = new Account(person);

        // Act
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Deposit equal to 30,000 THB per transaction per person, result should be true")
    void deposit_equal_to_30000_result_should_be_true() {
        // Arrange
        float amountToDeposit = 30000.00f;
        Branch branch = new Branch();
        Person person = new Person("2002-01-04");
        Account account = new Account(person);

        // Act
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Deposit greater than 30,000 THB per transaction per person, result should be false")
    void deposit_greater_than_30000_result_should_be_false() {
        // Arrange
        float amountToDeposit = 30000.50f;
        Branch branch = new Branch();
        Person person = new Person("2003-04-22");
        Account account = new Account(person);

        // Act
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertFalse(actual);
    }
}
