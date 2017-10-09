package carteAction;

import java.awt.Image;

import control.Joueur;
import control.Partie;

public class CarteAction {
	
	  //les attributes des carteAction en common
	protected String origine;
	protected String dogme;
	protected String nom;
	protected String type;
	public Image imageAction;
	
	public boolean utiliser=true;
	protected Partie partie;
	
	  //le constructeur
	public CarteAction(){
		  //Initialiser
		this.partie = Partie.getPartie();
	}
	
	public void utiliserCapacite(Joueur joueur,Partie partie){
	  
    }
	
	
	  //Getters & Setters
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getOrigine() {
		return origine;
	}


	public void setOrigine(String origine) {
		this.origine = origine;
	}


	public String getDogme() {
		return dogme;
	}


	public void setDogme(String dogme) {
		this.dogme = dogme;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Image getImage() {
		return imageAction;
	}


	public void setImage(Image image) {
		this.imageAction = image;
	}
	
	
	
}
