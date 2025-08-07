//URK24CS9009
import java.util.*;
class CinemaTicket {
    public static void main(){
    
        Scanner sc = new Scanner(System.in);
    
        //Variable declaration
        int age, booking_date;
        float final_price,base_price=200;
    
        //Temporary initialization
        int discount_age=0;
        int discount_day=0;
        float discount_amt,total_discount;
        
        System.out.println("URK24CS9009----------Cinema Ticket Booking----------URK24CS9009");
    
        //Inputing age
        System.out.print("Enter age(0-200): ");
        age=sc.nextInt();
    
        //Checking age limit
        if(age>-1 && age<5) 
                discount_age = 100;
        else if(age>=5 && age <=18)
                discount_age = 40;
        else if(age>=19 && age<=60)
                discount_age = 0;
        else if(age>60 && age<=200)
                discount_age = 30;
        else {
                System.out.println("Invalid Input. Exiting program");
                System.exit(0);
        }
    
        //Inputing day of booking
        System.out.print("Enter 1 for weekdays and 2 for weekends: ");
        booking_date=sc.nextInt();
    
        //Checking limits 
        if(booking_date == 1)
                discount_day = 10;
        else if(booking_date == 2)
                discount_day=0;
        else {
                System.out.println("Invalid Input. Exiting program.");
                System.exit(0);
        }
    
        //Discount and final amount calculation
        total_discount = discount_day + discount_age - (discount_day*discount_age)/100;
        discount_amt = base_price*(total_discount/100);
        final_price = base_price - discount_amt;
    
        //Display price to be paid
        System.out.println("Pay Rs "+final_price+".");
        
        //System.out.println(discount_amt);

    }
}
