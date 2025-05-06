import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);


        while (true) {

            printMenu();
            System.out.println("Введите команду: ");
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 4) {
                System.out.println("Выход.");
                break;
            }
        }
    }

    static void printMenu() {
        System.out.println("1. Ввод шагов за день");
        System.out.println("2. Изменить цель шагов");
        System.out.println("3. Вывести статистику за месяц");
        System.out.println("4. Выйти");
    }
}
