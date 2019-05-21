/*  
    This program is the first assignment for the class Object-Oriented Design.
    It simulates a mail shipping center wherein the user can view, add, remove, 
    or search for a product in stock from a command line menu.  Upon exiting, 
    the program writes any changes to a textfile, "packages.txt".
    
    Author: Anne Leach
    Instructor: Vangelis Metsis
    Date:  Sep 2017
*/

package shippingproject;
import java.io.IOException;

public class ShippingProject {
    public static void main(String[] args) throws IOException{
        
        final String FILE_NAME = "packages.txt";
        int menuCommand;
        
        ProcessFile itemsFile = new ProcessFile(FILE_NAME);  
        ItemArray arrayOb = new ItemArray();  
        arrayOb.loadArray(FILE_NAME);  
        Menu menuOb = new Menu(); 
        UniqueItem itemOb = new UniqueItem();  
        
        menuOb.printMenu();
        menuCommand = menuOb.getCommand();
        do{
            if (menuCommand == 1){
                arrayOb.printArray();
                menuOb.printMenu();
                menuCommand = menuOb.getCommand();
            }
            if (menuCommand == 2){
                itemOb = new UniqueItem(1); //1 -> distinguish user input.
                arrayOb.addItem(itemOb);  
                menuOb.printMenu();
                menuCommand = menuOb.getCommand();              
            }
            if (menuCommand == 3){
                arrayOb.deleteItem();
                menuOb.printMenu();
                menuCommand = menuOb.getCommand();              
            }
            if (menuCommand == 4){
                arrayOb.searchItem();
                menuOb.printMenu();
                menuCommand = menuOb.getCommand();               
            }
            if (menuCommand == 5){
                arrayOb.searchWeight();
                menuOb.printMenu();
                menuCommand = menuOb.getCommand();               
            }                     
        }while(menuCommand != 6);
 
        itemsFile.overwriteFile(arrayOb);  //Overwrites text file.
        System.out.print("\n\nThank you.  Goodbye.");
        System.out.print("\n\n");     
    }
}
