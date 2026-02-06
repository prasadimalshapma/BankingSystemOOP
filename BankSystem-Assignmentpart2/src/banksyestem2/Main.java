package banksyestem2;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		String file = "C:/Users/Prasad Malsha/eclipse-workspace/BankSystem-Assignmentpart2/src/banksyestem2/Accounts.csv";
		ReadAccounts reader = new ReadAccounts(file);

		LinkedList<String> firstNames = new LinkedList<>(reader.getFirstName());
		LinkedList<String> lastNames = new LinkedList<>(reader.getLastName());
		LinkedList<Integer> accountList = new LinkedList<>(reader.getAccountNumber());
		LinkedList<Integer> balanceList = new LinkedList<>(reader.getBalance());

		LinkedList<Account> accounts = new LinkedList<>();

		for (int i = 0; i < firstNames.size(); i++) {
			accounts.add(new Account(firstNames.get(i), lastNames.get(i), accountList.get(i), balanceList.get(i)));
		}

		
		if (accounts.size() >= 2) {
			Transaction t = new Transaction();
			t.transfer(accounts.get(0), accounts.get(1), 1000);
		}
		System.out.println("-----------------------------------------------");
		 System.out.println("\n--- Updated Account Details ---");
		 System.out.println("     "+"*********************");
	        for (Account acc : accounts) {
	            System.out.println(acc);
	            System.out.println("-----------------------------------------------");
	            
	        }
		
	}
}
