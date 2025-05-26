public class Coffee extends Product{
    private int coffeeGrams;
    private int waterMl;
    private int milkGrams;


    public Coffee(String name, double price, int coffeeGrams, int waterMl, int milkGrams) {
        super(name, price, "Coffee");
        this.coffeeGrams = coffeeGrams;
        this.waterMl = waterMl;
        this.milkGrams = milkGrams;
    }

    //Getters
    public int getCoffeeGrams() {return coffeeGrams;}
    public int getwaterMl() {return waterMl;}
    public int getMilkGrams() {return milkGrams;}
    //Setters
    public void setCoffeeGrams(int coffeeGrams) {this.coffeeGrams = coffeeGrams;}
    public void setwaterMl(int waterMl) {this.waterMl = waterMl;}
    public void setMilkGrams(int milkGrams) {this.milkGrams = milkGrams;}
}
