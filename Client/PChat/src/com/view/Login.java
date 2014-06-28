/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import java.awt.GridLayout;
import javax.swing.*;
import com.lang.English;

/**
 *
 * @author User
 */
public class Login extends JFrame{
    
    public JLabel headerLabel;
    public JTextField user;
    public JTextField pass;
    public JButton login;
    
    public Login()
	{
		super(English.MAIN_WINDOW_TITLE);
		setSize(300, 300);
		setLayout(new GridLayout(10,8));
		intializeComponents();
		setVisible(true);
		
	}

    private void intializeComponents() {
        
        headerLabel = new JLabel("" , JLabel.LEFT) ;
        headerLabel.setAlignmentY(TOP_ALIGNMENT);
        headerLabel.setText("Add Employees"); 

	JLabel  userLabel= new JLabel("User Name: ", JLabel.LEFT);
	JLabel  passLabel = new JLabel("Password: ", JLabel.LEFT);
	 user = new JTextField(8);
	 pass = new JTextField(8); 
         
        login = new JButton(English.LOGIN_BUTTON);
         this.add(headerLabel);
         this.add(userLabel);
         
         this.add(user);
         this.add(passLabel);
         this.add(pass);
         this.add(login);
                
    
    }
    
}
