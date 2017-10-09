package carteDeusEx;

import control.Joueur;
import control.Partie;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.DeusEx;


public class InfluenceN��ant extends DeusEx{
	//contructeur
    public InfluenceN��ant(){
    	super();
   	 this.nom="InfluenceN��ant";
   	 this.origine = "";
   	Image image = null;
	//image = getImages.getPng("InfluenceNeant");
	//this.setImage(image);
    }
    
    //Annule la capacit�� sp��ciale d'une carte d'Action d'Origine Jour ou Nuit.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	 System.out.println("Utiliser Carte DeusEx: InfluenceN��ant");
    	 System.out.println("Annule la capacit�� sp��ciale d'une carte d'Action d'Origine Jour ou Nuit.");
       	 Scanner sc = new Scanner(System.in);
   			Joueur targetJoueur = j;
   			int sizeJoueur;
   			int n = -1;
   			  //Si ce joueur est un JoueurVirtuel
   			if(j.getNumeroJoueur() != 1){
   				sizeJoueur = partie.getPartie().getJoueurs().size();
   				n = new java.util.Random().nextInt(sizeJoueur)+1;
   				System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur num��ro " + n);
   			}else{
   				  //Si ce joueur est un JoueurPhysique	
   				System.out.println("Joueur " + 1 + " choisit un joueur, entrer son num��ro");
   				
   				n = sc.nextInt();
   				System.out.println("Joueur" + 1 + " a choisi Joueur num��ro " + n);
   				
   			}
   			List l =partie.getPartie().getJoueurs();
   			Iterator it = l.iterator();
   			while(it.hasNext()){
   				targetJoueur = (Joueur)it.next();
   				if(targetJoueur.getNumeroJoueur() == n){
   					break;
   				}
   			}
   			  
   			
   			boolean FLAG = false;
   			List carteJourNuit=new ArrayList();
   			Iterator itcnn=targetJoueur.getCarteEnMain().iterator();
   			while(itcnn.hasNext()){
   				CarteAction carte=(CarteAction)itcnn.next();
   				if(carte.getOrigine()=="Jour"||carte.getOrigine()=="Nuit"){
   					carteJourNuit.add(carte);
   				}
   			}
   			
   			if(carteJourNuit.size() >0){
   				int m1 = -1;
   				int sizeMain;
   				if(j.getNumeroJoueur() != 1){
   					sizeMain = carteJourNuit.size();
   					
   						m1 = new java.util.Random().nextInt(sizeMain);
   						
   				}else{
   					
   					while(FLAG == false){
   						int size=carteJourNuit.size();
   						System.out.println("le nombre des cartes d'Action d'Origine Jour ou Nuit est "+size);
   						System.out.println("Joueur " + 1 + " choisit une carte d'origine jour ou une carte d'origine nuit en main de Joueur " + targetJoueur.getNumeroJoueur());
   						m1= sc.nextInt();
   						
   						if(m1 >= 0 && m1 < carteJourNuit.size() ) {
   							FLAG = true;
   						}else{
   							System.out.println("Le num��ro de carte n'est pas compris!");
   							FLAG = false;
   						}
   					}
   				}
   			               CarteAction ca=(CarteAction)carteJourNuit.get(m1);
			             	targetJoueur.getCarteEnMain().remove(ca);
				 //Eviter de supprimer la carte �� l'avance et le num��ro dans List CarteEnMain change
				
				           ca.utiliser=false;
				           targetJoueur.getCarteEnMain().add(ca);
   						System.out.println("joueur " + j.getNumeroJoueur() + " a annul�� la capacit�� d'une des cartes actions de joueur " + targetJoueur.getNumeroJoueur() + "!");
   				
   			}else{
   				System.out.println("Joueur " + targetJoueur.getNumeroJoueur() + " n'a pas de carte en main");
   			}
   		
    	}else{
	    	System.out.println("Sa capacite a ��t�� annul��e d��ja! ");
	    }
    }
}