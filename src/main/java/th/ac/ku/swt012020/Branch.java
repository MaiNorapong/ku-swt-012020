package th.ac.ku.swt012020;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Branch {
    private Time time;

    private static float maxDepositAmountPerTransaction = 30000.00f;
    private static float minDepositAmountPerTransaction = 100.00f;
    private static float maxDepositAmountPerDay = 50000.00f;
    private static LocalTime openingHour = LocalTime.parse("05:00:00");
    private static LocalTime closingHour = LocalTime.parse("00:00:00");

    private static Map<Person, Float> totalAmountPerPerson = new HashMap<>();

    public Branch() {
        this.time = new RealTime();
    }

    public Branch(Time time) {
        this.time = time;
    }

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

    public boolean isBusinessHours() {
        LocalTime localTime = time.now();
        int cmp = closingHour.compareTo(openingHour);
        if (cmp == 0) {
            return true;
        }
        else if (cmp > 0) {
            return localTime.compareTo(openingHour) >= 0 && localTime.compareTo(closingHour) < 0;
        }
        else {
            return localTime.compareTo(openingHour) >= 0 || localTime.compareTo(closingHour) < 0;
        }
    }
}
