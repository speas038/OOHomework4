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
		((JFrameView)getView()).setTitle("Hello");
		
		
	}
	
	public void operation(String option){
		
//		System.out.println("Controller option: " + option);
		
		if(option == AccountView.USD){
			((AccountModel)getModel()).setcurrentRate(AccountView.USD);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);
			//set the title of the JFrame window
			((JFrameView)getView()).setTitle(((AccountModel)getModel()).getCurrentAccount().getName());
			currentSelection = AccountView.USD;
			
			
		}else if(option == AccountView.EUROS){
			((AccountModel)getModel()).setcurrentRate(AccountView.EUROS);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);	
			((JFrameView)getView()).setTitle(((AccountModel)getModel()).getCurrentAccount().getName());
			currentSelection = AccountView.EUROS;
			
			//set the title of the JFrame window
			((JFrameView)getView()).setTitle(((AccountModel)getModel()).getCurrentAccount().getName());
			
		}else if(option == AccountView.YEN){
			((AccountModel)getModel()).setcurrentRate(AccountView.YEN);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);	
			((JFrameView)getView()).setTitle(((AccountModel)getModel()).getCurrentAccount().getName());
			currentSelection = AccountView.YEN;
			
		}else if(option == AccountView.SAVE){
			((AccountModel)getModel()).save();
			
		}else if(option == AccountView.EXIT){
			((AccountModel)getModel()).exit();
			System.exit(0);
			
		}else if(option == EditView.editDeposit){
			((AccountModel)getModel()).deposit(((EditView)getView()).getAmountChanged());
			
		}else if(option == EditView.editDismiss){
			((JFrameView)getView()).setVisible(false);
			returnView();
		
		}else if(option == "comboBoxChanged"){
			((AccountModel)getModel()).setCurrentAccount((((AccountView)getView()).getSelectedItem()));
			
		}else if(option == EditView.editWithdraw){
				((AccountModel)getModel()).withdraw(((EditView)getView()).getAmountChanged());
			
		}
	}
}
