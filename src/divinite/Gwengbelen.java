package divinite;

import control.Partie;
import control.Joueur;
import carteAction.CarteAction;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.*;

import outils.getImages;

public class Gwengbelen extends Divinite {
	
	  //constructeur
	public Gwengbelen(){
		super();
		this.setNom("Gwengbelen");
		this.setDiviniteOrigine("Aube");
		this.setDiviniteDogme("HumainMystiqueSymboles");
		//Image image = null;
		//image = getImages.getPng("Gwengbelen");
	//	this.setImageDivinite(image);
	}
	  
	  //R¨¦cup¨¨re autant de points d'Action suppl¨¦mentaire d'Origine N¨¦ant que le nombre de Guides Spirituels que la Divinit¨¦ poss¨¨de
	public void capaciteDivinite(Partie partie, Joueur j){
		if(capacite == true){
			System.out.println("Gwengbelen:");
			System.out.println("R¨¦cup¨¨re autant de points d'Action suppl¨¦mentaires d'Origine N¨¦ant que le nombre de Guides Spirituels que la Divinit¨¦ poss¨¨de."); 
			List carteGuide=j.getCarteGsEnjeu();
			Iterator it=carteGuide.iterator();
			int i=0;
			while(it.hasNext()){
				i++;
			}
			j.setPointActionN¨¦ant(j.getPointActionN¨¦ant() + i);
			System.out.println("Il y a " + i + " GuideSpirituel, donc vous pouvez ajouter " + i + " points au point d'action N¨¦ant");
			this.capacite = false;
		 }else{
			 System.out.println("Joueur " + j.getNumeroJoueur() + " a d¨¦j¨¤ utili¨¦ la capacit¨¦ de son divinit¨¦");
		 }
	 }
}
