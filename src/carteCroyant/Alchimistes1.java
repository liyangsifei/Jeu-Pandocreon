package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;

public class Alchimistes1 extends Croyant {
	
	  //constructeur
	public Alchimistes1(){
		super();
		this.nombrePuissance = 2;
		this.nom = "Alchimistes1";
		this.origine = "Nuit";
		this.dogme = "SymbolesNatureChaos";
		Image image = null;
		//image = getImages.getPng("Alchimiste3");
		//this.setImage(image);
	}
	
	  //Vous piochez deux cartes au hasard dans la main d'une autre Divinit¨¦.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
			System.out.println("Alchimiste1:");
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
			boolean FLAG = false;
			if(targetJoueur.getCarteEnMain().size() >= 2){
				int m1 = -1;
				int m2 = -1;
				int sizeMain;
				if(j.getNumeroJoueur() != 1){
					sizeMain = targetJoueur.getCarteEnMain().size();
					while(m1 == m2){
						m1 = new java.util.Random().nextInt(sizeMain);
						m2 = new java.util.Random().nextInt(sizeMain);
						}
				}else{
					while(FLAG == false){
						System.out.println("Joueur " + 1 + " choisit deux carte en main de Joueur " + targetJoueur.getNumeroJoueur());
						m1= sc.nextInt();
						m2 = sc.nextInt();
						if(m1 >= 0 && m1 < targetJoueur.getCarteEnMain().size() && m2 >= 0 && m2 < targetJoueur.getCarteEnMain().size() && m1 !=m2) {
							FLAG = true;
						}else{
							System.out.println("Le num¨¦ro de carte n'est pas compris dans carte en main de Joueur" + targetJoueur.getNumeroJoueur());
							FLAG = false;
						}
					}
				}
				CarteAction ca1 =(CarteAction) targetJoueur.getCarteEnMain().get(m1);
				CarteAction ca2 =(CarteAction)targetJoueur.getCarteEnMain().get(m2);
				  //Eviter de supprimer la carte ¨¤ l'avance et le num¨¦ro dans List CarteEnMain change
				if(m1 > m2){
					targetJoueur.getCarteEnMain().remove(m1);
					targetJoueur.getCarteEnMain().remove(m2);
				}else{
					targetJoueur.getCarteEnMain().remove(m2);
					targetJoueur.getCarteEnMain().remove(m1);
				}
				j.getCarteEnMain().add(ca1);
				j.getCarteEnMain().add(ca2);
				System.out.println("joueur " + j.getNumeroJoueur() + " a d¨¦j¨¤ pioch¨¦ deux cartes actions de joueur " + targetJoueur.getNumeroJoueur() + "!");
			}else{
				System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " a moins de deux carte en main");
			}
		}else{
			System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
		}
	}
}
