package pchat.ui;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pchat.lang.English;


public class Con_to_server extends JFrame{

	JButton btnServer;
	JLabel conToServer;
	
	public Con_to_server(){
	    
	        setTitle(English.SERVER_TITLE);
	        setSize(300,200);
	        initComponents();
	        setLayout(new FlowLayout(FlowLayout.CENTER));
	        setVisible(true);
	}
	public void initComponents(){
		
		conToServer = new JLabel("To Connect Server");
		btnServer = new JButton("Click Here");
		
		btnServer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Login();
			}		
		});
		add(conToServer);
		add(btnServer);
	}
	
}
