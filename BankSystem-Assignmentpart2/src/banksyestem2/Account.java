package banksyestem2;



public class Account extends Customer{
	private int balance;
	private int accountNumber;
	
	public Account (String FName, String LName, int accNum, int accBal) {
		setFirstName(FName);
		setLastName(LName);
		this.accountNumber = accNum;
		this.balance = accBal;
		
		
	}

	
	public int getBalance() {
		return balance;
		
	
	}
	
	public int getAccountNum() {
		return accountNumber;
		
	}
	
	public void deposit(int amount) {
		if (amount > 0) {
			balance +=amount;
			System.out.println("Deposited " + amount + " to account " + accountNumber);			
		}
		else {
			System.out.println("Invalid deposit amount.");
		}
		
	
	}
	
	public void withdraw(int amount) {
		if(amount > balance) {
			System.out.println("Insufficient balance in account " + accountNumber);
			
		}
		else if (amount <= 0) {
			System.out.println("Invalid withdrawal amount.");
		}
		else {
			balance -=amount;
			System.out.println("Withdrew " + amount + " from account " + accountNumber);
		}
		
		
	}
	
	public String getAccountDetails() {
	    return "Account Name   : " + getFirstName() + " " + getLastName() + "\n"
	         + "Account Number : " + accountNumber + "\n"
	         + "Balance        : " + balance;
	}

	
	public String toString() {
		return getAccountDetails();
	}
}

