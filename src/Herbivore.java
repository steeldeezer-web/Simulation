import java.util.UUID;

public class Herbivore extends Creature{
    public Herbivore(Coordinate coordinate, UUID ID, int HP, int speed){
        super(coordinate, ID, HP, speed);
    }

    @Override
    public void showDisplay() {
        System.out.println("Объект класса: Herbivore");
        super.showDisplay();
    }
}
