package gui;
import javax.swing.*;


import control.Joueur;
import control.Partie;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Panel_sousJoueurVirtuel extends JPanel {
	//储存这个panel对应的虚拟玩家
	private Joueur joueur;
	//这个numero与之前的玩家的编号对应，虚拟玩家从2开始
	private int numero;
    private Panel_diviniteVirtuel diviniteView;
    private Panel_espacePersonnelV espacePersonnelView;
    private int lChangeable;
    private Dimension dimDivinite = new Dimension(lChangeable,50);
    private Dimension dimEspace = new Dimension(lChangeable,170);
    
    public Panel_sousJoueurVirtuel(int numero,Pandocreon_Frame f){
    	this.numero=numero;
    	this.diviniteView=new Panel_diviniteVirtuel(numero);
    	this.espacePersonnelView=new Panel_espacePersonnelV(numero);
    	this.setLayout(new BorderLayout());
    	diviniteView.setPreferredSize(dimDivinite);
    	this.add("North",diviniteView);
    	f.partie.getPartie().addObserver(diviniteView);
    	espacePersonnelView.setPreferredSize(dimEspace);
    	this.add("South",espacePersonnelView);
    	f.partie.getPartie().addObserver(espacePersonnelView);
    }

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public int getlChangeable() {
		return lChangeable;
	}

	public void setlChangeable(int lChangeable) {
		this.lChangeable = lChangeable;
	}

	public Panel_espacePersonnelV getEspacePersonnelView() {
		return espacePersonnelView;
	}

	public void setEspacePersonnelView(Panel_espacePersonnelV espacePersonnelView) {
		this.espacePersonnelView = espacePersonnelView;
	}

	
    
	
}
