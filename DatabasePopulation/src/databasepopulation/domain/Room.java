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
    private Building myBuilding;
    private int floorNo;
    private int roomNo;
    private float size; // in square meters
    private int noWindows;

    public Room(Building myBuilding, int floorNo, int roomNo, float size, int noWindows) {
        this.myBuilding = myBuilding;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.size = size;
        this.noWindows = noWindows;
    }

    /**
     * @return the myBuilding
     */
    public Building getMyBuilding() {
        return myBuilding;
    }

    /**
     * @param myBuilding the myBuilding to set
     */
    public void setMyBuilding(Building myBuilding) {
        this.myBuilding = myBuilding;
    }

    /**
     * @return the floorNo
     */
    public int getFloorNo() {
        return floorNo;
    }

    /**
     * @param floorNo the floorNo to set
     */
    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    /**
     * @return the roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * @return the size
     */
    public float getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(float size) {
        this.size = size;
    }

    /**
     * @return the noWindows
     */
    public int getNoWindows() {
        return noWindows;
    }

    /**
     * @param noWindows the noWindows to set
     */
    public void setNoWindows(int noWindows) {
        this.noWindows = noWindows;
    }
}
