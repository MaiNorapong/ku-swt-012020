package th.ac.ku.swt012020;

import java.util.HashMap;
import java.util.Map;

public class Branch {
    private static float maxDepositAmountPerTransaction = 30000.00f;
    private static float minDepositAmountPerTransaction = 100.00f;
    private static float maxDepositAmountPerDay = 50000.00f;

    private static Map<Person, Float> totalAmountPerPerson = new HashMap<>();

    public boolean canDeposit(Account account, float amount) {
        if (account.isSuspended()) {
            return false;
        }
        if (amount > maxDepositAmountPerTransaction) {
            return false;
        }
        if (amount < minDepositAmountPerTransaction) {
            return false;
        }
        Float prevAmount = totalAmountPerPerson.get(account.getOwner());
        if (prevAmount != null) {
            return amount + prevAmount <= maxDepositAmountPerDay;
        }
        return true;
    }

    public void deposit(Account account, float amount) {
        if (!canDeposit(account, amount)) {
            throw new RuntimeException("Invalid transaction.");
        }
        totalAmountPerPerson.merge(account.getOwner(), amount, Float::sum);
    }

    public static float getMinDepositAmountPerTransaction() {
        return minDepositAmountPerTransaction;
    }
}
