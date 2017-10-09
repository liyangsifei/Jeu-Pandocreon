package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;

import outils.getImages;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;


public class Nibillistes extends Croyant{
	  //constructeur
    public Nibillistes(){
    	super();
    	this.nombrePuissance = 4;
    	this.nom = "Nibillistes";
    	this.origine = "N¨¦ant";
    	this.dogme = "SymbolesMystiqueChaos";
    	Image image = null;
	//	image = getImages.getPng("Nibillistes");
	//	this.setImage(image);
    }
    
      //Jusqu'¨¤ la fin du tour, plus aucune Divinit¨¦ ne recoit de points d'Action.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Nibillistes:");
    	System.out.println("Aucun joueur ne plus pouvoir gagner de point d'action avant le terminal de ce tour!");
    	partie.getPartie().setPeuxGagnePointAction(false);
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
