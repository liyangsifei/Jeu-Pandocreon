package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.Croyant;
import control.Joueur;
import control.Partie;

public class Pillards extends Croyant {
	  //constructeur
	public Pillards(){
		super();
		this.nombrePuissance = 4;
		this.nom = "Pillards";
		this.origine = "Nuit";
		this.dogme = "MystiqueNatureSymboles";
		Image image = null;
		//image = getImages.getPng("Pillards");
	//	this.setImage(image);
    }
	
	  //R¨¦cup¨¦rez les points d'Action d'une Divinit¨¦ n'ayant pas encore jou¨¦ durant ce tour. 
      //Les points d'Action gardent leur Origine. La Divinit¨¦ perd ses points.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	System.out.println("Pillards:");
    	boolean FLAG = false;
    	if(partie.getPartie().isPeuxGagnePointAction()){
    		List listJoueurs = partie.getPartie().getJoueurs();
    		Joueur j2 = j;
    		int i = -1;
    		int n = -1;
    		for(i = 0 ; i < listJoueurs.size() ; i++){
    			j2 = (Joueur) listJoueurs.get(i);
    			if(j2.getNumeroJoueur() == partie.getPartie().getPremierJoueurCompter().getNumeroJoueur()){
    				break;
    			}
    		}
    		if(j2.getNumeroJoueur() == 1){
    			System.out.println("Il n'y a pas de joueur qui joue apr¨¨s vous dans ce tour!");
    		}else{
    			boolean FLAG2 = false;
    			Scanner sc = new Scanner(System.in);
    			if(j.getNumeroJoueur() != 1 ){
    				n = new java.util.Random().nextInt(i-1)+1;
    				System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur num¨¦ro " + n);
    			}else{
    				while(FLAG2 == false){
    					System.out.println("Joueur " + j.getNumeroJoueur() + " choisit un joueur qui n'a pas encore jou¨¦, entrer son num¨¦ro."
    	       	       			 + "Vous pouvez choisir entre " + 1 + "(Compris) et " + (i-1) + " (Compris)");
    	    			System.out.println("R¨¦cup¨¦rez les points d'Action d'une Divinit¨¦ n'ayant pas encore jou¨¦ durant ce tour." +
    	    					"Les points d'Action gardent leur Origine. La Divinit¨¦ perd ses points.");
    	    			n = sc.nextInt();
    	    			if(n <= (i-1) && n>= 1){
        					FLAG = true;
        				}else{
        					System.out.println("Vous avez choisi un joueur interdit!");
        					FLAG = false;
        				}
    				}
    			}	
    			List l = partie.getPartie().getJoueurs();
	    		Iterator it = l.iterator();
	    		Joueur targetJoueur = j;
	    		while(it.hasNext()){
	    			Joueur j1 = (Joueur)it.next();
	    			if(j1.getNumeroJoueur() == n){
	    				targetJoueur = j1;
	    				break;
	    			}
	    		}
	    		j.setPointActionJour(j.getPointActionJour() + targetJoueur.getPointActionJour());
	    		j.setPointActionNuit(j.getPointActionNuit() + targetJoueur.getPointActionNuit());
	    		j.setPointActionN¨¦ant(j.getPointActionN¨¦ant() + targetJoueur.getPointActionN¨¦ant());
	    		targetJoueur.setPointActionJour(0);
	    		targetJoueur.setPointActionNuit(0);
	    		targetJoueur.setPointActionN¨¦ant(0);
    		}
    	}else{
    		System.out.println("Aucun joueur ne peux gagner de point d'action avant le terminal de ce tour");
    	}
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    	
    }

}
