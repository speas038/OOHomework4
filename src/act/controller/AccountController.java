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
}
