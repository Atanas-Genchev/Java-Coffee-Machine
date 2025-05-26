public class CoffeeMachine {
    private int teaGrams;
    private int waterMl;
    private int cocoaGrams;
    private int milkGrams;
    private int coffeeGrams;
    private int cupsCount;
    private double credit = 0.0;
    private Product [] products = new Product[20];
    private Coins [] coins = new Coins[8];

    public CoffeeMachine(Product [] products, Coins [] coins, int waterMl, int milkGrams, int coffeeGrams, int cocoaGrams, int teaGrams, int cupsCount){
        this.products = products;
        this.coins = coins;
        this.waterMl = waterMl;
        this.milkGrams = milkGrams;
        this.cocoaGrams = cocoaGrams;
        this.coffeeGrams = coffeeGrams;
        this.teaGrams = teaGrams;
        this.cupsCount = cupsCount;
    }

    public double getCredit() {return credit;}

    public void buyProduct(int index){
        if(index > 19 || index < 0){
            System.out.println("Please choose a valid product form 1-20");
            return;
        }
        if(credit < products[index].getPrice()){
            System.out.println("Low Credit");
            return;
        }
        if(makeProduct(products[index])) {
            System.out.println("Enjoy");
            returnMoney(credit - products[index].getPrice());
        }else{
            returnMoney(credit);
        }

    }

    public boolean makeProduct(Product product) {
        if (cupsCount < 1){
            System.out.println("out of cups");
            return false;
        }

        switch (product.getTYPE()) {

            case "Tea":
                Tea tea = (Tea) product;
                if (teaGrams >= tea.getTeaGrams() && waterMl >= tea.getWaterMl()) {

                    teaGrams -= tea.getTeaGrams();
                    waterMl -= tea.getWaterMl();
                    System.out.println("Dispensing " + tea.getName());
                    cupsCount -= 1;
                    return true;

                } else {
                    System.out.println("Not enough ingredients for " + tea.getName());
                    return false;
                }

            case "Chocolate":
                Chocolate hotChoco = (Chocolate) product;
                if (cocoaGrams >= hotChoco.getCocoaGrams()
                        && waterMl >= hotChoco.getWaterMl()
                        && milkGrams >= hotChoco.getMilkGrams()) {

                    cocoaGrams -= hotChoco.getCocoaGrams();
                    waterMl -= hotChoco.getWaterMl();
                    milkGrams -= hotChoco.getMilkGrams();
                    cupsCount -= 1;
                    System.out.println("Dispensing " + hotChoco.getName());
                    return true;

                } else {
                    System.out.println("Not enough ingredients for " + hotChoco.getName());
                    return false;
                }
            case "Coffee":
                Coffee coffee = (Coffee) product;
                if (coffeeGrams >= coffee.getCoffeeGrams()
                        && waterMl >= coffee.getwaterMl()
                        && milkGrams >= coffee.getMilkGrams()){

                    coffeeGrams -= coffee.getCoffeeGrams();
                    waterMl -= coffee.getwaterMl();
                    milkGrams -= coffee.getMilkGrams();
                    cupsCount -= 1;
                    return true;

                }else{
                    System.out.println("Not enough ingredients for " + coffee.getName());
                    return false;
                }
            case "Cup":
                System.out.println("Here's a cup");
                cupsCount -= 1;
                return true;

            default:
                return false;
        }
    }

    public void returnMoney(double amount){
        if (amount == 0.00){
            return;
        }

        for (Coins coin : coins){
            while (amount >= coin.getValue() && coin.getValue() > 0){
                System.out.println("Dispensing coin $" + coin.getValue());
                amount -= coin.getValue();
                amount = (double) Math.round(amount * 100.0) / 100;
                coin.addQuantity(-1);
            }
        }
        credit = 0.00;
    }

    public void addCredit(double creditToAdd){
        for (Coins coin : coins){
            if (coin.getValue() == creditToAdd) {
                coin.addQuantity(1);
                this.credit += creditToAdd;
                return;
            }
        }
        System.out.println("Please enter a valid coin");
    }

    public void resupply(int waterMl, int milkGrams, int coffeeGrams, int cocoaGrams, int teaGrams, int cupsCount){
        this.waterMl = waterMl;
        this.milkGrams = milkGrams;
        this.cocoaGrams = cocoaGrams;
        this.coffeeGrams = coffeeGrams;
        this.teaGrams = teaGrams;
        this.cupsCount = cupsCount;
    }
    public void coffeeMachineStatus() {
        System.out.println("Coffee Machine Status:");
        System.out.println("Water: " + waterMl + " ml");
        System.out.println("Milk: " + milkGrams + " grams");
        System.out.println("Coffee: " + coffeeGrams + " grams");
        System.out.println("Cocoa: " + cocoaGrams + " grams");
        System.out.println("Tea: " + teaGrams + " grams");
        System.out.println("Available Cups: " + cupsCount);
        System.out.printf("Credit: " + credit);

        System.out.println("Available Coins:");
        for (Coins coin : coins) {
            System.out.println(" - $" + coin.getValue() + ": " + coin.getQuantity() + " coins");
        }

    }
}
