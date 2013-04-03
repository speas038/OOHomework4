package act.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import act.view.AccountView;


public class AccountModel extends AbstractModel{
	
	public PriorityQueue<Account> accounts = new PriorityQueue<Account>(100, new AccountComparator());
	public static final double EURO = 0.77;
	public static final double YEN = 93.57;
	public static final double USD = 1.0;
	private double currentRate = USD;
	
	public void setcurrentRate(String selection){
		if(selection == AccountView.EUROS){
			currentRate = EURO;
		}else if(selection == AccountView.USD){
			currentRate = USD;
		}else if(selection == AccountView.YEN){
			currentRate = YEN;
		}
		
		System.out.println("Current Rate changed to " + currentRate);
	}

	public AccountModel(String [] args){
		readAccounts(args[0]);
	}
	
	public void usd(){
		System.out.println("USD model code executed");
	}
	
	public void changeUSD(){
		System.out.println("CHANGE USD");
	}
	
	public void euros(){
		System.out.println("EURO model code executed");
	}
	
	public void yen(){
		System.out.println("YEN model code executed");
	}
	
	public void save(){
		System.out.println("SAVE model code executed");
	}
	
	public void exit(){
		System.out.println("System exit code");
	}
	
	
	/**
	 * readAccounts is for the initialization of the JComboBox that holds the accounts.
	 * 
	 * @param args
	 * @return String []
	 */
	private void readAccounts(String input){
		
        // Location of file to read
        File file = new File(input);
        String [] temp;
        int ID;
        String name;
        double balance;
                
        try {
            Scanner scanner = new Scanner(file);
 
            while (scanner.hasNextLine()) {
                temp = ((String)scanner.nextLine()).split("[,\n]");
                ID = Integer.parseInt(temp[0]);
                name = temp[1];
                balance = Double.parseDouble(temp[2]);
                accounts.add(new Account(ID, name, balance));
            }
            
            scanner.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	private class AccountComparator implements Comparator<Account>{
		public int compare(Account a1, Account a2){
			if(a1.ID < a2.ID)
				return -1;
			else if (a1.ID > a2.ID)
				return 1;
			else 
				return 0;
		}
	}
}
