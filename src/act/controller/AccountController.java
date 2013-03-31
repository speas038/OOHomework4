package act.controller;

import act.model.AccountModel;
import act.view.AccountView;
import act.view.JFrameView;

public class AccountController extends AbstractController {
	
	public AccountController(){
		setModel(new AccountModel() );
		setView( new AccountView( (AccountModel)getModel(), this ));
		((JFrameView)getView()).setVisible(true);
	}
}
