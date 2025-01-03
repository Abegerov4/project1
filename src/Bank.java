import java.util.*;
class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> SortedByBalance() {
        List<Account> sortedList = new ArrayList<>(accounts);
        sortedList.sort(Comparator.comparingDouble(Account::getBalance));
        return sortedList;
    }

    public List<Account> searchAccountsByCustomerName(String name) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account instanceof BankAccount) {
                BankAccount ba = (BankAccount) account;
                if (ba.getCustomer().getName().equalsIgnoreCase(name)) {
                    result.add(account);
                }
            }
        }
        return result;
    }

    public List<Account> filterAccountsByBalance(double minBalance, double maxBalance) {
        List<Account> filteredAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getBalance() >= minBalance && account.getBalance() <= maxBalance) {
                filteredAccounts.add(account);
            }
        }
        return filteredAccounts;
    }
}