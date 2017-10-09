package control;

import java.util.Random;

public class ModeDifficile extends Strategie {
	public ModeDifficile(Joueur joueur){
		super(joueur);
	}
	public int choisirNumero(){
	  if(this.carteMain.size()<7&&this.carteMain.size()>0){
		 // il peut choisir un des trois actions (defausser cartes, piocher cartes, utiliser cartes)
		Random r=new Random();
		int resultat = r.nextInt(3);
		int numeroAction=(int)Math.floor(resultat);
		return numeroAction;
	  }
	  else if(this.carteMain.size()==0){
		  // il y a pas de carte en main, il doit piocher les carte
		 return 1;
	  }else{
		  // il y a 7 cartes en main, il ne peut pas piocher les cartes
		 Random r=new Random();
		 int resultat = r.nextInt(2);
		 int i=(int)Math.floor(resultat);
		 if(i==0){
			 return 0;
		 }else{
			 return 2;
		 }
	  }
	}
}
