package databasepopulation.dbaccess;

import databasepopulation.domain.Building;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * The purpose of DBFacade is to provide an encapsulation of the database access
 *
 * @author kasper
 */
public class DBFacade {

    public static void insertSingleBuilding() {

        String sql = "INSERT INTO building"
                + "(street,contactName,zip,city,contactPhone)"
                + "VALUES"
                + "(?,?,?,?,?)";
        try ( Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareCall( sql ) ) {
            stmt.setString( 1, "Pengvin gade 10" );
            stmt.setString( 2, "Lars Hansen" );
            stmt.setInt( 3, 2800 );
            stmt.setString( 4, "Lyngby" );
            stmt.setString( 5, "2526-9080" );
            int rowsAffected = stmt.executeUpdate();
            if ( rowsAffected > 0 ) {
                System.out.println( "Element inserted" );
            } else {
                System.out.println( "No change" );
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Element not inserted: " + ex.getMessage() );
        }
    }

    public static void insertBuildings( List<Building> buildings ) {
        String sql = "INSERT INTO building"
                + "(id,street,contactName,zip,city,contactPhone)"
                + "VALUES"
                + "(?,?,?,?,?,?)";
        try ( Connection con = DBConnection.getConnection();
                PreparedStatement stmt = con.prepareCall( sql ) ) {
            int key = 100; // Here we could read max key from database
            for ( Building bld : buildings ) {
                key += 10;
                int idx = 1;
                stmt.setInt( idx++, key );
                stmt.setString( idx++, bld.getAddress() );
                stmt.setString( idx++, bld.getContactPerson() );
                stmt.setInt( idx++, bld.getZip() );
                stmt.setString( idx++, bld.getCity() );
                stmt.setString( idx++, bld.getContactPhone() );
                int rowsAffected = stmt.executeUpdate();
                if ( rowsAffected > 0 ) {
                    System.out.println( "Element inserted" );
                } else {
                    System.out.println( "No change" );
                }
            }
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Element not inserted: " + ex.getMessage() );
        }
    }

    public static void truncateRoomAndBuildings() {
        try ( Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement() ) {
            System.out.println( "Connected" );
            stmt.execute( "TRUNCATE room" );
            stmt.execute( "TRUNCATE building" );
            System.out.println( "Tables truncated" );
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Tables not truncated: " + ex.getMessage() );
        }
    }

    public static void testConnection() {
        try ( Connection con = DBConnection.getConnection() ) {
            System.out.println( "Connected" );
        } catch ( SQLException | ClassNotFoundException ex ) {
            System.out.println( "Could not connect to database: " + ex.getMessage() );
        }
    }
}
