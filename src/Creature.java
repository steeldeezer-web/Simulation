import java.util.List;
import java.util.UUID;

public abstract class Creature extends Entity{
    private int health;         // Значение здоровья существа
    private String name;        // Имя или идентификатор существа
    WorldMap worldMap;

    // Конструктор для инициализации начальных значений
    public Creature(Coordinate coordinate, UUID ID, int health, String name, WorldMap worldMap){
        super(coordinate,ID);
        this.health = health;
        this.name = name;
        this.worldMap = worldMap;
    }

    // Получить текущее здоровье
    public int getHealth() {
        return health;
    }

    //Проверка, жив ли объект (параметр health больше 0)?
    public boolean isAlive(){
        return health > 0;
    }

    //Уменьшить здоровье на заданное значение
    public void reduceHealth(int damage){
        health = Math.max(0, health - damage);
        /*из текущего значения здоровья (health) вычитается урон (damage),
         и результат сравнивается с 0 с помощью метода Math.max.
         Метод Math.max возвращает максимальное из двух чисел.
          Это гарантирует, что здоровье не станет меньше нуля
           — если результат вычитания отрицательный, вместо него установится 0.*/
    }
    public void causeDamage(Creature taregetCreature){
        System.out.println("Урон нанесен");
        taregetCreature.reduceHealth(1);

    }
    // Абстрактный метод: действие существа в ход симуляции — должен реализовать подкласс
    public abstract void act(List<Coordinate> coordinateListForTarget);

    @Override
    public String toString(){
        return name + " at " + coordinate + "(" + health + ")";
    }
}