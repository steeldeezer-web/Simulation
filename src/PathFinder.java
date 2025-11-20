import java.util.*;
class PathFinder {
    // Находит путь к ближайшему объекту нужного типа с помощью BFS
    public static <T extends Entity> List<Coordinate> findPathToNearestEntity(
            Coordinate start, WorldMap map, Class<T> targetClass) {
        Queue<Coordinate> queue = new LinkedList<>();
        Map<Coordinate, Coordinate> parents = new HashMap<>();
        Set<Coordinate> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        parents.put(start, null);

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            Entity entity = map.getEntityAt(current);
            if (entity != null && targetClass.isInstance(entity) && !current.equals(start)) {
                return buildPath(parents, current);
            }

            for (int[] dir : directions) {
                Coordinate next = new Coordinate(current.getX() + dir[0], current.getY() + dir[1]);
                if (map.isWithinBounds(next) && !visited.contains(next) &&
                        (map.isSpotFree(next) || targetClass.isInstance(map.getEntityAt(next)))) {
                    queue.add(next);
                    visited.add(next);
                    parents.put(next, current);
                }
            }
        }
        return null; // Цели нет
    }

    // Восстановление пути по родителям
    private static List<Coordinate> buildPath(Map<Coordinate, Coordinate> parents, Coordinate end) {
        List<Coordinate> path = new ArrayList<>();
        for(Coordinate at = end; at != null; at = parents.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}