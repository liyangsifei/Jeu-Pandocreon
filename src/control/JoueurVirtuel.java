package control;
import gui.Pandocreon_Frame;

import java.util.*;
import carteAction.*;

public class JoueurVirtuel extends Joueur{
      private Strategie mode;
      //le constructeur
      public  JoueurVirtuel(int numero,int modeChoisi){
     	 super(numero);
     	 //creer les joueurs virtuels en mode facile
     	 if(modeChoisi==1){
     		 mode=new ModeFacile(this);
     	 }
     	 if(modeChoisi==2){
     		 mode=new ModeDifficile(this);
     	 }
      }
      
      public int choisirNumeroDuAction(Partie p){
    	  int numero=mode.choisirNumero();
    	  return numero;
      }
      
      public void defausserCarte(Partie p){
       	  Random r=new Random();
  		  int resultat = r.nextInt( this.getCarteEnMain().size());
  	      int i=(int)Math.floor(resultat);
  		  List cartes=new ArrayList();
  		  cartes=this.getCarteEnMain();
  		  CarteAction carte=(CarteAction)cartes.get(i);
  		  System.out.println("Il defausse une carte "+ carte.getNom());
 		  this.getCarteEnMain().remove(i);
    	  
 	  }
      
      public void piocherCarte(Partie p){
			CartePile cp = p.getPartie().getCarteEnJeu();
			List l = cp.getCartes();
			while(this.getCarteEnMain().size() < 7){
					this.getCarteEnMain().add(l.get(0));
					l.remove(0);
			}			
			cp.setCartes(l);
			p.getPartie().setCarteEnJeu(cp);
			  //Afficher les cartes en main obtenu
			Iterator it = getCarteEnMain().iterator();
			System.out.println("Il pioche les cartes. Les cartes en main de Joueur " + getNumeroJoueur() + " est:");
			while(it.hasNext()){ 
		 		CarteAction ca = (CarteAction)it.next(); 
		 		System.out.println("CarteEnMain : " + ca.getNom() );
		 	}
	 }
      
      public void utiliserCarte(Partie p){
    	  Random r=new Random();
  		  int resultat = r.nextInt(this.getCarteEnMain().size());
  		  int i=(int)Math.floor(resultat);
  		  CarteAction ca = (CarteAction)this.getCarteEnMain().get(i);
  		  String origine=ca.getOrigine();
  		  int pointJour=this.getPointActionJour();
		  int pointNuit=this.getPointActionNuit();
		  int pointN¨¦ant=this.getPointActionN¨¦ant();
  		  if(ca.getType()=="Croyant"){
  			 Croyant cc = (Croyant)ca;
  			 //Si le point d'action est suffisant, il utilise le carte, Sinon, il sacrifie le carte.
  			  if(origine=="Jour"){
  				  if(pointJour>0){
  					this.setPointActionJour(this.getPointActionJour()-1);
					poserCroyant(cc);
  				  }else{
  					  utiliserCroyant(cc,p);
  				  }
  			  }else if(origine=="Nuit"){
  				  if(pointNuit>0){
  					this.setPointActionNuit(this.getPointActionNuit()-1);
					poserCroyant(cc);
  				  }else{
  					  utiliserCroyant(cc,p);
  				  }
  			  }else if(origine=="N¨¦ant"){
  				  if(pointN¨¦ant>0){
  					this.setPointActionN¨¦ant(this.getPointActionN¨¦ant()-1);
					poserCroyant(cc);
  				  }else{
  					  utiliserCroyant(cc,p);
  				  }
  			  }
  			  
  		  }else if(ca.getType()=="GuideSpirituel"){
  			 GuideSpirituel cc = (GuideSpirituel)ca;
  			 //Si le point d'action est suffisant, il utilise le carte, Sinon, il sacrifie le carte.
  			  if(origine=="Jour"){
  				  if(pointJour>0){
  					this.setPointActionJour(this.getPointActionJour()-1);
					poserGuideSpirituel(cc);
  				  }else{
  					  utiliserGuideSpirituel(cc,p);
  				  }
  			  }else if(origine=="Nuit"){
  				  if(pointNuit>0){
  					this.setPointActionNuit(this.getPointActionNuit()-1);
					poserGuideSpirituel(cc);
  				  }else{
  					  utiliserGuideSpirituel(cc,p);
  				  }
  			  }else if(origine=="N¨¦ant"){
  				  if(pointN¨¦ant>0){
  					this.setPointActionN¨¦ant(this.getPointActionN¨¦ant()-1);
					poserGuideSpirituel(cc);
  				  }else{
  					  utiliserGuideSpirituel(cc,p);
  				  }
  			  }
  			  
  		  }else if(ca.getType()=="DeusEx"){
  			  DeusEx cc=(DeusEx)ca;
  			 if(origine=="Jour"){
				  if(pointJour>0){
					this.setPointActionJour(this.getPointActionJour()-1);
					utiliserDeusEx(cc,p);
				  }else{
					 System.out.println("Il veut utiliser une carte DeusEx, mais son point d'action n'est pas suffisant!");
				  }
			  }else if(origine=="Nuit"){
				  if(pointNuit>0){
					this.setPointActionNuit(this.getPointActionNuit()-1);
					utiliserDeusEx(cc,p);
				  }else{
					  System.out.println("Il veut utiliser une carte DeusEx, mais son point d'action n'est pas suffisant!");
				  }
			  }else if(origine=="N¨¦ant"){
				  if(pointN¨¦ant>0){
					this.setPointActionN¨¦ant(this.getPointActionN¨¦ant()-1);
					 utiliserDeusEx(cc,p);
				  }else{
					  System.out.println("Il veut utiliser une carte DeusEx, mais son point d'action n'est pas suffisant!");
				  }
			  }else{
				  utiliserDeusEx(cc,p);
			  }
  		  }else if(ca.getType()=="Apocalypse"){
  			  Apocalypse cc=(Apocalypse)ca;
  			  if(origine=="Jour"){
				  if(pointJour>0){
					this.setPointActionJour(this.getPointActionJour()-1);
					utiliserApocalypse(cc,p);
				  }else{
					 System.out.println("Il veut utiliser une carte DeusEx, mais son point d'action n'est pas suffisant!");
				  }
			  }else if(origine=="Nuit"){
				  if(pointNuit>0){
					this.setPointActionNuit(this.getPointActionNuit()-1);
					utiliserApocalypse(cc,p);
				  }else{
					  System.out.println("Il veut utiliser une carte DeusEx, mais son point d'action n'est pas suffisant!");
				  }
			  }else if(origine=="N¨¦ant"){
				  if(pointN¨¦ant>0){
					this.setPointActionN¨¦ant(this.getPointActionN¨¦ant()-1);
					utiliserApocalypse(cc,p);
				  }else{
					  System.out.println("Il veut utiliser une carte DeusEx, mais son point d'action n'est pas suffisant!");
				  }
			  }
  		  }
  		this.getCarteEnMain().remove(i);
      }
   
      
      public void poserGuideSpirituel(GuideSpirituel guide){
			//int size = CarteTable.getCarteTable().getCroyantEnTable().size();
			List cartes=this.carteTable.getCartesEnTable();
			int nombreCroyant=0;
			List cartesCroyant=new ArrayList();
			Iterator it=cartes.iterator();
			while(it.hasNext()){
				CarteAction carte=(CarteAction)it.next();
				if(carte.getType()=="Croyant"){
					cartesCroyant.add(carte);
					nombreCroyant++;
				}
			}
			int nbCroyant = guide.getNombreCroyant();
			if(nombreCroyant==0){
				System.out.println("Il y a pas de croyant sur table!");
			}
			
			while(guide.getCroyantAttache().size() < nbCroyant && nombreCroyant!=0 ){
				    Iterator itc=cartesCroyant.iterator();
				    while(itc.hasNext()){
				    	Croyant c=(Croyant)itc.next();
				    	System.out.println("Ces sont les cartes Croyant sur table");
				    	System.out.println(c.getNom());
				    }
				    Random r=new Random();
			  		int resultat = r.nextInt(cartesCroyant.size());
			  		int num=(int)Math.floor(resultat);
					Croyant cy = (Croyant)cartesCroyant.get(num);
					boolean p = false;
					if(guide.getDogme().contains("Humain") && cy.getDogme().contains("Humain") ){
						p = true;
					}else if(guide.getDogme().contains("Nature") && cy.getDogme().contains("Nature")){
						p = true;
					}else if(guide.getDogme().contains("Mystique") && cy.getDogme().contains("Mystique")){
						p = true;
					}else if(guide.getDogme().contains("Symboles") && cy.getDogme().contains("Symboles")){
						p = true;
					}else if(guide.getDogme().contains("Chaos") && cy.getDogme().contains("Chaos")){
						p = true;
					}
					if(p == true){
						this.carteTable.getCartesEnTable().remove(cy);
						this.getCarteCroyantEnjeu().add(cy);
						this.getCarteGsEnjeu().add(guide);
						guide.getCroyantAttache().add(cy);
						cy.setGuideAttache(guide);
						break;
					}else{
						System.out.println("Il n'y a pas de m¨ºme dogme de ce Guide Spirituel et ce Croyant, continuer attacher? Si oui, saisissez 1,sinon 0");
						System.out.println("Joueur virtuel n'a pas reussi a attacher a carte Croyant!");
						break;
					}
			}
		}

	@Override
	public void defausserCarteP(int numero) {
		// TODO Auto-generated method stub
		
	}
}

