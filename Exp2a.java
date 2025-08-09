import java.util.*;
class Question2a {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("----------Display count of nos < X----------\n");
		int n,x,count = 0;
		
		System.out.print("Enter size of array: ");
		n = s.nextInt();
		
		//Accepting user input
		System.out.print("Enter array elements: ");
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = s.nextInt();
		
		//Displaying user input
		System.out.print("The entered array is:");
		for(int i=0;i<n;i++)
			System.out.print("	"+arr[i]);
		
		//sorting the entered array
		for (int i = 0; i < n - 1; i++) {	          
            int min_idx = i;      
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])                                
                    min_idx = j;
             }//end of j
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;           
        }//end of i
		
		//Displaying the sorted array 
		System.out.print("\nThe sorted array is:");
		for(int i=0;i<n;i++)
			System.out.print("	"+arr[i]);
		
		System.out.print("\nEnter the value of x: ");
		x = s.nextInt();
		System.out.print("\nNumbers are = ");
		for(int i=0;i<n;i++) {
			if(arr[i]<x) {
				System.out.print(arr[i]+" , ");
				count++;
			}else 
				break;
		}//end of for
		System.out.println("\nCount = "+count);
		
	}//end of main
}//end of class
