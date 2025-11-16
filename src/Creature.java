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
    public List<Coordinate> findPathBFS(Coordinate start, Map<Coordinate, Entity> map, Class<? extends Entity> targetClass, int maxDistance){
        // Объявляем метод, который ищет путь от start до ближайшей цели targetClass на карте map, ограничивая поиск maxDistance
        Queue<Coordinate>queue = new LinkedList<>();
        // Очередь для хранения координат, которые нужно посетить FIFO
        Set<Creature> visited = new HashSet<>();
        //Множество посещенных координат
        Map<Coordinate,Coordinate> parents = new HashMap<>();
        //Храним для каждой координаты ее родителя
        queue.add(start);
        //Помещаем стартовую координату в очередь
        visited.add(start);
        //Помечаем координату как посещенную, чтобы повторно не поместить в очередь
        parents.put(start,null);
        // У стартовой точки нет родителя, поэтому ставим null

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        // Массив с направлением двиения
        while (!queue.isEmpty()){
            //Цикл работает пока есть координаты в очереди для посещения
            Coordinate current = queue.poll();
            //Получаем координату из очереди
            Entity entity = map.get(current);
            // Получаем по ранее полученной координате объект
            if(entity != null && targetClass.isInstance(entity) && !current.equals(start)){
                //Проверяем не пустой ли объект и точно ли объект является объектом наследника Entity и проверяем не стартовая ли координата, чтобы не проверять ее т.к на ней уже находим
                // Если все врено то цель найдена
                return buildPath(current,parents);
                //Восстанавливаем и возвращаем путь от стартовой точки до цели
            }
            for(int[] dir : directions){
                // Проходим по соседни координатам
                int newX = current.getX() + dir[0];
                // новая координа  старая координата + нулевой эллемент массива dir (координата x)
                int newY = current.getY() + dir[1];
                // новая координа  старая координата + первый эллемент массива dir (координата y)
                Coordinate neighbor = new Coordinate(newX,newY);
                //Создаем объект хранящий коодинаты соседа
                if(!visited.contains(neighbor) && )

            }
        }

    }

}
