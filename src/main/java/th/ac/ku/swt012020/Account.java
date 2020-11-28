package th.ac.ku.swt012020;

public class Account {
    private Boolean suspended;
    private Person owner;

    public Account(Person owner) {
        this.owner = owner;
        suspended = false;
    }

    public void suspend() {
        if (!isSuspended()) {
            suspended = true;
        }
        else {
            throw new RuntimeException("Account is already suspended");
        }
    }

    public void unsuspend() {
        if (isSuspended()) {
            suspended = false;
        }
        else {
            throw new RuntimeException("Account is not suspended");
        }
    }

    public boolean isSuspended() {
        return suspended;
    }

    public Person getOwner() {
        return owner;
    }
}
