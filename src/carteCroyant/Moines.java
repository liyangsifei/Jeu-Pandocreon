package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;

import outils.getImages;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;

public class Moines extends Croyant {
	
	  //constructeur
    public Moines(){
    	super();
    	this.nom="Moines";
    	this.nombrePuissance = 2;
    	this.origine = "Jour";
    }
    
      //Donne un point d'Action d'Origine Jour.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Moines:");
       	if(partie.getPartie().isPeuxGagnePointAction()){
    		System.out.println("Joueur " + j.getNumeroJoueur() + " gagne un point d'action jour!");
        	j.setPointActionJour(j.getPointActionJour() + 1);
    	}else{
    		System.out.println("Aucun joueur ne peux gagner de point d'action avant le terminal de ce tour");
    	}}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }

}
