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
		this.setDiviniteOrigine("Cr��puscule");
		this.setDiviniteDogme("HumainSymbolesChaos");
	//	Image image = null;
	//	image = getImages.getPng("Gorpa");
	//	this.setImageDivinite(image);
	}
	  
	  //Peut r��cup��rer les points d'Action d'une autre Divinit�� en plus des siens. 
	  //Et l'autre Divinit�� ne recoit aucun point d'Action ce tour-ci.
	public void capaciteDivinite(Partie partie,Joueur j){
		if(capacite == true){
			System.out.println("Gorpa:");
			System.out.println("Peut r��cup��rer les points d'Action d'une autre Divinit�� en plus des siens." +
					"Et l'autre Divinit�� ne recoit aucun point d'Action ce tour-ci.");
			  //Choisir un joueur et le chercher dans List joueurs
			Scanner sc = new Scanner(System.in);
			Joueur targetJoueur = j;
			int sizeJoueur;
			int n = -1;
			  //Si ce joueur est un JoueurVirtuel
			if(j.getNumeroJoueur() != 1){
				sizeJoueur = partie.getPartie().getJoueurs().size();
				n = new java.util.Random().nextInt(sizeJoueur)+1;
				System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur num��ro " + n);
			}else{
				  //Si ce joueur est un JoueurPhysique	
				System.out.println("Joueur " + 1 + " choisit un joueur, entrer son num��ro");
				System.out.println("Vous piochez deux cartes au hasard dans la main d'une autre Divinit��.");
				n = sc.nextInt();
				System.out.println("Joueur" + 1 + " a choisi Joueur num��ro " + n);
				
			}
			List l = partie.getPartie().getJoueurs();
			Iterator it = l.iterator();
			while(it.hasNext()){
				targetJoueur = (Joueur)it.next();
				if(targetJoueur.getNumeroJoueur() == n){
					break;
				}
			}
			
			int point2 = targetJoueur.getPointActionJour() + targetJoueur.getPointActionNuit() + targetJoueur.getPointActionN��ant();
			int point1 = j.getPointActionJour() + j.getPointActionNuit() + j.getPointActionN��ant();
			if(point1 < point2){
				j.setPointActionJour(targetJoueur.getPointActionJour());
				j.setPointActionNuit(targetJoueur.getPointActionNuit());
				j.setPointActionN��ant(targetJoueur.getPointActionN��ant());
				/**
				 * +����targetJoueur ce tour���ٻ�õ���
				 */
				System.out.println("Juoeur " + j.getNumeroJoueur() + " r��cup��re les points action de joueur num��ro" + targetJoueur.getNumeroJoueur());
				System.out.println("Joueur" + targetJoueur.getNumeroJoueur() + " ne recoit aucun point d'Action ce tour-ci.");
			}else{
				System.out.println("joueur num��ro" + j.getNumeroJoueur() + "ne peux pas utiliser maintenant");
			}
			  //la capacit�� de divinit�� n'��tre utilis�� qu'une seul fois
			this.capacite = false;
		}else{
			System.out.println("Joueur " + j.getNumeroJoueur() + " a d��j�� utili�� la capacit�� de son divinit��");
		}
	}
	  
	  
}
