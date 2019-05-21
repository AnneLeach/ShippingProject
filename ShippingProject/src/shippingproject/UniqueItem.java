/*
    This class handles each unique mail item.  Each item has specific mailing
    characteristics.  The creation and enforcement of mailing items is handled
    here.  In this program, once an object is created, it cannot be changed.
*/
package shippingproject;
import java.util.Scanner;

public class UniqueItem {   
    private String tracking;
    private String type;
    private String spec;
    private String mClass;
    private float weight;
    private int volume;

    private String type1 = "Postcard";
    private String type2 = "Letter";
    private String type3 = "Envelope";
    private String type4 = "Packet";
    private String type5 = "Box";
    private String type6 = "Crate";
    private String type7 = "Drum";
    private String type8 = "Roll";
    private String type9 = "Tube";

    private String spec1 = "Fragile";
    private String spec2 = "Books";
    private String spec3 = "Catalogs";
    private String spec4 = "Do-not-Bend";
    private String spec5 = "N/A";

    private String mClass1 = "First-Class";
    private String mClass2 = "Priority";
    private String mClass3 = "Retail";
    private String mClass4 = "Ground";
    private String mClass5 = "Metro";

    String divider = (" -------------------------------------------"
            + "---------------------------------------------------");
    String leftWall = " |";

    public UniqueItem() {
    }

    public UniqueItem(String nTracking, String nType, String nSpec,
            String nMClass, float nWeight, int nVolume) {

        tracking = nTracking;
        type = nType;
        spec = nSpec;
        mClass = nMClass;
        weight = nWeight;
        volume = nVolume;
    }

    public UniqueItem(int user) {
        Scanner userInput = new Scanner(System.in);

        //***********************************************************TRACKING
        System.out.print("\nYou have chosen to enter a new item.\n"
                + "Enter the tracking # --->  ");
        while (!userInput.hasNext("[A-Za-z0-9]+")) {
            System.out.print("\nError: invalid input."
                    + "\nPlease enter only letters and numbers.  --->  ");
            userInput.next();
        }
        tracking = userInput.next();
        //************************************************************TYPE
        userInput = new Scanner(System.in);
        System.out.print("Enter the type --->  ");
        String temp = userInput.nextLine();

        while (!temp.equalsIgnoreCase(type1) && !temp.equalsIgnoreCase(type2)
                && !temp.equalsIgnoreCase(type3) && !temp.equalsIgnoreCase(type4)
                && !temp.equalsIgnoreCase(type5)
                && !temp.equalsIgnoreCase(type6)
                && !temp.equalsIgnoreCase(type7)
                && !temp.equalsIgnoreCase(type8)
                && !temp.equalsIgnoreCase(type9)) {
            System.out.print("\nError: invalid input.\n"
                    + "Please enter a valid type  --->  ");
            userInput = new Scanner(System.in);
            temp = userInput.nextLine();
        }
        type = temp;
        //***************************************************SPECIFICATION
        userInput = new Scanner(System.in);
        System.out.print("Enter the specification --->  ");
        temp = userInput.nextLine();

        while (!temp.equalsIgnoreCase(spec1) && !temp.equalsIgnoreCase(spec2)
                && !temp.equalsIgnoreCase(spec3) && !temp.equalsIgnoreCase(spec4)
                && !temp.equalsIgnoreCase(spec5)) {
            System.out.print("\nError: invalid input.\n"
                    + "Please enter a valid specfication  --->  ");
            userInput = new Scanner(System.in);
            temp = userInput.nextLine();
        }
        spec = temp;

        //*****************************************************MAILING CLASS
        userInput = new Scanner(System.in);
        System.out.print("Enter the mailing class --->  ");
        temp = userInput.nextLine();

        while (!temp.equalsIgnoreCase(mClass1)
                && !temp.equalsIgnoreCase(mClass2)
                && !temp.equalsIgnoreCase(mClass3)
                && !temp.equalsIgnoreCase(mClass4)
                && !temp.equalsIgnoreCase(mClass5)) {
            System.out.print("\nError: invalid input.\n"
                    + "Please enter a valid mailing class  --->  ");
            userInput = new Scanner(System.in);
            temp = userInput.nextLine();
        }
        mClass = temp;

        //************************************************************WEIGHT
        userInput = new Scanner(System.in);
        System.out.print("Enter the weight (in oz)  --->  ");

        while (!userInput.hasNextFloat()) {

            System.out.print("\nError: invalid input."
                    + "\nPlease enter only numbers for weight (in oz)  --->  ");
            userInput.next();

        }
        weight = userInput.nextFloat();

        //**********************************************************VOLUME
        userInput = new Scanner(System.in);
        System.out.print("Enter the volume (cubic inch)  --->  ");

        while (!userInput.hasNextInt()) {

            System.out.print("Error: invalid input."
                    + "\nPlease enter only numbers for volume (cubic inch)"
                    + "  --->  ");
            userInput.next();
        }
        volume = userInput.nextInt();
    }

    public String getTracking() {
        return tracking;
    }

    public float getWeight() {
        return weight;
    }

    public void printHeader() {
        System.out.println("\n" + divider);
        System.out.printf("%-1s%15s%14s%20s%18s%14s%12s%n",
                leftWall, "TRACKING # |", "TYPE |", "SPECIFICATION |", "MAILING CLASS |",
                "WEIGHT |", "VOLUME |");
        System.out.println(divider);
    }

    public void printItemLine() {
        String trackingCol = (tracking + " |");
        String typeCol = (type + " |");
        String specCol = (spec + " |");
        String mClassCol = (mClass + " |");
        String weightCol = (weight + " |");
        String volumeCol = (volume + " |");
        System.out.printf("%-1s%15s%14s%20s%18s%14s%12s%n",
                leftWall, trackingCol, typeCol, specCol, mClassCol,
                weightCol, volumeCol);
    }

    public String returnStringLine() {
        return (tracking + " " + spec + " " + mClass + " " + weight
                + " " + volume + "\n");
    }
}
