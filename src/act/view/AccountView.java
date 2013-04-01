package act.view;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

import act.model.AccountModel;
import act.model.ModelEvent;
import act.controller.AccountController;

@SuppressWarnings("serial")
public class AccountView extends JFrameView {
	
	private JTextField textField = new JTextField();
	private String [] accounts;
	
	/*
	 * AccountView initializes the view and opens the file specified by the command line.
	 */
	public AccountView(AccountModel model, AccountController controller, String [] args){
		super(model, controller);
		
		textField.setText("0");
		this.getContentPane().add(textField, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		Handler l = new Handler();
		
		accounts = readAccounts(args);
		JComboBox accountsCombo = new JComboBox(accounts);
		accountsCombo.addActionListener(l);
		JButton jButton1 = new JButton();
		jButton1.addActionListener(l);
		
		buttonPanel.setLayout(new GridLayout(5, 5, 7, 7));
		this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
		
		buttonPanel.add(accountsCombo);
		buttonPanel.add(jButton1);
		
		pack();
		
	}
	
	private String [] readAccounts(String [] args){
		
	    	 
        // Location of file to read
        File file = new File(args[0]);
        ArrayList<String> stringList = new ArrayList<String>();
                
        try {
            Scanner scanner = new Scanner(file);
 
            while (scanner.hasNextLine()) {
                stringList.add(scanner.nextLine());
            }
            String [] retArray = new String[stringList.size()];
            stringList.toArray(retArray);
            scanner.close();
            
            return retArray;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
	}
	
	@Override
	public void modelChanged(ModelEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	class Handler implements ActionListener { 
		// Event handling is handled locally
		public void actionPerformed(ActionEvent e) {
//			((AccountController)getController()).operation(e.getActionCommand()); 
	    } }
	
	/**
	 * Main is located inside of the view class.  It accepts the path of the input file as an argument
	 * @param String []
	 */
	public static void main(String [] args) { new AccountController(args);}
}
