import java.util.*;
//Super class
class Hotel {
	//Variable Declaration
	protected String hotelName,location,custName,roomType;
	protected int roomNo,noOfDays;
	protected double roomRate,GST,tax,serviceCharge,bill,billWithTax;

	//Constructor
	Hotel(String hotelName,String location,int roomNo,String custName,int noOfDays){
		this.hotelName = hotelName;
		this.location = location;
		this.roomNo = roomNo;
		this.custName = custName;
		this.noOfDays = noOfDays;
	}

	//Functions
	void checkIn() {
		System.out.println("CheckIn done.");
	}//end of checkIn

	void checkOut() {
		System.out.println("CheckOut done.");
	}//end of checkOut

	void displayBill() {
		
		bill = (roomRate * noOfDays)  + serviceCharge;
		tax = (bill/100)*GST;
		billWithTax = bill + tax;
				
		System.out.println("\n---------- Bill ----------\n");
		
		System.out.println("Customer Name: "+custName);
		System.out.println("Hotel Name: "+hotelName);
		System.out.println("Location: "+location);
		System.out.println("Room no: "+roomNo);
		System.out.println("Room Rate: "+roomRate);
		System.out.println("No Of Days: "+noOfDays);
		System.out.println("GST: "+GST+"%");
		System.out.println("Service Charge: "+serviceCharge);
		
		System.out.println("Total Bill: "+billWithTax);
	}//end of displayBill
}//end of super class


//Sub Class: Deluxe Room
class DeluxeRoom extends Hotel{
	
	DeluxeRoom(String hotelName,String location,int roomNo,String custName,int noOfDays){
		super(hotelName,location,roomNo,custName,noOfDays);
	}//end of constructor
	
	void checkIn() {
		super.checkIn();
	}//end of checkIn

	void checkOut() {
		super.checkOut();
	}//end of checkOut
	
	void displayBill(){
		roomRate = 8000;
		serviceCharge = 0;
		GST = 5;
		super.displayBill();
	}//end of displayBill
	
}//end of sub class DeluxeRoom


//Sub Class: Suite Room
class SuiteRoom extends Hotel{
	
	SuiteRoom(String hotelName,String location,int roomNo,String custName,int noOfDays){
		super(hotelName,location,roomNo,custName,noOfDays);
	}//end of constructor
	
	void checkIn() {
		super.checkIn();
	}//end of checkIn

	void checkOut() {
		super.checkOut();
	}//end of checkOut
	
	void displayBill(){
		roomRate = 20000;
		serviceCharge = 5000;
		GST = 10;
		super.displayBill();
	}//end of displayBill
	
}//end of sub class SuiteRoom


//Main Class
class Main{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Hotel hotel = null;
		
		System.out.println("Enter customer Name: ");
		String custName = sc.nextLine();
		System.out.println("Enter no of days: ");
		int noOfDays = sc.nextInt();
		System.out.println("Enter Hotel Name: ");
		String hotelName = sc.nextLine();
		System.out.println("Enter location: ");
		String location = sc.nextLine();
		System.out.println("Enter room no: ");
		int roomNo = sc.nextInt();
		
		System.out.println("Choose Room Type: ");
		System.out.println("1.Deluxe Room");
		System.out.println("2.Suite Room");
		int choice = sc.nextInt();
		
		if(choice == 1) 
			hotel = new DeluxeRoom(hotelName,location,roomNo,custName,noOfDays);
		else if(choice == 2)
			hotel = new SuiteRoom(hotelName,location,roomNo,custName,noOfDays);
		else {
				System.out.println("Invalid choice!");
				System.exit(0);
		}
				
		int option;
		do {
			System.out.println("\n1.CheckIn");
			System.out.println("2.CheckOut");
			System.out.println("3.Display Bill");
			System.out.println("4.Exit\n");
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				hotel.checkIn();
				break;
			case 2:
				hotel.checkOut();
				break;
			case 3:
				hotel.displayBill();
				break;
			case 4:
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Invalid Input!");
			}
		}while(option != 4);
		
		sc.close();
	}//end of main
}//end of Main class
