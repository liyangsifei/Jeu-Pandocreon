package carteGuide;

import gui.Pandocreon_Frame;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import control.Joueur;
import control.Partie;
import carteAction.GuideSpirituel;


public class Clerc extends GuideSpirituel {
	//contructeur
    public Clerc(){
     super();
   	 this.nom="Clerc";
   	 this.nombreCroyant = 2;
    }
    
    //Fait gagner un nombre de points d'Action ¨¦gal au nombre de cartes de 
    //Croyants rattach¨¦es. L'Origine des points d'Action est au choix du joueur.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Clerc:");
    	if(partie.getPartie().isPeuxGagnePointAction()){
    		int sizeCroyant = j.getCarteCroyantEnjeu().size();
        	int i = -1;
        	if(j.getNumeroJoueur() != 1){
        		i = new java.util.Random().nextInt(3)+1;
        	}else{
        		boolean FLAG = false;
        		System.out.println("Joueur 1 choisit le type de point d'action que vous voulez");
        		System.out.println(" '1' = Jour");
        		System.out.println(" '2' = Nuit");
        		System.out.println(" '3' = N¨¦ant");
        		Scanner sc = new Scanner(System.in);
        		i = sc.nextInt();
        		while(FLAG == false){
        			if(i == 1 || i == 2 || i == 3){
        				FLAG = true;
        			}else{
        				System.out.println("Ce num¨¦ro n'est pas disponible, entrez 1 ou 2 ou 3 !");
        				FLAG = false;
        				i = sc.nextInt();
        			}
        		}
        	}
        	
        	if(i == 1){
        		j.setPointActionJour(j.getPointActionJour() + sizeCroyant);
        		System.out.println("Joueur " + j.getNumeroJoueur() + " a gagn¨¦ " + sizeCroyant + " point d'action Jour");
        	}else if(i == 2){
        		j.setPointActionNuit(j.getPointActionNuit() + sizeCroyant);
        		System.out.println("Joueur " + j.getNumeroJoueur() + " a gagn¨¦ " + sizeCroyant + " point d'action Jour");
        	}else if(i == 3){
        		j.setPointActionN¨¦ant(j.getPointActionN¨¦ant() + sizeCroyant);
        		System.out.println("Joueur " + j.getNumeroJoueur() + " a gagn¨¦ " + sizeCroyant + " point d'action Jour");
        	}
    	}else{
    		System.out.println("Dans ce tour, aucun joueur ne peux gagner de point d'action");
    	}
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    	
    }
}
