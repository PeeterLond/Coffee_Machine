package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        boolean isOn= true;
        while (isOn) {
            try {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                String actionInput = scanner.nextLine();
                if (actionInput.equals("exit")) {
                    isOn = false;
                }
                if (actionInput.equals("remaining")) {
                    printTotalIngredients(inventory);
                }
                switch (actionInput) {
                    case "buy" :
                        coffeeMaker.buyCoffee(inventory, scanner);
                        break;
                    case "fill":
                        addIngredients(inventory, scanner);
                        break;
                    case "take":
                        withdrawMoneyFromTheMachine(inventory);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void withdrawMoneyFromTheMachine(Inventory inventory) {
        int withdrawMoney = inventory.getMoney();
        inventory.setMoney(0);
        System.out.println("I gave you $" + withdrawMoney);
    }

    private static void addIngredients(Inventory inventory, Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int water = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        int milk = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        int cups = Integer.parseInt(scanner.nextLine());
        inventory.setWater(inventory.getWater() + water);
        inventory.setMilk(inventory.getMilk() + milk);
        inventory.setCoffeeBeans(inventory.getCoffeeBeans() + beans);
        inventory.setCups(inventory.getCups() + cups);
    }

    private static void printTotalIngredients(Inventory inventory) {
        System.out.println("The coffee machine has:");
        System.out.println(inventory.getWater() + " ml of water");
        System.out.println(inventory.getMilk() + " ml of milk");
        System.out.println(inventory.getCoffeeBeans() + " g of coffee beans");
        System.out.println(inventory.getCups() + " disposable cups");
        System.out.println("$" + inventory.getMoney() + " of money");
        System.out.println();
    }
}