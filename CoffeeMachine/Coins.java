public class Coins {
    private double value;
    private int quantity;

    public Coins(double value, int quantity){
        this.value = value;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        if (this.quantity + quantity < 0) {
            this.quantity = 0;
        } else {
            this.quantity += quantity;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }

    }

    public void setValue(double value) {this.value = value;}


    public double getValue() {return value;}
    public int getQuantity() {return quantity;}
}
