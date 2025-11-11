import java.util.Map;
import java.util.UUID;

abstract class Creature extends Entity {
    private int HP;
    private int speed;
    private Map<Entity, Creature> map;
    public Creature(Coordinate coordinate, UUID ID, int HP, int speed){
        super(coordinate, ID);
        this.HP = HP;
        this.speed = speed;
    }

    @Override
    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }

    @Override
    public UUID getID() {
        return super.getID();
    }

    public int getHP() {
        return HP;
    }

    public int getSpeed() {
        return speed;
    }

    public Map<Entity, Creature> getMap() {
        return map;
    }

    @Override
    public void setID(UUID ID) {
        super.setID(ID);
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        super.setCoordinate(coordinate);
    }


    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMap(Map<Entity, Creature> map) {
        this.map = map;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean makeMove(int newX, int newY, Map<Coordinate,Entity> map){
    Coordinate newCoordinate = new Coordinate(newX,newY);
    if(map.containsKey(newCoordinate)) return false;
    Coordinate oldCoordinate = new Coordinate(coordinate.getX(),coordinate.getY());
    map.remove(oldCoordinate);
    coordinate.setX(newX);
    coordinate.setY(newY);
    map.put(newCoordinate,this);
    return true;
    }
    @Override
    public void showDisplay(){
        super.showDisplay();
        System.out.println("HP: " + getHP());
        System.out.println("speed: " + getSpeed());

    }
}
