package control;
import java.util.*;

public abstract class Strategie {
	protected List carteMain;
	public Strategie(Joueur joueur){
		this.carteMain=joueur.getCarteEnMain();
		
	}
	public abstract int choisirNumero();
	
}

  
