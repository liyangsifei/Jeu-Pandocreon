package carteGuide;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import outils.getImages;

import control.Joueur;
import control.Partie;
import control.Tour;
import carteAction.CarteAction;
import carteAction.GuideSpirituel;


public class Messie extends GuideSpirituel{
	//contructeur
    public Messie(){
      super();
   	  this.nom="Messie";
   	  this.origine = "Jour";
   	  this.dogme = "HumainMystique";
   	  this.nombreCroyant =3;
   	Image image = null;
//	image = getImages.getPng("Messie");
	//this.setImage(image);
    }
    
    //Le joueur pose le d¨¦ de Cosmogonie sur la face qu'il d¨¦sire et 
    //commence un nouveau tour de jeu.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Messie:");
    	System.out.println("Le joueur pose le d¨¦ de Cosmogonie sur la face qu'il d¨¦sire et commence un nouveau tour de jeu.");
    	List l = j.getCarteEnMain();
    	Iterator it = l.iterator();
    	int i = 0;
    	while(it.hasNext()){
    		CarteAction ca  = (CarteAction) it.next();
    		if(ca.getNom().equals("Messie")){
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
