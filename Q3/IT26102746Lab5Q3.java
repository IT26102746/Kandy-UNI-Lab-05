
import java.util.Scanner;

public class IT26102746Lab5Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double ROOM_CHARGE = 48000.00;
        final double DISCOUNT_10 = 0.10;
        final double DISCOUNT_20 = 0.20;

        int startDate, endDate, daysReserved;
        double totalAmount, discountRate = 0.0;

        System.out.print("Enter start date (day): ");
        startDate = input.nextInt();

        System.out.print("Enter end date (day): ");
        endDate = input.nextInt();

        // Validation 1
        if (startDate < 1 || startDate > 31 ||
            endDate < 1 || endDate > 31) {
            System.out.println("Error: Start date and end date must be between 1 and 31.");
            input.close();
            return;
        }

        // Validation 2
        if (startDate >= endDate) {
            System.out.println("Error: Start date should be less than end date.");
            input.close();
            return;
        }

        daysReserved = endDate - startDate;

        // Calculate discount rate
        if (daysReserved >= 5) {
            discountRate = DISCOUNT_20;
        } else if (daysReserved >= 3) {
            discountRate = DISCOUNT_10;
        }

        // Calculate total amount
        totalAmount = daysReserved * ROOM_CHARGE;
        totalAmount = totalAmount - (totalAmount * discountRate);

        System.out.println("Number of days reserved: " + daysReserved);
        System.out.printf("Discount rate: %.0f%%%n", discountRate * 100);
        System.out.printf("Total amount to be paid: Rs. %.2f%n", totalAmount);

        input.close();
    }
}
