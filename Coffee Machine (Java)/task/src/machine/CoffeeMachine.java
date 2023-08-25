package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        MoneyHandler moneyHandler = new MoneyHandler();
        boolean isOn= true;
        System.out.println("Hello and welcome to the CoffeeMachine.\n");
        while (isOn) {
            try {
                System.out.println("Write an action (buy, fill, take, remaining, exit):");
                String actionInput = scanner.nextLine();
                if (actionInput.equals("exit")) {
                    isOn = false;
                }
                if (actionInput.equals("remaining")) {
                    inventory.printTotalIngredients(inventory);
                }
                switch (actionInput) {
                    case "buy" :
                        coffeeMaker.buyCoffee(inventory, scanner, moneyHandler);
                        break;
                    case "fill":
                        inventory.addIngredients(inventory, scanner);
                        break;
                    case "take":
                        moneyHandler.withdrawMoneyFromTheMachine(inventory, scanner);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}