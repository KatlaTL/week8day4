package databasepopulation;

import databasepopulation.randomdata.Address;
import databasepopulation.randomdata.AddressGenerator;
import databasepopulation.randomdata.PersonGenerator;
import databasepopulation.dbaccess.DBConnection;
import databasepopulation.domain.*;
import databasepopulation.randomdata.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DatabasePopulation {

    public static void main(String[] args) {
        //testRandomBuildings();
        //testConnection();
        //truncateRoomAndBuildings();

        //insertSingleBuilding();
        //insertBuildings(200);
    }

    private static void insertBuildings(int N) {
        List<Building> buildings = randomBuildings(N);
        String sql = "INSERT INTO building"
                + "(id,street,contactName,zip,city,contactPhone)"
                + "VALUES"
                + "(?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareCall(sql)) {
            int key = 100;
            for (Building bld : buildings) {
                key += 10;
                int idx = 1;
                stmt.setInt     (idx++, key);
                stmt.setString  (idx++, bld.getAddress());
                stmt.setString  (idx++, bld.getContactPerson());
                stmt.setInt     (idx++, bld.getZip());
                stmt.setString  (idx++, bld.getCity());
                stmt.setString  (idx++, bld.getContactPhone());
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Element inserted");
                } else {
                    System.out.println("No change");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
    }

    private static void insertSingleBuilding() {

        String sql = "INSERT INTO building"
                + "(street,contactName,zip,city,contactPhone)"
                + "VALUES"
                + "(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareCall(sql)) {
            stmt.setString  (1, "Pengvin gade 10");
            stmt.setString  (2, "Lars Hansen");
            stmt.setInt     (3, 2800);
            stmt.setString  (4, "Lyngby");
            stmt.setString  (5, "2526-9080");
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Element inserted");
            } else {
                System.out.println("No change");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Element not inserted: " + ex.getMessage());
        }
    }

    private static void truncateRoomAndBuildings() {
        try (Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement()) {
            System.out.println("Connected");
            stmt.execute("TRUNCATE room");
            stmt.execute("TRUNCATE building");
            System.out.println("Tables truncated");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Tables not truncated: " + ex.getMessage());
        }
    }

    private static void testConnection() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Connected");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Could not connect to database: " + ex.getMessage());
        }
    }

    private static void testRandomBuildings() {
        List<Building> buildings = randomBuildings(5);
        for (Building b : buildings) {
            System.out.println(b);
        }
    }

    public static List<Building> randomBuildings(int N) {
        List<Building> buildings = new ArrayList<>();
        for (Person p: PersonGenerator.persons(N)) {
            Address addr = AddressGenerator.address();
            String street = addr.getAddress();
            int zip = Integer.parseInt(addr.getZip());
            String city = addr.getCity();
            String name = p.getName();
            String phone = p.getPhoneNo();
            buildings.add(new Building(street, zip, city, name, phone));
        }
        return buildings;
    }

    public static List<Room> floors(int N, int sqmPerFloor){
        int maxRoomPerFloor = sqmPerFloor / 12;
        int minRoomPerFloor = 2; // A room and a bathroom
        Random rnd = new Random();
        List<Room> rooms = new ArrayList<>();
        for (int floor = 0; floor <N; floor++ ){
            int noRoomsThisFloor = minRoomPerFloor 
                    +rnd.nextInt(maxRoomPerFloor-minRoomPerFloor+1);
            float size = sqmPerFloor/noRoomsThisFloor;
            int windows = (int)size/12;
            for (int roomNo = 1; roomNo <= noRoomsThisFloor; roomNo++){
                //rooms.add( new Room(...))
            }
        }
        return rooms;
    }
    

}
