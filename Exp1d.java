//URK24CS9009
import java.util.Random;
import java.util.*;
public class NumGuessingGameModify {

	public static void main(String[] args) {

		//creating scanner and random object
		Scanner s= new Scanner(System.in);
		Random r = new Random();

		//Variable Initialization
		int guess, trys_left = 7,max_trys = 1,contd_or_leave = 1;

		do {

			int random = r.nextInt(100) + 1;
			System.out.println("\n\nURK24CS9009----------Number Guessing Game----------URK24CS9009\n");
			System.out.println("Guess a number between 1 to 100: ");
			//System.out.println(random);

			do {

				for(int i = 0;i < 7;i++) {

					guess = s.nextInt();

					if(guess == random) {
						System.out.println("Correct");
						max_trys = 8;
						break;

					}

					else if(guess < random) {
						//System.out.println(max_trys);
						//System.out.println(trys_left);
						trys_left--;
						max_trys ++;
						System.out.println("Low. "+trys_left+" trys left.");
					}

					else if(guess > random) {
						//System.out.println(max_trys);
						//System.out.println(trys_left);
						trys_left --;
						max_trys ++;	
						System.out.println("High. "+trys_left+" trys left.");
					}

					else
						System.out.println("Invalid Input");
					
					break;

				}//end of for
				
			}while(max_trys < 8);

			if (trys_left == 0)
				System.out.println("Game Over. Correct ans is "+random);
			
			while(true){
				System.out.println("Enter 1 to try again and 0 to exit");
				contd_or_leave = s.nextInt();

				if(contd_or_leave == 1) {
					trys_left = 7;
					max_trys = 1;
					break;
				}
				
				else if(contd_or_leave == 0) {
					System.out.println("Byee");
					System.exit(0);
				}
				else 
					System.out.println("Invalid Input. Try again");
	
			}//end of while
			
		}while(contd_or_leave != 0);
	}//end of main
}//end of class
