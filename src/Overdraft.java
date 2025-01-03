class Overdraft extends BankAccount {
    private double overdraftLimit;

    public Overdraft(String id, Customer customer, double balance, double overdraftLimit) {
        super(id, customer, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            double balanceToUse = getBalance();
            if (amount <= balanceToUse) {
                super.withdraw(amount);
            } else {
                double overdraftUsed = amount - balanceToUse;
                super.withdraw(balanceToUse);
                overdraftLimit -= overdraftUsed;
            }
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }

    @Override
    public String toString() {
        return "Account[ID=" + getId() + ", Customer=" + getCustomer().getName() +
                ", Balance=" + getBalance() + ", OverdraftLimit=" + overdraftLimit + "]";
    }
}