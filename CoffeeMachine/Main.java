import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Input
        Scanner scanner = new Scanner(System.in);
        //Kapacitet na mashinata
        int waterMlCapacity = 6000;
        int teaGramsCapacity = 1000;
        int cocoaGramsCapacity = 2000;
        int milkGramsCapacity = 2000;
        int coffeeGramsCapacity = 3000;
        int cupsCapacity = 300;

        //Promenlivi za izbor
        double coinValue;
        int productNumber;
        String choice;

        Coins[] coinsInMachine = new Coins[]{
                new Coins(2.00, 20),
                new Coins(1.00,20),
                new Coins(0.50, 20),
                new Coins(0.20, 20),
                new Coins(0.10, 20),
                new Coins(0.05, 20),
                new Coins(0.02, 20),
                new Coins(0.01, 20)
        };

        Product[] products = new Product[]{
                new Coffee("Espresso", 1.00, 15, 100, 0),
                new Coffee("Americano", 1.50, 10, 150, 0),
                new Coffee("Latte", 2.00, 10, 100, 50),
                new Coffee("Cappuccino", 2.20, 12, 100, 50),
                new Coffee("2 in 1", 1.00, 10, 80, 40),
                new Coffee("Macchiato", 2.00, 12, 90, 20),
                new Coffee("Normal", 0.70, 10, 50, 0),
                new Coffee("Long", 0.80, 10, 80, 0),
                new Coffee("Affogato", 2.00, 10, 70, 30),
                new Coffee("Irish Coffee", 3.00, 12, 100, 50),
                new Coffee("Turkish Coffee", 2.70, 15, 60, 0),
                new Coffee("French Press", 1.75, 12, 75, 0),
                new Chocolate("Hot chocolate", 1.00, 20, 100, 0),
                new Chocolate("Cocoa and milk", 1.80, 25, 100, 15),
                new Chocolate("Hot chocolate with milk", 1.00, 18, 100, 10),
                new Chocolate("Double hot chocolate", 1.50, 40, 100, 0),
                new Chocolate("Double cocoa and milk", 1.30, 35, 100, 20),
                new Chocolate("Double hot chocolate with milk", 2.00, 25, 80, 55),
                new Tea("Green Tea", 1.00, 10, 200),
                new Product("Cup", 0.20, "Cup")
    };
        CoffeeMachine myMachine = new CoffeeMachine(products,coinsInMachine,waterMlCapacity,milkGramsCapacity,coffeeGramsCapacity,cocoaGramsCapacity,teaGramsCapacity,cupsCapacity);
        while (true) {
            System.out.println("Credit:$" + myMachine.getCredit());
            System.out.println("1. Show Products");
            System.out.println("2. Insert Coin");
            System.out.println("3. Buy a Product");
            System.out.println("4. Return money");
            System.out.println("5. Show Machine Status");
            System.out.println("6. Resupply The machine");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nAvailable Products:");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i].getName() + " - $" + products[i].getPrice());
                    }
                    break;

                case "2":
                    System.out.print("Enter coin value (2.00, 1.00, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01): ");
                    if (scanner.hasNextDouble()) {
                        coinValue = scanner.nextDouble();
                        scanner.nextLine();
                        myMachine.addCredit(coinValue);
                    } else {
                        System.out.println("Invalid input! write a value nothing else");
                        scanner.nextLine();
                    }
                    break;

                case "3":
                    System.out.print("Enter product number (1-20): ");
                    if (scanner.hasNextInt()){
                        productNumber = scanner.nextInt();
                        scanner.nextLine();
                        myMachine.buyProduct(productNumber - 1);
                    }else{
                        System.out.println("invalid input! write a whole number");
                        scanner.nextLine();
                    }
                    break;

                case "4":
                    myMachine.returnMoney(myMachine.getCredit());
                    break;

                case "5":
                    myMachine.coffeeMachineStatus();
                    break;

                case "6":
                    myMachine.resupply(waterMlCapacity,milkGramsCapacity,coffeeGramsCapacity,cocoaGramsCapacity,teaGramsCapacity,cupsCapacity);
                    break;

                case "7":
                    System.out.println("Chao");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}