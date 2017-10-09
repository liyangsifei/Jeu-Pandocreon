package gui;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import control.Joueur;
import control.Partie;
import outils.getImages;

import javax.swing.*;

import carteAction.CarteAction;
import carteAction.CarteTable;

public class Panel_centreTable extends JPanel implements Observer{
	
	private static final long serialVersionUID = -7329658774707402643L;
	protected CarteTable carteTable=CarteTable.getCarteTable();
	JLabel label = new JLabel("centreTable");
	 private List cartes;
	 public Panel_centreTable(){
		 this.setBackground(Color.darkGray);
		 this.add(label);
		 //this.setSize(1000, 300);
		// this.setBorder(BorderFactory.createTitledBorder("table"));
		// this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	 }
	 

	@Override
	public void update(Observable o, Object arg) {
		this.removeAll();
		this.revalidate();
		// TODO Auto-generated method stub
		this.setBackground(Color.darkGray);
		 this.cartes=this.carteTable.getCartesEnTable();
		 int length=cartes.size();
		 if(length!=0){
		   for(int i=0;i<length;i++){
			
				  CarteAction carte=(CarteAction)cartes.get(i);
				  Image img = getImages.getPng(carte.getNom());
				  Image imgSize = (img.getScaledInstance(50,75,Image.SCALE_DEFAULT));
				  JLabel l=new JLabel(new ImageIcon(imgSize));
			      this.add(l);
			     // this.setSize(1000, 300);
					 this.setBorder(BorderFactory.createTitledBorder("table"));
					// this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		  }
		 }else{
			     this.label.setText("Il y a pas de cartes dans table!");
			     this.add(label);
			  //   this.setSize(1000, 300);
				 this.setBorder(BorderFactory.createTitledBorder("table"));
			//	 this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		 }
		 
		 this.revalidate();
	}
}
