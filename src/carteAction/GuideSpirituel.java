package carteAction;

import gui.Pandocreon_Frame;

import java.util.ArrayList;
import java.util.List;

import control.Joueur;
import control.Partie;


public class GuideSpirituel extends CarteAction{
	  // les croyants qui a deja ramene
	protected List <Croyant> croyantAttache;
	  //le nombre des croyant il peut ramener
	protected int nombreCroyant;
	public boolean peuxCreer;
	  //le constructeur
	public GuideSpirituel(){
		super();
		this.croyantAttache = new ArrayList();
		this.type = "GuideSpirituel";
		this.peuxCreer=true;
	}
	
	  //capacite 
	public void utiliserCapacite(Joueur j,Partie partie){
		
	}
	
	public int getNombreCroyant() {
		return nombreCroyant;
	}
	
	public void setNombreCroyant(int nombreCroyant) {
		this.nombreCroyant = nombreCroyant;
	}
	public List<Croyant> getCroyantAttache() {
		return croyantAttache;
	}
	public void setCroyantAttache(List<Croyant> croyantAttache) {
		this.croyantAttache = croyantAttache;
	}
	
	

  
}
