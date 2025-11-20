import javax.swing.plaf.PanelUI;
import java.util.UUID;

abstract class Entity{
    protected Coordinate position;
    protected UUID ID;

    public Entity(Coordinate position){
        this.position = position;
        this.ID = UUID.randomUUID();
    }
    public Coordinate getPosition(){
        return position;
    }

    public UUID getID() {
        return ID;
    }
}