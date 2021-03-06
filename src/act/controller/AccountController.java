package act.controller;

import act.model.Account;
import act.model.AccountModel;
import act.view.AccountView;
import act.view.EditView;
import act.view.JFrameView;
import javax.swing.JComboBox;


@SuppressWarnings("unused")
public class AccountController extends AbstractController {
	
	private String currentSelection = AccountView.USD;
	
	//It makes sense that the arguments would get passed to the conroller then passed to the view.
	
	public AccountController(String [] args){
		setModel(new AccountModel(args) );
		setView( new AccountView( (AccountModel)getModel(), this ));
		((JFrameView)getView()).setVisible(true);
		((JFrameView)getView()).setTitle("Speas Accounting Software");
		
		
	}
	
	public void operation(String option){
		
//		System.out.println("Controller option: " + option);
		
		if(option == AccountView.USD){
			((AccountModel)getModel()).setcurrentRate(AccountView.USD);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);
			//set the title of the JFrame window
			String title = new String(((AccountModel)getModel()).getCurrentAccount().getName() + " - " + Integer.toString(((AccountModel)getModel()).getCurrentAccount().getID()));
			((JFrameView)getView()).setTitle(title);
			currentSelection = AccountView.USD;
			
			
		}else if(option == AccountView.EUROS){
			((AccountModel)getModel()).setcurrentRate(AccountView.EUROS);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);	
			//set the title of the JFrame window
			String title = new String(((AccountModel)getModel()).getCurrentAccount().getName() + " - " + Integer.toString(((AccountModel)getModel()).getCurrentAccount().getID()));
			((JFrameView)getView()).setTitle(title);
			currentSelection = AccountView.EUROS;
			
		}else if(option == AccountView.YEN){
			((AccountModel)getModel()).setcurrentRate(AccountView.YEN);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);	
			//set the title of the JFrame window
			String title = new String(((AccountModel)getModel()).getCurrentAccount().getName() + " - " + Integer.toString(((AccountModel)getModel()).getCurrentAccount().getID()));
			((JFrameView)getView()).setTitle(title);
			currentSelection = AccountView.YEN;
			
		}else if(option == AccountView.SAVE){
			((AccountModel)getModel()).save();
			
		}else if(option == AccountView.EXIT){
			((AccountModel)getModel()).exit();
			System.exit(0);
			
		}else if(option == EditView.editDeposit){
			try {
				((AccountModel)getModel()).deposit(((EditView)getView()).getAmountChanged());
			} catch (Exception e) {
				((EditView)getView()).displayDialog(e.getMessage());
			}
			((EditView)getView()).resetEditField();
			
		}else if(option == EditView.editDismiss){
			((JFrameView)getView()).setVisible(false);
			returnView();
			
		
		}else if(option == "comboBoxChanged"){
			((AccountModel)getModel()).setCurrentAccount((((AccountView)getView()).getSelectedItem()));
			
		}else if(option == EditView.editWithdraw){
			try{
				((AccountModel)getModel()).withdraw(((EditView)getView()).getAmountChanged());
				((EditView)getView()).resetEditField();
			}catch(Exception e){
				((EditView)getView()).displayDialog(e.getMessage());
			}
				
			
		}
	}
}
