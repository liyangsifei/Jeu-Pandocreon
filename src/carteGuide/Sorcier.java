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


public class Sorcier extends GuideSpirituel{
	
	  //constructeur
	public Sorcier(){
		super();
		this.nom="Sorcier";
		this.dogme = "MystiqueSymboles";
		this.origine = "Nuit";
		this.nombreCroyant = 3;
		Image image = null;
	//	image = getImages.getPng("Sorcier");
	//	this.setImage(image);
	}
	
	  //Echangez l'un de vos Guides Spirituels avec un d'une autre Divinit¨¦. 
	  //Vous choisissez les deux guides Spirituels en question. 
	  //Les Croyants restent attach¨¦s aux m¨ºmes cartes.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
		System.out.println("Sorcier:");
		System.out.println("Echangez l'un de vos Guides Spirituels avec un d'une autre Divinit¨¦." +
		    "Vous choisissez les deux guides Spirituels en question. Les Croyants restent attach¨¦s aux m¨ºmes cartes.");
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
		
		  //Choisir deux Guide Spirituel
		if(j.getCarteGsEnjeu().size() != 0 && targetJoueur.getCarteGsEnjeu().size() != 0){
			boolean FLAG1 = false;
			boolean FLAG2 = false;
			Scanner sc1 = new Scanner(System.in);
			int g1 = -1;
			int g2 = -1;
			if(j.getNumeroJoueur() != 1){
				int size1 = j.getCarteGsEnjeu().size();
				int size2 = targetJoueur.getCarteGsEnjeu().size();
				g1 = new java.util.Random().nextInt(size1);
				g2 = new java.util.Random().nextInt(size2);
			}else{
				//Choisir guide spirituel de joueur j
				while(FLAG1 == false){
					System.out.println("Entrer le num¨¦ro de Guide Spiruel dans votre espace personnel");
					g1 = sc1.nextInt();
					if(g1 >= 0 && g1 < j.getCarteGsEnjeu().size()){
						FLAG1 = true;
					}else{
						System.out.println("Ce num¨¦ro de carte Guide Spirituel n'est pas compris dans votre espace personnel");
						g1 = sc1.nextInt();
						FLAG1 = false;
					}
				}
				  //Choisir guide spirituel de targetJoueur
				while(FLAG2 == false){
					System.out.println("Entrer le num¨¦ro de Guide Spiruel dans l'espace personnel de joueur choisi");
					g2 = sc1.nextInt();
					if(g2 >= 0 && g2 < j.getCarteGsEnjeu().size()){
						FLAG2 = true;
					}else{
						System.out.println("Ce num¨¦ro de carte Guide Spirituel n'est pas compris dans l'espace personnel de joueur choisi");
						g2 = sc1.nextInt();
						FLAG2 = false;
					}
				}
			}
			
			GuideSpirituel gs1 = (GuideSpirituel)j.getCarteGsEnjeu().get(g1);
			GuideSpirituel gs2 = (GuideSpirituel)targetJoueur.getCarteGsEnjeu().get(g2);
			
			j.getCarteGsEnjeu().remove(g1);
			targetJoueur.getCarteGsEnjeu().remove(g2);
			
			j.getCarteGsEnjeu().add(gs2);
			targetJoueur.getCarteGsEnjeu().add(gs1);
			
			for(int i = j.getCarteCroyantEnjeu().size() - 1 ; i >= 0 ; i++){
				Croyant cy = (Croyant)j.getCarteCroyantEnjeu().get(i);
				if(cy.getGuideAttache().getNom().equals(gs1.getNom()) && cy.getGuideAttache().getOrigine().equals(gs1.getOrigine()) && cy.getGuideAttache().getDogme().equals(gs1.getDogme())){
					j.getCarteCroyantEnjeu().remove(cy);
					targetJoueur.getCarteCroyantEnjeu().add(cy);
				}
			}
			
			for(int i = targetJoueur.getCarteCroyantEnjeu().size() - 1 ; i >= 0 ; i++){
				Croyant cy = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(i);
				if(cy.getGuideAttache().getNom().equals(gs2.getNom()) && cy.getGuideAttache().getOrigine().equals(gs2.getOrigine()) && cy.getGuideAttache().getDogme().equals(gs2.getDogme())){
					targetJoueur.getCarteCroyantEnjeu().remove(cy);
					j.getCarteCroyantEnjeu().add(cy);
				}
			}
			System.out.println("Joueur " + j.getNumeroJoueur() + " et Joueur " + targetJoueur.getNumeroJoueur() + " a chang¨¦ une carte Guide Spirituel");
			
		}else{
			System.out.println("Ce joueur ou vous-m¨ºme n'a pas de carte Guide Spirituel dans l'espace personnel");
		}
		}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }}
}
