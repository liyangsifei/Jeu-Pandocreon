package carteDeusEx;

import control.Joueur;
import control.Partie;
import control.Tour;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.DeusEx;


public class Miroir extends DeusEx{
	//contructeur
    public Miroir(){
    	super();
   	 this.nom="Miroir";
   	 this.origine = "";
   	Image image = null;
	//image = getImages.getPng("Miroir");
	//this.setImage(image);
    }
    
    //Retourne les effets d'une carte d'Action sur la Divinit¨¦ qui l'a pos¨¦e.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	 System.out.println("Utiliser Carte DeusEx: Miroir");
    	 System.out.println("Relancez le d¨¦ de Cosmogonie. Le tour de jeu se terminera normalement, mais sous la nouvelle influence.");
 		List l = j.getCarteEnMain();
     	Iterator it = l.iterator();
     	int i = 0;
     	while(it.hasNext()){
     		CarteAction ca  = (CarteAction) it.next();
     		if(ca.getNom().equals("Diplomates")){
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
