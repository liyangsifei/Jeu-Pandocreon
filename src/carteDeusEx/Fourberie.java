package carteDeusEx;

import control.Joueur;
import control.Partie;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.*;

import outils.getImages;
import carteAction.*;


public class Fourberie extends DeusEx{
	//contructeur
    public Fourberie(){
    	super();
   	 this.nom="Fourberie";
   	 this.origine = "Nuit";
   	Image image = null;
	//image = getImages.getPng("Fourberie");
	//this.setImage(image);
   	 
    }
    
    //Sacrifiez 2 cartes Croyants d'une autre Divinité. 
    //Les capacités spéciales ne sont pas jouées.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Utiliser Carte DeusEx: Fourberie");
    	System.out.println("Sacrifiez 2 cartes Croyants d'une autre Divinité. Les capacités spéciales ne sont pas jouées.");
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
    	  List croyants=new ArrayList();
    	  Iterator c=cartes.iterator();
    	  int numCroyant=0;
    	  while(c.hasNext()){
    		   CarteAction carte=(CarteAction)c.next();
    		   if(carte.getType()=="Croyant"){
    			  croyants.add(carte);
    			  numCroyant++;
    		   }
    	   }
    	  
    			  
    			
    			boolean FLAG = false;
    			
    			if(numCroyant > 2){
    				int m1 = -1;
    				int m2 = -1;
    				int sizeMain=croyants.size();
    				if(j.getNumeroJoueur() != 1){
    					sizeMain = targetJoueur.getCarteEnMain().size();
    					while(m1 == m2){
    						m1 = new java.util.Random().nextInt(sizeMain);
    						m2 = new java.util.Random().nextInt(sizeMain);
    					}
    				}else{
    					while(FLAG == false){
    						System.out.println("Ces sont les cartes croyants!");
    						Iterator cro=croyants.iterator();
    						int numero=0;
    						while(cro.hasNext()){
    							Croyant croyantEnMain=(Croyant)cro.next();
    							System.out.println(numero + croyantEnMain.getNom());
    							numero++;
    						}
    						System.out.println("Joueur " + 1 + " choisit deux carte en main de Joueur " + targetJoueur.getNumeroJoueur());
    						m1= sc.nextInt();
    						m2 = sc.nextInt();
    						if(m1 >= 0 && m1 < numCroyant && m2 >= 0 && m2 < numCroyant && m1 !=m2) {
    							FLAG = true;
    						}else{
    							System.out.println("Il y a des erreurs avec le numero vous avez saisi!");
    							FLAG = false;
    						}
    					}
    				}
    						Croyant cy1 =(Croyant)croyants.get(m1);
    						Croyant cy2 =(Croyant)croyants.get(m2);
    					
    						 //Eviter de supprimer la carte à l'avance et le numéro dans List CarteEnMain change
    						if(m1 > m2){
    							
    							targetJoueur.getCarteEnMain().remove(cy1);
    							targetJoueur.getCarteEnMain().remove(cy2);
    						}else{
    							targetJoueur.getCarteEnMain().remove(cy2);
    							targetJoueur.getCarteEnMain().remove(cy1);
    						}
    						System.out.println("joueur " + j.getNumeroJoueur() + " a déjà sacrifié deux cartes croyants de joueur " + targetJoueur.getNumeroJoueur() + "!");
    				
    			}else if(numCroyant==1||numCroyant==2){
    				System.out.println("Il y a "+numCroyant+ " croyants, vous n'avez pas besoin de choisir les cartes Croyants");
    				 Iterator cs=cartes.iterator();
    		    	  while(cs.hasNext()){
    		    		   CarteAction carte=(CarteAction)cs.next();
    		    		   if(carte.getType()=="Croyant"){
    		    			   targetJoueur.getCarteEnMain().remove(carte);
    		    		   }
    		    	   }
    		    	  
    				
    			}else{
    				System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " a moins de deux carte en main");
    			}
    	}else{
	    	System.out.println("Sa capacite a été annulée déja! ");
	    }		
    			
    }
}
