package carteGuide;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import control.Joueur;
import control.Partie;
import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.GuideSpirituel;


public class Shaman extends GuideSpirituel{
	//contructeur
    public Shaman(){
     super();
   	 this.nom="Shaman";
   	 this.origine = "Nuit";
   	 this.dogme = "NatureSymboles";
   	 this.nombreCroyant = 3;
   	Image image = null;
//	image = getImages.getPng("Shaman");
//	this.setImage(image);
    }
    
    //Sacrifie tous les Croyants d'Origine N¨¦ant d'une Divinit¨¦ ayant le Dogme Humain. 
    //Les capacit¨¦s sp¨¦cials sont jou¨¦es normalement.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Shaman:");
    	System.out.println("Sacrifie tous les Croyants d'Origine N¨¦ant d'une Divinit¨¦ ayant le Dogme Humain." +
    			" Les capacit¨¦s sp¨¦cials sont jou¨¦es normalement.");
    	  //Choisir un joueur et le chercher dans List joueurs
    	Scanner sc = new Scanner(System.in);
    	Joueur targetJoueur = j;
    	int sizeJoueur;
    	int n = -1;
    	  //Si ce joueur est un JoueurVirtuel
    	if(j.getNumeroJoueur() != 1){
    		sizeJoueur = partie.getPartie().getJoueurs().size();
    		n = new java.util.Random().nextInt(sizeJoueur);
    		System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur num¨¦ro " + n);
    	}else{
    		  //Si ce joueur est un JoueurPhysique	
    		System.out.println("Joueur " + 1 + " choisit un joueur, entrer son num¨¦ro");
    		n = sc.nextInt();
    		System.out.println("Joueur" + 1 + " a choisi Joueur num¨¦ro " + n);
    	}
    	List l =partie.getPartie().getJoueurs();
    	Iterator it = l.iterator();
    	while(it.hasNext()){
    		targetJoueur = (Joueur)it.next();
    		if(targetJoueur.getNumeroJoueur() == n){
    			break;
    		}
    			}
    	if(targetJoueur.getDivinite().getDiviniteDogme().contains("Humain")){
    		if(targetJoueur.getCarteEnMain().size() != 0){
    			int sizeMain = targetJoueur.getCarteEnMain().size();
    			for(int i = sizeMain - 1 ; i >= 0 ; i++){
    				Croyant cy;
    				CarteAction ca;
    				ca = (CarteAction)targetJoueur.getCarteEnMain().get(i);
    				if(ca.getType() == "Croyant"){
    					cy = (Croyant)ca;
    					if(cy.getOrigine() == "N¨¦ant"){
    						System.out.println("Croyant " + cy.getNom() + " est sacrifice");
    						cy.utiliserCapacite(j, partie.getPartie());
    						targetJoueur.getCarteEnMain().remove(cy);
    					}
    				}
    			}
    			System.out.println("Les Croyant ont Origine de N¨¦ant de Joueur " + targetJoueur.getNumeroJoueur() + " sont supprimer est sacrifi¨¦");
    		}else{
    			System.out.println("Ce joueur n'a pas de Croyant dans son carte en main");
    		}
    	}else{
    		System.out.println("Ce divinit¨¦ n'est pas compris de Dogme Humain");
    	}}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
