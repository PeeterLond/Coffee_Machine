package machine;

import java.util.Scanner;

public class Inventory {
    private int water = 500;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int cups = 10;
    private int money = 100;

    public void addIngredients(Inventory inventory, Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int waterToAdd = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        int milkToAdd = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        int cupsToAdd = Integer.parseInt(scanner.nextLine());
        inventory.setWater(inventory.getWater() + waterToAdd);
        inventory.setMilk(inventory.getMilk() + milkToAdd);
        inventory.setCoffeeBeans(inventory.getCoffeeBeans() + beans);
        inventory.setCups(inventory.getCups() + cupsToAdd);
    }

    public void printTotalIngredients(Inventory inventory) {
        System.out.println("The coffee machine has:");
        System.out.println(inventory.getWater() + " ml of water");
        System.out.println(inventory.getMilk() + " ml of milk");
        System.out.println(inventory.getCoffeeBeans() + " g of coffee beans");
        System.out.println(inventory.getCups() + " disposable cups");
        System.out.println("$" + inventory.getMoney() + " of money");
        System.out.println();
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
