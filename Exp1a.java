//URK24CS9009
import java.util.*;
class ATM{
    public static void main(String args[]){
        //Declaring Scanner object
        Scanner s = new Scanner(System.in);
        
        //Variable declaration and initialization
        double deposit,withdraw,bank_balance=10000;
        int choice;
        
        //infinite loop till user wants to end
        do{
        	System.out.println("\n\nURK24CS9009----------ATM----------URK24CS9009\n");
            System.out.println("Enter 1 to check account balance\nEnter 2 to deposit money\nEnter 3 to withdraw money\nEnter 4 to exit:"); 
            choice = s.nextInt();
            switch(choice){
            	case 1:
            		System.out.println("\nCurrent bank balance: "+bank_balance);
            		break;
            	case 2:
            		System.out.println("\nEnter the deposit amount:");
            		deposit = s.nextDouble();
            		bank_balance += deposit;
            		break;
            	case 3:
            		System.out.println("\nEnter the withdrawal amount:");
            		withdraw = s.nextDouble();
            		bank_balance -= withdraw;
            		if(bank_balance <= 2000) {
            			System.out.println("\nWarning!!\nMinimum balance of 2000 need to be maintained.\nTranscation Failed.");
            			bank_balance += withdraw;
            		}
            		break;
            	case 4:
            		System.out.println("\nByee");
            		System.exit(0);
            	default:
            		System.out.println("Invalid Input");
            }
        }while(choice != 4);
    }
}
