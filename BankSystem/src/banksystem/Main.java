package banksystem;

public class Main {

	public static void main(String[] args) {
		
		Account account1 = new Account("Jeffrey", "Ting",1,2000);
		Account account2 = new Account("Hiran", "Patel",2,1000);
		
		System.out.println(account1.getAccountDetails());
		System.out.println("******************************");
		System.out.println(account2.getAccountDetails());
		System.out.println("******************************");
		
		account1.deposit(250);
		System.out.println("-------------------------------");
		
		System.out.println(account1.getAccountDetails());
		System.out.println("*******************************");
		
		
		account2.withdraw(500);
		System.out.println("------------------------------");
		
		
		System.out.println(account2.getAccountDetails());
		System.out.println("******************************");
		
		
		Transaction t = new Transaction();
		t.transfer(account1, account2, 250);
		System.out.println("******************************");
		
		
		System.out.println(account1.getAccountDetails());
		System.out.println("******************************");
		System.out.println(account2.getAccountDetails());
		System.out.println("----------------------------");
		
		t.transfer(account2 , account1 , 2000);
		
		
		
		
		
		
		

	}

}
