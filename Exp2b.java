import java.util.*;
class Question2b {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("----------Searching a num in an array----------\n");
		int size,n,count=0;
		
		System.out.print("Enter size of array: ");
		size = s.nextInt();
		
		//Accepting user input
		System.out.print("Enter array elements: ");
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i] = s.nextInt();
		
		/*
		//Displaying user input
		System.out.print("The entered array is:");
		for(int i=0;i<size;i++)
			System.out.print("	"+arr[i]);
		*/
		
		System.out.print("Enter the number to search: ");
		n = s.nextInt();
		
		int x = 0;
		for(int i=0;i<size;i++) {
			if(arr[i] == n) {
				x = 1;
				count++;
			}//end of if
		}//end of for
		if(x == 0)
			System.out.print("Num not present in array.");
		else
			System.out.println("Num found "+count+" times.");
		
	}//end of main
}//end of class
