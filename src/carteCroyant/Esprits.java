package carteCroyant;

import gui.Pandocreon_Frame;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;


public class Esprits extends Croyant {
	
	  //constructeur
    public Esprits(){
    	super();
    	this.nombrePuissance = 2;
    	this.nom = "Esprits";
    	this.origine = "N¨¦ant";
    }
    
      //Donne un point d'Action d'Origine N¨¦ant.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Esprits:");
    	if(partie.getPartie().isPeuxGagnePointAction()){
    		System.out.println("Joueur " + j.getNumeroJoueur() + " gagne un point d'action n¨¦ant!");
        	j.setPointActionN¨¦ant(j.getPointActionN¨¦ant() + 1);
    	}else{
    		System.out.println("Aucun joueur ne peux gagner de point d'action avant le terminal de ce tour");
    	}}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
