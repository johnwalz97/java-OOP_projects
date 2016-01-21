public class Move{
    private String name;
    private ElementType type;
    private int damage;
    private int accuracy;
    public Move(String newName, ElementType newType, int newDamage, int newAccuracy){
        name = newName;
        type = newType;
        damage = newDamage;
        accuracy = newAccuracy;
    }
    public String getName(){
        return name;
    }
    public ElementType getType(){
        return type;
    }
    public int getDamage(){
        return damage;
    }
    public int getAccuracy(){
        return accuracy;
    }
    public boolean didHit(){
        int chance = (int) Math.ceil(Math.random()*100);
        if(chance <= accuracy){
            return true;
        } else {
            return false;
        }
    }
}