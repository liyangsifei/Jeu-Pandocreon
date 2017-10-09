package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import carteAction.CarteAction;
import control.Joueur;
import control.Partie;
import outils.getImages;

public class Panel_diviniteVirtuel extends JPanel implements Observer{
	
	private int numero;
	private List joueurs;
	JLabel label = new JLabel("divinite");
	 private Dimension d = new Dimension(90,60);
	 
	 public Panel_diviniteVirtuel(int numero){
		 this.setBackground(Color.darkGray);
		 this.joueurs=new ArrayList<Joueur>();
		 this.add(label);
		 this.numero=numero;
		// this.setBorder(BorderFactory.createTitledBorder("divinite"));
		// this.setBorder(BorderFactory.createLineBorder(Color.red));
	 }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.removeAll();
        this.revalidate();
        this.setBackground(Color.darkGray);
        int i=this.numero-1;
        Partie p=(Partie)o;
        Joueur j=(Joueur)p.getJoueurs().get(i);
        Image nomCarte = getImages.getPng(j.getDivinite().getNom());
        Image nomCarteFinal = (nomCarte.getScaledInstance(90,60,Image.SCALE_DEFAULT));
	    JLabel label = new JLabel(new ImageIcon(nomCarteFinal));
	    label.setPreferredSize(d);
		this.add(label);
		JLabel labelNom = new JLabel("Divinite du joueur virtuel");
		this.add(labelNom);
		
		 
		 this.revalidate();
	}
	
}

