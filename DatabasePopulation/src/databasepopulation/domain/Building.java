package databasepopulation.domain;

/**
 * The purpose of Building is to represent the domain class Building.
 * 
 * @author kasper
 */
public class Building {
    // street address, a contact person (name and telephone)
    private String address;
    private int zip;
    private String city;
    private String contactPerson;
    private String contactPhone;

    public Building(String address, int zip, String City, String contactPerson, String contactPhone) {
        this.address = address;
        this.zip = zip;
        this.city = City;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Building( " + address + ", " + zip + ", " + city + ", " + 
                contactPerson + ", " + contactPhone + " )";
    }
    

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}
