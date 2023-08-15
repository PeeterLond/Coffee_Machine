package machine;

import java.util.Scanner;

public class CoffeeMaker {

    public void buyCoffee(Inventory inventory, Scanner scanner) throws Exception {
        Drinks drink = getDrinkType(scanner);
        validateIfEnoughIngredientsToMakeCoffee(inventory, drink);
        makeCoffee(drink, inventory);

    }

    private Drinks getDrinkType(Scanner scanner) throws Exception {
        int drinkNr = validateDrinkOption(scanner);
        Drinks[] drinks = Drinks.values();
        Drinks drinkType = null;
        for (Drinks drink : drinks) {
            if (drink.getDrinkNr() == drinkNr) {
                drinkType = drink;
            }
        }
        return drinkType;
    }

    private int validateDrinkOption(Scanner scanner) throws Exception {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 cappuccino, back - to main menu:");
        String inputOption = scanner.nextLine();
        if (inputOption.equals("back")) {
            throw new Exception("");
        }
        return Integer.parseInt(inputOption);
    }

    private void validateIfEnoughIngredientsToMakeCoffee(Inventory inventory, Drinks drink) throws Exception {
        int remainingWater = inventory.getWater() - drink.getWater();
        int remainingMilk = inventory.getMilk() - drink.getMilk();
        int remainingBeans = inventory.getCoffeeBeans() - drink.getBeans();
        int remainingCups = inventory.getCups() - drink.getCups();
        if (remainingWater < 0) {
            throw new Exception("Sorry, not enough water!\n");
        }
        if (remainingMilk < 0) {
            throw new Exception("Sorry, not enough milk!\n");
        }
        if (remainingBeans < 0) {
            throw new Exception("Sorry, not enough beans!\n");
        }
        if (remainingCups < 0) {
            throw new Exception("Sorry, not enough cups\n");
        }
    }

    private void makeCoffee(Drinks drink, Inventory ingredients) {
        System.out.println("I have enough resources, making you a coffee!\n");
        ingredients.setWater(ingredients.getWater() - drink.getWater());
        ingredients.setMilk(ingredients.getMilk() - drink.getMilk());
        ingredients.setCoffeeBeans(ingredients.getCoffeeBeans() - drink.getBeans());
        ingredients.setCups(ingredients.getCups() - drink.getCups());
        ingredients.setMoney(ingredients.getMoney() + drink.getCost());
    }
}

