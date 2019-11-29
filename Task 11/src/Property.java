/**
 * Class Property
 * @version 1.01 2019-11-10
 * @author Stine Rygh
 */
class Property {
    private final int municipalityNumber; //Kommunenummer
    private final String municipalityName; //Kommunenavn
    private final int lotNumber; //Gårdsnummer(gnr.)
    private final int sectionNumber; //Bruksnummer(bnr.)
    private String name; //Bruksnavn
    private final double area; //Areal i m^2
    private String nameOfOwner; //Navn på eier

    /**
     * Constructor that creates an object of type Property.
     * @param municipalityNumber A integer number from 101 (Halden) up until 5054 (Indre Fosen).
     * @param municipalityName The name of the municipality the property resides in.
     * @param lotNumber A positive integer.
     * @param sectionNumber A positive integer.
     * @param name The name of the property(Not all properties have names).
     * @param area A positive decimal in m^2.
     * @param nameOfOwner Name of the owner of the property.
     */

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner){
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Constructor that creates an object of type Property without a name for the property.
     * @param municipalityNumber A integer number from 101 (Halden) up until 5054 (Indre Fosen).
     * @param municipalityName The name of the municipality the property resides in.
     * @param lotNumber A positive integer.
     * @param sectionNumber A positive integer
     * @param area A positive decimal in m^2.
     * @param nameOfOwner Name of the owner of the property.
     */

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String nameOfOwner){
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Gets the municipality number
     * @return int
     */

    public int getMunicipalityNumber() { //aksessor-metode
        return municipalityNumber;
    }

    /**
     * Gets the municipality name
     * @return String
     */

    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * Gets lot number
     * @return int
     */

    public int getLotNumber() {
        return lotNumber;
    }

    /**
     * Gets section number
     * @return int
     */

    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * Gets the name of the property
     * @return String
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the property
     * @param name
     */

    public void setName(String name) { //mutator-metode
        this.name = name;
    }

    /**
     * Gets the area
     * @return double
     */

    public double getArea() {
        return area;
    }

    /**
     * Gets the name of the owner
     * @return String
     */

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    /**
     * Sets the name of the owner
     * @param nameOfOwner
     */

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * A method that makes a PropertyID and return it in the right format(Municipality number-Lot number/Section number. Eks:1445-77/631)
     * @return String
     */

    public String propertyID(){
        return getMunicipalityNumber() + "-" + getLotNumber() + "/" + getSectionNumber();
    }

    /**
     * A toString method that prints the information about the property
     * @return String
     */

    public String toString(){
        String list = "Municipality number: " + municipalityNumber +
                        "\nMunicipality name: " + municipalityName +
                        "\nProperty ID: " + propertyID() +
                         "\nName of Owner: " + nameOfOwner;
        if(name != null){
            list += "\nName of property: " + name;

        }
        return "\n------------------------------\n" + list + "\n------------------------------\n";
    }
}