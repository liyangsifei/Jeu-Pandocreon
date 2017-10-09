package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.Croyant;
import control.Joueur;
import control.Partie;


public class Illusionnistes extends Croyant{
	//contructeur
    public Illusionnistes(){
     super();
   	 this.nombrePuissance = 4;
   	 this.nom = "Illusionnistes";
   	 this.origine = "Nuit";
   	 this.dogme = "SymbolesHumainChaos";
   	Image image = null;
	//image = getImages.getPng("Illusionnistes");
	//this.setImage(image);
    }
    
      //Vous b¨¦n¨¦ficiez de la capacit¨¦ sp¨¦ciale de sacrifice d'une carte de Croyants 
      //appartenant ¨¤ une autre Divinit¨¦. La carte en question reste en jeu.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Illusionnistes:");
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
    		System.out.println("Vous b¨¦n¨¦ficiez de la capacit¨¦ sp¨¦ciale de sacrifice d'une carte de Croyants appartenant ¨¤ une autre Divinit¨¦. " +
    				"La carte en question reste en jeu.");
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
		
	   if(targetJoueur.getCarteCroyantEnjeu().size() != 0){
		   boolean FLAG = false;
		   int n2 = -1;
		   if(j.getNumeroJoueur() != 1){
			   int sizeEspaceCroyant;
			   sizeEspaceCroyant = targetJoueur.getCarteCroyantEnjeu().size();
			   n2= new java.util.Random().nextInt(sizeEspaceCroyant);
		   }else{
			   while(FLAG == false){
				   System.out.println("Joueur " + 1 + " saisit le num¨¦ro de carte dans l'espace croyant de Joueur " + targetJoueur.getNumeroJoueur());
				   n2 = sc.nextInt();
				   if(n2 >= 0 && n2 < targetJoueur.getCarteCroyantEnjeu().size()){
					   FLAG = true;
				   }else{
					   System.out.println("Ce num¨¦ro de carte n'est pas compris dans l'espace de ce joueur");
					   FLAG = false;
				   }
			   }
		   }
			Croyant cy = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(n2);
			j.utiliserCroyant(cy,partie.getPartie());
			System.out.println("Joueur " + j.getNumeroJoueur() + " a b¨¦n¨¦fici¨¦ de la capacit¨¦ de sacrifice de la carte de Croyant " + cy.getNom());
		}else{
			System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " n'a pas de carte de Croyant dans son espace personnel");
		}
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
