public class Chocolate extends Product {
    private int cocoaGrams;
    private int waterMl;
    private int milkGrams;


    public Chocolate(String name, double price, int cocoaGrams, int waterMl, int milkGrams) {
        super(name, price, "Chocolate");
        this.cocoaGrams = cocoaGrams;
        this.waterMl = waterMl;
        this.milkGrams = milkGrams;
    }

    //Getters
    public int getCocoaGrams() {return cocoaGrams;}
    public int getWaterMl() {return waterMl;}
    public int getMilkGrams() {return milkGrams;}
    //Setters
    public void setCocoaGrams(int cocoaGrams) {this.cocoaGrams = cocoaGrams;}
    public void setWaterMl(int waterMl) {this.waterMl = waterMl;}
    public void setMilkGrams(int milkGrams) {this.milkGrams = milkGrams;}
}
