
import java.util.Scanner;

public class EmployeeSalaryCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter hourly rate: ");
        double hourlyRate = scanner.nextDouble();

        System.out.print("Enter number of hours worked per week: ");
        double hoursWorkedPerWeek = scanner.nextDouble();

        // Constants
        final int REGULAR_HOURS = 40;
        final double OVERTIME_RATE = 1.5;
        final double TAX_RATE = 0.10;
        final int WEEKS_IN_MONTH = 4;

        // Calculate weekly salary
        double weeklySalary;
        if (hoursWorkedPerWeek <= REGULAR_HOURS) {
            weeklySalary = hoursWorkedPerWeek * hourlyRate;
        } else {
            double overtimeHours = hoursWorkedPerWeek - REGULAR_HOURS;
            weeklySalary = (REGULAR_HOURS * hourlyRate) + (overtimeHours * hourlyRate * OVERTIME_RATE);
        }

        // Monthly salary before tax
        double grossMonthlySalary = weeklySalary * WEEKS_IN_MONTH;

        // Deduct tax
        double taxAmount = grossMonthlySalary * TAX_RATE;
        double netMonthlySalary = grossMonthlySalary - taxAmount;

        // Output
        System.out.printf("Gross Monthly Salary: ₹%.2f%n", grossMonthlySalary);
        System.out.printf("Tax Deducted (10%%): ₹%.2f%n", taxAmount);
        System.out.printf("Net Monthly Salary: ₹%.2f%n", netMonthlySalary);

        scanner.close();
    }
}

