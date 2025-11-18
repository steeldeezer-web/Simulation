import java.util.*;

class PathFinder {
    private final WorldMap worldMap;
    //Ссылка на мир для проверки границ и ограничений
    public PathFinder(WorldMap worldMap){
        this.worldMap = worldMap;
    }
    //проверяем, находится ли точка coord в пределах maxDistance от start согласно манхеттонскому расстоянию
    public boolean isWithinMaxDistance(Coordinate start, Coordinate coord, int maxDistance){
        int dx = Math.abs(coord.getX() - start.getX());
        int dy = Math.abs(coord.getY() - start.getY());
        // Возвращаем true, если сумма расстояний не превышает maxDistance и координата в границах карты
        return dx + dy <= maxDistance && worldMap.isWithinBounds(coord);


    }
    // Метод поиска пути от start до ближайшего объекта targetClass с ограничением maxDistance
    // creaturesMap содержит размещение существ на координатах
    public List<Coordinate> findPathBFS(Coordinate start, Map<Coordinate, Creature> creaturesMap, Class<? extends Creature> targetClass, int maxDistance){
        //Очередь координат на проверку
        Queue<Coordinate> queue = new LinkedList<>();
        //Множество посещенных координат, чтобы не проверять повторно
        Set<Coordinate> visited = new HashSet<>();
        //Родители для восстановления пути
        Map<Coordinate, Coordinate> parents = new HashMap<>();

        queue.add(start); // Добавляем стартовую точку в очередь
        visited.add(start); // Отмечаем её как посещённую
        parents.put(start,null); // Для старта нет родителя

    }

}
