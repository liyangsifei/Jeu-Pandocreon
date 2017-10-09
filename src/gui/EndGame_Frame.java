package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Joueur;

public class EndGame_Frame extends JFrame{
	
	JButton recommence = new JButton("Oui");
	JButton termine = new JButton("Non");
	JLabel infoJeu = new JLabel();
	JPanel choixPanel = new JPanel();
	Joueur joueurGagne = null;
	
	public EndGame_Frame(){
		
	//	choixPanel.setLayout(new GridLayout(1,2));
		choixPanel.add(recommence);
		choixPanel.add(termine);
		this.add(infoJeu,BorderLayout.NORTH);
		this.add(choixPanel,BorderLayout.SOUTH);
		infoJeu.setText("Le jeu termine. Joueur n." + "a gagné! Voulez vous recommencer?");
		
		addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                //退出应用程序  
                System.exit(0);  
            }   
        });  
		
		 this.recommence.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent ae) {  
	            	setVisible(false);
	            	
	            	Bienvenu_Frame frame = new Bienvenu_Frame();
	            	frame.setVisible(true);
	            }  
	        });
		 
		 this.termine.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent ae) {  
	            	System.exit(0); 
	            }  
	        });
		
		
		this.setSize(500, 200);
		this.setResizable(false);
		this.setVisible(true);
		
	}

	public Joueur getJoueurGagne() {
		return joueurGagne;
	}

	public void setJoueurGagne(Joueur joueurGagne) {
		this.joueurGagne = joueurGagne;
	}
	
	

}
