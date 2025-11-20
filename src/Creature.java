abstract class Creature extends Entity{
    protected int speed;
    protected int health;
    protected String name;
    protected WorldMap worldMap;

    public Creature(Coordinate pos, int speed, int health, String name, WorldMap worldMap){
        super(pos);
        this.speed = speed;
        this.health = health;
        this.name = name;
        this.worldMap = worldMap;
    }
    public boolean isAlive(){
        return health > 0;
    }
    public void reduceHealth(int damage){
        health = Math.max(0, health - damage);
        //гарантирует что не уйдем по значению дальше 0
    }
    abstract void makeMove(Simulation sim);
    @Override
    public String toString() {
        return name + " at " + position + " HP:" + health;
    }

}