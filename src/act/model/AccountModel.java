package act.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import act.view.AccountView;
import java.util.Collections;

public class AccountModel extends AbstractModel{
	
//	public PriorityQueue<Account> accounts = new PriorityQueue<Account>(100, new AccountComparator());
	public ArrayList<Account> accounts = new ArrayList<Account>();
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
	}
	
	public Account getCurrentAccount(){
		return currentAccount;
	}
	
	public void deposit(String amt){
		
		if( isValid(amt)){
			double amount = Double.parseDouble(amt);
			currentAccount.setBalance(currentAccount.getBalance() + amount*currentRate);
			ModelEvent e = new ModelEvent((Object)this, 1, "changed", currentAccount.getBalance());
			notifyChanged(e);
		}
	}
	
	public void withdraw(String amt){
		
		if( isValid(amt) ){
			double amount = Double.parseDouble(amt);
			currentAccount.setBalance(currentAccount.getBalance() - amount*currentRate);
			ModelEvent e = new ModelEvent((Object)this, 1, "changed", currentAccount.getBalance());
			notifyChanged(e);
		}
	}
	
	private boolean isValid(String s){
		
		char t = '0';
		for (int i = 0; i<s.length(); i++){
			t = s.charAt(i);
			if( !Character.isDigit(t) && t != '.' ){
				return false;
			}
			return true;
		}
		
		return false;
	}
	
	public void save(){
		
		try {
			FileWriter fstream = new FileWriter(inputFile);
			BufferedWriter out = new BufferedWriter(fstream);
			
			for (Account e : accounts){
				out.write(e.getID() + ",");
				out.write(e.getName() + ",");
				out.write(String.format("%.2f",e.getBalance()) + '\n');
			}
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void exit(){
		save();
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
                boolean repeat = false;
                ID = Integer.parseInt(temp[0]);
                name = temp[1];
                balance = Double.parseDouble(temp[2]);
                for (Account e : accounts){
                	if(e.getID() == ID){
                		repeat = true;
                		System.out.println("found repeat");
                	}
                }
                if(repeat == false){
                	accounts.add(new Account(ID, name, balance));
                }
                repeat = false;
                
            }
            
            scanner.close();
            Collections.sort(accounts);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
//	private class AccountComparator implements Comparator<Account>{
//		public int compare(Account a1, Account a2){
//			if(a1.ID < a2.ID)
//				return -1;
//			else if (a1.ID > a2.ID)
//				return 1;
//			else 
//				return 0;
//		}
//	}
}
