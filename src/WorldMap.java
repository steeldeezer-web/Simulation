class WorldMap {
  private final int width;
  private final int height;

  public WorldMap(int width, int height){
      this.height = width;
      this.width = width;
  }
  public boolean isWithinBounds(int x, int y){
      return x >=0 && y >= 0 && x < width && y < height;
  }
  public boolean isWithinBounds(Coordinate coord){
      return isWithinBounds(coord.getX(), coord.getY());
  }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
