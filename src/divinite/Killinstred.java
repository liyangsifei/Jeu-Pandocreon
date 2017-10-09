package divinite;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import control.Joueur;
import control.Partie;

import carteAction.Apocalypse;
import carteAction.CarteAction;


public class Killinstred extends Divinite {
	
	  //constructeur
	public Killinstred(){
		super();
		this.setNom("Killinstred");
		this.setDiviniteOrigine("Nuit");
		this.setDiviniteDogme("NatureMystiqueChaos");
	//	Image image = null;
	//	image = getImages.getPng("Killinstred");
	//	this.setImageDivinite(image);
	}
	
	  //Peut obliger un joueur ¨¤ poser une carte Apocalypse s'il en poss¨¨de une.
	public void capaciteDivinite(Partie partie,Joueur j){
		if(capacite == true){
			System.out.println("Killinstred:");
			System.out.println("Peut obliger un joueur ¨¤ poser une carte Apocalypse s'il en poss¨¨de une.");
			  //Choisir un joueur et le chercher dans List joueurs
			Scanner sc = new Scanner(System.in);
			Joueur targetJoueur = j;
			int sizeJoueur;
			int n = -1;
			  //Si ce joueur est un JoueurVirtuel
			if(j.getNumeroJoueur() != 1){
				sizeJoueur = partie.getPartie().getJoueurs().size();
				n = new java.util.Random().nextInt(sizeJoueur)+1;
				System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur num¨¦ro " + n);
			}else{
				  //Si ce joueur est un JoueurPhysique	
				System.out.println("Joueur " + 1 + " choisit un joueur, entrer son num¨¦ro");
				System.out.println("Vous piochez deux cartes au hasard dans la main d'une autre Divinit¨¦.");
				n = sc.nextInt();
				System.out.println("Joueur" + 1 + " a choisi Joueur num¨¦ro " + n);
				
			}
			List l =partie.getPartie().getJoueurs();
			Iterator it = l.iterator();
			while(it.hasNext()){
				targetJoueur = (Joueur)it.next();
				if(targetJoueur.getNumeroJoueur() == n){
					break;
				}
			}
			
			List listMain = targetJoueur.getCarteEnMain();
			int i = 0;
			  //D¨¦cider si le joueur choisi a une carte Apocalypse
			boolean have = false;
			
			for(i = listMain.size() - 1 ; i >= 0 ;i--){
				CarteAction ca = (CarteAction)listMain.get(i);
				if(ca.getType() == "Apocalypse"){
					have = true;
					break;
				}
			}
			
			if(have == true){
				System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " doit utiliser sa carte Apocalypse");
				Apocalypse ap =(Apocalypse)listMain.get(i);
				targetJoueur.utiliserApocalypse(ap,partie.getPartie());
				targetJoueur.getCarteEnMain().remove(i);
				this.capacite = false;
				  //la capacit¨¦ de divinit¨¦ n'¨ºtre utilis¨¦ qu'une seul fois
			}else{
				System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " n'a pas de carte Apocalypse");
			}
			
			
		}else{
			System.out.println("Joueur " + j.getNumeroJoueur() + " a d¨¦j¨¤ utili¨¦ la capacit¨¦ de son divinit¨¦");
		}
	}
	
	
}
