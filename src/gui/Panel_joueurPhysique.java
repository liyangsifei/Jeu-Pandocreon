package gui;

import javax.swing.*;

import control.Partie;

import java.awt.*;
import java.util.*;

public class Panel_joueurPhysique extends JPanel {
	static final long serialVersionUID = -2312366663752775092L;
	//JLabel label = new JLabel("joueurPhysique");
	//private Panel_espacePersonnelP espacePersonnelView=new Panel_espacePersonnelP();
	private Panel_sousJoueurPhysique joueurPhysiqueView;;
	private Panel_carteMain carteMainView = new Panel_carteMain();
	
	//private Dimension dimEspacePhysique = new Dimension(1600,150);
	private Dimension dimSousPhysique = new Dimension(1300,100);
	private Dimension dimCarteMain = new Dimension(1300,200);
	
	 public Panel_joueurPhysique(Pandocreon_Frame f){
		 //this.setSize(1600, 100);
		 this.setLayout(new BorderLayout());
		 this.setBackground(Color.darkGray);
		 this.joueurPhysiqueView=new Panel_sousJoueurPhysique(f);
	//	 espacePersonnelView.setPreferredSize(dimEspacePhysique);
	//	 this.add(espacePersonnelView);
		 joueurPhysiqueView.setPreferredSize(dimSousPhysique);
		 this.add("North",joueurPhysiqueView);
		 carteMainView.setPreferredSize(dimCarteMain);
		 this.add("South",carteMainView);
		 
		// this.setBorder(BorderFactory.createTitledBorder("divinite"));
		// this.setBorder(BorderFactory.createLineBorder(Color.CYAN));
	 }


	

	public Panel_sousJoueurPhysique getJoueurPhysiqueView() {
		return joueurPhysiqueView;
	}


	public void setJoueurPhysiqueView(Panel_sousJoueurPhysique joueurPhysiqueView) {
		this.joueurPhysiqueView = joueurPhysiqueView;
	}


	public Panel_carteMain getCarteMainView() {
		return carteMainView;
	}


	public void setCarteMainView(Panel_carteMain carteMainView) {
		this.carteMainView = carteMainView;
	}
	
	
	
	
}
