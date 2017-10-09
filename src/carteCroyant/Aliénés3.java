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

public class Ali¨¦n¨¦s3 extends Croyant {
	
	  //constructeur
	public Ali¨¦n¨¦s3(){
		super();
		this.nombrePuissance = 2;
		this.nom = "Ali¨¦n¨¦s3";
		this.origine = "N¨¦ant";
		this.dogme = "SymbolesHumainNature";
		Image image = null;
	//	image = getImages.getPng("Aliene2");
		//this.setImage(image);
    }
	
	  //Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Chaos ou Mystique 
	  //de sacrifier un de ses Guides Spirituels durant ce tour.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
		
		System.out.println("Ali¨¦n¨¦s3:");
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
			System.out.println("Emp¨ºche une Divinit¨¦ poss¨¦dant le Dogme Chaos ou Mystique " +
					" de sacrifier un de ses Guides Spirituels durant ce tour de jeu.");
			n = sc.nextInt();
			System.out.println("Joueur" + 1 + " a choisi Joueur num¨¦ro " + n);
		}
		List l = partie.getPartie().getJoueurs();
		Iterator it = l.iterator();
		while(it.hasNext()){
			targetJoueur = (Joueur)it.next();
			if(targetJoueur.getNumeroJoueur() == n){
				break;
			}
		}
			
			 //D¨¦cider si pouvoir choisir ce joueur(Dogme)
			if(targetJoueur.getDivinite().getDiviniteDogme().contains("Chaos")|| targetJoueur.getDivinite().getDiviniteDogme().contains("Mystique")){
				if(targetJoueur.getCarteGsEnjeu().size() != 0){
		    		boolean FLAG = false;
		    		int n1 = -1;
		    		  //targetJoueur est un JoueurVirtuel
		    		if(j.getNumeroJoueur() != 1){
		    			int sizeEspaceGuide;
		    			sizeEspaceGuide = targetJoueur.getCarteGsEnjeu().size();
		    			n1 = new java.util.Random().nextInt(sizeEspaceGuide);
		    		}else{
		    			  //targetJoueur est un JoueurPhysique
		    			while(FLAG == false){
		        			System.out.println("Joueur " + 1 + " choisit un carte de GuideSpirituel dans l'espace personnel de Joueur " + targetJoueur.getNumeroJoueur());
		            		n1 = sc.nextInt();
		            		if(n1 >= 0 && n1 < targetJoueur.getCarteGsEnjeu().size()){
		            			FLAG =true;
		            		}else{
		            			System.out.println("Ce num¨¦ro de carte n'est pas compris dans l'espace croyant de Joueur" + targetJoueur.getNumeroJoueur());
		            			FLAG = false;
		            		}
		    		    }
		        	}
		    		
					GuideSpirituel gs = (GuideSpirituel)targetJoueur.getCarteGsEnjeu().get(n1);
		    		targetJoueur.getCarteGsEnjeu().remove(n1);
		    		System.out.println("Joueur " + j.getNumeroJoueur() + " a utilis¨¦ une carte de GuideSpirituel " + gs.getNom());
		    		j.utiliserGuideSpirituel(gs,partie.getPartie());
		    		
		    		for(int d = 0 ; d < gs.getCroyantAttache().size() ; d++){
		    			Croyant cy = (Croyant)targetJoueur.getCarteGsEnjeu().get(d);
		    			for(int i = 0 ; i < targetJoueur.getCarteCroyantEnjeu().size() ; i++){
		    				Croyant cy1 = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(i);
		    				if(cy.getNom().equals(cy1.getNom()) && cy.getOrigine().equals(cy1.getOrigine()) && cy.getDogme().equals(cy1.getDogme())){
		    					targetJoueur.getCarteCroyantEnjeu().remove(i);
		    					System.out.println("Une carte de Croyant " +cy.getNom() + " qui attach¨¦ avec ce Guide Spirituel de Joueur " + targetJoueur.getNumeroJoueur() + " est d¨¦fauss¨¦");
		    					break;
		    				}
		    			}
		    		}
		    		
		    	}else{
		    		System.out.println("Joueur" + targetJoueur.getNumeroJoueur() + " n'a pas de carte Croyant dans son espace");
		    	}
		}}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
	}
}
