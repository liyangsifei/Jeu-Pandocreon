package carteCroyant;

import gui.Pandocreon_Frame;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;
import control.Tour;

public class D¨¦mons extends Croyant {
	
	  //constructeur
	public D¨¦mons(){
		super();
		this.nombrePuissance = 2;
		this.nom = "D¨¦mons";
		this.origine = "Nuit";
	}
	
	  //Donne un point d'Action d'Origine Nuit.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
			System.out.println("D¨¦mon:");
			if(partie.getPartie().isPeuxGagnePointAction()){
				System.out.println("Joueur " + j.getNumeroJoueur() + " gagne un point d'action nuit!");
				j.setPointActionNuit(j.getPointActionNuit() + 1);
			}else{
				System.out.println("Aucun joueur ne peux gagner de point d'action avant le terminal de ce tour");
			}
		}else{
			System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
			}
	}
}
