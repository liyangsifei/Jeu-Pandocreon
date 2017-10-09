package control;
import control.Joueur;

public class ModeFacile extends Strategie{
	public ModeFacile(Joueur joueur){
		super(joueur);
	}
   public int choisirNumero(){
	  if(this.carteMain.size()<7){
		   //completer sa main a 7 cartes
		  return 1;
	  }else{
		   //se defausser les cartes
		   return 0;
	   }
   }
}
