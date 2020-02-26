package bankaccountapp;

public class CheckingAcc extends Account{
    private int debitCardNo;
    private int debitCardPin;
    
    public CheckingAcc(String name, String socSecNo, double initDeposit)  {
        super(name, socSecNo, initDeposit);
        accNo = "2" + accNo;
        setDebitCard();
    }
    
    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;
    }
    
    private void setDebitCard() {
        debitCardNo =(int) (Math.random() * Math.pow(10,12));
        debitCardPin = (int) (Math.random() * Math.pow(10,4));
    }
    
    public void showInfo(){
        super.showInfo();
        System.out.println("Your checking account info: " + 
            "\n Debit card no: " + debitCardNo + 
             "\n Debit card PIN: " + debitCardPin 
             );
    }
}