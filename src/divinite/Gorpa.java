package divinite;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;
import control.Joueur;
import control.Partie;

public class Gorpa extends Divinite {
	
	  //constructeur
	public Gorpa(){
		super();
		this.setNom("Gorpa");
		this.setDiviniteOrigine("Crépuscule");
		this.setDiviniteDogme("HumainSymbolesChaos");
	//	Image image = null;
	//	image = getImages.getPng("Gorpa");
	//	this.setImageDivinite(image);
	}
	  
	  //Peut récupérer les points d'Action d'une autre Divinité en plus des siens. 
	  //Et l'autre Divinité ne recoit aucun point d'Action ce tour-ci.
	public void capaciteDivinite(Partie partie,Joueur j){
		if(capacite == true){
			System.out.println("Gorpa:");
			System.out.println("Peut récupérer les points d'Action d'une autre Divinité en plus des siens." +
					"Et l'autre Divinité ne recoit aucun point d'Action ce tour-ci.");
			  //Choisir un joueur et le chercher dans List joueurs
			Scanner sc = new Scanner(System.in);
			Joueur targetJoueur = j;
			int sizeJoueur;
			int n = -1;
			  //Si ce joueur est un JoueurVirtuel
			if(j.getNumeroJoueur() != 1){
				sizeJoueur = partie.getPartie().getJoueurs().size();
				n = new java.util.Random().nextInt(sizeJoueur)+1;
				System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur numéro " + n);
			}else{
				  //Si ce joueur est un JoueurPhysique	
				System.out.println("Joueur " + 1 + " choisit un joueur, entrer son numéro");
				System.out.println("Vous piochez deux cartes au hasard dans la main d'une autre Divinité.");
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
			
			int point2 = targetJoueur.getPointActionJour() + targetJoueur.getPointActionNuit() + targetJoueur.getPointActionNéant();
			int point1 = j.getPointActionJour() + j.getPointActionNuit() + j.getPointActionNéant();
			if(point1 < point2){
				j.setPointActionJour(targetJoueur.getPointActionJour());
				j.setPointActionNuit(targetJoueur.getPointActionNuit());
				j.setPointActionNéant(targetJoueur.getPointActionNéant());
				/**
				 * +能让targetJoueur ce tour不再获得点数
				 */
				System.out.println("Juoeur " + j.getNumeroJoueur() + " récupère les points action de joueur numéro" + targetJoueur.getNumeroJoueur());
				System.out.println("Joueur" + targetJoueur.getNumeroJoueur() + " ne recoit aucun point d'Action ce tour-ci.");
			}else{
				System.out.println("joueur numéro" + j.getNumeroJoueur() + "ne peux pas utiliser maintenant");
			}
			  //la capacité de divinité n'être utilisé qu'une seul fois
			this.capacite = false;
		}else{
			System.out.println("Joueur " + j.getNumeroJoueur() + " a déjà utilié la capacité de son divinité");
		}
	}
	  
	  
}
