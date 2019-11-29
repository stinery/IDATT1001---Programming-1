import javax.swing.*;
import java.util.Scanner;

/**
 * Class Main
 * @version 1.01 2019-11-10
 * @author Stine Rygh
 */
public class Main {
    public static void main(String[] args) {
        PropertyRegister propertyRegister = new PropertyRegister();
        //Test data
        propertyRegister.reigsterNewProperty(1445, "Gloppen", 77, 631, 1017.6,"Jens Olsen");
        propertyRegister.reigsterNewProperty(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        propertyRegister.reigsterNewProperty(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        propertyRegister.reigsterNewProperty(1445, "Gloppen", 74, 188, 1457.2, "Karl Ove Bråten");
        propertyRegister.reigsterNewProperty(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård");

        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice != 7){
            System.out.println("----------------------------------------\nWelcome to the property registration-app" +
                    "\nPlease select an option.\n----------------------------------------\n\n1.Register a new property" +
                    "\n2.Show all properties\n3.Search for property based on propertyID\n4.Search for properties based on lot number" +
                    "\n5.Calculate average area of the properties registered\n6.Delete a property\n7.Exit" +
                    "\n");
            choice = in.nextInt();
            //If the user enters a number choice that is not in the menu. A error will show and the menu will print again.
            if(choice > 7 || choice < 1){
                System.out.println("!!Enter a valid number.\n");
            }
            switch(choice){
                case 1: //Register new property with or without property name.
                    System.out.println("Write in the municipality number:");
                    int municipalityNumber = in.nextInt();
                    if(municipalityNumber < 101 || municipalityNumber > 5054){
                        System.out.println("This number is not valid.\n");
                        break;
                    }
                    System.out.println("Write in the municipality name:");
                    String municipalityName = in.next() + in.nextLine();
                    System.out.println("Write in the lot number:");
                    int lotNumber = in.nextInt();
                    if(lotNumber < 0) {
                        System.out.println("This number is not valid.\n");
                        break;
                    }
                    System.out.println("Write in the section number:");
                    int sectionNumber = in.nextInt();
                    if(sectionNumber < 0) {
                        System.out.println("This number is not valid.\n");
                        break;
                    }
                    System.out.println("Write in the area of the property:");
                    double area = in.nextDouble();
                    if(area < 0) {
                        System.out.println("This number is not valid.\n");
                        break;
                    }
                    System.out.println("Write in the name of the Owner:");
                    String nameOfOwner = in.next() + in.nextLine();
                    choice = JOptionPane.showConfirmDialog(null, "Does the property have a name?",
                            "Select an option..", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                    if(choice == 0){
                        System.out.println("Write in the property name:");
                        String name = in.next() + in.nextLine();
                        if(!propertyRegister.reigsterNewProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner)){
                            System.out.println("\nThe property is already registered!");
                        }
                        else{
                            propertyRegister.reigsterNewProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner);
                            System.out.println("\nThe property was successfully registered.\n");
                        }
                    }
                    else if(choice == 1){
                        if(!propertyRegister.reigsterNewProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner)){
                            System.out.println("\nThe property is already registered!");
                        }
                        else{
                            propertyRegister.reigsterNewProperty(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner);
                            System.out.println("\nThe property was successfully registered.\n");
                        }
                    }
                    else{
                        System.out.println("\nThe property was not registered.\n");
                    }
                    break;

                case 2: //Print all properties in the array list.
                    System.out.println(propertyRegister.toString());
                    break;

                case 3: //Find a property based on the propertyID with double check of propertyID.
                    choice = 1;
                    while(choice == 1){
                        System.out.println("What is the propertyID? E.g:1445-77/631");
                        String propertyID = in.next() + in.nextLine();
                        choice = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct propertyID?" +
                                 "\n" + propertyID,"Select an option..", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        if(choice == 0) {
                            if(propertyRegister.findPropertyBasedOnPropertyID(propertyID) == null){
                                System.out.println("\nThis propertyID does not exist!\n");
                            }
                            else{
                                System.out.println(propertyRegister.findPropertyBasedOnPropertyID(propertyID) + "\n");
                            }
                        }
                    }
                    break;

                case 4: //Finds the property/properties based on the lot number with double check of lot number.
                    choice = 1;
                    while(choice == 1){
                        System.out.println("What is the lot number?");
                        lotNumber = in.nextInt();
                        choice = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct lot number?" +
                                 "\n" + lotNumber, "Select an option..", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        if(choice == 0){
                            if(propertyRegister.findPropertyBasedOnLotNumber(lotNumber) == null) {
                                System.out.println("\nThis lot number does not exist!\n");
                                break;
                            }
                            else{
                                System.out.println(propertyRegister.findPropertyBasedOnLotNumber(lotNumber) + "\n");
                            }
                        }
                    }
                    break;

                case 5: //Computes and prints the average area of all the properties registered in the property register.
                    System.out.println("The average area of all the properties are:\n" + propertyRegister.averageArea() + "\n");
                    break;

                case 6: //Deletes property based on propertyID with double check of propertyID.
                    choice = 1;
                    while(choice == 1){
                        System.out.println("What is the propertyID of the property you wish to delete? E.g:1445-77/631");
                        String propertyID = in.next() + in.nextLine();
                        choice = JOptionPane.showConfirmDialog(null, "Are you sure this is the correct propertyID?" +
                                 "\n" + propertyID,"Select an option..", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                        if(choice == 0) {
                            if(!propertyRegister.deleteProperty(propertyID)){
                                System.out.println("\nThis propertyID does not exist!\n");
                            }
                            else{
                                propertyRegister.deleteProperty(propertyID);
                                System.out.println("\nThe property was successfully deleted.\n");
                            }
                        }
                        else if(choice == 2){
                            System.out.println("\nThe property was not successfully deleted.\n");
                        }
                    }
                    break;
            }
        }
        System.out.println("Thank you for using the property registration-app.");
    }
}
