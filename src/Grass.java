import java.util.UUID;

public class Grass extends Entity {
    private int amount;

    public Grass(Coordinate coordinate, UUID ID, int amount){
        super(coordinate, ID);
        this.amount = amount;
    }
    @Override
    public void showDisplay(){
        System.out.println("Объект класса Grass");
        super.showDisplay();
    }
}
