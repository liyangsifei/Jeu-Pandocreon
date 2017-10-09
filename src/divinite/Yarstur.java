package divinite;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.List;

import outils.getImages;

import carteAction.Croyant;
import control.Joueur;
import control.Partie;


public class Yarstur extends Divinite {
	
	  //constructeur
	public Yarstur(){
		super();
		this.setNom("Yarstur");
		this.setDiviniteOrigine("Jour");
		this.setDiviniteDogme("ChaosSymbolesMystique");
	//	Image image = null;
	//	image = getImages.getPng("Yarstur");
		//this.setImageDivinite(image);
	}
	  
	  //Peut d¨¦tuire toutes les cartes de Croyants au centre de la table d'Origine N¨¦ant
	public void capaciteDivinite(Partie partie,Joueur j){
		if(capacite == true){
			System.out.println("Yarstur:");
			System.out.println("Puet d¨¦tuire toutes les cartes de Croyants au centre de la table d'Origine N¨¦ant");
			int sizeTable = j.getCarteTable().getCartesEnTable().size();
			List listTable = j.getCarteTable().getCartesEnTable();
			Croyant cy;
			for(int i = sizeTable - 1 ; i >=0 ; i--){
				cy = (Croyant) listTable.get(i);
				if(cy.getOrigine().equals("N¨¦ant")){
					j.getCarteTable().getCartesEnTable().remove(i);
					System.out.println("La carte de Croyant " + cy.getNom() + " est d¨¦fauss¨¦ de centre de la table car c'est d'Origine N¨¦ant");
				}
			}
			System.out.println("Tous les cartes de Croyant au centre de la table d'Origine N¨¦ant sont d¨¦fauss¨¦s");
			this.capacite = false;
		}else{
			System.out.println("Joueur " + j.getNumeroJoueur() + " a d¨¦j¨¤ utili¨¦ la capacit¨¦ de son divinit¨¦");
		}
	}

}
