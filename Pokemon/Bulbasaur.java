public class Bulbasaur extends Pokemon{
    public static final int POKEMON_NUMBER = 1;
    public Bulbasaur(){
        super("Bulbasaur", new Move[3], ElementType.GRASS);
        Move tackle = new Move("Tackle", ElementType.NORMAL, 12, 80);
        setMove(0, tackle);
        Move leechSeed = new Move("Leech Seed", ElementType.GRASS, 15, 80);
        setMove(1, leechSeed);
        Move vineWhip = new Move("Vine Whip", ElementType.GRASS, 30, 60);
        setMove(2, vineWhip);
    }
}