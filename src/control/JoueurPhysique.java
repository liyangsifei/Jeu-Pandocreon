package control;

import gui.Pandocreon_Frame;

import java.util.*;
import carteAction.Apocalypse;
import carteAction.CartePile;
import carteAction.CarteTable;
import carteAction.Croyant;
import carteAction.DeusEx;
import carteAction.GuideSpirituel;
import carteAction.Apocalypse;
import carteAction.CarteAction;

public class JoueurPhysique extends Joueur{
	private int numeroAction;
	
	 //constructeur
	  public JoueurPhysique(int numero){
		  super(numero);
	  }
	  public int choisirNumeroDuAction(Partie p){
		//  System.out.println("Voici les actions vous pouvez choisir! (0 defausser 1 piocher 2 utiliser 3 capacité Divinité)Saisir le numero du action vous voulez choisir!");
	      
		//  Scanner input=new Scanner(System.in);
	   //   int numeroDuAction=input.nextInt();
	   //   numeroDuAction = f.getJoueurPhysiqueView().getJoueurPhysiqueView().getDiviniteView().getActionChoisi();
	   //   numeroAction = numeroDuAction;
		 return numeroAction;
	 }
	  
	  
	  
	  public void defausserCarteP(int numero){
		  boolean end = false;
		  //choisir le numero du carte vous voulez defausser
		  List cartesA=this.getCarteEnMain();
		  System.out.println(" Les cartes en main sont:");
		  int i2 = 0;
		  Iterator ii = cartesA.iterator();
		  while(ii.hasNext()){
			  CarteAction cartea=(CarteAction)ii.next();
			  System.out.println(i2 + ":" + cartea.getNom()+" "+cartea.getType()+" "+cartea.getOrigine());
			  i2++;
			  }
		  System.out.println("Vous voulez defausser carte "+numero+" !");
		  //int i = f.getJoueurPhysiqueView().getCarteMainView().getCarteDefausse();  ///**************新加入：手牌里的号码****
		  //Scanner input=new Scanner(System.in);
		  // int i=input.nextInt();
		  //do{
			 // if(i < this.getCarteEnMain().size()&&i>=0){
		   this.getCarteEnMain().remove(numero);
		  List cartes=this.getCarteEnMain();
		  System.out.println("Vous avez defausse ce carte! Les cartes en main sont:");
				  int i3 = 0;
				  Iterator it = cartes.iterator();
				  while(it.hasNext()){
					  CarteAction carte=(CarteAction)it.next();
					  System.out.println(i3 + ":" + carte.getNom()+" "+carte.getType()+" "+carte.getOrigine());
					  i3++;
				  }
				  
				  
			//  }else{
			//	  System.out.println("ce numéro n'est pas compris dans votre carte en main, entrer le numéro");
				//  i = input.nextInt();
				  
				  
			 // }
			 // System.out.println("Si vous voulez arrêter de défausser cartes, saisissez 'end', si vous voulez continuer defausser carte, saisir le numreo du carte. ");
			//  end = f.getJoueurPhysiqueView().getCarteMainView().isEndTour();  //*******新加入 不知道能不能endtour*******
			//  end = input.next().equals("end");
			//  }while(end == false);
	  }
	  
	  
	  public void piocherCarte(Partie p){
			CartePile cp = p.getPartie().getCarteEnJeu();
			List l = cp.getCartes();
			if(this.getCarteEnMain().size()== 7){
				System.out.println("Vous ne pouvez pas piocher les cartes");
			}else{
				while(this.getCarteEnMain().size() < 7){
					this.getCarteEnMain().add(l.get(0));
					l.remove(0);
				}
			}
			
			cp.setCartes(l);
			p.getPartie().setCarteEnJeu(cp);
			  //Afficher les cartes en main obtenu
			Iterator it = getCarteEnMain().iterator();
			System.out.println("Les cartes en main de Joueur " + getNumeroJoueur() + " est:");
			while(it.hasNext()){ 
		 		CarteAction ca = (CarteAction)it.next(); 
		 		System.out.println("CarteEnMain : " + ca.getNom() );
		 	}
	 }
//	  public void utiliserCarteMain(Partie p,CarteAction ca){
//		  if(ca.getType().equals("Croyant")){
//			  ((Croyant)ca).utiliserCapacite(p.getJoueurs().get(0), f)
//			  p.getJoueurs().get(0).getCarteEnMain().remove(ca);
//		  }
//	  }
	  public void utiliserCarte(Partie p){
			Iterator it = this.getCarteEnMain().iterator();
			System.out.println("Attention! Le utilisation du DeusEx, Apocalypse, scrifier croyant, guide va couter vos points d'action!");
			System.out.println("Le utilisation du croyant, guide ne coute pas vos points d'action! ");
			System.out.println("Les cartes en main de Joueur " + getNumeroJoueur() + " est:");
			while(it.hasNext()){ 
		 		CarteAction ca = (CarteAction)it.next(); 
		 		System.out.println("CarteEnMain : " + ca.getNom()+" "+ca.getOrigine()+" "+ca.getType());
		 	}
			boolean endTour = false;
			while(!endTour){
				System.out.println("Vous avez " + getPointActionJour() + " point action Jour");
				System.out.println("Vous avez " + getPointActionNuit() + " point action Nuit");
				System.out.println("Vous avez " + getPointActionNéant() + " point action Néant");
				System.out.println("Saisir 0 pour terminer ou 1 pour continuer");
				Scanner sc = new Scanner(System.in);
				int i = -1;
				int d = -1;
				i=sc.nextInt();
				if(i == 0){
					endTour = true;
				}else if(i == 1){
					boolean FLAG = false;
					while(!FLAG) {
						try{
							System.out.println("Choisir une carte action et saisir son numero dans votre carte en main");
							System.out.println("Par example: le numero du premier carte dans la liste est 0");
							int ii = 0;
							Iterator it2 = getCarteEnMain().iterator();
							System.out.println("Les cartes en main de Joueur " + getNumeroJoueur() + " est:");
							while(it2.hasNext()){ 
						 		CarteAction ca = (CarteAction)it2.next(); 
						 		System.out.println("CarteEnMain:" + ii + ":" + ca.getNom() + " " + ca.getOrigine() + " " + ca.getDogme());
						 		ii++;
						 	}
							
							d = sc.nextInt();
							if(d >= 0 && d < this.getCarteEnMain().size()) {
								FLAG = true;
							}else {
								System.out.println("Le numéro de carte n'est pas compris dans votre carte en main");
								FLAG = false;
							}
						}catch(InputMismatchException e) {
							System.out.println("Erreur");
							sc.next();
							FLAG = false;
						}
					}
					CarteAction ca = (CarteAction)this.getCarteEnMain().get(d);
					
					//Chercher le type de carte action et décider quelle méthode
					switch(ca.getType()) {
					case "Croyant":
						Croyant cc = (Croyant)ca;
						System.out.println("'sacrifier' ou 'poser'!");
						Scanner sc1 = new Scanner(System.in);
						String input = sc1.next();
						if(input.equals("sacrifier")){
							utiliserCroyant(cc,p);
						}else if(input.equals("poser")){
							switch(ca.getOrigine()) {
							case "Jour":
								if(this.getPointActionJour() >= 1) {
									this.setPointActionJour(this.getPointActionJour()-1);
									poserCroyant(cc);
								}else {
									System.out.println("Vous n'avez pas de point d'action Jour");
									continue;
								}
								break;
							case "Nuit":
								if(this.getPointActionNuit() >= 1) {
									this.setPointActionNuit(this.getPointActionNuit()-1); 
									poserCroyant(cc);
								}else{
									System.out.println("Vous n'avez pas de point d'action Nuit");
									continue;
								}
								break;
							
							case "Néant":
								if(this.getPointActionNéant() >= 1) {
									this.setPointActionNéant(this.getPointActionNéant()-1); 
									poserCroyant(cc);
								}else {
									System.out.println("Vous n'avez pas de point d'action Néant");
									continue;
								}
								break;
							case "":
								break;
							default :
								break;
							}
						}

						break;
					case "GuideSpirituel":
						GuideSpirituel guide = (GuideSpirituel)ca;
						System.out.println("'sacrifier' ou 'utiliser'!");
						Scanner sc2 = new Scanner(System.in);
						String input2 = sc2.next();
						if(input2.equals("sacrifier")){
							utiliserGuideSpirituel(guide,p);
						}else if(input2.equals("utiliser")){
							
							switch(ca.getOrigine()) {
							case "Jour":
								if(this.getPointActionJour() >= 1) {
									this.setPointActionJour(this.getPointActionJour()-1);
									poserGuideSpirituel(guide);
								}else {
									System.out.println("Vous n'avez pas de point d'action Jour");
									continue;
								}
								break;
							case "Nuit":
								if(this.getPointActionNuit() >= 1) {
									this.setPointActionNuit(this.getPointActionNuit()-1); 
									poserGuideSpirituel(guide);
								}else{
									System.out.println("Vous n'avez pas de point d'action Nuit");
									continue;
								}
								break;
							
							case "Néant":
								if(this.getPointActionNéant() >= 1) {
									this.setPointActionNéant(this.getPointActionNéant()-1); 
									poserGuideSpirituel(guide);
								}else {
									System.out.println("Vous n'avez pas de point d'action Néant");
									continue;
								}
								break;
							case "":
								break;
							default :
								break;
							}
						}
						break;
					case "DeusEx":
						DeusEx de = (DeusEx)ca;
						switch(ca.getOrigine()) {
						case "Jour":
							if(this.getPointActionJour() >= 1) {
								this.setPointActionJour(this.getPointActionJour()-1);
								utiliserDeusEx(de,p);
							}else {
								System.out.println("Vous n'avez pas de point d'action Jour");
								continue;
							}
							break;
						case "Nuit":
							if(this.getPointActionNuit() >= 1) {
								this.setPointActionNuit(this.getPointActionNuit()-1); 
								utiliserDeusEx(de,p);
							}else{
								System.out.println("Vous n'avez pas de point d'action Nuit");
								continue;
							}
							break;
						
						case "Néant":
							if(this.getPointActionNéant() >= 1) {
								this.setPointActionNéant(this.getPointActionNéant()-1); 
								utiliserDeusEx(de,p);
							}else {
								System.out.println("Vous n'avez pas de point d'action Néant");
								continue;
							}
							break;
						case "":
							utiliserDeusEx(de,p);
							break;
						default :
							break;
						}
						break;
					case "Apocalypse":
						Apocalypse ap = (Apocalypse)ca;
						switch(ca.getOrigine()) {
						case "Jour":
							if(this.getPointActionJour() >= 1) {
								this.setPointActionJour(this.getPointActionJour()-1);
								utiliserApocalypse(ap,p);
							}else {
								System.out.println("Vous n'avez pas de point d'action Jour");
								continue;
							}
							break;
						case "Nuit":
							if(this.getPointActionNuit() >= 1) {
								this.setPointActionNuit(this.getPointActionNuit()-1); 
								utiliserApocalypse(ap,p);
							}else{
								System.out.println("Vous n'avez pas de point d'action Nuit");
								continue;
							}
							break;
						
						case "Néant":
							if(this.getPointActionNéant() >= 1) {
								this.setPointActionNéant(this.getPointActionNéant()-1); 
								utiliserApocalypse(ap,p);
							}else {
								System.out.println("Vous n'avez pas de point d'action Néant");
								continue;
							}
							break;
						case "":
							utiliserApocalypse(ap,p);
							break;
						default :
							break;
						}
						
						break;
					}
					//Supprimer la carte action en main
					this.getCarteEnMain().remove(d);
				}
			}
			
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
		
			while( guide.getCroyantAttache().size() < nbCroyant && nombreCroyant!=0){
				    Iterator itc=cartesCroyant.iterator();
				    while(itc.hasNext()){
				    	Croyant c=(Croyant)itc.next();
				    	System.out.println("Ces sont les cartes Croyant sur table");
				    	System.out.println(c.getNom());
				    }
					System.out.println("Joueur " + this.getNumeroJoueur() + "Saisir le numéro de carte en table vous voulez attacher");
					System.out.println("Par example: le numéro du premier carte est 0");
					Scanner sc = new Scanner(System.in);
					int num = sc.nextInt();
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
						System.out.println("Il n'y a pas de même dogme de ce Guide Spirituel et ce Croyant, continuer attacher? Si oui, saisissez 1,sinon 0");
						int continu = sc.nextInt();
						if(continu == 0){
							break;
						}else if(continu ==1){
							continue;
						}
					}
			}
		}
	public int getNumeroAction() {
		return numeroAction;
	}
	public void setNumeroAction(int numeroAction) {
		this.numeroAction = numeroAction;
	}
	@Override
	public void defausserCarte(Partie p) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	  

}

