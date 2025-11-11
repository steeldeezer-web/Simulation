import java.util.UUID;

class Rock extends Entity{
    public Rock(Coordinate coordinate, UUID ID ){
        super(coordinate,ID);
    }
    @Override
    public void showDisplay(){
        System.out.println("Объект класса Rock");
        super.showDisplay();
    }


}
