package act.controller;

import act.model.AccountModel;
import act.view.AccountView;
import act.view.JFrameView;

public class AccountController extends AbstractController {
	
	//It makes sense that the arguments would get passed to the conroller then passed to the view.
	
	public AccountController(String [] args){
		setModel(new AccountModel() );
		setView( new AccountView( (AccountModel)getModel(), this, args ));
		((JFrameView)getView()).setVisible(true);
	}
	
	public void operation(String option){
		if(option == AccountView.USD){
			((AccountModel)getModel()).usd();
		}else if(option == AccountView.EUROS){
			((AccountModel)getModel()).euros();
		}else if(option == AccountView.YEN){
			((AccountModel)getModel()).yen();
		}else if(option == AccountView.SAVE){
			((AccountModel)getModel()).save();
		}else if(option == AccountView.EXIT){
			((AccountModel)getModel()).exit();
		}
	}
}
