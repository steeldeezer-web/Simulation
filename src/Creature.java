import java.util.*;

abstract class Creature extends Entity {
    private int damage;
    private int HP;
    private int speed;
    private int scoreCount;

    private Map<Entity, Creature> map;
    private boolean isLive;
    public Creature(Coordinate coordinate, UUID ID, int HP, int speed){
        super(coordinate, ID);
        this.HP = HP;
        this.speed = speed;
        this.isLive = true;
        this.damage = 1;
        this.scoreCount = 0;

    }

    @Override
    public Coordinate getCoordinate() {
        return super.getCoordinate();
    }

    @Override
    public UUID getID() {
        return super.getID();
    }

    public int getHP() {
        return HP;
    }

    public int getSpeed() {
        return speed;
    }

    public Map<Entity, Creature> getMap() {
        return map;
    }

    @Override
    public void setID(UUID ID) {
        super.setID(ID);
    }

    @Override
    public void setCoordinate(Coordinate coordinate) {
        super.setCoordinate(coordinate);
    }


    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMap(Map<Entity, Creature> map) {
        this.map = map;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public boolean makeMove(int newX, int newY, Map<Coordinate,Entity> map){
    Coordinate newCoordinate = new Coordinate(newX,newY);
    if(map.containsKey(newCoordinate)) return false;
    Coordinate oldCoordinate = new Coordinate(coordinate.getX(),coordinate.getY());
    map.remove(oldCoordinate);
    coordinate.setX(newX);
    coordinate.setY(newY);
    map.put(newCoordinate,this);
    return true;
    }
    @Override
    public void showDisplay(){
        super.showDisplay();
        System.out.println("HP: " + getHP());
        System.out.println("speed: " + getSpeed());

    }
    public Entity findTarget(Coordinate start, Map<Coordinate, Entity> map, Entity entity){
        //cоздаем очередь,куда будут помещаться координаты для избежания повторной обработки
        Queue<Coordinate> queue = new LinkedList<>();
        //cоздаем множество,для поверенных координат которые становятся родителями
        Set<Coordinate> visited = new HashSet<>();
        //Начать обход с координаты сущности (травоядного или хищника).
        //
        //Поместить начальную координату в очередь.
        queue.add(start);
        visited.add(start);
        //это способ представления всех возможных направлений движения в двухмерной сетке (2D мире) по четырём сторонам: вниз, вверх, вправо и влево.
        //
        //Каждая пара в массиве — это дельта координат (смещение по X и Y).
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()){
            Coordinate current = queue.poll();

            //проверка координаты на цель
        }
    }
}
