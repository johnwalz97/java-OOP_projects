public class Charmander extends Pokemon{
    public static final int POKEMON_NUMBER = 4;
    public Charmander(){
        super("Charmander", new Move[3], ElementType.FIRE);
        Move growl = new Move("Growl", ElementType.NORMAL, 10, 90);
        setMove(0, growl);
        Move scratch = new Move("Scratch", ElementType.NORMAL, 8, 100);
        setMove(1, scratch);
        Move ember = new Move("Ember", ElementType.FIRE, 17, 80);
        setMove(2, ember);
    }
}