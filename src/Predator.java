import java.util.*;

class Predator extends Creature {
    private int attackPower;

    public Predator(Coordinate pos, int speed, int health, int attackPower, WorldMap map) {
        super(pos, speed, health, "Predator", map);
        this.attackPower = attackPower;
    }

    @Override
    void makeMove(Simulation sim) {
        // Ищем ближайшего травоядного (жертву)
        List<Coordinate> pathToPrey = PathFinder.findPathToNearestEntity(
                position, sim.getMap(), Herbivore.class);
        if (pathToPrey != null && pathToPrey.size() > 1) {
            Coordinate nextStep = pathToPrey.get(1);
            Entity target = sim.getMap().getEntityAt(nextStep);
            if (target instanceof Herbivore) {
                // Если соседняя клетка с травоядным - атакуем
                ((Creature) target).reduceHealth(attackPower);
                if (!((Creature) target).isAlive()) {
                    sim.removeCreature((Creature) target);
                    sim.getMap().removeEntity(target);
                }
            } else if (sim.getMap().isSpotFree(nextStep)) {
                // Иначе ходим туда
                sim.moveCreature(this, nextStep);
            }
        }
    }
}
