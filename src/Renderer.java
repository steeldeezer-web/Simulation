// Рендерер для вывода консоли
class Renderer {
    private final WorldMap map;
    public Renderer(WorldMap map) { this.map = map; }

    public void render() {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Coordinate c = new Coordinate(x, y);
                Entity e = map.getEntityAt(c);
                if (e == null) System.out.print(". ");
                else if (e instanceof Herbivore) System.out.print("H ");
                else if (e instanceof Predator) System.out.print("P ");
                else if (e instanceof Grass) System.out.print("g ");
                else if (e instanceof Rock) System.out.print("r ");
                else if (e instanceof Tree) System.out.print("t ");
                else System.out.print("? ");
            }
            System.out.println();
        }
        System.out.println();
    }
}