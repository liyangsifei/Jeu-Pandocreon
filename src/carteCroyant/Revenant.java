package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;
import control.Tour;


public class Revenant extends Croyant{
	
	  //constructeur
    public Revenant(){
    	super();
    	this.nombrePuissance = 1;
    	this.nom = "Revenant";
    	this.origine = "N¨¦ant";
    	this.dogme = "HumainNatureMystique";
    	Image image = null;
	//	image = getImages.getPng("Revenant");
	//	this.setImage(image);
    }
    
      //Relancez le d¨¦ de Cosmogonie. Le tour se finit normalement sous la nouvelle influence.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Revenant:");
    	List l = j.getCarteEnMain();
    	Iterator it = l.iterator();
    	int i = 0;
    	while(it.hasNext()){
    		CarteAction ca  = (CarteAction) it.next();
    		if(ca.getNom().equals("Revenant")){
    			j.getCarteEnMain().remove(i);
    			break;
    		}
    		i++;
    	}
    	Tour tour=new Tour((ArrayList<Joueur>)partie.getPartie().getJoueurs());
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }

}
