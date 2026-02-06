package bankGUI;

import java.io.*;
import java.util.*;

public class ReadAccounts {
    private List<String> firstName = new LinkedList<>();
    private List<String> lastName = new LinkedList<>();
    private List<Integer> accountNumber = new LinkedList<>();
    private List<Integer> balance = new LinkedList<>();

    public ReadAccounts(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    firstName.add(data[0].trim());
                    lastName.add(data[1].trim());
                    accountNumber.add(Integer.parseInt(data[2].trim()));
                    balance.add(Integer.parseInt(data[3].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public List<String> getFirstName() {
        return firstName;
    }

    public List<String> getLastName() {
        return lastName;
    }

    public List<Integer> getAccountNumber() {
        return accountNumber;
    }

    public List<Integer> getBalance() {
        return balance;
    }
}
