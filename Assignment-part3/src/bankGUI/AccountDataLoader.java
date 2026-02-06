package bankGUI;

import java.util.ArrayList;
import java.util.List;
import bankGUI.ReadAccounts;

public class AccountDataLoader {

    public static List<Account> loadAccounts() {
        String filePath = "C:/Users/Prasad Malsha/eclipse-workspace/BankSystem-Assignmentpart2/src/banksyestem2/Accounts.csv";
        ReadAccounts reader = new ReadAccounts(filePath);

        List<Account> accounts = new ArrayList<>();

        List<String> firstNames = reader.getFirstName();
        List<String> lastNames = reader.getLastName();
        List<Integer> accountNumbers = reader.getAccountNumber();
        List<Integer> balances = reader.getBalance();

        for (int i = 0; i < accountNumbers.size(); i++) {
            String fname = firstNames.get(i);
            String lname = lastNames.get(i);
            int accNum = accountNumbers.get(i);
            int bal = balances.get(i);

            Account acc = new Account(fname, lname, accNum, bal);
            accounts.add(acc);
        }

        return accounts;
    }
}
