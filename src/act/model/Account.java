package act.model;

public class Account {
	
	public int ID;
	public String name;
	public double balance;
	
	public Account(int ID, String name, double balance){
		this.ID = ID;
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * This is freaking awesome because it lets the jcombobox display what I want to !!!!!!!
	 * @Override
	 */
	public String toString(){
		return ID + " " + name + " " + balance;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setBalance(double bal){
		balance = bal;
	}
	
	public String getBalanceString(){
		return Double.toString(balance);
	}
	
	public String getName(){
		return name;
	}

}
