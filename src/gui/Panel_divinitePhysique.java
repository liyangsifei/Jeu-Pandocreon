package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import carteAction.CarteAction;
import control.Joueur;
import control.JoueurPhysique;
import control.Partie;
import outils.getImages;

public class Panel_divinitePhysique extends JPanel implements Observer{
	
	private List joueurs;
	//JLabel label = new JLabel("divinite physique");
	 //JLabel affichePoint = new JLabel("J:" + "N:" + "Ne:");
	 private Dimension d = new Dimension(130,95);
	 private final static int WIDTH=130;
	 private final static int HEIGHT=95;
	 
	 private JPanel panelChoix = new JPanel();
	 private JButton piocherCarte = new JButton("Piocher Carte");
	 private JButton utiliserCarte = new JButton("Utiliser Carte");
	 private JButton defausserCarte = new JButton("Defausser Carte");
	 private JButton ok = new JButton("OK");
	
	 public Panel_divinitePhysique(final Pandocreon_Frame f){
		 this.setBackground(Color.darkGray);
		 this.joueurs=new ArrayList<Joueur>();
		 //this.add(affichePoint);
		 this.add(panelChoix);
		 panelChoix.setLayout(new GridLayout(3,1));
		 //this.label.setFont(new java.awt.Font("Dialog", 1, 15));
		//	this.label.setForeground(Color.yellow);
		// this.add(label);
		 //panelChoix.add(affichePoint);
		 panelChoix.add(piocherCarte);
		 panelChoix.add(utiliserCarte);
		 panelChoix.add(defausserCarte);
		// panelChoix.add(ok);
		 
		 this.piocherCarte.addActionListener(new ActionListener() {  
				
	            public void actionPerformed(ActionEvent ae) {  
	            	if(f.partie.getPartie().isJoueurPhysiqueEnTour()&&f.partie.getPartie().getActionChoisi()==-1){
	            	    f.partie.getPartie().setActionChoisi(1);
	            	    JoueurPhysique jp = (JoueurPhysique)f.partie.getPartie().getJoueurs().get(0);
	            	    jp.setNumeroAction(f.partie.getPartie().getActionChoisi());
	            	    f.getJoueurPhysiqueView().getCarteMainView().setEndClick(true);
	            	    f.partie.getPartie().setPeuxChoisirAction(true);
	            	    f.partie.getPartie().notifyO();
	            	    f.partie.getPartie().setJoueurPhysiqueEnTour(false);
	            	   
	            	  // f.setPeutChoisirAction(true);
	                }else {
	                	JOptionPane.showMessageDialog(null, "Vous pouvez pas choisir un action quand vous etre pas en tour! Vous pouvez choisir action pour justement une fois quand vous etes en tour! ", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
	                }
	            	
	            }	
	        });
		 
		 this.utiliserCarte.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent ae) {  
	            	if(f.partie.getPartie().isJoueurPhysiqueEnTour()&&f.partie.getPartie().getActionChoisi()==-1){
	            		 f.partie.getPartie().setActionChoisi(2);
	            	    JoueurPhysique jp = (JoueurPhysique)f.partie.getPartie().getJoueurs().get(0);
	            	    jp.setNumeroAction(f.partie.getPartie().getActionChoisi());
	            	    f.getJoueurPhysiqueView().getCarteMainView().setEndClick(true);
	            	    f.partie.getPartie().notifyO();
	            	    f.partie.getPartie().setPeuxChoisirAction(true);
	            	    f.partie.getPartie().setJoueurPhysiqueEnTour(false);
	            	  // f.setPeutChoisirAction(true);
	                }else {
	                	JOptionPane.showMessageDialog(null, "Vous pouvez pas choisir un action quand vous etre pas en tour! Vous pouvez choisir action pour justement une fois quand vous etes en tour! ", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
	                }
	            }  
	        });
		 
		 this.defausserCarte.addActionListener(new ActionListener() {  
	            public void actionPerformed(ActionEvent ae) {  
	            	if(f.partie.getPartie().isJoueurPhysiqueEnTour()&& f.partie.getPartie().getActionChoisi()==-1){
	            		 f.partie.getPartie().setActionChoisi(0);
	            	    JoueurPhysique jp = (JoueurPhysique)f.partie.getPartie().getJoueurs().get(0);
	            	    jp.setNumeroAction(f.partie.getPartie().getActionChoisi());
	            	    f.getJoueurPhysiqueView().getCarteMainView().setEndClick(true);
	            	    f.partie.getPartie().notifyO();
	            	    f.partie.getPartie().setPeuxChoisirAction(true);
	            	    f.partie.getPartie().setJoueurPhysiqueEnTour(false);
	            	  // f.setPeutChoisirAction(true);
	                }else {
	                	JOptionPane.showMessageDialog(null, "Vous pouvez pas choisir un action quand vous etre pas en tour! Vous pouvez choisir action pour justement une fois quand vous etes en tour! ", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
	                }
	            }  
	        });
		 
		 //this.setBorder(BorderFactory.createTitledBorder("divinite"));
		// this.setBorder(BorderFactory.createLineBorder(Color.yellow));
	 }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.removeAll();
        this.revalidate();
        this.setBackground(Color.darkGray);
        Partie p=(Partie)o;
        Joueur j = (Joueur) p.getJoueurs().get(0);
        Iterator it1 = p.getPartie().getJoueurs().iterator();
        while(it1.hasNext()){
        	Joueur j1 = (Joueur) it1.next();
        	if(j1.getNumeroJoueur() == 1){
        		j = j1;
        	}
        }
        
        Image imgCarte = getImages.getPng(j.getDivinite().getNom());
        Image imgCarteFinal=(imgCarte.getScaledInstance(this.WIDTH,this.HEIGHT,Image.SCALE_DEFAULT));
	    JLabel labelImg = new JLabel(new ImageIcon(imgCarteFinal));
	    labelImg.setPreferredSize(d);
		this.add(labelImg);
	//	this.label.setFont(new java.awt.Font("Dialog", 1, 15));
	//	this.label.setForeground(Color.yellow);
	//	this.add(this.label);
		
	//	if(p.getPartie().getJoueurEnJeu().getNumeroJoueur() == 1 && p.getPartie().isaCommence()){
		panelChoix.setLayout(new GridLayout(4,1));
			this.add(panelChoix);
	//	}
		
		
		this.revalidate();
	}


	
	
	
}
