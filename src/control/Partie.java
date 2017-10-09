package control;
import java.util.*;
import carteAction.*;
import divinite.DivinitePile;
import control.Tour;
import gui.Bienvenu_Frame;
import gui.Pandocreon_Frame;

public class Partie extends Observable{
	
	private static Partie partie = new Partie();
	  //Si le jeu est termine
	public boolean etatDuJeu = true;
	private int nombre;
	private int modeChoisi;
	private boolean difficulte;
	  //creer un list qui peut conserver tout les joueurs
	private List joueurs;
	private DivinitePile diviniteEnJeu;
	private CartePile carteEnJeu;
	public boolean peuxGagnePointAction;
	private Joueur premierJoueurCompter;
	private Joueur joueurEnJeu;
    
	private boolean peutCommencerNouvelTour;
	private boolean joueurPhysiqueEnTour;
	private boolean peuxChoisirAction;
	private boolean joueurPhysiqueFinirTour;
	private int actionChoisi;
	
	private int utiliserOuPoser;
	  //le constructeur
	public Partie(){
		
		this.peutCommencerNouvelTour=true;
		this.joueurPhysiqueEnTour=false;
		this.joueurPhysiqueFinirTour=false;
		this.peuxChoisirAction=false;
		this.actionChoisi=-1;
		//将欢迎界面选择的虚拟玩家数目与游戏模式传递给partie
		
		  //creer tout les cartes actions dans le carte pile
		  //Touiller les cartes actions

		this.joueurs=new ArrayList<Joueur>();
		System.out.println("Bienvenu sur Pandocreon!");
		carteEnJeu=new CartePile();
		carteEnJeu.touiller();
		  //测试洗牌
		//carteEnJeu.printCartePile();
		System.out.println("Tout les cartes dans le pile sont crees et touilles!");
		  //creer tout les cartes divinites dans le divinite pile
		  //Touiller les cartes actions
		diviniteEnJeu=new DivinitePile();
		diviniteEnJeu.touiller();
		System.out.println("Tout les divinites dans le pile sont crees et touilles!");
		
		
		
	}
	
	
	public void jouerDebut(Pandocreon_Frame f){
        creerJoueur(f);

		piocherDivinite();
		
		distribuerCarteAuDebut(f);
		
		
	}
	
	//public void jouer(){
	//	System.out.println("Jouer!");
	//	while(etatDuJeu){
	//		System.out.println("Jouer!!!!");
	//	}
		//while(etatDuJeu){
		//	this.peuxGagnePointAction = true;
			//commencerNouvelTour(this);
	//	}
//	}
	  //creer joueurs au debut
	public void creerJoueur(Pandocreon_Frame f){
		JoueurPhysique joueurP= new JoueurPhysique(1);
		joueurs.add(joueurP);
		//System.out.println("Combien de joueurs virtuels vous voulez jouer avec?");
		//Scanner nombreJoueurVirtuel=new Scanner(System.in);
		
		//System.out.println("Saisir le mode du joueur! 1 est mode facile, 2 est mode difficile!");
    //	System.out.println("Mode faicle: Le joueur justement choisir un des deux actions, defausser les cartes ou piocher les cartes! ");
      //  System.out.println("Mode difficile: Le joueur peut defausser les cartes, piocher les cartes, et utiliser les cartes");
       // Scanner input=new Scanner(System.in);
    	//int modeChoisi=input.nextInt();
        for(int i=2;i<=nombre+1;i++){
			JoueurVirtuel joueurV=new JoueurVirtuel(i,f.getMode());
			joueurs.add(joueurV);
		}
		//System.out.println("Tout les joueurs sont crees! Attention! Joueur1 est le joueur physique!");
	}
	
	  //piocher carte divinite au debut
	public void piocherDivinite(){
		Iterator it=joueurs.iterator();
		while(it.hasNext()){
			Joueur j=(Joueur) it.next();
			j.piocherDivinite(diviniteEnJeu.tirerCarteDuDessus());
		}
	}
	
	  //conmmencer un nouvel tour
	public void commencerNouvelTour(Pandocreon_Frame f){
		Tour tour=new Tour((ArrayList<Joueur>) partie.joueurs);
		tour.nouvelTour(this);        //出错行
		this.notifyO();
	}
	
	  //distribuer cartes au debut
	public void distribuerCarteAuDebut(Pandocreon_Frame f){
		Iterator it=joueurs.iterator();
		while(it.hasNext()){
			Joueur j=(Joueur) it.next();
			j.piocherCarte(f.partie.getPartie());
		}
		System.out.println("7 cartes d'Action sont distribuees a tous les joueurs!");
		
		  //imprimer après distribution
		//List cartePileEnJeu = carteEnJeu.getCartes();
		//carteEnJeu.printCartePile();
	}
	
	  //Il faut un 'if' avant de décider si le nombre joueur en jeu est égale ou superieur a 4, si oui, on utilise la méthode eliminerJoueur
	  //Eliminer un joueur quand une carte Apocalypse est utilisée
	public void eliminerJoueur(){
		Joueur j = (Joueur)joueurs.get(0);
		int posit=0;
		boolean meme = false;
		int size = joueurs.size();
		for(int ind = 1 ; ind < size ; ind ++){
			Joueur j1 = (Joueur)joueurs.get(ind);
			if(j.getPuissanceJoueur() > j1.getPuissanceJoueur()){
				j = (Joueur)joueurs.get(ind);
				posit = ind;
			}
		}
		//Pour éviter d'éliminer joueurs quand on a deux ou plus joueurs en jeu ont des même point de puissance  
		for(int i = 0; i <size ;i++){
			if(i == posit){
				continue;
			}else{
				Joueur j2 = (Joueur)joueurs.get(i);
				if(j.getPuissanceJoueur() == j2.getPuissanceJoueur()){
					meme = true;
				}
			}
		}
		if(meme==false){
			joueurs.remove(j);
			System.out.println("le joueur avec numéro" + j.getNumeroJoueur() + "est perdu, la partie continue");
		}else{
			System.out.println("La carte Apocalypse est cessé car il y a deux joueurs ou plus ont des même nombre de puissance!");
		}
	}
	
	  //Pour utiliser cette méthode,il faut que le nombre joueur enjeu inférieur à 4
	public void resultatJeu(){
		Joueur j = (Joueur)joueurs.get(0);
		int posit=0;
		boolean meme = false;
		int size = joueurs.size();
		for(int ind = 1 ; ind < size ; ind ++){
			Joueur j1 = (Joueur)joueurs.get(ind);
			if(j.getPuissanceJoueur() < j1.getPuissanceJoueur()){
				j = (Joueur)joueurs.get(ind);
				posit = ind;
			}
		}
		  //Pour éviter d'éliminer joueurs quand on a deux ou plus joueurs en jeu ont des même point de puissance  
		for(int i = 0; i <size ;i++){
			if(i == posit){
				continue;
			}else{
				Joueur j2 = (Joueur)joueurs.get(i);
				if(j.getPuissanceJoueur() == j2.getPuissanceJoueur()){
					meme = true;
				}
			}
		} 
		if(meme==false){
			System.out.println("le joueur avec numéro" + j.getNumeroJoueur() + "gagné!");
			etatDuJeu = false;
		}else{
			System.out.println("La carte Apocalypse est cessé car il y a deux joueurs ou plus ont des même nombre de puissance!");
		}
		
		
	}

	
	
	  //Getters & Setters
	
	public static Partie getPartie(){
		   return partie;
	   }
	public boolean isDifficulte() {
		return difficulte;
	}

	public void setDifficulte(boolean difficulte) {
		this.difficulte = difficulte;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List joueurs) {
		this.joueurs = joueurs;
	}

	public DivinitePile getDiviniteEnJeu() {
		return diviniteEnJeu;
	}

	public void setDiviniteEnJeu(DivinitePile diviniteEnJeu) {
		this.diviniteEnJeu = diviniteEnJeu;
	}

	public CartePile getCarteEnJeu() {
		return carteEnJeu;
	}

	public void setCarteEnJeu(CartePile carteEnJeu) {
		this.carteEnJeu = carteEnJeu;
	}

	public boolean isEtatDuJeu() {
		return etatDuJeu;
	}

	public void setEtatDuJeu(boolean etatDuJeu) {
		this.etatDuJeu = etatDuJeu;
	}

	public boolean isPeuxGagnePointAction() {
		return peuxGagnePointAction;
	}

	public void setPeuxGagnePointAction(boolean peuxGagnePointAction) {
		this.peuxGagnePointAction = peuxGagnePointAction;
	}

	public Joueur getPremierJoueurCompter() {
		return premierJoueurCompter;
	}

	public void setPremierJoueurCompter(Joueur premierJoueurCompter) {
		this.premierJoueurCompter = premierJoueurCompter;
	}

	
	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getModeChoisi() {
		return modeChoisi;
	}

	public void setModeChoisi(int modeChoisi) {
		this.modeChoisi = modeChoisi;
	}

	
	
	public void notifyO(){
		this.setChanged();
		this.notifyObservers();
       //  int i=this.countObservers();
        // System.out.println(i);
	}

	public Joueur getJoueurEnJeu() {
		return joueurEnJeu;
	}

	public void setJoueurEnJeu(Joueur joueurEnJeu) {
		this.joueurEnJeu = joueurEnJeu;
	}


	public boolean isPeutCommencerNouvelTour() {
		return peutCommencerNouvelTour;
	}


	public void setPeutCommencerNouvelTour(boolean peutCommencerNouvelTour) {
		this.peutCommencerNouvelTour = peutCommencerNouvelTour;
	}


	public boolean isJoueurPhysiqueEnTour() {
		return joueurPhysiqueEnTour;
	}


	public void setJoueurPhysiqueEnTour(boolean joueurPhysiqueEnTour) {
		this.joueurPhysiqueEnTour = joueurPhysiqueEnTour;
	}


	public boolean isPeuxChoisirAction() {
		return peuxChoisirAction;
	}


	public void setPeuxChoisirAction(boolean peuxChoisirAction) {
		this.peuxChoisirAction = peuxChoisirAction;
	}


	public boolean isJoueurPhysiqueFinirTour() {
		return joueurPhysiqueFinirTour;
	}


	public void setJoueurPhysiqueFinirTour(boolean joueurPhysiqueFinirTour) {
		this.joueurPhysiqueFinirTour = joueurPhysiqueFinirTour;
	}


	public int getActionChoisi() {
		return actionChoisi;
	}


	public void setActionChoisi(int actionChoisi) {
		this.actionChoisi = actionChoisi;
	}


	public int getUtiliserOuPoser() {
		return utiliserOuPoser;
	}


	public void setUtiliserOuPoser(int utiliserOuPoser) {
		this.utiliserOuPoser = utiliserOuPoser;
	}

	
	
	
   
}
