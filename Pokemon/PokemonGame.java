public class PokemonGame{
    public static void main(String[] args){
        Pokemon.startSong();
        Pikachu pikachu = new Pikachu();
        Charmander charmander = new Charmander();
        System.out.println(charmander.getHealth());
        pikachu.attack(0, charmander);
        System.out.println(charmander.getHealth());
    }
}