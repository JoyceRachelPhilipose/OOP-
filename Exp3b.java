import java.util.Scanner;
class Question3b {
	public static void main(String args[]) {
		
		//Creating Scanner object
		Scanner s = new Scanner(System.in);

		//Accepting input
		System.out.println("Input string:");
		String input = s.nextLine();
		
		if (input == null || input.isEmpty()) {
            System.out.println("");
            s.close();
            return;
        }

        String result = "";
        char prev = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                result = result + prev + count;
                prev = curr;
                count = 1;
            }
        }
        // Append the final run
        result = result + prev + count;

        System.out.println("Output: "+result);
        s.close();
	}
}
