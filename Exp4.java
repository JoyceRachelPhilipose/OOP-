import java.util.*;
class Product{
	//instance variables
	private String product_id;
	private String name;
	private int stock;
	private double unit_price;
	
	//initialization
	Product(String product_id, String name, int stock, double unit_price){
		this.product_id = product_id;
		this.name = name;
		this.stock = stock;
		this.unit_price = unit_price;
	}//end of constructor
	
	void updateQuantity(int qty,int ch){
		System.out.println("Stock updated from "+stock);
		if(ch == 1) 
			stock += qty;	
		else
			stock -= qty;
		System.out.print(" to "+stock+".");
	}//end of updateQuantity

	void updateUnitPrice(double price) {
		System.out.println("Price changed from "+unit_price);
		unit_price = price;
		System.out.println(" to "+unit_price);
	}//end of updateUnitPrice

	void calculateInventoryValue() {
		double total_value = stock * unit_price;
		System.out.println("The total value of the inventory is "+total_value);
	}//end of calculateInventoryValue

	void display() {
		System.out.println("ID: "+product_id);
		System.out.println("Name: "+name);
		System.out.println("Stock: "+stock);
		System.out.println("Price per unit: "+unit_price);
	}//end of display

}//end of class Product


class ProductManagement {
	public static void main(String args[]) {
		//creating Scanner object
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of products to enter: ");
		int num = sc.nextInt();

		for(int i=0;i<num;i++) {
			System.out.print("Enter the product id: ");
			String product_id = sc.nextLine();
			
			System.out.println("Enter the product name: ");
			String name = sc.nextLine();
			
			System.out.println("Enter the stock: ");
			int stock = sc.nextInt();
			
			System.out.println("Enter the price per unit: ");
			double unit_price = sc.nextDouble();

			Product product = new Product(product_id,name,stock,unit_price);

			int choice = 0;
			do {
				System.out.println("\n----------Product Management System----------");
				
				System.out.println("Enter 1 to update stock,");
				System.out.println("Enter 2 to update price per quantity,");
				System.out.println("Enter 3 to calculate total value of inventory,");
				System.out.println("Enter 4 to display,");
				System.out.println("Enter 5 to exit.");
				choice = sc.nextInt();

				switch(choice){
				case 1:
					
					System.out.println("Enter 1 to increase and 0 to decrease: ");
					int ch = sc.nextInt();
					/**while(ch != 1 && ch != 0) {
						System.out.println("Invalid Input! Re-enter");
						ch = sc.nextInt();
					}//end of while
					**/
					System.out.println("Enter the quantity: ");
					int qty = sc.nextInt(); 
					product.updateQuantity(qty, ch);
					break;
					
				case 2:
					System.out.println("Enter updated price per piece: ");
					double price = sc.nextDouble();
					product.updateUnitPrice(price);
					break;
					
				case 3:
					product.calculateInventoryValue();
					break;
					
				case 4:
					product.display();
					break;
					
				case 5:
					System.out.println("Byee!");
					break;
					
				default:
					System.out.println("Invalid input! Re-enter");
				}//end of switch
				
			}while(choice != 5);
			
		}//end of for
		sc.close();
	}//end of main
}//end of class ProductManagement
