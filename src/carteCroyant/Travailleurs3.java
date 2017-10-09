package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.GuideSpirituel;
import control.Joueur;
import control.Partie;

public class Travailleurs3 extends Croyant {
	
	  //constructeur
    public Travailleurs3(){
    	super();
    	this.nombrePuissance = 2;
    	this.nom = "Travailleurs3";
    	this.origine = "Jour";
    	this.dogme = "SymbolesHumainNature";
    	Image image = null;
	//	image = getImages.getPng("Travailleurs2");
	//	this.setImage(image);
    }
    
      //Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Chaos ou Mystique 
      //de sacrifier un de ses Guides Spirituels durant ce tour.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Travailleurs3:");
		new Ali¨¦n¨¦s3().utiliserCapacite(j,partie.getPartie());
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }


}
