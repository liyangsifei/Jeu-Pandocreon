package control;
import gui.Pandocreon_Frame;

import java.util.*;

public class Tour {
	private List joueurs;
	private Joueur premierJoueurDuTour;

	//constructeur
	public Tour(ArrayList<Joueur> arrayList){
		this.joueurs=new ArrayList();
		this.joueurs=arrayList;
	}
	
	//commencer un nouvel tour
	public void nouvelTour(Partie p){
		//暂时删掉每一轮更换掷骰子玩家 
	//	premierJoueurDuTour=(Joueur)joueurs.get(0);
	//	partie.setPremierJoueurCompter((Joueur)joueurs.get(0));
	//	int i=premierJoueurDuTour.getNumeroJoueur();
		
		int i = 1;
		  //lancer du de
		System.out.println("Nouvel tour! Joueur"+i+" lance du de!");
		Random r=new Random();
		int resultat = r.nextInt(3);
		int resultatDe=(int)Math.floor(resultat);
		  //distribuer point d'action
		distribuerPointAction(resultatDe);
		  //Chaque joueur joue son tour
		List lJoueurs = new ArrayList();
		lJoueurs = p.getPartie().getJoueurs();
		Iterator it = lJoueurs.iterator();
		
		while(it.hasNext()){
			Joueur j1=(Joueur) it.next();
			if(j1.getNumeroJoueur()!=1){
			   TourDuChaqueJoueur tourDuChaqueJoueur=new TourDuChaqueJoueur(j1);
			   tourDuChaqueJoueur.choisirAction(p);
			  // f.partie.getPartie().setJoueurEnJeu(j1);
			}
		}
		  //changer l'ordre des joueurs pour le prochain tour
	//	joueurs.remove(0);
	//	joueurs.add(premierJoueurDuTour);
		System.out.println("On a fini ce tour!");
	}
	
	
	  //distribuer points d'action
	public void distribuerPointAction(int resultat){
		if(resultat==0){
			System.out.println("Face Jour!");
			Iterator it=joueurs.iterator();
			while(it.hasNext()){
				Joueur j=(Joueur) it.next();
				if(j.getDivinite().getDiviniteOrigine()=="Jour"){
					j.setPointActionJour(j.getPointActionJour()+2);
					System.out.println("Donner 2 points Jour au joueur"+j.getNumeroJoueur());
				}else if(j.getDivinite().getDiviniteOrigine()=="Aube"){
					j.setPointActionJour(j.getPointActionJour()+1);
					System.out.println("Donner 1 points Jour au joueur"+j.getNumeroJoueur());
				}
			}
		}else if(resultat==1){
			System.out.println("Face Nuit!");
			Iterator it=joueurs.iterator();
			while(it.hasNext()){
				Joueur j=(Joueur) it.next();
				if(j.getDivinite().getDiviniteOrigine()=="Nuit"){
					j.setPointActionNuit(j.getPointActionNuit()+2);
					System.out.println("Donner 2 points Nuit au joueur"+j.getNumeroJoueur());
				}else if(j.getDivinite().getDiviniteOrigine()=="Crépuscule"){
					j.setPointActionNuit(j.getPointActionNuit()+1);
					System.out.println("Donner 1 points Nuit au joueur"+j.getNumeroJoueur());
				}
			}
		}else if(resultat==2){
			System.out.println("Face Néant!");
			Iterator it=joueurs.iterator();
			while(it.hasNext()){
				Joueur j=(Joueur) it.next();
				if(j.getDivinite().getDiviniteOrigine()=="Aube"){
					j.setPointActionNéant(j.getPointActionNéant()+1);
					System.out.println("Donner 1 points Néant au joueur"+j.getNumeroJoueur());
				}else if(j.getDivinite().getDiviniteOrigine()=="Crépuscule"){
					j.setPointActionNéant(j.getPointActionNéant()+1);
					System.out.println("Donner 1 points Néant au joueur"+j.getNumeroJoueur());
				}
			}
		}
	}

	
	
}

