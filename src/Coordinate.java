import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate c = (Coordinate) o;
        return x == c.x && y == c.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
        /*Этот метод использует встроенный статический метод Objects.hash, который принимает любое количество аргументов.
Метод internally создаёт массив из переданных значений и вычисляет хеш с помощью Arrays.hashCode.
Этот подход проще в написании, удобен для многих и разных типов полей.
Однако может быть чуть медленнее из-за создания массива и обхода элементов.*/
    }
    public void showDisplay(){
        System.out.println("Координата X: " + x);
        System.out.println("Координата Y: " + y);
    }
    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}