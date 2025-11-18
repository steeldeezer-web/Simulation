import java.util.List;
import java.util.UUID;

public class Predator extends Creature{
    public Predator(Coordinate coordinate, UUID ID, int health, String name, WorldMap worldMap){
        super(coordinate, ID, health, name,worldMap);
    }


    @Override
    public void showDisplay() {
        System.out.println("Объект класса: Predator");
        super.showDisplay();
    }

    @Override
    public void act(List<Coordinate> coordinateListForTarget) {
        Coordinate coordinate1 = null;
        for (int i = 0; i < coordinateListForTarget.size(); i++) {
            coordinate1 = coordinateListForTarget.get(i);
            this.getCoordinate().setX(coordinate1.getX());
            this.getCoordinate().setY(coordinate1.getY());







            this.causeDamage();
        }




    }
}
