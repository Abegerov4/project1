public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer customer1 = new Customer("Aldiyar", "Aldiyar@example.com");
        Customer customer2 = new Customer("Ayadil", "Ayadil@example.com");

        Account account1 = new Procent("A001", customer1, 5000, 2.5);
        Account account2 = new Overdraft("A002", customer2, 1500, 500);
        Account account3 = new Procent("A003", customer1, 3000, 3.0);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        System.out.println("All accounts sorted by balance:");
        for (Account account : bank.SortedByBalance()) {
            System.out.println(account);
        }

        System.out.println("\nAccounts of Aldiyar:");
        for (Account account : bank.searchAccountsByCustomerName("Aldiyar")) {
            System.out.println(account);
        }

        System.out.println("\nAccounts with balance between 2000 and 6000:");
        for (Account account : bank.filterAccountsByBalance(2000, 6000)) {
            System.out.println(account);
        }

        System.out.println("\nDemonstrating polymorphism:");
        if (account1 instanceof Procent interestAccount) {
            interestAccount.applyInterest();
        }
        System.out.println(account1);
        System.out.println("\nDemonstrating Overdraft:");
        account2.withdraw(1800);
        System.out.println(account2);

        System.out.println("\nDemonstrating polymorphism:");
        account1.withdraw(500);
        System.out.println(account1);

        if (account1 instanceof BankAccount bankAccount) {
            bankAccount.withdraw(1500, "godovoe obsluzhivanie "); // Withdraw with reason (overloaded method)
            System.out.println(bankAccount);
        }
    }
}