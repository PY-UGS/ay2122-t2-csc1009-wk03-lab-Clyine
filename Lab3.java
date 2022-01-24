import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate = new Date(System.currentTimeMillis());

    public Loan(double i, int period, double principal){
        this.annualInterestRate = i;
        this.numberOfYears = period;
        this.loanAmount = principal;
        this.loanDate = new Date(System.currentTimeMillis());
    }

    public Loan(){
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
        this.loanDate = new Date(System.currentTimeMillis());
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public int getNumberOfYears(){
        return this.numberOfYears;
    }

    public double getLoanAmount(){
        return this.loanAmount;
    }

    public Date getLoanDate(){
        return this.loanDate;
    }

    public void setAnnualInterestRate(double i){
        this.annualInterestRate = i; 
    }

    public void setNumberOfYears(int i){
        this.numberOfYears = i;
    }

    public void setLoanAmount(double i){
        this.loanAmount = i;
    }

    public double getMonthlyPayment(){
        double n = this.loanAmount*(this.annualInterestRate/100/12);
        double d = 1 - Math.pow(Math.pow(1+this.annualInterestRate/100/12, this.numberOfYears*12),-1);
        return n/d;
    }

    public double getTotalPayment(){
        double ans = getMonthlyPayment() * this.numberOfYears * 12;
        return ans;
    }
}

class Main {
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
        System.out.println("The loan was created on " + formatter.format(loan.getLoanDate()));
        System.out.println("The monthly payment is " + String.format("%.2f",loan.getMonthlyPayment()));
        System.out.println("The total payment is " + String.format("%.2f",loan.getTotalPayment()));
    }
}