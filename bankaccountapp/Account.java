package bankaccountapp;

public abstract class Account implements IBaseRate{
    private String name;
    private String socSecNo;
    private double balance;
    protected String accNo;
    protected double rate;
    private static int index = 10000;
    
    public Account(String name, String socSecNo, double initDeposit){
        this.name = name;
        this.socSecNo = socSecNo;
        balance = initDeposit;
        index++;
        this.accNo = setAccountNo();
        setRate();
    }
    
    public abstract void setRate();
    
    private String setAccountNo () {
        String lastTwoOfsocSecNo = socSecNo.substring(socSecNo.length()-2, socSecNo.length());
        int uniqueID = index;
        int randNo = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfsocSecNo + uniqueID + randNo;
    }
    
    public void compound() {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued interest: " + accruedInterest);
        printBalance();
    }
    
    public void deposit(double amount) {
        balance = balance + amount;
        printBalance();
    }
    
    public void withdraw(double amount) {
        balance = balance - amount;
        printBalance();
    }
    
    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }
    
    public void printBalance () {
        System.out.println("Your balance is now : $" + balance);
    }
    public void showInfo() {
        System.out.println("Name: " + name + "\nacc no: " + accNo + 
            "\nbalance: " + balance + "\n rate: " + rate + "%");
    }
}
