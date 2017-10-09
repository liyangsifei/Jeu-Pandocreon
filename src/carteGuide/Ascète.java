package carteGuide;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import control.Joueur;
import control.Partie;
import carteAction.Croyant;
import carteAction.GuideSpirituel;


public class Ascète extends GuideSpirituel {
	//contructeur
    public Ascète(){
     super();
   	 this.nom="Ascète";
   	 this.nombreCroyant = 1;
   	 this.origine = "Nuit";
   	 this.dogme = "HumainSymboles";
   	Image image = null;
//	image = getImages.getPng("Ascete");
	//this.setImage(image);
    }
    
    //Sacrifie 2 cartes Croyants d'une Divinité ayant le Dogme Humain ou Symboles. 
    //Les capacités spéciales sont jouées normalement.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Ascète:");
    	System.out.println("Sacrifie 2 cartes Croyants d'une Divinité ayant le Dogme Humain ou Symboles. " +
    			"Les capacités spéciales sont jouées normalement.");
    	  //Choisir un joueur et le chercher dans List joueurs
    	Scanner sc = new Scanner(System.in);
    	Joueur targetJoueur = j;
    	int sizeJoueur;
    	int n = -1;
    	  //Si ce joueur est un JoueurVirtuel
    	if(j.getNumeroJoueur() != 1){
    		sizeJoueur = partie.getPartie().getJoueurs().size();
    		n = new java.util.Random().nextInt(sizeJoueur);
    		System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur numéro " + n);
    	}else{
    		  //Si ce joueur est un JoueurPhysique	
    		System.out.println("Joueur " + 1 + " choisit un joueur, entrer son numéro");
    		n = sc.nextInt();
    		System.out.println("Joueur" + 1 + " a choisi Joueur numéro " + n);
    	}
    	List l =partie.getPartie().getJoueurs();
    	Iterator it = l.iterator();
    	while(it.hasNext()){
    		targetJoueur = (Joueur)it.next();
    		if(targetJoueur.getNumeroJoueur() == n){
    			break;
    		}
    			}
    			
    	 //Décider si pouvoir choisir ce joueur(Dogme)
    	if(targetJoueur.getDivinite().getDiviniteDogme().contains("Humain")|| targetJoueur.getDivinite().getDiviniteDogme().contains("Symboles")){
    		if(targetJoueur.getCarteCroyantEnjeu().size() >= 2){
    		   	boolean FLAG = false;
    		    int n1 = -1;
    		    int n2 = -1;
    		      //targetJoueur est un JoueurVirtuel
    		    if(j.getNumeroJoueur() != 1){
    		    	int sizeEspaceCroyant;
    		    	sizeEspaceCroyant = targetJoueur.getCarteCroyantEnjeu().size();
    		    	while(n1 != n2){
    		    		n1 = new java.util.Random().nextInt(sizeEspaceCroyant);
        		    	n2 = new java.util.Random().nextInt(sizeEspaceCroyant);
    		    	}
    		    }else{
    		    	  //targetJoueur est un JoueurPhysique
    		    	while(FLAG == false){
    		        	System.out.println("Joueur " + 1 + " choisit deux cartes de Croyant dans l'espace personnel de Joueur " + targetJoueur.getNumeroJoueur());
    		           	n1 = sc.nextInt();
    		           	n2 = sc.nextInt();
    		           	if(n1 >= 0 && n1 < targetJoueur.getCarteCroyantEnjeu().size() && n2 >= 0 && n2 < targetJoueur.getCarteCroyantEnjeu().size() && n1 != n2){
    		           		FLAG =true;
    		           	}else{
    		           		System.out.println("Ce numéro de carte n'est pas compris dans l'espace croyant de Joueur" + targetJoueur.getNumeroJoueur());
    		           		FLAG = false;
    		           	}
    		  	   }
        	    }
    		    		
    			Croyant cy = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(n1);
    			Croyant cy2 = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(n2);
    		    targetJoueur.getCarteCroyantEnjeu().remove(n1);
    		    targetJoueur.getCarteCroyantEnjeu().remove(n2);
    		    System.out.println("Joueur " + j.getNumeroJoueur() + " a utilisé une carte de Croyant " + cy.getNom());
    		    j.utiliserCroyant(cy,partie.getPartie());
    		    System.out.println("Joueur " + j.getNumeroJoueur() + " a utilisé une carte de Croyant " + cy2.getNom());
    		    j.utiliserCroyant(cy2,partie.getPartie());
    		    
    		    
    		    List croyantDeGuide = cy.getGuideAttache().getCroyantAttache();
    		    for(int d = 0 ; d < targetJoueur.getCarteGsEnjeu().size() ; d++){
    		    	GuideSpirituel gs = (GuideSpirituel) targetJoueur.getCarteGsEnjeu().get(d);
    		    	if(gs.getNom().equals(cy.getGuideAttache().getNom()) && gs.getOrigine().equals(cy.getGuideAttache().getOrigine()) && gs.getDogme().equals(cy.getGuideAttache().getDogme()));{
    		    		for(int i = 0 ; i < croyantDeGuide.size() ; i++){
    		           		Croyant cy1 = cy.getGuideAttache().getCroyantAttache().get(i);
    		            	if(cy.getNom().equals(cy1.getNom()) && cy.getOrigine().equals(cy1.getOrigine()) && cy.getDogme().equals(cy1.getDogme())){
    		           			targetJoueur.getCarteGsEnjeu().remove(i); //删除与之连接的guide牌中与这张牌的连接信息
    		           			System.out.println("Une carte de Croyant " +cy.getNom() + " de Joueur " + targetJoueur.getNumeroJoueur() + " est défaussé");
    		           			break;
    		           		}
    		           	}
    		    		break;
    		    	 }
    		     }
    		    List croyantDeGuide2 = cy2.getGuideAttache().getCroyantAttache();
    		    for(int d = 0 ; d < targetJoueur.getCarteGsEnjeu().size() ; d++){
    		    	GuideSpirituel gs = (GuideSpirituel) targetJoueur.getCarteGsEnjeu().get(d);
    		    	if(gs.getNom().equals(cy2.getGuideAttache().getNom()) && gs.getOrigine().equals(cy2.getGuideAttache().getOrigine()) && gs.getDogme().equals(cy2.getGuideAttache().getDogme()));{
    		    		for(int i = 0 ; i < croyantDeGuide.size() ; i++){
    		           		Croyant cy1 = cy2.getGuideAttache().getCroyantAttache().get(i);
    		            	if(cy2.getNom().equals(cy1.getNom()) && cy2.getOrigine().equals(cy1.getOrigine()) && cy2.getDogme().equals(cy1.getDogme())){
    		           			targetJoueur.getCarteGsEnjeu().remove(i); //删除与之连接的guide牌中与这张牌的连接信息
    		           			System.out.println("Une carte de Croyant " +cy2.getNom() + " de Joueur " + targetJoueur.getNumeroJoueur() + " est défaussé");
    		           			break;
    		           		}
    		           	}
    		    		break;
    		    	 }
    		     }
    	  }else{
    		  System.out.println("Joueur" + targetJoueur.getNumeroJoueur() + " n'a pas de carte Croyant suffisant dans son espace");
    	  }
      }	
    	}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }
   }
}
