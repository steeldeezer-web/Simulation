import java.util.UUID;

public class Predator extends Creature{
    public Predator(Coordinate coordinate, UUID ID, int HP, int speed){
        super(coordinate, ID, HP, speed);
    }

    @Override
    public void showDisplay() {
        System.out.println("Объект класса: Predator");
        super.showDisplay();
    }
}
