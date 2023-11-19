package app;

import java.util.Scanner;

public class Main01 {

    private static final String CURRENCY = "EUR";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the price in " + CURRENCY + ": ");
        double orderSum = Double.parseDouble(scanner.nextLine().replace(",", "."));

        double discountPercent = calculateDiscountPercent(orderSum);
        double orderSumToPayment = calculateOrderSumToPayment(orderSum, discountPercent);
        double totalAmountEUR = orderSum - orderSumToPayment;

        displayOrderInfo(orderSum, orderSumToPayment, discountPercent, totalAmountEUR);
        scanner.close();
    }

    private static double calculateDiscountPercent(double orderSum) {
        if (orderSum <= 5000) {
            return 5.0;
        } else if (orderSum <= 10000) {
            return 10.0;
        } else {
            return 15.0;
        }
    }

    private static double calculateOrderSumToPayment(double orderSum, double discountPercent) {
        return orderSum * (discountPercent / 100);
    }

    private static void displayOrderInfo(double orderSum, double orderSumToPayment,
                                         double discountPercent, double totalAmountEUR)
    {
        System.out.printf("Total price: %.2f %s%nDiscount amount: %.2f %s (%.2f%%)%nAmount to pay: %.2f %s%n",
                orderSum, CURRENCY, orderSumToPayment, CURRENCY, discountPercent, totalAmountEUR, CURRENCY);
    }
}