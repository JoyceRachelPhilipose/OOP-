import java.util.*;

//Interface
interface Transaction{

	void deposit(double add_amount);
	void withdraw(double remove_amount);
	void viewBalance();
	void viewAccountDetails();

}//end of interface

//Abstract class
abstract class Account{

	String acc_name;
	int acc_no;
	double balance;

	Account(String acc_name,int acc_no, double balance){

		this.acc_name = acc_name;
		this.acc_no = acc_no;
		this.balance = balance;

	}//end of constructor

	abstract void displayAccount();

}

class Bank extends Account implements Transaction {

	
	Bank(String acc_name,int acc_no, double balance){

		super(acc_name,acc_no,balance);

	}//end of constructor

	public void deposit(double add_amount) {

		balance += add_amount;
		System.out.println("Amount deposited successfully");

	}//end of deposit

	public void withdraw(double remove_amount) {

		if(balance > 2000) {
			balance -= remove_amount;
			System.out.println("Amount withdrawn successfully");
		}//end of if
		else
			System.out.println("Insufficient balance. Amt withdraw unsuccessful.");

	}//end of withdraw

	public void viewBalance() {

		System.out.println("Current Balance: ₹"+balance);

	}//end of viewBalance

	public void viewAccountDetails() {

		displayAccount();

	}//end of viewAccountDetails

	void displayAccount() {

		System.out.println("\n------Account Details------");
		System.out.println("Account Name: "+acc_name);
		System.out.println("Account number: "+acc_no);
		System.out.println("Balance: "+balance);

	}//end of displayAccount

}//end of bank

class Exp6 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		//Initial customer record

		System.out.println("Enter account name: ");
		String acc_name = s.nextLine();
		System.out.println("Enter account number: ");
		int acc_no = s.nextInt();
		System.out.println("Enter balance: ");
		double balance = s.nextDouble();
		Bank customer = new Bank(acc_name,acc_no,balance);
		int choice;

		do {
			System.out.println("\n------Bank Operations------");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.View Balance");
			System.out.println("4.View Account Details");
			System.out.println("5.Exit");
			System.out.println("ENTER YOUR CHOICE");

			choice = s.nextInt();

			switch(choice) {
			
			case 1:

				System.out.println("Enter the amt to deposit");
				double add_amt = s.nextDouble();
				customer.deposit(add_amt);
				break;

			case 2:

				System.out.println("Enter the amt to withdraw");
				double remove_amt = s.nextDouble();
				customer.withdraw(remove_amt);
				break;

			case 3:

				customer.viewBalance();
				break;

			case 4:

				customer.viewAccountDetails();
				break;

			case 5:

				System.out.println("Bye!");
				break;

			default:
				System.out.println("Invalid Input!\nTry again");
				
			}//end of switch
			
		}while(choice != 5);
		
		s.close();
		
	}//end of main
}//end of class
