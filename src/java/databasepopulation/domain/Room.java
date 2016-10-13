package databasepopulation.domain;

// each building has a number of rooms, each having a floor number, 
// room number, no square meters, and no of windows
// to turn this class into a proper Java class with 
// * private fields
// * getter and setters
// * constructor
// 1. Select menu "Refactor>Encapsulate fields"
// 2. Place the cursor after the the { of the Room class, and press ctrl-space
//    Or pick the menu "Source>complete code"
//    From the menu that pops up, pick the longer constructor (which has generate at the end of the line)
public class Room {
    private int id;
    private int floorNo;
    private int roomNo;
    private float size; // in square meters
    private int noWindows;

    public Room( int floorNo, int roomNo, float size, int noWindows ) {
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.size = size;
        this.noWindows = noWindows;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo( int floorNo ) {
        this.floorNo = floorNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo( int roomNo ) {
        this.roomNo = roomNo;
    }

    public float getSize() {
        return size;
    }

    public void setSize( float size ) {
        this.size = size;
    }

    public int getNoWindows() {
        return noWindows;
    }

    public void setNoWindows( int noWindows ) {
        this.noWindows = noWindows;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }
}
