public class Converter {

    static int convertToKm(int steps) {
        return (steps * 75) / 100000;
    }

    static int convertToKilocalories(int steps) {
        return (steps * 50) / 1000;
    }
}
