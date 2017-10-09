package gui;

import java.awt.Color;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class Panel_espacePersonnelV extends JPanel implements Observer{
	
	private int numero;
	JLabel label = new JLabel("espacePersonnel");
	JPanel panel = new JPanel();
	public Panel_espacePersonnelV(int numero){
		this.setBackground(Color.darkGray);
		 this.add(label);
		 this.add(panel);
	//	 this.setSize(1600,100);
		 this.setBorder(BorderFactory.createTitledBorder("espacePersonnel"));
		// this.setBorder(BorderFactory.createLineBorder(Color.white));
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.removeAll();
		this.revalidate();
		this.setBackground(Color.darkGray);
		this.label=new JLabel("EspacePersonnel du joueur virtuel");
		this.add(label);
		this.revalidate();
	}
	
}
