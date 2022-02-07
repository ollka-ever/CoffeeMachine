package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int money = 550;
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        cm.selectAction();
    }

    public void selectAction() {
        String action = askForAction();


         while (!action.equals("exit")) {
            if (action.equals("take")) {
                take();
            } else if (action.equals("fill")) {
                fill();
            } else if (action.equals("buy")) {
                buy();
            } else if (action.equals("remaining")) {
                machineState();
            }
             System.out.println();
             action = askForAction();
        }
    }

    public String askForAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return sc.nextLine();
    }

    public void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String drink = scanner.nextLine();
        if (drink.equals("1")) {
            espresso();
        } else if (drink.equals("2")) {
            latte();
        } else if (drink.equals("3")) {
            cappuccino();
        } else if (drink.equals("back")) {
            return;
        }
    }

    public void espresso(){
        if (water - 250 >= 0 && coffeeBeans - 16 >= 0 && disposableCups - 1 >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffeeBeans -= 16;
            disposableCups--;
            money += 4;
        } else if (water - 250 < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (coffeeBeans - 16 < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void latte(){
        if (water - 350 >= 0 && milk - 75 >= 0 && coffeeBeans - 20 >= 0 && disposableCups - 1 >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            disposableCups--;
            money += 7;
        } else if (water - 350 < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (milk - 75 < 0) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans - 20 < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void cappuccino(){
        if (water - 200 >= 0 && milk - 100 >= 0 && coffeeBeans - 12 >= 0 && disposableCups - 1 >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            disposableCups--;
            money += 6;
        } else if (water - 200 < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (milk - 100 < 0) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeans - 12 < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (disposableCups - 1 < 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void machineState() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}


