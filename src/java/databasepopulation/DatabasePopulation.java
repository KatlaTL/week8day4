package databasepopulation;

import databasepopulation.dbaccess.DBFacade;
import databasepopulation.randomdata.*;
import databasepopulation.domain.*;
import databasepopulation.randomdata.Person;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulation {

    public static void main( String[] args ) {
        printRandomBuildings();
        //testConnection();
        //truncateRoomAndBuildings();

        //insertSingleBuilding();
        DBFacade.insertBuildings( randomBuildings( 200 ) );
    }

    private static void printRandomBuildings() {
        List<Building> buildings = randomBuildings( 5 );
        for ( Building b : buildings ) {
            System.out.println( b );
        }
    }

    public static List<Building> randomBuildings( int N ) {
        List<Building> buildings = new ArrayList<>();
        int key = 1;
        for ( Person p : PersonGenerator.persons( N ) ) {
            Address addr = AddressGenerator.address();
            String street = addr.getAddress();
            int zip = Integer.parseInt( addr.getZip() );
            String city = addr.getCity();
            String name = p.getName();
            String phone = p.getPhoneNo();
            final Building building = new Building( street, zip, city, name, phone );
            building.setId( key++ );
            buildings.add( building );
        }
        return buildings;
    }

}
