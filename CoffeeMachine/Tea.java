public class Tea extends Product{
    private int teaGrams;
    private int waterMl;

    public Tea(String name, double price, int teaGrams, int waterMl) {
        super(name, price, "Tea");
        this.teaGrams =  teaGrams;
        this.waterMl = waterMl;
    }

    //Getters
    public int getTeaGrams() {return teaGrams;}
    public int getWaterMl() {return waterMl;}
    //Setters
    public void setWaterMl(int waterMl) {this.waterMl = waterMl;}
    public void setTeaGrams(int teaGrams) {this.teaGrams = teaGrams;}
}
