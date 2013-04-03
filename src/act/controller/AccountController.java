package act.controller;

import act.model.AccountModel;
import act.view.AccountView;
import act.view.EditView;
import act.view.JFrameView;

public class AccountController extends AbstractController {
	
	//It makes sense that the arguments would get passed to the conroller then passed to the view.
	
	public AccountController(String [] args){
		setModel(new AccountModel(args) );
		setView( new AccountView( (AccountModel)getModel(), this ));
		((JFrameView)getView()).setVisible(true);
		
		
	}
	
	public void operation(String option){
		
		System.out.println("Controller option: " + option);
		
		if(option == AccountView.USD){
			((AccountModel)getModel()).setcurrentRate(AccountView.USD);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);
			
		}else if(option == AccountView.EUROS){
			((AccountModel)getModel()).setcurrentRate(AccountView.EUROS);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);			
			
		}else if(option == AccountView.YEN){
			((AccountModel)getModel()).setcurrentRate(AccountView.YEN);
			swapView( new EditView( (AccountModel)getModel(), this));
			((JFrameView)getView()).setVisible(true);	
			
		}else if(option == AccountView.SAVE){
			((AccountModel)getModel()).save();
			
		}else if(option == AccountView.EXIT){
			((AccountModel)getModel()).exit();
			System.exit(0);
			
		}else if(option == EditView.editDeposit){
			
		}else if(option == EditView.editDismiss){
			((JFrameView)getView()).setVisible(false);
			returnView();
			
		}else if(option == EditView.editWithdraw){
			
		}
	}
}
