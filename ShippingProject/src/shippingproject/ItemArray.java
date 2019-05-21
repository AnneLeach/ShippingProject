/*
    This class handles the list of items in stock.  It is composed of a list
    of UniqueItem objects.  Any actions on the list (add, remove, search) are
    performed here.
*/

package shippingproject;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
public class ItemArray {
    
    private ArrayList<UniqueItem> allItems = new ArrayList<UniqueItem>(); 
    String divider = (" -------------------------------------------"
    + "---------------------------------------------------");  
    
    public ArrayList<UniqueItem> getArray(){
        return allItems;
    }
    
    public void loadArray(String FILE_NAME) throws IOException{
        Scanner scanFile = new Scanner (new FileReader(FILE_NAME));
        while(scanFile.hasNext()){
            String nTracking = scanFile.next();
            String nType = scanFile.next();
            String nSpec = scanFile.next(); 
            String nMClass = scanFile.next();    
            float nWeight = scanFile.nextFloat(); 
            int nVolume = scanFile.nextInt();
            allItems.add(new UniqueItem(nTracking, nType, nSpec, nMClass, nWeight, nVolume));
        }
    }
    
    public void addItem(UniqueItem newUniqueItem){
        
        allItems.add(newUniqueItem);
    }
    
    public void deleteItem(){
        System.out.print("\nEnter the tracking # of the item" + 
                "\nyou wish to delete  --->  ");
        
        Scanner userInput = new Scanner(System.in);
        
        while(!userInput.hasNext("[A-Za-z0-9]+")){
        System.out.print("\nError: invalid input." +
                "\nPlease enter only letters and numbers.  --->  ");
        userInput.next();
        }
        
        String deleteTrack = userInput.next();
        boolean found = false;
        
        for (int k = 0; k < allItems.size(); k++){
           
            if (deleteTrack.equalsIgnoreCase( (allItems.get(k)).getTracking() )){
                allItems.remove(k);
                found = true;
            }
        }
        if(found){
            System.out.print("\nThe item was removed from the list.\n");
        }
        else{
            System.out.print("\nThe item did not exist in records. "
                    + "\nNo item was removed.");
        }
    }
    
    public void searchItem(){
        System.out.print("\nEnter the tracking # of the item" + 
                "\nyou wish to find  --->  ");
        
        Scanner userInput = new Scanner(System.in);
        
        while(!userInput.hasNext("[A-Za-z0-9]+")){
        System.out.print("\nError: invalid input." +
                "\nPlease enter only letters and numbers.  --->  ");
        userInput.next();
        }
        
        String searchTrack = userInput.next();
        boolean found = false;
        
        for (int k = 0; k < allItems.size(); k++){
            if (searchTrack.equalsIgnoreCase( (allItems.get(k)).getTracking() )){
                System.out.println("\nItem found.");
                (allItems.get(k)).printHeader();
                (allItems.get(k)).printItemLine();
                System.out.print("\n" + divider);
                found = true;
            }
        }
        if(!found){
            System.out.print("\nThe item did not exist in records.");
        }
    }

    public void searchWeight(){
        System.out.print("\nPlease enter the bottom range"
            + " of target weight  --->  ");

        Scanner scanWeight = new Scanner(System.in);
        
        while (!scanWeight.hasNextFloat()){
            System.out.print("\nError: invalid input."
                + "\nPlease enter only numbers  --->  ");
            scanWeight.next();
        }
        
        float bottomWeight = scanWeight.nextFloat();
        System.out.print("Please enter the top range"
            + " of target weight --->  ");

        scanWeight = new Scanner(System.in);
        while (!scanWeight.hasNextFloat()){
            System.out.print("\nError: invalid input."
                + "\nPlease enter only numbers  --->  ");
            scanWeight.next();
        } 
        float topWeight = scanWeight.nextFloat();
        //************************************************* SEARCH & COMPARE
        boolean found = false;
        for (int k = 0; k < allItems.size(); k++){
            
            float tempWeight = (allItems.get(k)).getWeight();
            
            if (tempWeight < topWeight && tempWeight > bottomWeight){
                found = true;
                break;
            }
        }
        //Sorry this is messy.  It was the only way I could figure out 
        //how to print the nice-looking header with info below.
        if (found){
        (allItems.get(0)).printHeader(); 
        for (int i = 0; i < allItems.size(); i++){
            float tempWeight = (allItems.get(i)).getWeight();
            if (tempWeight < topWeight && tempWeight > bottomWeight){
                (allItems.get(i)).printItemLine();
                }     
            }
        System.out.print(divider);
        }
        else{
            System.out.print("\nNo item found within that range.");
        }
    }

    public void printArray(){    
        //Create UniqueItem object for header.
        UniqueItem header = new UniqueItem();
        //Print header
        header.printHeader();
        //Print body
        for (int k = 0; k < allItems.size(); k++){            
            (allItems.get(k)).printItemLine();
        }
        System.out.println(divider);
    }
}
