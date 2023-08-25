package machine;

public class ValidationService {

    public static int validateAndReturnDrink(String inputOption) throws Exception {
        int validatedInput = validateAndReturnCorrectInput(inputOption);
        validateMenuNumberRange(validatedInput);
        if (inputOption.equals("back")) {
            throw new Exception("");
        }
        return validatedInput;
    }

    private static int validateAndReturnCorrectInput(String inputOption) throws Exception {
        try {
            return Integer.parseInt(inputOption);
        } catch (NumberFormatException e) {
            throw new Exception("Please enter a number");
        }
    }

    private static void validateMenuNumberRange(int parseInt) throws Exception {
        int nrOfDrinks = Drinks.values().length;
        if (parseInt < 1 || parseInt > nrOfDrinks) {
            throw new Exception("Please enter a correct number from the list");
        }
    }

    public static void validateIfEnoughIngredientsToMakeCoffee(Inventory inventory, Drinks drink) throws Exception {
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

    public static int validateCorrectMoney(String inputMoney) throws Exception {
        int validatedNumber = validateAndReturnCorrectInput(inputMoney);
        if (!areBillsCorrect(validatedNumber)) {
            throw new Exception("Please input the correct bills to the machine");
        }
        return validatedNumber;

    }

    private static boolean areBillsCorrect(int validatedNumber) {
        switch (validatedNumber) {
            case 1:
            case 2:
            case 5:
            case 10:
            case 20:
                return true;
        }
        return false;
    }

    public static void validateWithdrawAmount(int inventoryMoney, int withdrawAmount) throws Exception {
        if (withdrawAmount > inventoryMoney) {
            throw new Exception("You can't withdraw more than the machine has.");
        }
    }
}
