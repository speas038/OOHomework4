package act.view;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

import act.model.AccountModel;
import act.model.ModelEvent;
import act.controller.AccountController;

@SuppressWarnings("serial")
public class AccountView extends JFrameView {
	
	private JTextField textField = new JTextField();
	
	public AccountView(AccountModel model, AccountController controller){
		super(model, controller);
		
		textField.setText("0");
		this.getContentPane().add(textField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		Handler handler = new Handler();
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(handler);
		
		buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		
		buttonPanel.add(jButton1);
		
		pack();
		
		
	}
	

	@Override
	public void modelChanged(ModelEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	class Handler implements ActionListener { 
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
//			((CalculatorController)getController()).operation(e.getActionCommand()); 
	    } }
	
	public static void main(String [] args) { new AccountController(); }
}
