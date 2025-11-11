import java.util.UUID;

abstract class Entity {
    Coordinate coordinate;
    private UUID ID;
    public Entity(Coordinate coordinate, UUID ID ){
        this.coordinate = coordinate;
        this.ID = ID;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void showDisplay(){
        coordinate.showDisplay();
        System.out.println("ID: " + ID);

    }
}
