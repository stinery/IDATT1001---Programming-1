import java.util.ArrayList;

/**
 * Class PropertyRegister
 * @version 1.01 2019-11-10
 * @author Stine Rygh
 */

class PropertyRegister {
    /**
     * Array list is being used in this task because it's easier to add to it, without having to expand it manually.
     * Versus a set or empty array.
     */
    private ArrayList<Property> properties = new ArrayList<>();

    /**
     * Registering and adding new properties to the array list.
     * Also checking if the property already exist.
     * @param municipalityNumber A integer number from 101 (Halden) up until 5054 (Indre Fosen).
     * @param municipalityName The name of the municipality the property resides in.
     * @param lotNumber A positive integer.
     * @param sectionNumber A positive integer.
     * @param name The name of the property(Not all properties have names).
     * @param area A positive decimal in m^2.
     * @param nameOfOwner Name of the owner of the property.
     * @return boolean
     */

    public boolean reigsterNewProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner){
        for (int i = 0; i < properties.size(); i++){
            if ((municipalityNumber + "-" + lotNumber + "/" + sectionNumber).equals(properties.get(i).propertyID())) {
                return false;
            }
        }
        return properties.add(new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, name, area, nameOfOwner));
    }

    /**
     * Registering and adding a new property, without a name, to the array list.
     * Also checking if the property already exist.
     * @param municipalityNumber A integer number from 101 (Halden) up until 5054 (Indre Fosen).
     * @param municipalityName The name of the municipality the property resides in.
     * @param lotNumber A positive integer.
     * @param sectionNumber A positive integer
     * @param area A positive decimal in m^2.
     * @param nameOfOwner Name of the owner of the property.
     * @return boolean
     */

    public boolean reigsterNewProperty(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String nameOfOwner){

        for (int i = 0; i < properties.size(); i++){
            if ((municipalityNumber + "-" + lotNumber + "/" + sectionNumber).equals(properties.get(i).propertyID())) {
                return false;
            }
        }
        return properties.add(new Property(municipalityNumber, municipalityName, lotNumber, sectionNumber, area, nameOfOwner));
    }
    /**
     * Deletes a property. The user writes the propertyID of the property it wants to delete.
     * This will be double checked in the main program, if the user is sure this is the propertyID of the property it wants to delete.
     * If the propertyID does not exist the method will return false.
     * @param propertyID The propertyID of the property the user want to delete.
     * @return boolean
     */

    public boolean deleteProperty(String propertyID){
        for (int i = 0; i < properties.size(); i++) {
            if (propertyID.equals(properties.get(i).propertyID())) {
                properties.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Return the number of properties in the array list.
     * @return int
     */

    public int numberOfProperties(){
        return properties.size();
    }

    /**
     * Finds a property based on the propertyID. Since this is unique to every property, it only returns one property if it exists.
     * This will be double checked in the main program, if the user is sure this is the propertyID of the property it wants to find.
     * @param propertyID The propertyId on the property the user wants to find.
     * @return String
     */

    public String findPropertyBasedOnPropertyID(String propertyID){
        for(int i = 0; i < properties.size(); i++){
            if(propertyID.equals(properties.get(i).propertyID())) {
                return (i + 1) + ")" + properties.get(i).toString();

            }
        }
        return null;
    }

    /**
     * Computes the average area of all the properties registered in the property register.
     * @return double
     */

    public double averageArea(){
        double area = 0;
        for(int i = 0; i < properties.size(); i++){
            area += properties.get(i).getArea();
        }
        return area / properties.size();
    }

    /**
     * Finds the property/properties based on the lot number.
     * This will be double checked in the main program, if the user is sure this is the lot number it wants to check.
     * @param lotNumber The lot number the user wants to check.
     * @return String
     */

    public String findPropertyBasedOnLotNumber(int lotNumber){
        String list = "";
        for(int i = 0; i < properties.size(); i++){
            if(lotNumber == properties.get(i).getLotNumber()) {
                list += (i + 1) + ")" + properties.get(i).toString() + "\n";

            }
        }
        if (list.equals("")) {
            return null;
        }
        else{
            return list;
        }
    }

    /**
     * Numbered list with all the properties.
     * @return String
     */

    public String toString(){
        String allProperties = "";
        for (int i = 0; i < properties.size(); i++) {
            allProperties += (i + 1) + ")" + properties.get(i).toString() + "\n";
        }
         return allProperties;
    }
}
