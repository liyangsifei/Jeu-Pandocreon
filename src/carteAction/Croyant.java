package carteAction;

import gui.Pandocreon_Frame;
import control.Joueur;
import control.Partie;

public class Croyant extends CarteAction{
	protected int nombrePuissance;
	protected GuideSpirituel guideAttache;
	
	  //le constructeur
	public Croyant(){
		super();
		this.guideAttache = new GuideSpirituel();
		this.type = "Croyant";
	}
	
	  //capacite 
	public void utiliserCapacite(Joueur j,Partie partie){
		
	}
	
	  //Getters & Setters
	public int getNombrePuissance() {
		return nombrePuissance;
	}

	public void setNombrePuissance(int nombrePuissance) {
		this.nombrePuissance = nombrePuissance;
	}

	public GuideSpirituel getGuideAttache() {
		return guideAttache;
	}

	public void setGuideAttache(GuideSpirituel guideAttache) {
		this.guideAttache = guideAttache;
	}

	
	
}
