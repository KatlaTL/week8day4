package databasepopulation.randomdata;

/**
 * The purpose of this class is is to represent contact persons
 * @author kasper
 */
public class Person {
    private final String Name;
    private final String PhoneNo;

    public Person(String Name, String PhoneNo) {
        this.Name = Name;
        this.PhoneNo = PhoneNo;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }
    
}
