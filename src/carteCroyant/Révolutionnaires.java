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


public class R¨¦volutionnaires extends Croyant{
	
	  //constructeur
    public R¨¦volutionnaires(){
    	super();
    	this.nombrePuissance = 2;
    	this.nom = "R¨¦volutionnaires";
    	this.origine = "N¨¦ant";
    	this.dogme = "SymbolesHumainChaos";
    	Image image = null;
	//	image = getImages.getPng("Revolutionnaire");
		//this.setImage(image);
    }
    
      //Imposez le sacrifice d'une carte de Croyants ¨¤ autant de Divinit¨¦s que vous le voulez. 
      //Chaque Divinit¨¦ choisit la carte ¨¤ sacrifier. Les capacit¨¦s sp¨¦ciales sont jou¨¦es.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("R¨¦volutionnaires:");
    	new Ermite().utiliserCapacite(j,partie.getPartie());
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
