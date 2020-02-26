package bankaccountapp;
import java.util.*;

public class BankAccApp{
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();
        
        String file = "/home/maria/BankApp/NewBankAccounts.csv";
        List<String[]> newCustomers = utilities.CSV.read(file);
        
        for (String[] customer : newCustomers) {
            String name = customer[0];
            String socSecNo = customer[1];
            String accType = customer[2];
            double initDeposit = Double.parseDouble(customer[3]);
            if (accType.equals("Savings")) {
                accounts.add(new SavingsAcc(name, socSecNo, initDeposit));
            } else if (accType.equals("Checking")) {
                accounts.add(new CheckingAcc(name, socSecNo, initDeposit));
            } else System.out.println("Error reading account type!");
        }   
        
        for (Account acc : accounts) {
            System.out.println("\n*******************");
            acc.showInfo();
        }
    }
}
