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


        int[][] directions = {{1,0}, {-1,0},{0,1},{0,-1}};

        //цикл пока очередь не станет пустой
        while(!queue.isEmpty()){
            // берем из очереди текущую координату
            Coordinate current = queue.poll();
            //проверяем есть ли на данной координате како-либо существо
            Creature creature = creaturesMap.get(current);
            if(creature != null && targetClass.isInstance(creature) && !current.equals(start)){

                return buildPath(current, parents);// Восстанавливаем путь и возвращаем
            }
            for(int[] dir : directions){
                int newX = current.getX() + dir[0];
                int newY = current.getY() + dir[1];
                Coordinate neighbor = new Coordinate(newX, newY);

                // если сосед не посещен, в пределеах maxDistance и мира - добавляем в очередь
                queue.add(neighbor);
                visited.add(neighbor);
                parents.put(neighbor,current); // Запоминаем откуда пришли
            }
        }
        return null; // Если цель не найдена, возвращаем null

    }
    private List<Coordinate> buildPath(Coordinate end, Map<Coordinate,Coordinate> parents){
        List<Coordinate> path = new ArrayList<>();
        for(Coordinate at = end; at != null; at = parents.get(at))   {
            // Добавляем в список
            path.add(at);
        }
        // Разворачиваем список чтобы координаты были от начала к концу
        Collections.reverse(path);
        return path;
    }


}
