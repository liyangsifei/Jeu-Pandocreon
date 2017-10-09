package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteTable;
import carteAction.Croyant;
import carteAction.GuideSpirituel;
import control.Joueur;
import control.Partie;


public class GuerriersSaints extends Croyant{
	protected CarteTable carteTable=CarteTable.getCarteTable();
	//constructeur
    public GuerriersSaints(){
    	super();
    	this.nombrePuissance = 4;
    	this.nom = "GuerriersSaints";
    	this.origine = "Jour";
    	this.dogme = "MystiqueNatureSymboles";
    	Image image = null;
		//image = getImages.getPng("GurrriersSaints");
	
    }
    
      //Un Guide Spirituel revient dans la main de sa Divinité. 
      //Ses Croyants reviennent au centre de la table.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("GuerriersSaints:");
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
    		System.out.println("Un Guide Spirituel revient dans la main de sa Divinité. " +
    				"Ses Croyants reviennent au centre de la table.");
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
		
		if(targetJoueur.getCarteGsEnjeu().size() != 0){
			boolean FLAG = false;
    		int n1 = -1;
			if(j.getNumeroJoueur() != 1){
    			int sizeEspaceGuide;
    			sizeEspaceGuide = targetJoueur.getCarteGsEnjeu().size();
    			n1 = new java.util.Random().nextInt(sizeEspaceGuide);
    		}else{
    			  //targetJoueur est un JoueurPhysique
    			while(FLAG == false){
        			System.out.println("Joueur " + 1 + " choisit un carte de Guide Spirituel dans l'espace personnel de Joueur " + targetJoueur.getNumeroJoueur());
            		n1 = sc.nextInt();
            		if(n1 >= 0 && n1 < targetJoueur.getCarteGsEnjeu().size()){
            			FLAG =true;
            		}else{
            			System.out.println("Ce numéro de carte n'est pas compris dans l'espace croyant de Joueur" + targetJoueur.getNumeroJoueur());
            			FLAG = false;
            		}
    		    }
        	}
			GuideSpirituel gs = new GuideSpirituel();
			gs = (GuideSpirituel) targetJoueur.getCarteGsEnjeu().get(n1);
			targetJoueur.getCarteEnMain().add(gs);
			targetJoueur.getCarteGsEnjeu().remove(gs);
			int size = gs.getCroyantAttache().size();
			List listCroyantEspace = new ArrayList();
			for(int i = 0 ; i < size ; i++){  //在该玩家的espace的croyant牌堆中检测与该号码guide连接的croyant
				Croyant cy = (Croyant)gs.getCroyantAttache().get(i); 
				for(int ind = 0 ; ind < targetJoueur.getCarteCroyantEnjeu().size() ; ind++){
					Croyant cy1 = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(ind);
					if(cy.getNom().equals(cy1.getNom()) && cy.getDogme().equals(cy1.getDogme()) && cy.getOrigine().equals(cy1.getOrigine())){    
						targetJoueur.getCarteCroyantEnjeu().remove(ind);//删除croyant牌堆中这些牌
						break;
					}
				}
				j.getCarteTable().ajouterCarte(cy);//将这些croyant添加至桌面中间
				cy.setGuideAttache(null);  //删除这些croyant的连接的guide牌
				}
			for(int i = 0 ; i < size ; i++){
				gs.getCroyantAttache().remove(0); //删除此guide牌的连接的croyant数组
			}		
		}
    	}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }	
	}
}

