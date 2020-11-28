package th.ac.ku.swt012020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DepositMaxAmountDayTest {
    @Test
    @DisplayName("Deposit less than 50,000 THB per day per person (all branches), result should be true")
    void deposit_less_than_50000_result_should_be_true() {
        // Arrange
        float amountDeposited = 30000.00f;
        float amountToDeposit = 19999.50f;
        Branch branch = new Branch();
        Person person = new Person("2004-01-04");
        Account account = new Account(person);

        // Act
        branch.deposit(account, amountDeposited);
        boolean actual = branch.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Deposit equal to 50,000 THB per day per person (all branches), result should be true")
    void deposit_equal_to_50000_result_should_be_true() {
        // Arrange
        float amountDeposited = 25000.00f;
        float amountToDeposit = 25000.00f;
        Branch branch1 = new Branch();
        Branch branch2 = new Branch();
        Person person = new Person("2001-12-12");
        Account account = new Account(person);

        // Act
        branch1.deposit(account, amountDeposited);
        boolean actual1 = branch1.canDeposit(account, amountToDeposit);
        boolean actual2 = branch2.canDeposit(account, amountToDeposit);

        // Assert
        assertTrue(actual1);
        assertTrue(actual2);
    }

    @Test
    @DisplayName("Deposit greater than 50,000 THB per day per person (all branches), result should be false")
    void deposit_greater_than_50000_result_should_be_false() {
        // Arrange
        float amountDeposited1 = 10000.00f;
        float amountDeposited2 = 20000.00f;
        float amountDeposited3 = 19000.00f;
        float amountToDeposit = 10000.00f;
        Branch branch1 = new Branch();
        Branch branch2 = new Branch();
        Person person = new Person("2001-12-16");
        Account account = new Account(person);

        // Act
        branch1.deposit(account, amountDeposited1);
        branch1.deposit(account, amountDeposited2);
        branch2.deposit(account, amountDeposited3);
        boolean actual1 = branch1.canDeposit(account, amountToDeposit);
        boolean actual2 = branch2.canDeposit(account, amountToDeposit);

        // Assert
        assertFalse(actual1);
        assertFalse(actual2);
    }
}
