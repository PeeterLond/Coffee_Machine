package machine;

import java.util.Scanner;

public class CoffeeMaker {


    public void buyCoffee(Inventory inventory, Scanner scanner, MoneyHandler moneyHandler) throws Exception {
        printDrinkMenu();
        Drinks drink = getDrinkType(scanner);
        ValidationService.validateIfEnoughIngredientsToMakeCoffee(inventory, drink);
        moneyHandler.handleCustomerMoney(drink, scanner);
        makeCoffee(drink, inventory);

    }

    private static void printDrinkMenu() {
        System.out.println("Here is the menu of drinks:");
        for (Drinks drink : Drinks.values()) {
            System.out.println(drink.getDrinkNr() + ". - " + drink.name().toLowerCase() + " - €" + drink.getCost());
        }
        System.out.println("\nEnter the number of drink you wish to buy or 'back' to return to main menu. ");
    }

    private Drinks getDrinkType(Scanner scanner) throws Exception {
        String inputOption = scanner.nextLine();
        int drinkNr = ValidationService.validateAndReturnDrink(inputOption);
        Drinks[] drinks = Drinks.values();
        Drinks drinkType = null;
        for (Drinks drink : drinks) {
            if (drink.getDrinkNr() == drinkNr) {
                drinkType = drink;
            }
        }
        return drinkType;
    }

    private void makeCoffee(Drinks drink, Inventory ingredients) {
        System.out.println("Here is your drink. Enjoy and come again.\n");
        ingredients.setWater(ingredients.getWater() - drink.getWater());
        ingredients.setMilk(ingredients.getMilk() - drink.getMilk());
        ingredients.setCoffeeBeans(ingredients.getCoffeeBeans() - drink.getBeans());
        ingredients.setCups(ingredients.getCups() - drink.getCups());
        ingredients.setMoney(ingredients.getMoney() + drink.getCost());
    }
}

