package cis;

import cis.entity.Kid;
import cis.util.CisUtility;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Controls the overall flow of the program.
 *
 * @author cis1201
 * @since Nov 18, 2020
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = System.lineSeparator()+"--- Main Menu ---"+System.lineSeparator()+"1) Add a kid to Santa's lists" + System.lineSeparator()
            + "2) Lookup a kid" + System.lineSeparator()
            + "3) Move a kid from the nice list" + System.lineSeparator()
            + "4) Show the list" + System.lineSeparator()  
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    //**********************************************************
    //Santa specifica attributes.  Note these strings will contain
    //the list of kids who are naughty or nice.
    //**********************************************************
    private static String listNice, listNaughty;
private static String lookUpName,removeName;
    public static void main(String[] args) {

        int menuOption;
        initializeLists(); //Load the initial names into the lists (not reflective of who's actually naughty/nice :-)

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    addKid();  //Method to add a kid
                    break;
                case 2:
                    lookup();  //Method to lookup a kid
                    break;
                case 3:
                    removeKidNiceList(); //Method to move from nice to naughty list string.
                    break;
                case 4:
                    showLists();  //This method is completed and can show the kids on the lists.
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * When the user picks 1 add a kid.
     *
     * @since 20201202
     * @author BJM
     */
    public static void addKid() {
        System.out.println(System.lineSeparator() + "--- Add a kid ---");
        Kid kid = new Kid();
        kid.getInformation();
        kid.display();
        
        String name = kid.getName();
        int age = kid.getAge();
        int behaviourRating = kid.getBehaviourRating();

        //todo Requirement 1-Making the lists
       if (kid.getAge()>=10 && kid.getBehaviourRating()<6)
       {
           listNaughty+=","+kid.getName();
       } else if (kid.getAge()<10 && kid.getBehaviourRating()<5)
       {
           listNaughty+=","+kid.getName();
       } else {
       listNice+=","+kid.getName();
       }
        
        
        
        
       

        
    }

    /**
     * Option 2 - lookup a kid to see if naughty or nice.  
     *
     * @since 20201118
     * @author BJM
     */
    public static void lookup() {
        System.out.println(System.lineSeparator() + "--- Lookup a kid's status ---");
        lookUpName = CisUtility.getInputString("Type the kid's name");
        
         boolean isFoundNice=listNice.contains(lookUpName);
       boolean  isFoundNaughty=listNaughty.contains(lookUpName) ;
        if(isFoundNice==true){
            System.out.println(System.lineSeparator() +lookUpName + " is  Nice ");
        } 
        if (isFoundNaughty==true){
            System.out.println(System.lineSeparator() +lookUpName + " is  Naughty ");
        //todo Requirement#2 Add code to see if a kid is naughty or nice.
    }
        }

    /**
     * Option 3 - removed of the nicelist
     *
     * @since 20201202
     * @author BJM
     */
    public static void removeKidNiceList() {
        System.out.println(System.lineSeparator() + "--- Remove a kid from the nice list ---");
        //todo Requirement#3 - Add code to remove a kid of the nice list
       removeName = CisUtility.getInputString("Type the kid's name you want to remove");
       listNice=listNice.replace( ","+removeName,"");
    }

    /**
     * Show the lists
     *
     * @since 20201202
     * @author BJM
     */
    public static void showLists() {
        StringTokenizer st = new StringTokenizer(listNice, ",");
        System.out.println(System.lineSeparator()+"--- Nice List ---");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        st = new StringTokenizer(listNaughty, ",");
        System.out.println(System.lineSeparator()+"--- Naughty List ---");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

    }


    /**
     * Load the nice and naughty lists. Note these are randomly assigned!
     *
     * @since 20201202
     * @author BJM
     */
    public static void initializeLists() {

        listNice = ",Aaron,Adline,Alberto,Amy,Andres,Azam,Bailee,Ben,Blaise,Brandon,Chad,Christian,Colin,Courtney,Dakota,"
                + "David,Dmitrii";

        //Just random :-)
        listNaughty = ",Nick,Michael,Steve";
    }

}
