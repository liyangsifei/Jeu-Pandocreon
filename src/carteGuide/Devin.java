package carteGuide;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import control.Joueur;
import control.Partie;
import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.GuideSpirituel;

public class Devin extends GuideSpirituel {
	//constructeur
	
    public Devin(){
     super();
   	 this.nom="Devin";
   	 this.nombreCroyant = 1; 
   	 this.origine = "N¨¦ant";
   	 this.dogme = "NatureMystique";
 //  	Image image = null;
//	image = getImages.getPng("Devin");
//	this.setImage(image);
    }
    
      //Oblige une Divinit¨¦ ayant le Dogme Nature ou Mystique ¨¤ sacrifier 
      //l'un de ses Guides Spirituels.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Devin:");
    	System.out.println("Oblige une Divinit¨¦ ayant le Dogme Nature ou Mystique ¨¤ sacrifier l'un de ses Guides Spirituels.");
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
    			
    	 //D¨¦cider si pouvoir choisir ce joueur(Dogme)
    	if(targetJoueur.getDivinite().getDiviniteDogme().contains("Nature") || targetJoueur.getDivinite().getDiviniteDogme().contains("Mystique")){
    		boolean have = false;
			GuideSpirituel gs = new GuideSpirituel();
			if(targetJoueur.getCarteEnMain().size() != 0){
				int sizeMain = targetJoueur.getCarteEnMain().size();
				for(int i = 0 ;i <sizeMain ; i++){
					CarteAction ca = (CarteAction) targetJoueur.getCarteEnMain().get(i);
					if(ca.getType().equals("GuideSpirituel") ){
						gs = (GuideSpirituel)ca;
						have = true;
						break;
					}
				}
				if(have){
					gs.utiliserCapacite(targetJoueur,partie.getPartie());
				}else{
					System.out.println("Ce joueur n'a pas de carte de Guide Spirituel de ces Dogmes dans sa main");
				}
			}
    		}
    		
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
