package carteGuide;

import gui.Pandocreon_Frame;

import java.util.List;

import control.Joueur;
import control.Partie;
import carteAction.GuideSpirituel;


public class Martyr extends GuideSpirituel{
	//contructeur
    public Martyr(){
     super();
   	 this.nom="Martyr";
   	 this.nombreCroyant = 2;
    }
    
      //Equivalent ¨¤ la pose d'une carte Apocalypse.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Matyr:");
    	System.out.println("Equivalent ¨¤ la pose d'une carte Apocalypse.");
    	List l;
		l = partie.getPartie().getJoueurs();
		int nbJoueurEnjeu = l.size();
		if(nbJoueurEnjeu < 4){
			partie.getPartie().resultatJeu();
		}else{
			partie.getPartie().eliminerJoueur();
		}}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
