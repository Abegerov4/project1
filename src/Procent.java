class Procent extends BankAccount {
    private double interestRate;

    public Procent(String id, Customer customer, double balance, double interestRate) {
        super(id, customer, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    @Override
    public String toString() {
        return "Account[ID=" + getId() + ", Customer=" + getCustomer().getName() +
                ", Balance=" + getBalance() + ", InterestRate=" + interestRate + "%]";
    }
}