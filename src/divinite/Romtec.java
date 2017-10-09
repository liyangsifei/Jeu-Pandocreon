package divinite;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.GuideSpirituel;

import control.Joueur;
import control.Partie;

public class Romtec extends Divinite {
	
	  //constructeur
	public Romtec(){
		super();
		this.setNom("Romtec");
		this.setDiviniteOrigine("Cr¨¦puscule");
		this.setDiviniteDogme("NatureHumainChaos");
		//Image image = null;
	//	image = getImages.getPng("Romtec");
		//this.setImageDivinite(image);
	}
	  
	  
	  //Peut emp¨ºcher un joueur de cr¨¦er un Guide Spirituel. La carte est d¨¦fauss¨¦e.
	public void capaciteDivinite(Partie partie,Joueur j){
		if(capacite == true){
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
			List l = partie.getPartie().getJoueurs();
			Iterator it = l.iterator();
			while(it.hasNext()){
				targetJoueur = (Joueur)it.next();
				if(targetJoueur.getNumeroJoueur() == n){
					break;
				}
			}
			boolean have = false;
			GuideSpirituel gs = new GuideSpirituel();
			if(targetJoueur.getCarteEnMain() != null){
				int sizeMain = targetJoueur.getCarteEnMain().size();
				for(int i = 0 ;i <sizeMain ; i++){
					CarteAction ca = (CarteAction) targetJoueur.getCarteEnMain().get(i);
					if(ca.getType().equals("GuideSpirituel")){
						gs = (GuideSpirituel)ca;
						have = true;
						break;
					}
				}
				if(have){
					gs.peuxCreer = false;
					this.capacite = false;
				}else{
					System.out.println("Ce joueur n'a pas de carte de Guide Spirituel dans sa main, Vous pouvez utiliser encore ce capacite divinit¨¦");
				}
				
				
			}else{
				System.out.println("Ce joueur n'a pas de carte en main");
			}
			
		}else{
			System.out.println("Joueur " + j.getNumeroJoueur() + " a d¨¦j¨¤ utili¨¦ la capacit¨¦ de son divinit¨¦");
		}
	}
}
