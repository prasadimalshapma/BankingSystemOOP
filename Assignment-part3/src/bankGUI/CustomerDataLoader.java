package bankGUI;

import bankGUI.ReadAccounts;
import java.util.List;
import java.util.ArrayList;

public class CustomerDataLoader {
    public static List<Customer> loadCustomers() {
        String filePath = "C:/Users/Prasad Malsha/eclipse-workspace/BankSystem-Assignmentpart2/src/banksyestem2/Accounts.csv";
        ReadAccounts reader = new ReadAccounts(filePath);

        List<Customer> customers = new ArrayList<>();
        List<String> firstNames = reader.getFirstName();
        List<String> lastNames = reader.getLastName();

        for (int i = 0; i < firstNames.size(); i++) {
            Customer c = new Customer();
            c.setFirstName(firstNames.get(i));
            c.setLastName(lastNames.get(i));
            customers.add(c);
        }

        return customers;
    }
}
