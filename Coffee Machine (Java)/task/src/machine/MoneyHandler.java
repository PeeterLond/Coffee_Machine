package machine;

import java.util.Scanner;

public class MoneyHandler {


    public void handleCustomerMoney(Drinks drink, Scanner scanner) throws Exception {
        int drinkCost = drink.getCost();
        System.out.println(drink.name().toLowerCase() + " costs €: " + drinkCost);
        int enteredAmount = 0;
        while (enteredAmount < drinkCost) {
            System.out.println("Insert the money. " +
                    "The machine accepts 1, 2, 5, 10 and 20 bills. Entered amount: " + enteredAmount);
            String inputMoney = scanner.nextLine();
            int correctAmount = ValidationService.validateCorrectMoney(inputMoney);
            enteredAmount += correctAmount;
        }
        if (enteredAmount > drinkCost) {
            int change = enteredAmount - drinkCost;
            System.out.println("Here is your change: €" + change);
        }
    }

    public void withdrawMoneyFromTheMachine(Inventory inventory, Scanner scanner) throws Exception {
        int inventoryMoney = inventory.getMoney();
        System.out.println("How much would you like to withdraw from the machine? It currently has €" + inventoryMoney);
        int withdrawAmount = Integer.parseInt(scanner.nextLine());
        ValidationService.validateWithdrawAmount(inventoryMoney, withdrawAmount);
        int moneyLeft = inventoryMoney - withdrawAmount;
        inventory.setMoney(moneyLeft);
        System.out.println("Here you go: € " + withdrawAmount + ". The machine has now : €" + moneyLeft);
    }
}
