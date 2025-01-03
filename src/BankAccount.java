class BankAccount implements Account {
    private String id;
    private Customer customer;
    private double balance;

    public BankAccount(String id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) balance
                += amount;
    }

    @Override
    public void withdraw(double amount ) {
        if (amount > 0 && balance >= amount)
            balance -= amount;
    }
    public void withdraw(double amount, String reason) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " for reason: " + reason);
        }
    }

    @Override
    public String toString() {
        return "BankAccount[ID=" + id + ", Customer=" + customer.getName() + ", Balance=" + balance + "]";
    }
}