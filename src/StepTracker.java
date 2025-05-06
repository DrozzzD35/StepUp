import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData;
    Scanner scanner;
    int goalByStepsPerDay;


    StepTracker(Scanner scanner) {
        this.monthToData = new MonthData[12];
        this.scanner = scanner;
        this.goalByStepsPerDay = 10000;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        Integer month = getMonthFromUser();
        if (month == null) return;
        Integer daysOfMonth = getDayFromUser();
        if (daysOfMonth == null) return;
        Integer stepsOfDays = getStepsFromUser();
        if (stepsOfDays == null) return;

        // Находим месяц
        MonthData monthData = monthToData[month];

        // TODO подумать
//        int day = monthData.days[daysOfMonth];
//        day = stepsOfDays;

        // Находим день и записываем в него шаги
        monthData.days[daysOfMonth] = stepsOfDays;
    }

    private Integer getStepsFromUser() {
        System.out.println("Введите количество шагов: ");
        int stepsOfDays = scanner.nextInt();
        if (stepsOfDays < 0) {
            System.out.println("Шаги не могут быть отрицательными!");
            return null;
        }
        return stepsOfDays;
    }

    private Integer getDayFromUser() {
        System.out.println("Введите день месяца (1-30):");
        int daysOfMonth = scanner.nextInt();
        if (daysOfMonth < 1 || daysOfMonth > 30) {
            System.out.println("Некорректное значение дня");
            return null;
        }
        return daysOfMonth - 1;
    }

    private Integer getMonthFromUser() {
        System.out.println("Введите номер месяца (1-12):");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Некорректное значение месяца");
            return null;
        }
        return month - 1;
    }


    void changeStepGoal() {
        System.out.println("Введите новую цель шагов:");
        int newGoal = scanner.nextInt();
        if (newGoal > 0) {
            goalByStepsPerDay = newGoal;
        } else {
            System.out.println("Цель должна быть больше 0");
        }

    }

    void printStatistic() {
        Integer month = getMonthFromUser();
        if (month == null) return;

        MonthData monthData = monthToData[month];

        int sumSteps = monthData.sumStepsFromMonth();
        int maxSteps = monthData.maxSteps();
        double averageSteps = monthData.averageSteps();
        int bestSeries = monthData.bestSeries(goalByStepsPerDay);
        int km = Converter.convertToKm(sumSteps);
        int kilocalories = Converter.convertToKilocalories(sumSteps);

        System.out.println("Количество сделанных шагов " + sumSteps);
        System.out.println("Максимальное количество сделанных шагов " + maxSteps);
        System.out.println("Среднее количество шагов в день " + averageSteps);

        if (bestSeries == 1 || bestSeries == 21) {
            System.out.println("Цель достигнута в течении " + bestSeries + " дня");
        } else {
            System.out.println("Цель достигнута в течении " + bestSeries + " дней");
        }

        System.out.println("Пройдено километров: " + km);
        System.out.println("Потерянно калорий: " + kilocalories);
    }


}
