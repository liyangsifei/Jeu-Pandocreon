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


public class Paladin extends GuideSpirituel{
	//contructeur
    public Paladin(){
     super();
   	 this.nom="Paladin";
   	 this.dogme = "HumainMystique";
   	 this.origine = "Jour";
   	 this.nombreCroyant = 3;
   	Image image = null;
	//image = getImages.getPng("Paladin");
	//this.setImage(image);
    }
    
    //Tous les Croyants, d'Origine Nuit ou N¨¦ant et ayant le Dogme Nature, actuellement sur la table sont d¨¦fauss¨¦s.
    //Les capacit¨¦s sp¨¦ciales ne sont pas jou¨¦es.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Paladin:");
    	System.out.println("Tous les Croyants, d'Origine Nuit ou N¨¦ant et ayant le Dogme Nature, actuellement sur la table sont d¨¦fauss¨¦s." +
    			"Les capacit¨¦s sp¨¦ciales ne sont pas jou¨¦es.");
    	List tc = j.getCarteTable().getCartesEnTable();
    	Iterator it = tc.iterator();
    	Croyant cy;
    	while(it.hasNext()){
    		cy = (Croyant)it.next();
    		if((cy.getOrigine() == "Nuit" || cy.getOrigine() == "N¨¦ant") && (cy.getDogme().contains("Nature"))){
    			j.getCarteTable().getCartesEnTable().remove(cy);
    			System.out.println("Croyant " + cy.getNom() + " est d¨¦fauss¨¦ de carte table");
    		}
    	}
    	System.out.println("Tous les cartes croyant d'origine Nuit ou N¨¦ant et ayant le Dogme Nature en table sont d¨¦fauss¨¦s");
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    } }
}
