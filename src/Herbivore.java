import java.util.*;
class Herbivore extends Creature {
    public Herbivore(Coordinate pos, int speed, int health, WorldMap map) {
        super(pos, speed, health, "Herbivore", map);
    }

    @Override
    void makeMove(Simulation sim) {
        // Ищем ближайшую траву с помощью поиска в ширину (BFS)
        List<Coordinate> pathToFood = PathFinder.findPathToNearestEntity(
                position, sim.getMap(), Grass.class);
        if (pathToFood != null && pathToFood.size() > 1) {
            Coordinate nextStep = pathToFood.get(1);
            if (sim.getMap().isSpotFree(nextStep)) {
                sim.moveCreature(this, nextStep);
            }
        }
    }
}
