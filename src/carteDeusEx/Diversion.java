package carteDeusEx;

import control.Joueur;
import control.Partie;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.DeusEx;


public class Diversion extends DeusEx{
	//constructeur
	public Diversion(){
		 super();
	  this.nom="Diversion";
	  this.origine = "Nuit";
	  Image image = null;
	//	image = getImages.getPng("Diversion");
	//	this.setImage(image);
	}
	
	//Prenez 3 cartes dans la main d'un autre joueur et incluez-les ¨¤ votre main.
	 public void utiliserCapacite(Joueur j,Partie partie){
		 if(this.utiliser==true){
		 System.out.println("Utiliser Carte DeusEx: Diversion");
		 System.out.println("Prenez 3 cartes dans la main d'un autre joueur et incluez-les ¨¤ votre main.");
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
			  
			
			boolean FLAG = false;
			
			if(targetJoueur.getCarteEnMain().size() >=3){
				int m1 = -1;
				int m2 = -1;
				int m3 = -1;
				int sizeMain;
				if(j.getNumeroJoueur() != 1){
					sizeMain = targetJoueur.getCarteEnMain().size();
					while(m1 == m2 || m2 == m3 || m1==m3){
						m1 = new java.util.Random().nextInt(sizeMain);
						m2 = new java.util.Random().nextInt(sizeMain);
						m3 = new java.util.Random().nextInt(sizeMain);
					}
				}else{
					while(FLAG == false){
						System.out.println("Joueur " + 1 + " choisit deux carte en main de Joueur " + targetJoueur.getNumeroJoueur());
						m1= sc.nextInt();
						m2 = sc.nextInt();
						m3 = sc.nextInt();
						if(m1 >= 0 && m1 < targetJoueur.getCarteEnMain().size() && m2 >= 0 && m2 < targetJoueur.getCarteEnMain().size()&& m3 >= 0 && m3 < targetJoueur.getCarteEnMain().size() && m1 !=m2 && m1 != m3&& m2 != m3) {
							FLAG = true;
						}else{
							System.out.println("Le num¨¦ro de carte n'est pas compris dans carte en main de Joueur" + targetJoueur.getNumeroJoueur());
							FLAG = false;
						}
					}
				}
						CarteAction ca1 =(CarteAction) targetJoueur.getCarteEnMain().get(m1);
						CarteAction ca2 =(CarteAction)targetJoueur.getCarteEnMain().get(m2);
						CarteAction ca3 =(CarteAction)targetJoueur.getCarteEnMain().get(m3);
						 //Eviter de supprimer la carte ¨¤ l'avance et le num¨¦ro dans List CarteEnMain change
						
						targetJoueur.getCarteEnMain().remove(ca1);
						targetJoueur.getCarteEnMain().remove(ca2);
						targetJoueur.getCarteEnMain().remove(ca3);
						j.getCarteEnMain().add(ca1);
						j.getCarteEnMain().add(ca2);
						j.getCarteEnMain().add(ca3);
						System.out.println("joueur " + j.getNumeroJoueur() + " a d¨¦j¨¤ pioch¨¦ deux cartes actions de joueur " + targetJoueur.getNumeroJoueur() + "!");
				
			}else if(targetJoueur.getCarteEnMain().size()==3 || targetJoueur.getCarteEnMain().size()==2 ||targetJoueur.getCarteEnMain().size()==1){
				System.out.println("Il y moins de 3 cartes en main,vous n'avez pas besoin de choisir!");
				Iterator carte=targetJoueur.getCarteEnMain().iterator();
				while(carte.hasNext()){
					j.getCarteEnMain().add(carte.next());
					targetJoueur.getCarteEnMain().remove(carte.next());
				}
			}else{
				System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " n'a pas de carte en main");
			}
			
		 }else{
		    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
		    }	
	  }
}