package carteAction;

import gui.Pandocreon_Frame;

import java.util.List;

import control.Partie;

public class Apocalypse extends CarteAction{
	  //constructeur
	public Apocalypse(){
		super();
		this.type = "Apocalypse";
		this.nom = "Apocalypse";
		this.utiliser = true;

	}
	
	public void utiliserCapacite(Partie p){
		if(this.utiliser==true){
		   List l;
		   l = partie.getPartie().getJoueurs();
		   int nbJoueurEnjeu = l.size();
		   if(nbJoueurEnjeu < 4){
			 partie.getPartie().resultatJeu();
		   }else{
			 partie.getPartie().eliminerJoueur();
		   }
	    }else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}