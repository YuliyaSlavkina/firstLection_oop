import java.util.Random;

public class BaseHero {
    protected static int number;  // protected значит доступно в рамках текущего класса и всех наследников
    protected static Random r;

    protected String name;
    protected int hp;
    protected int maxHp;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public BaseHero(String name, int hp) {  //конструктор отвечает за инициализацию именя и запас здоровья
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero() { //конструктор по умолчанию
        this(String.format("Hero_Priest #%d", ++BaseHero.number),
                BaseHero.r.nextInt(100, 200));
    }

    public String getInfo() {  //метод получения информации
        return String.format("Name: %s  Hp: %d  Type: %s",
                this.name, this.hp, this.getClass().getSimpleName());
    }

    public void healed(int Hp) {  //метод лечения
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    public void GetDamage(int damage) {  // метод получения атаки
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }
}