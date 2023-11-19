package app;

import java.util.Scanner;

public class Main01 {
    private static final String CURRENCY = "EUR";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the price in " + CURRENCY + ": ");
        double orderSum = Double.parseDouble(scanner.nextLine().replace(",", "."));

        float discountPercent = calculateDiscountPercent((float) orderSum);
        float orderSumToPayment = calculateOrderSumToPayment((float) orderSum, discountPercent);
        float totalAmountEUR = (float) orderSum - orderSumToPayment;

        displayOrderInfo((float) orderSum, orderSumToPayment, discountPercent, totalAmountEUR);
        scanner.close();
    }
    private static float calculateDiscountPercent(float orderSum) {
        if (orderSum <= 5000) {
            return 5.0f;
        } else if (orderSum <= 10000) {
            return 10.0f;
        } else {
            return 15.0f;
        }
    }
    private static float calculateOrderSumToPayment(float orderSum, float discountPercent) {
        return orderSum * (discountPercent / 100);
    }
    private static void displayOrderInfo(float orderSum, float orderSumToPayment, float discountPercent, float totalAmountEUR) {
        System.out.printf("Total price: %.2f %s%n", orderSum, CURRENCY);
        System.out.printf("Discount amount: %.2f %s (%.2f%%)%n", orderSumToPayment, CURRENCY, discountPercent);
        System.out.printf("Amount to pay: %.2f %s%n", totalAmountEUR, CURRENCY);
    }
}