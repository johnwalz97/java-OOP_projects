public class Squirtle extends Pokemon{
    public static final int POKEMON_NUMBER = 7;
    public Squirtle(){
        super("Squirtle", new Move[3], ElementType.WATER);
        Move tailWhip = new Move("Tail Whip", ElementType.NORMAL, 9, 95);
        setMove(0, tailWhip);
        Move waterGun = new Move("Water Gun", ElementType.WATER, 8, 100);
        setMove(1, waterGun);
        Move bubble = new Move("Bubble", ElementType.WATER, 25, 70);
        setMove(2, bubble);
    }
}