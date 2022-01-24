import java.sql.Date;
public class Loan {
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

