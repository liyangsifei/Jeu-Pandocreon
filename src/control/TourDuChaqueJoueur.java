package control;
import gui.Pandocreon_Frame;

import java.util.*;

import carteAction.CarteAction;

public class TourDuChaqueJoueur{
   private Joueur joueur;
   //private static Partie partie;
   //creer un nouvel tour pour chaque joueur
   public TourDuChaqueJoueur(Joueur joueur){
	   //this.partie = partie.getPartie();
	   this.joueur=joueur;
	   System.out.println("Tour du joueur"+this.joueur.getNumeroJoueur());
   }
   public void choisirAction(Partie p){
	   if(this.joueur.getNumeroJoueur()==1){
		   this.joueur.carteTable.printCarteTable();
		   //C'est tour de joueur physique
		   System.out.println("Votre cartes en main sont:");
		   List cartes=this.joueur.getCarteEnMain();
		   Iterator it=cartes.iterator();
		   while(it.hasNext()){
			   CarteAction carte=(CarteAction)it.next();
			   System.out.println(carte.getNom()+" "+carte.getType()+" "+carte.getOrigine());
		   }
		   int nb=this.joueur.choisirNumeroDuAction(p);
	       this.joueur.Action(nb,p);
	       this.joueur.carteTable.printCarteTable();
	   }else{
		   // c'est tour de joueur virtuel
		   int numeroDuAction=this.joueur.choisirNumeroDuAction(p);
		   this.joueur.Action(numeroDuAction,p);
		   this.joueur.carteTable.printCarteTable();
	   }
	   
	    p.getPartie().notifyO();
   }
public Joueur getJoueur() {
	return joueur;
}
public void setJoueur(Joueur joueur) {
	this.joueur = joueur;
}
   
   
}
