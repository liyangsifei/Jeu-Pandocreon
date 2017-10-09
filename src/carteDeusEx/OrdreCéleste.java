package carteDeusEx;

import control.Joueur;
import control.Partie;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.Croyant;
import carteAction.DeusEx;
import carteAction.GuideSpirituel;


public class OrdreCéleste extends DeusEx{
	  //contructeur
	public OrdreCéleste(){
		super();
		this.nom="OrdreCéleste";
		this.origine = "Jour";
		Image image = null;
	//	image = getImages.getPng("OrdreCeleste");
	//	this.setImage(image);
	}
	
	  //Vous récupérez un des Guides Spirituels posés devant une autre Divinité 
      //et le placez devant vous avec les Croyants qui y sont attachés.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
		 System.out.println("Utiliser Carte DeusEx: OrdreCéleste");
		 System.out.println("Il peut récupérez un des Guides Spirituels posés devant une autre Divinité et le placez devant vous avec les Croyants qui y sont attachés.");
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
   		      System.out.println("Ces sont la liste des joueurs avec ses guide spirituel");
   		      List ll =partie.getPartie().getJoueurs();
      	      Iterator itl = ll.iterator();
      	      int num=0;
        	  while(itl.hasNext()){
      		    Joueur  Jr = (Joueur)itl.next();
      		    System.out.println(num + "Ce joueur a les guides suivant dans espacePersonne:");
      		    List lg=Jr.getCarteGsEnjeu();
      		    Iterator itlg=lg.iterator();
      		    while(itlg.hasNext()){
      		    	GuideSpirituel g=(GuideSpirituel)itlg.next();
      		    	System.out.println(g.getNom());
      		    }
      		  }
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
		
		if(targetJoueur.getCarteGsEnjeu().size() != 0){
			boolean FLAG = false;
			GuideSpirituel gs = new GuideSpirituel();
			int n2 = -1;
			if(j.getNumeroJoueur() != 1){
				int sizeGuide = targetJoueur.getCarteGsEnjeu().size();
				n2 = new java.util.Random().nextInt(sizeGuide);
			}else{
				while(FLAG == false){
					System.out.println("Joueur "+ 1 + " choisir le carte guide spirituel que vous voulez retirez");
					Iterator g=targetJoueur.getCarteGsEnjeu().iterator();
					int i=0;
					while(g.hasNext()){
						GuideSpirituel g1=(GuideSpirituel)g.next();
						System.out.println(i+" "+g1.getNom() + " "+g1.getType()+" "+g1.getOrigine());
						i++;
					}
					n2 = sc.nextInt();
					if(n2 >= 0 && n2 < targetJoueur.getCarteGsEnjeu().size()){
						FLAG = true;
					}else{
						System.out.println("ce numéro n'est pas compris dans la carte Guide Spirituel de l'espace de joueur");
						FLAG = false;
					}
				}
			}
			gs = (GuideSpirituel) targetJoueur.getCarteGsEnjeu().get(n2);
			
			targetJoueur.getCarteGsEnjeu().remove(gs);
			int size = gs.getCroyantAttache().size();
			List listCroyantEspace = new ArrayList();
			    for(int i = 0 ; i < size ; i++){  //在该玩家的espace的croyant牌堆中检测与该号码guide连接的croyant
				    Croyant cy = (Croyant)gs.getCroyantAttache().get(i); 
				    for(int ind = 0 ; ind < targetJoueur.getCarteCroyantEnjeu().size() ; ind++){
					    Croyant cy1 = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(ind);
					    if(cy.getNom().equals(cy1.getNom()) && cy.getDogme().equals(cy1.getDogme()) && cy.getOrigine().equals(cy1.getOrigine())){    
						    targetJoueur.getCarteCroyantEnjeu().remove(ind);//删除croyant牌堆中这些牌
						    j.getCarteCroyantEnjeu().add(ind);
						    break;
					    }
				    }
				  
				   }
			j.getCarteGsEnjeu().add(gs);   
			
		 }else{
			System.out.println("Le joueur choisi n'a pas guide spirituel dans espace personne!");
		 }	
		}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }
	}
}