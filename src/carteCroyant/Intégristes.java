package carteCroyant;

import gui.Pandocreon_Frame;

import java.awt.Image;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import outils.getImages;

import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.GuideSpirituel;
import control.Joueur;
import control.Partie;


public class Int��gristes extends Croyant{
	//contructeur
    public Int��gristes(){
     super();
   	 this.nombrePuissance = 1;
   	 this.nom = "Int��gristes";
   	 this.origine = "Jour";
   	 this.dogme = "MystiqueNatureChaos";
   	Image image = null;
	//image = getImages.getPng("Integriste");
	//this.setImage(image);
    }
    
      //Impose le sacrifice d'un Guide Spirituel d'un autre joueur, qui choisit la carte. 
      //La capacit�� sp��ciale du sacrifice est jou��e.
    public void utiliserCapacite(Joueur j,Partie partie){	
    	if(this.utiliser==true){
    	System.out.println("Int��gristes:");
    	  //Choisir un joueur et le chercher dans List joueurs
    	Scanner sc = new Scanner(System.in);
    	Joueur targetJoueur = j;
    	int sizeJoueur;
    	int n = -1;
    	  //Si ce joueur est un JoueurVirtuel
    	if(j.getNumeroJoueur() != 1){
    		sizeJoueur = partie.getPartie().getJoueurs().size();
    		n = new java.util.Random().nextInt(sizeJoueur);
    		System.out.println("Joueur" + j.getNumeroJoueur() + " a choisi Joueur num��ro " + n);
    	}else{
    		  //Si ce joueur est un JoueurPhysique	
    		System.out.println("Joueur " + 1 + " choisit un joueur, entrer son num��ro");
    		System.out.println("Vous piochez deux cartes au hasard dans la main d'une autre Divinit��.");
    		n = sc.nextInt();
    		System.out.println("Joueur" + 1 + " a choisi Joueur num��ro " + n);	
    	}
    	List l = partie.getPartie().getJoueurs();
    	Iterator it = l.iterator();
    	while(it.hasNext()){
    		targetJoueur = (Joueur)it.next();
    		if(targetJoueur.getNumeroJoueur() == n){
    			break;
    		}
    	}
    	/**
		 * �������ɱ�ѡ�����������������
		 */
    	  //le targetJoueur qui choisit la carte Croyant �� sacrifice
    	if(targetJoueur.getCarteGsEnjeu().size() != 0){
    		boolean FLAG = false;
    		int n1 = -1;
    		  //targetJoueur est un JoueurVirtuel
    		if(targetJoueur.getNumeroJoueur() != 1){
    			int sizeEspaceGuide;
    			sizeEspaceGuide = targetJoueur.getCarteGsEnjeu().size();
    			n1 = new java.util.Random().nextInt(sizeEspaceGuide);
    		}else{
    			  //targetJoueur est un JoueurPhysique
    			while(FLAG == false){
        			System.out.println("Joueur " + 1 + " choisit un carte de Guide Spirituel dans l'espace personnel de Joueur " + targetJoueur.getNumeroJoueur());
            		n1 = sc.nextInt();
            		if(n1 >= 0 && n1 < targetJoueur.getCarteGsEnjeu().size()){
            			FLAG =true;
            		}else{
            			System.out.println("Ce num��ro de carte n'est pas compris dans l'espace croyant de Joueur" + targetJoueur.getNumeroJoueur());
            			FLAG = false;
            		}
    		    }
        	}
    		
			GuideSpirituel gs = (GuideSpirituel)targetJoueur.getCarteGsEnjeu().get(n1);
    		targetJoueur.getCarteGsEnjeu().remove(n1);
    		System.out.println("Joueur " + j.getNumeroJoueur() + " a utilis�� une carte de Guide Spirituel " + gs.getNom());
    		j.utiliserGuideSpirituel(gs,partie.getPartie());
    		
    		List croyantDeGuide = gs.getCroyantAttache();
    		
    		for(int d = 0 ; d < gs.getCroyantAttache().size() ; d++){
    			Croyant cy = (Croyant)targetJoueur.getCarteGsEnjeu().get(d);
    			for(int i = 0 ; i < targetJoueur.getCarteCroyantEnjeu().size() ; i++){
    				Croyant cy1 = (Croyant)targetJoueur.getCarteCroyantEnjeu().get(i);
    				if(cy.getNom().equals(cy1.getNom()) && cy.getOrigine().equals(cy1.getOrigine()) && cy.getDogme().equals(cy1.getDogme())){
    					targetJoueur.getCarteCroyantEnjeu().remove(i);
    					System.out.println("Une carte de Croyant " +cy.getNom() + " qui attach�� avec ce Guide Spirituel de Joueur " + targetJoueur.getNumeroJoueur() + " est d��fauss��");
    					break;
    				}
    			}
    		}		
    	}else{
    		System.out.println("Joueur" + targetJoueur.getNumeroJoueur() + " n'a pas de carte Croyant dans son espace");
    	}
    	}else{
	    	System.out.println("Sa capacite a ��t�� annul��e d��ja! ");
	    }
	}
		
}
