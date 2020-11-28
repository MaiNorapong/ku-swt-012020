package th.ac.ku.swt012020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepositMinAmountTransactionTest {
    private static final float minDepositAmount = Branch.getMinDepositAmountPerTransaction();

    @Test
    @DisplayName("Deposit less than minimum deposit amount, result should be false")
    void deposit_less_than_minimum_deposit_amount_result_should_be_false() {
        // Arrange
        float amountToDeposit = minDepositAmount - 0.50f;
        Branch branch = new Branch();
        Person person = new Person("2002-08-07");
        Account account = new Account(person);

        // Act
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Deposit equal to minimum deposit amount, result should be true")
    void deposit_equal_to_minimum_deposit_amount_result_should_be_true() {
        // Arrange
        float amountToDeposit = minDepositAmount;
        Branch branch = new Branch();
        Person person = new Person("2004-12-23");
        Account account = new Account(person);

        // Act
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Deposit less than minimum deposit amount, result should be true")
    void deposit_greater_than_minimum_deposit_amount_result_should_be_true() {
        // Arrange
        float amountToDeposit = minDepositAmount + 0.50f;
        Branch branch = new Branch();
        Person person = new Person("2004-11-09");
        Account account = new Account(person);

        // Act
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual);
    }
}
