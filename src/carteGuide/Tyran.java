package carteGuide;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;

import outils.getImages;

import control.Joueur;
import control.Partie;
import carteAction.Croyant;
import carteAction.GuideSpirituel;


public class Tyran extends GuideSpirituel{
	//contructeur
    public Tyran(){
     super();
   	 this.nom="Tyran";
   	 this.origine = "N¨¦ant";
   	 this.dogme = "SymbolesChaos";
   	 this.nombreCroyant = 3;
   	Image image = null;
	//image = getImages.getPng("Tyran");
	//this.setImage(image);
    }
    
      //D¨¦fausse tous les Croyants ayant le Dogme Mystique actuellement 
      //au centre de la table.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Tyran:");
    	System.out.println("D¨¦fausse tous les Croyants ayant le Dogme Mystique actuellement au centre de la table.");
    	List tc = j.getCarteTable().getCartesEnTable();
    	Iterator it = tc.iterator();
    	Croyant cy;
    	while(it.hasNext()){
    		cy = (Croyant)it.next();
    		if(cy.getDogme().contains("Mystique")){
    			j.getCarteTable().getCartesEnTable().remove(cy);
    			System.out.println("Croyant " + cy.getNom() + " est d¨¦fauss¨¦ de carte table");
    		}
    	}
    	System.out.println("Tous les cartes croyant ayant le Dogme Mystique en table sont d¨¦fauss¨¦s");
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    } }
}
