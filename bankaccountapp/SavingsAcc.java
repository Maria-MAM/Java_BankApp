package bankaccountapp;

public class SavingsAcc extends Account{
    private int safetyDepBoxID;
    private int safetyDepBoxKey;
    
    public SavingsAcc(String name, String socSecNo, double initDeposit) {
        super(name, socSecNo, initDeposit);
        accNo = "1" + accNo;
        setSafetyDepBox();
    }
    
    @Override
    public void setRate() {
        rate = getBaseRate()-0.25;
    }
    
    private void setSafetyDepBox() {
        safetyDepBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }
    
    public void showInfo(){
        super.showInfo();
        System.out.println("Your savings account features: " + 
            "\n Safety deposit box ID: " + safetyDepBoxID + 
            "\n Safety deposit box key: " + safetyDepBoxKey
            );
    }
}