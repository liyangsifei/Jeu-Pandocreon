package carteDeusEx;

import control.Joueur;
import control.Partie;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import outils.getImages;

import carteAction.*;


public class Inquisition extends DeusEx{
	//contructeur
    public Inquisition(){
    	super();
   	 this.nom="Inquisition";
   	 this.origine = "";
   	Image image = null;
//	image = getImages.getPng("Inquisition");
	//this.setImage(image);
    }
    
    //Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. 
    //Lancez le dé de Cosmogonie. Sur Jour, le Guide adverse est sacrifié, 
    //sur Nuit le votre est sacrifié, sur Néant rien ne se passe. Les
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	 System.out.println("Utiliser Carte DeusEx: Inquisition");
    	 System.out.println("Choisissez un des Guides Spirituels d'un autre joueur, et l'un des votres. Lancez le dé de Cosmogonie. Sur Jour,le Guide adverse est sacrifié, sur Nuit le votre est sacrifié, sur Néant rien ne se passe. ");
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
 		/**
 		 * 这里是由被选择的玩家输入的哪张牌
 		 */
     	  //le targetJoueur qui choisit la carte Croyant à sacrifice
     	  List cartes=targetJoueur.getCarteEnMain();
     	  List guides=new ArrayList();
     	  Iterator c=cartes.iterator();
     	  int numGuide=0;
     	  while(c.hasNext()){
     		   CarteAction carte=(CarteAction)c.next();
     		   if(carte.getType()=="GuideSpirituel"){
     			  guides.add(carte);
     			  numGuide++;
     		   }
     	   }
     	  
     	 List cartesP=j.getCarteEnMain();
     	 List guidesP=new ArrayList();
   	     Iterator cP=cartes.iterator();
   	     int numGuideP=0;
   	      while(cP.hasNext()){
   		     CarteAction carte=(CarteAction)cP.next();
   		     if(carte.getType()=="GuideSpirituel"){
   			    guidesP.add(carte);
   			    numGuideP++;
   		    }
   	      }
   	      
   	   
     			
     			boolean FLAG = false;
     			
     			if(numGuide > 1&& numGuideP > 1){
     				int m1 = -1;
     				int m2 = -1;
     				int sizeMain=guides.size();
     				int sizeMainP=guidesP.size();
     				if(j.getNumeroJoueur() != 1){
     					    sizeMain = guides.size();
     					    sizeMainP = guidesP.size();
     						m1 = new java.util.Random().nextInt(sizeMain);
     						m2 = new java.util.Random().nextInt(sizeMainP);
     				}else{
     					while(FLAG == false){
     						System.out.println("Ces sont ses cartes guide spirituel !");
     						Iterator gs=guides.iterator();
     						int numero=0;
     						while(gs.hasNext()){
     							GuideSpirituel guideEnMain=(GuideSpirituel)gs.next();
     							System.out.println(numero + guideEnMain.getNom());
     							numero++;
     						}
     						System.out.println("Joueur " + 1 + " choisit un guide spirituel en main de Joueur " + targetJoueur.getNumeroJoueur());
     						m1= sc.nextInt();
     						
     						if(m1 >= 0 && m1 < numGuide ) {
     							FLAG = true;
     						}else{
     							System.out.println("Il y a des erreurs avec le numero vous avez saisi!");
     							FLAG = false;
     						}
     						System.out.println("Ces sont vos cartes guide spirituel !");
     						Iterator gsP=guidesP.iterator();
     						int numeroP=0;
     						while(gsP.hasNext()){
     							GuideSpirituel guideEnMain=(GuideSpirituel)gsP.next();
     							System.out.println(numeroP + guideEnMain.getNom());
     							numeroP++;
     						}
     						System.out.println("Joueur " + 1 + " choisit un des guide spirituel en main ");
     						m2= sc.nextInt();
     						
     						if(m2 >= 0 && m2 < numGuideP ) {
     							FLAG = true;
     						}else{
     							System.out.println("Il y a des erreurs avec le numero vous avez saisi!");
     							FLAG = false;
     						}
     					}
     				}
     				    Random r=new Random();
     					int resultat = r.nextInt(3);
     					int resultatDe=(int)Math.floor(resultat);
     					if(resultatDe==0){
     						System.out.println("Face Jour! Sacrifier son guide!");
     						GuideSpirituel g=(GuideSpirituel)guides.get(m1);
     						g.utiliserCapacite(j, partie.getPartie());
     						targetJoueur.getCarteEnMain().remove(g);
     					}else if(resultatDe==1){
     						System.out.println("Face Nuit! Sacrifier ton guide!");
     						GuideSpirituel g=(GuideSpirituel)guidesP.get(m2);
     						g.utiliserCapacite(j, partie.getPartie());
     						j.getCarteEnMain().remove(g);
     					}else if(resultatDe==2){
     						System.out.println("Face Néant!");
     					}
     					
     					
     						 //Eviter de supprimer la carte à l'avance et le numéro dans List CarteEnMain change
     						
     				
     			  }else if(numGuide==1&&numGuideP>1){
     				
     				
      				int m2 = -1;
      				int sizeMain=guides.size();
      				int sizeMainP=guidesP.size();
      				if(j.getNumeroJoueur() != 1){
      					   
      					    sizeMainP = guidesP.size();
      						
      						m2 = new java.util.Random().nextInt(sizeMainP);
      				}else{
      					while(FLAG == false){
      						
      						System.out.println("Ces sont vos cartes guide spirituel !");
      						Iterator gsP=guidesP.iterator();
      						int numeroP=0;
      						while(gsP.hasNext()){
      							GuideSpirituel guideEnMain=(GuideSpirituel)gsP.next();
      							System.out.println(numeroP + guideEnMain.getNom());
      							numeroP++;
      						}
      						System.out.println("Joueur " + 1 + " choisit un des guide spirituel en main ");
      						m2= sc.nextInt();
      						
      						if(m2 >= 0 && m2 < numGuideP ) {
      							FLAG = true;
      						}else{
      							System.out.println("Il y a des erreurs avec le numero vous avez saisi!");
      							FLAG = false;
      						}
      					}
      				}
      				    Random r=new Random();
      					int resultat = r.nextInt(3);
      					int resultatDe=(int)Math.floor(resultat);
      					if(resultatDe==0){
      						System.out.println("Face Jour! Sacrifier son guide!");
      						GuideSpirituel g=(GuideSpirituel)guides.get(0);
      						g.utiliserCapacite(j, partie.getPartie());
      						targetJoueur.getCarteEnMain().remove(g);
      					}else if(resultatDe==1){
      						System.out.println("Face Nuit! Sacrifier ton guide!");
      						GuideSpirituel g=(GuideSpirituel)guidesP.get(m2);
      						g.utiliserCapacite(j, partie.getPartie());
      						j.getCarteEnMain().remove(g);
      					}else if(resultatDe==2){
      						System.out.println("Face Néant!");
      					}
      					
      					
      						 //Eviter de supprimer la carte à l'avance et le numéro dans List CarteEnMain change
      						
     			}else if(numGuide>1&&numGuide==1){
     				int m1 = -1;
     			
     				int sizeMain=guides.size();
     				
     				if(j.getNumeroJoueur() != 1){
     					    sizeMain = guides.size();
     					   
     						m1 = new java.util.Random().nextInt(sizeMain);
     						
     				}else{
     					while(FLAG == false){
     						System.out.println("Ces sont ses cartes guide spirituel !");
     						Iterator gs=guides.iterator();
     						int numero=0;
     						while(gs.hasNext()){
     							GuideSpirituel guideEnMain=(GuideSpirituel)gs.next();
     							System.out.println(numero + guideEnMain.getNom());
     							numero++;
     						}
     						System.out.println("Joueur " + 1 + " choisit un guide spirituel en main de Joueur " + targetJoueur.getNumeroJoueur());
     						m1= sc.nextInt();
     						
     						if(m1 >= 0 && m1 < numGuide ) {
     							FLAG = true;
     						}else{
     							System.out.println("Il y a des erreurs avec le numero vous avez saisi!");
     							FLAG = false;
     						}
     						
     					}
     				}
     				    Random r=new Random();
     					int resultat = r.nextInt(3);
     					int resultatDe=(int)Math.floor(resultat);
     					if(resultatDe==0){
     						System.out.println("Face Jour! Sacrifier son guide!");
     						GuideSpirituel g=(GuideSpirituel)guides.get(m1);
     						g.utiliserCapacite(j, partie.getPartie());
     						targetJoueur.getCarteEnMain().remove(g);
     					}else if(resultatDe==1){
     						System.out.println("Face Nuit! Sacrifier ton guide!");
     						GuideSpirituel g=(GuideSpirituel)guidesP.get(0);
     						g.utiliserCapacite(j, partie.getPartie());
     						j.getCarteEnMain().remove(g);
     					}else if(resultatDe==2){
     						System.out.println("Face Néant!");
     					}
     					
     					
    				
    			}else if(numGuide==1&&numGuide==1){
     				
    				Random r=new Random();
 					int resultat = r.nextInt(3);
 					int resultatDe=(int)Math.floor(resultat);
 					if(resultatDe==0){
 						System.out.println("Face Jour! Sacrifier son guide!");
 						GuideSpirituel g=(GuideSpirituel)guides.get(0);
 						g.utiliserCapacite(j, partie.getPartie());
 						targetJoueur.getCarteEnMain().remove(g);
 					}else if(resultatDe==1){
 						System.out.println("Face Nuit! Sacrifier ton guide!");
 						GuideSpirituel g=(GuideSpirituel)guidesP.get(0);
 						g.utiliserCapacite(j, partie.getPartie());
 						j.getCarteEnMain().remove(g);
 					}else if(resultatDe==2){
 						System.out.println("Face Néant!");
 					}
 					
    				
    			}else{
     				System.out.println(" Il y a pas de carte Guide Spirituel en main");
     			}
    	}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }
    }
}
