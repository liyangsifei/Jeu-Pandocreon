package divinite;

import gui.Pandocreon_Frame;

import java.awt.Image;

import control.Joueur;
import control.Partie;

public class Divinite {
	protected String diviniteDogme;
	protected String nom;
	protected String diviniteOrigine;
	protected boolean capacite;
	private Image imageDivinite;
	
	public Divinite(){
		this.capacite = true;
	}
	
	public void capaciteDivinite(Partie p,Joueur j){
		
	}
	
	public String getDiviniteDogme() {
		return diviniteDogme;
	}
	
	public void setDiviniteDogme(String diviniteDogme) {
		this.diviniteDogme = diviniteDogme;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDiviniteOrigine() {
		return diviniteOrigine;
	}
	
	public void setDiviniteOrigine(String diviniteOrigine) {
		this.diviniteOrigine = diviniteOrigine;
	}

	public boolean isCapacite() {
		return capacite;
	}

	public void setCapacite(boolean capacite) {
		this.capacite = capacite;
	}

	public Image getImageDivinite() {
		return imageDivinite;
	}

	public void setImageDivinite(Image imageDivinite) {
		this.imageDivinite = imageDivinite;
	}
	
	
 
}