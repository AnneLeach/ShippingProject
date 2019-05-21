/*
    This class handles the textFile which saves the stock items in between
    program use.  If "packages.txt" does not exist, one will be created.  At
    end of program, the existing textfile is overwritten with changes.
*/
package shippingproject;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ProcessFile{
    private String fileName;
   
    public ProcessFile(String newName) throws IOException{
        fileName = newName;
        
        File itemsFile = new File(fileName);
        if(!itemsFile.exists()){
            //System.out.print("\nT: " + fileName + " does not exist.  Creating now.");    
            PrintWriter pw = new PrintWriter(fileName);
            pw.close();
        }
        else{
            //System.out.print("\nT: " + fileName + " file found.  Opening now.");       
        }
    }
    
    public void overwriteFile(ItemArray arrayOb) throws IOException{
        PrintWriter outFile = new PrintWriter(fileName);
        ArrayList<UniqueItem> temp = new ArrayList<UniqueItem>();
        temp = arrayOb.getArray();
        
        for(int k = 0; k < temp.size(); k++){
            outFile.println( (temp.get(k)).returnStringLine() );
        }
        outFile.close();
    }
}
