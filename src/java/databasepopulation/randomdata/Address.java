package databasepopulation.randomdata;

/**
 * The purpose of Address is to represent simple Addresses
 * @author kasper
 */
public class Address {

    private String address;
    private String zip;
    private String city;

    public Address(String address, String zip, String city) {
        this.address = address;
        this.zip = zip;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }
}
