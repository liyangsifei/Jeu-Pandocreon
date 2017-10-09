package control;
import divinite.Divinite;
import gui.Pandocreon_Frame;

import carteAction.*;

import java.util.*;
import carteAction.CarteTable;
public abstract class Joueur {
	private int numeroJoueur;
	private int pointActionJour;
	private int pointActionNuit;
	private int pointActionN¨¦ant;
	private Divinite divinite;
	  //une List pour placer les carte en main qui n'est que visible pour ce Joueur 
	private List carteEnMain;
	  //Les cartes Guide Spirituel dans l'espace joueur, qui est attach¨¦ avec les cartes croyant(carteCroyantEnjeu)
	private List carteGsEnjeu;
	  //Les cartes Croyant dans l'espace joueur, qui est compt¨¦ dans ses point de pri¨¨re
	private List carteCroyantEnjeu;
	  //Point de pri¨¨re du Joueur
	public int puissanceJoueur;
	  //Carte que le joueur en train de poser
	private CarteAction CartePose;
	protected CarteTable carteTable=CarteTable.getCarteTable();
	
	  //le constructeur
	public  Joueur(int numero){
		this.numeroJoueur=numero;
		this.carteEnMain=new ArrayList();
		this.carteGsEnjeu = new ArrayList();
		this.carteCroyantEnjeu = new ArrayList();
		this.pointActionJour=0;
		this.pointActionNuit=0;
		this.pointActionN¨¦ant=0;
	}
	
	  //piocher divinite au debut du jeu
	public void piocherDivinite(Divinite divinitePioche){
		this.divinite=divinitePioche;
		System.out.println("Joueur"+this.numeroJoueur+" pioche divinite:"+this.divinite.getNom());
	}
	
	  //get divinite
	public Divinite getDivinite() {
		return divinite;
	}
	

	  //D¨¦fausser les cartes choisis par Joueur
	public abstract void defausserCarte(Partie p);
	

	  //piocher carteAction
	public abstract void piocherCarte(Partie p);
		
	
	public abstract void utiliserCarte(Partie p);
	

	//Joueur sacrifie les cartes Guide Spirituel ou Carte Croyant
	public void utiliserDeusEx(DeusEx deusEx,Partie p){
		deusEx.utiliserCapacite(this,p);
	}
	

	public void utiliserCroyant(Croyant croyant,Partie p){
		croyant.utiliserCapacite(this,p);
	}
	

	public void utiliserGuideSpirituel(GuideSpirituel guide,Partie p){
		guide.utiliserCapacite(this,p);
	}
	
	public void utiliserApocalypse(Apocalypse apocalypse,Partie p){
		apocalypse.utiliserCapacite(p);
	}
	
	public void poserCroyant(Croyant croyant){
		
			this.carteTable.ajouterCarte(croyant);
			System.out.println("Vous avez posez la carte:" + croyant.getNom() + " dans l'espace Table");
			this.carteTable.printCarteTable();
		
	    
	}
	
	public abstract void poserGuideSpirituel(GuideSpirituel guide);
	
	public void utiliserCapaciteDivinite(Partie p){
		this.getDivinite().capaciteDivinite(p, this);
	}
		
	
	  //choisir une action
	public void Action(int numeroDuAction,Partie p){
		switch (numeroDuAction) {
		case 0:
	     	defausserCarte(p);
			break;
		case 1:
			piocherCarte(p);
			break;
		case 2:
			utiliserCarte(p);
			break;
		case 3:
			utiliserCapaciteDivinite(p);
			break;
		default:
			//
			break;
		}
	}
	
	public abstract int choisirNumeroDuAction(Partie p);
	
	  //memorizer la carte croyant rattach¨¦ avec carte guide spirituel.
	public int calculatorPuissance(){
		int puissance = 0;
		Croyant cy;
		int size = carteCroyantEnjeu.size();
		for(int ind = 0 ; ind <size ; ind++){
			cy = (Croyant)carteCroyantEnjeu.get(ind);
			puissance += cy.getNombrePuissance();
		}
		return puissance;
	}
	
	  //test si les joueurs sont creer?
	public void test(){
		System.out.print(this.numeroJoueur);
	}
	
	
	  //Getters & Setters
	public void addCarteGsEspace(GuideSpirituel gs){
		carteGsEnjeu.add(gs);
	}

	public int getNumeroJoueur() {
		return numeroJoueur;
	}

	public void setNumeroJoueur(int numeroJoueur) {
		this.numeroJoueur = numeroJoueur;
	}

	public int getPointActionJour() {
		return pointActionJour;
	}

	public void setPointActionJour(int pointActionJour) {
		this.pointActionJour = pointActionJour;
	}

	public int getPointActionNuit() {
		return pointActionNuit;
	}

	public void setPointActionNuit(int pointActionNuit) {
		this.pointActionNuit = pointActionNuit;
	}

	public int getPointActionN¨¦ant() {
		return pointActionN¨¦ant;
	}

	public void setPointActionN¨¦ant(int pointActionN¨¦ant) {
		this.pointActionN¨¦ant = pointActionN¨¦ant;
	}

	public List getCarteEnMain() {
		return carteEnMain;
	}

	public void setCarteEnMain(List carteEnMain) {
		this.carteEnMain = carteEnMain;
	}

	public List getCarteGsEnjeu() {
		return carteGsEnjeu;
	}

	public void setCarteGsEnjeu(List carteGsEnjeu) {
		this.carteGsEnjeu = carteGsEnjeu;
	}

	public List getCarteCroyantEnjeu() {
		return carteCroyantEnjeu;
	}

	public void setCarteCroyantEnjeu(List carteCroyantEnjeu) {
		this.carteCroyantEnjeu = carteCroyantEnjeu;
	}

	public int getPuissanceJoueur() {
		return puissanceJoueur;
	}

	public void setPuissanceJoueur(int puissanceJoueur) {
		this.puissanceJoueur = puissanceJoueur;
	}

	public CarteAction getCartePose() {
		return CartePose;
	}

	public void setCartePose(CarteAction cartePose) {
		CartePose = cartePose;
	}

	public void setDivinite(Divinite divinite) {
		this.divinite = divinite;
	}

	public CarteTable getCarteTable() {
		return carteTable;
	}

	public void setCarteTable(CarteTable carteTable) {
		this.carteTable = carteTable;
	}
	
	
	public abstract void defausserCarteP(int numero);

	

}

