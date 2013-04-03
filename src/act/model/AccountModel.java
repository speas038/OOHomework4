package act.model;

import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import act.view.AccountView;


public class AccountModel extends AbstractModel{
	
	public PriorityQueue<Account> accounts = new PriorityQueue<Account>(100, new AccountComparator());
	public Account currentAccount;
	public String inputFile;
	public static final double EURO = 0.77;
	public static final double YEN = 93.57;
	public static final double USD = 1.0;
	private double currentRate = USD;
	
	
	public AccountModel(String [] args){
		readAccounts(args[0]);
	}
	
	public void setcurrentRate(String selection){
		if(selection == AccountView.EUROS){
			currentRate = EURO;
		}else if(selection == AccountView.USD){
			currentRate = USD;
		}else if(selection == AccountView.YEN){
			currentRate = YEN;
		}
		
//		System.out.println("Current Rate changed to " + currentRate);
	}
	
	public void setCurrentAccount(Account act){
		this.currentAccount = act;
//		System.out.println("Current Account: " + currentAccount.toString());
	}
	
	public Account getCurrentAccount(){
		return currentAccount;
	}
	
	public void deposit(double amt){
//		System.out.println("AMT: " + amt);
		currentAccount.setBalance(currentAccount.getBalance() + amt*currentRate);
		ModelEvent e = new ModelEvent((Object)this, 1, "changed", currentAccount.getBalance());
		notifyChanged(e);
	}
	
	public void withdraw(double amt){
//		System.out.println("AMT: " + amt);
		currentAccount.setBalance(currentAccount.getBalance() - amt*currentRate);
		ModelEvent e = new ModelEvent((Object)this, 1, "changed", currentAccount.getBalance());
		notifyChanged(e);
	}
	
	
	public void save(){
		System.out.println("SAVE model code executed");
		
		try {
			FileWriter fstream = new FileWriter(inputFile);
			BufferedWriter out = new BufferedWriter(fstream);
			
			for (Account e : accounts){
				out.write(e.getID() + ",");
				out.write(e.getName() + ",");
				out.write(Double.toString(e.getBalance()) + '\n');
			}
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		inputFile = new String(input);
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
