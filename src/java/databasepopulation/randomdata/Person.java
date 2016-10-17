package databasepopulation.randomdata;

/**
 * The purpose of this class is is to represent contact persons
 * @author zaeem
 */
public class Person {
    private final String name;
    private final String phoneNo;

    public Person(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
    
}
