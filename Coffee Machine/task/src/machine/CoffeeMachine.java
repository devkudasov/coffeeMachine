package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine coffeeMachine = new Machine();

        while (true) {
            coffeeMachine.process(scanner.nextLine());
        }
    }
}
