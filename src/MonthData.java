public class MonthData {
    int[] days = new int[30];

    int sumStepsFromMonth() {
        int sum = 0;
        for (int steps : days) {
            sum += steps;
        }
        return sum;
    }

    int maxSteps() {
        int max = 0;
        for (int steps : days) {
            if (steps > max) max = steps;
        }
        return max;
    }

    double averageSteps() {
        int sum = sumStepsFromMonth();
        return (double) sum / days.length;
    }

    int bestSeries(int goal) {
        int currentSeries = 0, bestSeries = 0;
        for (int steps : days) {
            if (steps >= goal) currentSeries++;
            else currentSeries = 0;
            bestSeries = Math.max(bestSeries, currentSeries);
        }
        return bestSeries;
    }

}
