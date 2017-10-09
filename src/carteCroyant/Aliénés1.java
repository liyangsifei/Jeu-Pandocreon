package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;

public class Ali¨¦n¨¦s1 extends Croyant {
	
	  //constructeur
	public Ali¨¦n¨¦s1(){
		super();
		this.nombrePuissance = 2;
		this.nom = "Ali¨¦n¨¦s1";
		this.origine = "N¨¦ant";
		this.dogme = "MystiqueHumainChaos";
		Image image = null;
		//image = getImages.getPng("Aliene3");
		//this.setImage(image);
	}
	
	  //Vous piochez deux cartes au hasard dans la main d'une autre Divinit¨¦.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
		System.out.println("Ali¨¦n¨¦s1:");
		new Alchimistes1().utiliserCapacite(j,partie.getPartie());
		}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
	}
	
}
