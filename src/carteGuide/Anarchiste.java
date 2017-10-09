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
import carteAction.Croyant;
import carteAction.GuideSpirituel;


public class Anarchiste extends GuideSpirituel {
	
	  //constructeur
	public Anarchiste(){
		super();
		this.nom="Anarchiste";
		this.dogme = "HumainChaos";
		this.origine = "Néant";
		this.nombreCroyant = 3;
		Image image = null;
	//	image = getImages.getPng("Anarchiste");
	//	this.setImage(image);
	}
	
	  //Sacrifie un Guide Spirituel, si lui ou sa Divinité ne croit pas au Dogme Chaos. 
	  //Les capacités spéciales sont jouées normalement.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
		System.out.println("Anarchiste:");
		System.out.println("Sacrifie un Guide Spirituel, si lui ou sa Divinité ne croit pas au Dogme Chaos." +
		    "Les capacités spéciales sont jouées normalement. ");
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
    	if(!targetJoueur.getDivinite().getDiviniteDogme().contains("Chaos")){
    		if(targetJoueur.getCarteGsEnjeu().size() != 0){
    		   	boolean FLAG = false;
    		    int n1 = -1;
    		      //targetJoueur est un JoueurVirtuel
    		    if(j.getNumeroJoueur() != 1){
    		    	int sizeEspaceCroyant;
    		    	sizeEspaceCroyant = targetJoueur.getCarteGsEnjeu().size();
    		    	n1 = new java.util.Random().nextInt(sizeEspaceCroyant);
    		    }else{
    		    	  //targetJoueur est un JoueurPhysique
    		    	while(FLAG == false){
    		        	System.out.println("Joueur " + 1 + " choisit un carte de Guide Spirituel dans l'espace personnel de Joueur qui ne croit pas Dogme Chaos" + targetJoueur.getNumeroJoueur());
    		           	n1 = sc.nextInt();
    		           	if(n1 >= 0 && n1 < targetJoueur.getCarteCroyantEnjeu().size()){
    		           		FLAG =true;
    		           	}else{
    		           		System.out.println("Ce numéro de carte n'est pas compris dans l'espace croyant de Joueur" + targetJoueur.getNumeroJoueur());
    		           		FLAG = false;
    		           	}
    		  	    }
        	    }
    			GuideSpirituel gs = (GuideSpirituel) targetJoueur.getCarteGsEnjeu().get(n1);
    			if(!gs.getDogme().contains("Chaos")){
    				targetJoueur.getCarteGsEnjeu().remove(gs);
    				gs.utiliserCapacite(j, partie.getPartie());
    				int sizeCroyant = gs.getCroyantAttache().size();  
    				List listCroyantEspace = new ArrayList();  
    				for(int i = sizeCroyant - 1 ; i >= 0 ; i--){  //在该玩家的espace的croyant牌堆中检测与该号码guide连接的croyant
    					Croyant cy = (Croyant)gs.getCroyantAttache().get(i); 
    					for(int ind = targetJoueur.getCarteCroyantEnjeu().size() -1 ; ind >= 0 ; ind--){
        					Croyant cy1 = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(ind);
        					if(cy.getNom().equals(cy1.getNom()) && cy.getDogme().equals(cy1.getDogme()) && cy.getOrigine().equals(cy1.getOrigine())){    
        						targetJoueur.getCarteCroyantEnjeu().remove(ind);//删除croyant牌堆中这些牌
        						break;
        					}
        					j.getCarteTable().ajouterCarte(cy);//将这些croyant添加至桌面中间
            				cy.setGuideAttache(null);  //删除这些croyant的连接的guide牌
        				}
    				}
    			}else{
    				System.out.println("Cette carte de Guide Spirituel a Domge Chaos");
    			}
    		}
    	}
		}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }
    	
    }
}
