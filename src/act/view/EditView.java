package act.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import act.model.ModelEvent;
import act.model.AccountModel;
import act.controller.AccountController;


@SuppressWarnings("serial")
public class EditView extends JFrameView{
	

	public static final String editDeposit = "Deposit";
	public static final String editWithdraw = "Withdraw";
	public static final String editDismiss = "Dismiss";
	
	
	public EditView(AccountModel model, AccountController controller ){
		super(model, controller);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setUndecorated(true);
//		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		JPanel buttonPanel = new JPanel();
		Handler l = new Handler();
		
		
		JButton jButtonDeposit = new JButton(editDeposit);
		jButtonDeposit.addActionListener(l);
		JButton jButtonWithdraw = new JButton(editWithdraw);
		jButtonWithdraw.addActionListener(l);
		JButton jButtonDismiss = new JButton(editDismiss);
		jButtonDismiss.addActionListener(l);
		
		buttonPanel.setLayout(new GridLayout(5, 5, 7, 7));
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		
		
		buttonPanel.add(jButtonDeposit);
		buttonPanel.add(jButtonWithdraw);
		buttonPanel.add(jButtonDismiss);
		
		pack();
	}

	@Override
	public void modelChanged(ModelEvent event) {
		// TODO Auto-generated method stub
		
	}
	class Handler implements ActionListener { 
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
			((AccountController)getController()).operation(e.getActionCommand());
	    } }

}
