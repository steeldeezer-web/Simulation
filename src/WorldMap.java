import java.util.HashMap;
import java.util.Map;
class WorldMap {
    private final int width, height;
    private Map<Coordinate, Entity> entities = new HashMap<>();

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }

    public boolean isWithinBounds(Coordinate coord) {
        return coord.getX() >= 0 && coord.getX() < width &&
                coord.getY() >= 0 && coord.getY() < height;
    }

    public boolean isSpotFree(Coordinate coord) {
        return isWithinBounds(coord) && !entities.containsKey(coord);
    }

    public Entity getEntityAt(Coordinate coord) {
        return entities.get(coord);
    }

    public void addEntity(Entity e) {
        entities.put(e.getPosition(), e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e.getPosition());
    }

    public void moveEntity(Entity e, Coordinate newPos) {
        entities.remove(e.getPosition());
        e.position = newPos;
        entities.put(e.getPosition(), e);
    }
}