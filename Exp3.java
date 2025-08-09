import java.util.*;
class Question3a {
	public static void main(String args[]) {
		
		//Creating Scanner object
		Scanner s = new Scanner(System.in);


		System.out.println("To count the number of letters and digits in a given sentence.");


		//Accepting input
		System.out.println("Input string:");
		String input = s.nextLine();

		char c;
		int count_letter = 0,count_digit = 0;
		int len = input.length();
		for(int i=0;i<len;i++) {
			c = input.charAt(i);
			if(Character.isAlphabetic(c))//checks if c is a alphabet
				count_letter++;//counter
			if(Character.isDigit(c))//checks if c is a digit
				count_digit++;//counter
		}//end of for
		
		//displaying output
		System.out.println("Letters present: "+count_letter);
		System.out.println("Digit present: "+count_digit);

	}//end of main
}//end of class
