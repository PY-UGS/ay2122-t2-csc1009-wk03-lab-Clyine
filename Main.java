import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double i = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int n = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double p = input.nextDouble();
        input.close();

        Loan loan = new Loan(i, n, p);

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        System.out.println("The loan was created on " + formatter.format(loan.getLoanDate()));
        System.out.println("The monthly payment is " + String.format("%.2f", loan.getMonthlyPayment()));
        System.out.println("The total payment is " + String.format("%.2f", loan.getTotalPayment()));
    }

}
