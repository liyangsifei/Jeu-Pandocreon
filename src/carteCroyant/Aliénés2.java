package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.GuideSpirituel;
import control.Joueur;
import control.Partie;

public class Aliénés2 extends Croyant {
	public Aliénés2(){
		super();
		this.nombrePuissance = 2;
		this.nom = "Aliénés2";
		this.origine = "Néant";
		this.dogme = "SymbolesHumainChaos";
		Image image = null;
	//	image = getImages.getPng("Aliene1");
	//	this.setImage(image);
	}
	
	//Empêche une Divinité possédant le Dogme Nature ou Mystique 
	//de sacrifier une de ses cartes de Croyants durant ce tour.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
		System.out.println("Aliénés2:");
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
			System.out.println("Empêche une Divinité possédant le Dogme Nature ou Mystique de" +
					" sacrifier une de ses cartes de Croyants durant ce tour de jeu");
			n = sc.nextInt();
			System.out.println("Joueur" + 1 + " a choisi Joueur numéro " + n);
		}
		List l = partie.getPartie().getJoueurs();
		Iterator it = l.iterator();
		while(it.hasNext()){
			targetJoueur = (Joueur)it.next();
			if(targetJoueur.getNumeroJoueur() == n){
				break;
			}
		}
		
		 //Décider si pouvoir choisir ce joueur(Dogme)
		if(targetJoueur.getDivinite().getDiviniteDogme().contains("Nature")|| targetJoueur.getDivinite().getDiviniteDogme().contains("Mystique")){
			if(targetJoueur.getCarteCroyantEnjeu().size() != 0){
	    		boolean FLAG = false;
	    		int n1 = -1;
	    		  //targetJoueur est un JoueurVirtuel
	    		if(j.getNumeroJoueur() != 1){
	    			int sizeEspaceCroyant;
	    			sizeEspaceCroyant = targetJoueur.getCarteCroyantEnjeu().size();
	    			n1 = new java.util.Random().nextInt(sizeEspaceCroyant);
	    		}else{
	    			  //targetJoueur est un JoueurPhysique
	    			while(FLAG == false){
	        			System.out.println("Joueur " + 1 + " choisit un carte de Croyant dans l'espace personnel de Joueur " + targetJoueur.getNumeroJoueur());
	            		n1 = sc.nextInt();
	            		if(n1 >= 0 && n1 < targetJoueur.getCarteCroyantEnjeu().size()){
	            			FLAG =true;
	            		}else{
	            			System.out.println("Ce numéro de carte n'est pas compris dans l'espace croyant de Joueur" + targetJoueur.getNumeroJoueur());
	            			FLAG = false;
	            		}
	    		    }
	        	}
	    		
				Croyant cy = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(n1);
	    		targetJoueur.getCarteCroyantEnjeu().remove(n1);
	    		System.out.println("Joueur " + j.getNumeroJoueur() + " a utilisé une carte de Croyant " + cy.getNom());
	    		j.utiliserCroyant(cy,partie.getPartie());
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
	    		
	    	}else{
	    		System.out.println("Joueur" + targetJoueur.getNumeroJoueur() + " n'a pas de carte Croyant dans son espace");
	    	}
		}
		}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }
	}

}
