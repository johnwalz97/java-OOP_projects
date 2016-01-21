public class Pikachu extends Pokemon{
    public static final int POKEMON_NUMBER = 25;
    public Pikachu(){
        super("Pikachu", new Move[3], ElementType.ELECTRIC);
        Move quickAttack = new Move("Quick Attack", ElementType.NORMAL, 8, 100);
        setMove(0, quickAttack);
        Move thunderShock = new Move("Thunder Shock", ElementType.ELECTRIC, 11, 90);
        setMove(1, thunderShock);
        Move thunderBolt = new Move("Thunder Bolt", ElementType.ELECTRIC, 50, 25);
        setMove(2, thunderBolt);
    }
}