public class WorldMap {
    private int worldWith;
    private int worldHeight;
    // Стартовая точка (например, координата существа):
   
    public WorldMap(int worldWith, int worldHeight){
        this.worldWith = worldWith;
        this.worldHeight = worldHeight;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getWorldWith() {
        return worldWith;
    }

    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }

    public void setWorldWith(int worldWith) {
        this.worldWith = worldWith;
    }

    public boolean isWithinBounds(int x, int y, int maxDistance){
        if(x < 0 || y < 0 || x >= worldWith || y>= worldHeight) return false;
        int dx =  Math.abs(x-start)
    }
}
