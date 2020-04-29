package machine;

public class Machine {

    private State currentState = State.CHOOSE;

    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public Machine() {
        getMassage();
    }

    void getMassage() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    void process(String input) {
        switch (currentState) {
            case CHOOSE:
                switch (input) {
                    case "buy":
                        currentState = State.BUY;
                        System.out.print("What do you want to buy? ");
                        System.out.println("1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        break;
                    case "fill":
                        currentState = State.FILL_WATER;
                        System.out.println("Write how many ml of water do you want to add:");
                        break;
                    case "take":
                        takeAction();
                        getMassage();
                        break;
                    case "remaining":
                        checkState();
                        getMassage();
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                }
                break;
            case BUY:
                currentState = State.CHOOSE;
                buyAction(input);
                getMassage();
                break;
            case FILL_WATER:
                currentState = State.FILL_MILK;
                fillWater(Integer.parseInt(input));
                break;
            case FILL_MILK:
                currentState = State.FILL_BEANS;
                fillMilk(Integer.parseInt(input));
                break;
            case FILL_BEANS:
                currentState = State.FILL_CUPS;
                fillBeans(Integer.parseInt(input));
                break;
            case FILL_CUPS:
                currentState = State.CHOOSE;
                fillCups(Integer.parseInt(input));
                getMassage();
                break;
            default:
        }
    }

    private void buyAction(String coffee) {
        switch (coffee) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            default:
        }
    }

    private void makeCoffee(int water, int milk, int beans, int _money) {
        if (this.water < water) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.beans < beans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (this.cups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.money += _money;
            this.cups--;
        }
    }

    private void fillWater(int water) {
        this.water += water;

        System.out.println("Write how many ml of milk do you want to add:");
    }

    private void fillMilk(int milk) {
        this.milk += milk;

        System.out.println("Write how many grams of coffee beans do you want to add:");
    }

    private void fillBeans(int beans) {
        this.beans += beans;

        System.out.println("Write how many disposable cups of coffee do you want to add:");
    }

    private void fillCups(int cups) {
        this.cups += cups;
    }

    private void takeAction() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    private void checkState() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println("$" + this.money + " of money");
    }
}
