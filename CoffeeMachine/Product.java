public class Product {
    private String name;
    private double price;
    private final String TYPE;

    public Product(String name, double price, String TYPE){
        this.name = name;
        this.price = price;
        this.TYPE = TYPE;
    }

    //Getters
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}


    //Setters
    public String getName() {return name;}
    public double getPrice() {return price;}
    public String getTYPE() {return TYPE;}
}
