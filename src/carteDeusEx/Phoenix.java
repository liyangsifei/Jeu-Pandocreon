package carteDeusEx;

import control.Joueur;
import control.Partie;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.*;

import outils.getImages;
import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.DeusEx;


public class Phoenix extends DeusEx{
	//contructeur
    public Phoenix(){
    	super();
   	 this.nom="Phoenix";
   	 this.origine = "N¨¦ant";
   	Image image = null;
//	image = getImages.getPng("Phoenix");
	//this.setImage(image);
    }
    
    //Permet de b¨¦n¨¦ficier de la capacit¨¦ sp¨¦ciale de l'un de vos Croyants ou 
    //Guides Spirituels sans sacrifier la carte.
    public void utiliserCapacite(Joueur j,Partie partie){
    	if(this.utiliser==true){
    	 System.out.println("Utiliser Carte DeusEx: Phoenix ");
    	 System.out.println("Permet de b¨¦n¨¦ficier de la capacit¨¦ sp¨¦ciale de l'un de vos Croyants ou Guides Spirituels sans sacrifier la carte.");
    	 Scanner sc = new Scanner(System.in);
     	 Iterator lcg=j.getCarteEnMain().iterator();
     	 List croyantGuide=new ArrayList();
     	 int nombre=0;
     	 while(lcg.hasNext()){
     		 CarteAction carte=(CarteAction)lcg.next();
     		 if(carte.getType()=="Croyant"||carte.getType()=="GuideSpirituel"){
     			 croyantGuide.add(carte);
     			 nombre++;
     		 }
     	 }
 		
 	   if(nombre!= 0){
 		   boolean FLAG = false;
 		   int n2 = -1;
 		   if(j.getNumeroJoueur() != 1){
 			
 			    
 			   n2= new java.util.Random().nextInt(croyantGuide.size());
 		   }else{
 			   while(FLAG == false){
 				   System.out.println("Saisir le num¨¦ro de carte vous voulez choisir!");
 				   Iterator cg=croyantGuide.iterator();
 				   int num=0;
 				   while(cg.hasNext()){
 					   CarteAction carte=(CarteAction)cg.next();
 					   System.out.println(num + " "+carte.getNom() + " " + carte.getType());
 					   num++;
 				   }
 			       
 				   n2 = sc.nextInt();
 				   if(n2 >= 0 && n2 < croyantGuide.size()){
 					   FLAG = true;
 				   }else{
 					   System.out.println("Ce num¨¦ro de carte n'est pas correct!");
 					   FLAG = false;
 				   }
 			   }
 		   }
 			CarteAction cy = (CarteAction)croyantGuide.get(n2);
 			cy.utiliserCapacite(j, partie.getPartie());
 			System.out.println("Joueur " + j.getNumeroJoueur() + " a b¨¦n¨¦fici¨¦ de la capacit¨¦ de sacrifice de la carte de Croyant " + cy.getNom());
 		}else{
 			System.out.println("Vous n'avez pas de carte de Croyant dans votre espace personnel");
 		}
    	}else{
	    	System.out.println("Sa capacite a ¨¦t¨¦ annul¨¦e d¨¦ja! ");
	    }
    }
}
