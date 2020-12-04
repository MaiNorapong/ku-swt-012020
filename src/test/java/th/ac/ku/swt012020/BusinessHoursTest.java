package th.ac.ku.swt012020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessHoursTest {
    @Test
    @DisplayName("Transaction at 5:00, result should be true")
    void transaction_at_0500_result_should_be_true() {
        // Arrange
        Time time = new StubTime("05:00:00");
        Branch branch = new Branch(time);

        // Act
        boolean actual = branch.isBusinessHours();

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Transaction at 23:59, result should be true")
    void transaction_at_2359_result_should_be_true() {
        // Arrange
        Time time = new StubTime("23:59:00");
        Branch branch = new Branch();

        // Act
        boolean actual = branch.isBusinessHours();

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Transaction at 00:00, result should be false")
    void transaction_at_0000_result_should_be_false() {
        // Arrange
        Time time = new StubTime("00:00:00");
        Branch branch = new Branch(time);

        // Act
        boolean actual = branch.isBusinessHours();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Transaction at 04:59, result should be false")
    void transaction_at_0459_result_should_be_false() {
        // Arrange
        Time time = new StubTime("04:59:00");
        Branch branch = new Branch(time);

        // Act
        boolean actual = branch.isBusinessHours();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Transaction at 6:00, result should be true")
    void transaction_at_0600_result_should_be_true() {
        // Arrange
        Time time = new StubTime("06:00:00");
        Branch branch = new Branch(time);

        // Act
        boolean actual = branch.isBusinessHours();

        // Assert
        assertTrue(actual);
    }
}
