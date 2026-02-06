package banksyestem2;



public class Transaction {
	public void transfer(Account acc1, Account acc2, int amount) {
		if (amount <= 0) {
			System.out.println("Invalid transfer amount.");
		}
		else if (acc1.getBalance()>= amount) {
			acc1.withdraw(amount);
			acc2.deposit(amount);
			System.out.println("Transferred " + amount + " from " 
	                + acc1.getFirstName() + " " + acc1.getLastName() + " (Acc#: " + acc1.getAccountNum() + ") to "
	                + acc2.getFirstName() + " " + acc2.getLastName() + " (Acc#: " + acc2.getAccountNum() + ")");
			
			
		}
		else {
			System.out.println("Transfer failed: Not enough balance in account " + acc1.getAccountNum());
		}
		
		
	}

}
