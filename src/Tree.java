import java.util.UUID;

public class Tree extends Entity{
    public Tree(Coordinate coordinate, UUID ID ){
        super(coordinate, ID);
    }
    @Override
    public void showDisplay(){
        System.out.println("Объект класса Tree");
        super.showDisplay();
    }
}
