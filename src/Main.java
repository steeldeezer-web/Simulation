public class Main {
    public static void main(String[] args) {
        Simulation sim = new Simulation(10, 10);

        // Создаём объекты
        sim.addCreature(new Herbivore(new Coordinate(3, 3), 1, 10, sim.getMap()));
        sim.addCreature(new Predator(new Coordinate(0, 0), 1, 15, 3, sim.getMap()));

        // Добавляем ресурсы и препятствия
        sim.getMap().addEntity(new Grass(new Coordinate(7, 7)));
        sim.getMap().addEntity(new Rock(new Coordinate(5, 5)));
        sim.getMap().addEntity(new Tree(new Coordinate(2, 8)));

        sim.startSimulation(20);
    }
}