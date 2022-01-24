import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate = new Date(System.currentTimeMillis());

    public Loan(double i, int period, double principal){
        annualInterestRate = i;
        numberOfYears = period;
        loanAmount = principal;
        loanDate = new Date(System.currentTimeMillis());
    }

    public Loan(){
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 1000;
        loanDate = new Date(System.currentTimeMillis());
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }

    public double getLoanAmount(){
        return loanAmount;
    }

    public Date getLoanDate(){
        return loanDate;
    }

    public void setAnnualInterestRate(double i){
        annualInterestRate = i; 
    }

    public void setNumberOfYears(int i){
        numberOfYears = i;
    }

    public void setLoanAmount(double i){
        loanAmount = i;
    }

    public double getMonthlyPayment(){
        double n = loanAmount*(annualInterestRate/100/12);
        double d = 1 - Math.pow(Math.pow(1+annualInterestRate/100/12, numberOfYears*12),-1);
        return n/d;
    }

    public double getTotalPayment(){
        double ans = getMonthlyPayment() * numberOfYears * 12;
        return ans;
    }

    public static void main(String[] args){
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
        System.out.println("The loan was created on " + formatter.format(loan.loanDate));
        System.out.println("The monthly payment is " + String.format("%.2f",loan.getMonthlyPayment()));
        System.out.println("The total payment is " + String.format("%.2f",loan.getTotalPayment()));
    }
}