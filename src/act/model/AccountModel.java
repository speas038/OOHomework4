package act.model;

public class AccountModel extends AbstractModel{

	public AccountModel(){
		
	}
	
	public void usd(){
		System.out.println("USD model code executed");
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
		System.exit(0);
	}
}
