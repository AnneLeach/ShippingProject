/*
    This class prints the menu and validates user command (must choose from
    options on menu list.1
*/
package shippingproject;
import java.util.Scanner;
public class Menu {
    private int command;
    public void printMenu(){  
        
        System.out.print("\n\nWelcome to the ShipperQuicker 3000"
                + "\nPlease enter your command:"
                + "\n\n1.  View all records currently in database."
                + "\n2.  Add new package record."
                + "\n3.  Delete package record."
                + "\n4.  Search for a package."
                + "\n5.  Find packages within a weight range."
                + "\n6.  Exit."
                +"\n\n--->  ");
    }  
    
    public int getCommand(){
        Scanner menuScan = new Scanner(System.in);
        String temp = menuScan.nextLine();
        
        while (!temp.equals("1") && !temp.equals("2") && !temp.equals("3")
                && !temp.equals("4") && !temp.equals("5") && !temp.equals("6")){
            System.out.print("\nPlease enter a valid number (1 - 6) --->  ");
            temp = menuScan.nextLine();
        }
        command = Integer.parseInt(temp);
        return command;
    }
}













