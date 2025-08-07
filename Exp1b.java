//URK24CS9009
import java.util.*;
class ElectricityUsage{
    public static void main(String args[]){
        //Creating scanner object
        Scanner s = new Scanner(System.in);
        
        //Variable Declaration and initialization
        int total_units = 0;
        float avg_monthly_usage;
        int monthly_usage[] = new int[12];
        
        System.out.println("URK24CS9009----------Electrity Usage----------URK24CS9009");
        
        //Accepting user input
        System.out.println("Enter the electricity unit consumption for the past year:");
        for(int i=0;i<12;i++)
            monthly_usage[i] = s.nextInt();
        
        //Calculation of total units used in the past year
        for(int i=0;i<12;i++)
            total_units += monthly_usage[i];
        
        //Average monthly used and alert if necessary
        avg_monthly_usage = total_units/12;
        if(avg_monthly_usage>500)
            System.out.println("High Consumption Alert");
            
        //Debugging
        System.out.println("Total units used in the past year is "+total_units);
        System.out.println("Average monthly usage is "+avg_monthly_usage);
    }
}
