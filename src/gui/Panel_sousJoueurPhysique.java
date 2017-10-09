package gui;
import javax.swing.*;

import control.Partie;

import java.awt.*;
import java.util.Observable;

public class Panel_sousJoueurPhysique extends JPanel{
	 
    // private Panel_carteMain carteMainView=new Panel_carteMain();
     private Panel_divinitePhysique diviniteView;
     private Panel_espacePersonnelP espacePersonnelView=new Panel_espacePersonnelP();
     
     private Dimension dimEspacePersonnel = new Dimension(900,100);
     private Dimension dimDiviniteView = new Dimension(400,100);
     public Panel_sousJoueurPhysique(Pandocreon_Frame f){
    	 this.diviniteView=new Panel_divinitePhysique(f);
    	 this.setBackground(Color.darkGray);
    	 this.setLayout(new BorderLayout());
    	 espacePersonnelView.setPreferredSize(dimEspacePersonnel);
    	 this.add("West",espacePersonnelView);
    	 
    	 diviniteView.setSize(150, 150);
    	 diviniteView.setPreferredSize(dimDiviniteView);
    	 this.add("East",diviniteView);
    	 
    	 
    	// this.setBorder(BorderFactory.createTitledBorder("sousPhysique"));
		// this.setBorder(BorderFactory.createLineBorder(Color.yellow));
    	 
     }
	
     

	public Panel_espacePersonnelP getEspacePersonnelView() {
		return espacePersonnelView;
	}



	public void setEspacePersonnelView(Panel_espacePersonnelP espacePersonnelView) {
		this.espacePersonnelView = espacePersonnelView;
	}



	public Panel_divinitePhysique getDiviniteView() {
		return diviniteView;
	}

	public void setDiviniteView(Panel_divinitePhysique diviniteView) {
		this.diviniteView = diviniteView;
	}
     
	
    
}
