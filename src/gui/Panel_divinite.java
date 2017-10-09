package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import control.Joueur;
import control.Partie;

public class Panel_divinite extends JPanel{
	
	
	private List joueurs;
	JLabel label = new JLabel("divinite");
	
	 public Panel_divinite(){
		 this.joueurs=new ArrayList<Joueur>();
		 this.add(label);
		 
		 this.setBorder(BorderFactory.createTitledBorder("divinite"));
		 this.setBorder(BorderFactory.createLineBorder(Color.red));
	 }
	
}
