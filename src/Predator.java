import java.util.UUID;

public class Predator extends Creature{
    private int damage;
    public Predator(Coordinate coordinate, UUID ID, int HP, int speed, int damage){
        super(coordinate, ID, HP, speed);
        this.damage = damage;
    }

    @Override
    public void showDisplay() {
        System.out.println("Объект класса: Predator");
        super.showDisplay();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
