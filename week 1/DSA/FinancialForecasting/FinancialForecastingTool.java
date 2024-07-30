
/* Recursion is a programming technique where a function calls itself in order to solve a problem. A recursive function typically has two main components */
import java.util.HashMap;
import java.util.Map;

public class FinancialForecastingTool {

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double predictFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double futureValue = predictFutureValue(initialValue, growthRate, periods - 1) * (1 + growthRate);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double initialValue = 1160.0;
        double annualGrowthRate = 0.09;
        int years = 10;

        double futureValue = predictFutureValue(initialValue, annualGrowthRate, years);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue);
    }
}
