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

public class Travailleurs2 extends Croyant {
	
	//constructeur
    public Travailleurs2(){
    	super();
    	this.nombrePuissance = 2;
    	this.nom = "Travailleurs2";
    	this.origine = "Jour";
    	this.dogme = "SymbolesHumainChaos";
    	Image image = null;
	//	image = getImages.getPng("Travailleurs1");
	//	this.setImage(image);
    }
    
      //Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Nature ou Mystique 
      //de sacrifier une de ses cartes de Croyants durant ce tour.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Travailleurs2:");
    	new Ali¨¦n¨¦s2().utiliserCapacite(j,partie.getPartie());
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
    	


}
