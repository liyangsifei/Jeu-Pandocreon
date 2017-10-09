package divinite;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.Apocalypse;
import carteAction.CarteAction;
import carteAction.GuideSpirituel;

import control.Joueur;
import control.Partie;


public class Brewalen extends Divinite {
	  
      //constructeur
	public Brewalen(){
		super();
		this.setNom("Brewalen");
		this.setDiviniteOrigine("Jour");
		this.setDiviniteDogme("NatureHumainChaos");
	//	Image image = null;
	//	image = getImages.getPng("Brewalen");
	//	this.setImageDivinite(image);
	}
	
	  //Peut emp��cher l'utilisation d'une carte Apocalypse. La carte est d��fauss��e;
	public void capaciteDivinite(Partie partie,Joueur j){
		if(capacite == true){
			System.out.println("Brewalen:");
			System.out.println("Peut emp��cher l'utilisation d'une carte Apocalypse. La carte est d��fauss��e;");
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
			List l =partie.getPartie().getJoueurs();
			Iterator it = l.iterator();
			while(it.hasNext()){
				targetJoueur = (Joueur)it.next();
				if(targetJoueur.getNumeroJoueur() == n){
					break;
				}
			}
			
			boolean have = false;
			Apocalypse ap = new Apocalypse();
			if(targetJoueur.getCarteEnMain() != null){
				int sizeMain = targetJoueur.getCarteEnMain().size();
				for(int i = 0 ;i <sizeMain ; i++){
					CarteAction ca = (CarteAction) targetJoueur.getCarteEnMain().get(i);
					if(ca.getType().equals("Apocalypse")){
						ap = (Apocalypse)ca;
						have = true;
						break;
					}
				}
				if(have){
					ap.utiliser = false;
					this.capacite = false;
				}else{
					System.out.println("Ce joueur n'a pas de carte de Guide Spirituel dans sa main, Vous pouvez utiliser encore ce capacite divinit��");
				}
			}else{
				System.out.println("Ce joueur n'a pas de carte en main");
			}
		}else{
			System.out.println("Joueur " + j.getNumeroJoueur() + " a d��j�� utili�� la capacit�� de son divinit��");
		}
	}
	
}
