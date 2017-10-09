package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import control.Joueur;
import control.Partie;
import control.Tour;


public class Diplomates extends Croyant{
	
	//constructeur
	public Diplomates(){
		super();
		this.nombrePuissance = 4;
		this.nom = "Diplomates";
		this.origine = "Jour";
		this.dogme = "SymbolesHumainChaos";
		Image image = null;
		//image = getImages.getPng("Diplomates");
	//	this.setImage(image);
		}
	
	  //Relancez le d¨¦ de Cosmogonie. Le tour se finit normalement sous la nouvelle influence.
	public void utiliserCapacite(Joueur j,Partie partie){
		if(this.utiliser==true){
			System.out.println("Diplomates:");
			List l = j.getCarteEnMain();
			Iterator it = l.iterator();
			int i = 0;
			while(it.hasNext()){
				CarteAction ca  = (CarteAction) it.next();
				if(ca.getNom().equals("Diplomates")){
					j.getCarteEnMain().remove(i);
					break;
				}
				i++;
			}
			Tour tour=new Tour((ArrayList<Joueur>)partie.getPartie().getJoueurs());
		}else{
			System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
		}
	}
}
