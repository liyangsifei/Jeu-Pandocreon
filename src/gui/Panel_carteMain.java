package gui;
import javax.swing.*;


import javax.swing.text.html.HTMLDocument.Iterator;

import carteAction.Apocalypse;
import carteAction.CarteAction;
import carteAction.Croyant;
import carteAction.DeusEx;
import carteAction.GuideSpirituel;
import outils.getImages;

import control.Joueur;
import control.JoueurPhysique;
import control.Partie;
import control.Tour;
import control.TourDuChaqueJoueur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Panel_carteMain extends JPanel implements Observer{
	private Joueur joueurPhysique;
	//JLabel label = new JLabel("carteMain");
	 //private Panel_carte c[];
	
	 private Dimension d = new Dimension(100,150);
	 private ArrayList carteList;
	 private ArrayList labels;
	 Image noCarte1 = getImages.getPng("noCarte");
	 //手牌尺寸
	 private final static int WIDTH=100;
	 private final static int HEIGHT=150;
	 
	 private ArrayList typeList = new ArrayList<String>();
	 private int carteDefausse;
	 private int carteUtilise;
	 //private int utiliseOuPoser = 0;
	 private int verifier = 0;
	 private boolean endTour = false;
	 private int numMain;
	 
	 private int numeroCarte=0;
	 private boolean endClick=true;
	 
	 
	 public Panel_carteMain(){
		 this.setBackground(Color.darkGray);
		// this.add(label);
		 this.carteList=new ArrayList();
		 this.labels=new ArrayList();
		 
		 for(int i=0;i<7;i++){
			 JLabel label = new JLabel(new ImageIcon(noCarte1));
			 label.setPreferredSize(d);
			 Panel_carte c=new Panel_carte();
			 c.add(label);
			 this.carteList.add(c);
		 }
		 
		 java.util.Iterator it=carteList.iterator();
		 while(it.hasNext()){
			 Panel_carte cc=(Panel_carte)it.next();
			 this.add(cc);
		 }
		
	 }
		 


	@Override
	public void update(Observable o, Object arg) {
		this.endTour = false; //不确定是不是在这里加flase
		
		this.removeAll();
		this.revalidate();
		this.setBackground(Color.darkGray);
		this.carteList.removeAll(carteList);
		this.typeList.removeAll(typeList);
		final Partie p=(Partie)o;
		final Joueur j=(Joueur)p.getJoueurs().get(0);
		List cartes=j.getCarteEnMain();
		int length=cartes.size();
		for(int i=0;i<length;i++){
			CarteAction carte=(CarteAction)cartes.get(i);
			Image imgCarte = getImages.getPng(carte.getNom());
			Image imgCarteFinal=(imgCarte.getScaledInstance(this.WIDTH,this.HEIGHT,Image.SCALE_DEFAULT));
			JLabel label = new JLabel(new ImageIcon(imgCarteFinal));
			label.setPreferredSize(d);
			Panel_carte c=new Panel_carte();
			c.add(label);
			this.carteList.add(c);
			//Panel choix = new Panel();
			switch(carte.getType()){
				case "Croyant":
					String typeC = "Croyant";
					this.typeList.add(typeC);
					break;
				case "GuideSpirituel":
					String typeG = "Guide";
					this.typeList.add(typeG);
					break;
				case "DeusEx": 
					String typeD = "Deus";
					this.typeList.add(typeD);
					break;
				case "Apocalypse": 
					String typeA = "Apocalypse";
					this.typeList.add(typeA);
					break;
			}
		}
		if(length<7){
			for(int i=length;i<7;i++){
				JLabel label = new JLabel(new ImageIcon(noCarte1));
				label.setPreferredSize(d);
				Panel_carte c=new Panel_carte();
				c.add(label);
				this.carteList.add(c);
			}
		}
		
		
		
		/////////////////
		//piocher carte///
		if(((JoueurPhysique)j).getNumeroAction() == 1&&endClick){ //piocher
			  if(p.isPeuxChoisirAction()){
				int nc=j.getCarteEnMain().size();
				boolean peutPiocher=false;
				if(nc<7){peutPiocher=true;}
				if(p.isPeuxChoisirAction()&&peutPiocher){
					((JoueurPhysique)j).piocherCarte(p);
					p.setPeuxChoisirAction(false);
	            	p.notifyO();
	            }
				else if (nc>=7){
	             // if(!p.isPeuxChoisirAction()){
	              //  JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
	             // }else if(!peutPiocher){
	            	//  if(p.isPeuxChoisirAction()){
	            	  JOptionPane.showMessageDialog(null, "Vous avez deja 7 cartes!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
	               //   }
	             // }
	            }
			  }	
			}
////////////////////////////////000000000000000000000000000000000000000000000000000000000000000000000000000000000///////////////////////////////////////
		numMain = 0;
		
		Panel_carte cc = (Panel_carte)carteList.get(numMain);
		this.add(cc);
		
		JPanel utilise0 = new JPanel();
		utilise0.setLayout(new GridLayout(3,1));
		JButton ok0 = new JButton("OK");
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			   if(length >= 1 ){
				utilise0.add(ok0);
			   }
			}
		
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
		    ok0.addActionListener(new ActionListener() {  
		    	public void actionPerformed(ActionEvent e) {  
		    		if(p.isPeuxChoisirAction()){
		            	j.defausserCarteP(0);
		            	p.notifyO();
		            }else{
		                JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
		            }
		    	}  
		     });
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){  //utiliser
		    p.getPartie().setUtiliserOuPoser(0);
		    if(length >= 1 ){
		    switch((String)typeList.get(0)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  //查错要求改成final 不知道会不会有问题
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise0.add(sacrificeCroyant);
				utilise0.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {  
						JRadioButton radio = (JRadioButton) ae.getSource();  
						if (radio == sacrificeCroyant) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserCroyant) {  
							p.getPartie().setUtiliserOuPoser(2);
						}
					}  
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				
				ok0.addActionListener(new ActionListener() {  
			    public void actionPerformed(ActionEvent e) {  
			    	if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
			    		if(p.getPartie().getUtiliserOuPoser() == 1){
			    			j.utiliserCroyant((Croyant)j.getCarteEnMain().get(0), p);
			    			j.getCarteEnMain().remove(0);
			    			p.notifyO();
			    		}else if(p.getPartie().getUtiliserOuPoser() == 2){
			    			if(((Croyant)j.getCarteEnMain().get(0)).getOrigine().equals("Jour")){
			    				if(j.getPointActionJour() !=0 ){
			    					j.poserCroyant((Croyant)j.getCarteEnMain().get(0));
					    			j.getCarteEnMain().remove(0);
					    			j.setPointActionJour(j.getPointActionJour() - 1);
					            	p.notifyO();
			    				}else{
			    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
			    				}
			    			}else if(((Croyant)j.getCarteEnMain().get(0)).getOrigine().equals("Nuit")){
			    				if(j.getPointActionNuit() !=0 ){
			    					j.poserCroyant((Croyant)j.getCarteEnMain().get(0));
					    			j.getCarteEnMain().remove(0);
					    			j.setPointActionNuit(j.getPointActionNuit() - 1);
					            	p.notifyO();
			    				}else{
			    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
			    				}
			    			}else if(((Croyant)j.getCarteEnMain().get(0)).getOrigine().equals("Néant")){
			    				if(j.getPointActionNéant() !=0 ){
			    					j.poserCroyant((Croyant)j.getCarteEnMain().get(0));
					    			j.getCarteEnMain().remove(0);
					    			j.setPointActionNéant(j.getPointActionNéant() - 1);
					            	p.notifyO();
			    				}else{
			    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
			    				}
			    			}
			            }else{
			            	JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
			            }
			    	}
			    }  
			    });
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise0.add(sacrificeGuide);
				utilise0.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {  
				    	JRadioButton radio = (JRadioButton) ae.getSource();  
				    	if (radio == sacrificeGuide) {  //选择utiliserCarte之后选择牺牲croyant
				    		p.getPartie().setUtiliserOuPoser(1);
				    	} else if (radio == poserGuide) {  
				    		p.getPartie().setUtiliserOuPoser(2);
				    	} 
				    }
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
				ok0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {  
			            if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
			            	if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(0), p);
			            		j.getCarteEnMain().remove(0);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(0));
			            		j.getCarteEnMain().remove(0);
			            		p.notifyO();
			            	}
			            }
			        }
				});
				break;
			case "Deus":
				ok0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(0), p);
						j.getCarteEnMain().remove(0);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok0.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(0), p);
						j.getCarteEnMain().remove(0);
			            p.notifyO();
			        }
				});
				break;
			}
		    }
		}
		this.add(utilise0);
			
/////////11111111111111111111111111111111111111111111111111111111111111111111111111111111111//////////////////////////////////////////////////////////
		numMain = 1;
		
		Panel_carte cc1 = (Panel_carte)carteList.get(numMain);
		this.add(cc1);
				
		JPanel utilise1 = new JPanel();
		utilise1.setLayout(new GridLayout(3,1));
		JButton ok1 = new JButton("OK");
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			  if(length >= 2){
				utilise1.add(ok1);
			  }	
			}	
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
			ok1.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {  
					if(p.isPeuxChoisirAction()){
						j.defausserCarteP(1);
						p.notifyO();
					}else{
						JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
					}
				}
			});
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){  //utiliser
			p.getPartie().setUtiliserOuPoser(0);
			if(length >= 2){
			switch((String)typeList.get(1)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  //查错要求改成final 不知道会不会有问题
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise1.add(sacrificeCroyant);
				utilise1.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();  
				        if (radio == sacrificeCroyant) {  //选择utiliserCarte之后选择牺牲croyant
				        	p.getPartie().setUtiliserOuPoser(1);
				        }else if (radio == poserCroyant) {  
				            p.getPartie().setUtiliserOuPoser(2);
				        } 
				    }  
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				ok1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
							if(p.getPartie().getUtiliserOuPoser() == 1){
								j.utiliserCroyant((Croyant)j.getCarteEnMain().get(1), p);
								j.getCarteEnMain().remove(1);
								p.notifyO();
							}else if(p.getPartie().getUtiliserOuPoser() == 2){
								if(((Croyant)j.getCarteEnMain().get(1)).getOrigine().equals("Jour")){
				    				if(j.getPointActionJour() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(1));
						    			j.getCarteEnMain().remove(1);
						    			j.setPointActionJour(j.getPointActionJour() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(1)).getOrigine().equals("Nuit")){
				    				if(j.getPointActionNuit() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(1));
						    			j.getCarteEnMain().remove(1);
						    			j.setPointActionNuit(j.getPointActionNuit() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(1)).getOrigine().equals("Néant")){
				    				if(j.getPointActionNéant() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(1));
						    			j.getCarteEnMain().remove(1);
						    			j.setPointActionNéant(j.getPointActionNéant() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}
							}else{
								JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
							}
						}
					}
				});
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise1.add(sacrificeGuide);
				utilise1.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeGuide) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						}else if (radio == poserGuide) {
							p.getPartie().setUtiliserOuPoser(2);
						}
					}
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
				ok1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){
							if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(1), p);
			            		j.getCarteEnMain().remove(1);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(1));
			            		j.getCarteEnMain().remove(1);
			            		p.notifyO();
			            	}
						}
					}
				});
				break;
			case "Deus":
				ok1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(1), p);
						j.getCarteEnMain().remove(1);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(1), p);
						j.getCarteEnMain().remove(1);
			            p.notifyO();
					}
				});
				break;
			}
			}
		}
		this.add(utilise1);
//////////////////2222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222///////////////////////////////////////////
		numMain = 2;
		Panel_carte cc2 = (Panel_carte)carteList.get(numMain);
		this.add(cc2);
					
		JPanel utilise2 = new JPanel();
		utilise2.setLayout(new GridLayout(3,1));
		JButton ok2 = new JButton("OK");
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			   if(length >= 3){
				utilise2.add(ok2);
			  }
			}
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
			ok2.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {
					if(p.isPeuxChoisirAction()){
						j.defausserCarteP(2);
						p.notifyO();
					}else{
						JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
					}
				}
			});
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){  //utiliser
			p.getPartie().setUtiliserOuPoser(0);
			if(length >= 3){
			switch((String)typeList.get(2)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  //查错要求改成final 不知道会不会有问题
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise2.add(sacrificeCroyant);
				utilise2.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {  
						JRadioButton radio = (JRadioButton) ae.getSource();  
						if (radio == sacrificeCroyant) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						}else if (radio == poserCroyant) {  
							p.getPartie().setUtiliserOuPoser(2);
						}
					}
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				
				ok2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
							if(p.getPartie().getUtiliserOuPoser() == 1){
								j.utiliserCroyant((Croyant)j.getCarteEnMain().get(2), p);
								j.getCarteEnMain().remove(2);
								p.notifyO();
							}else if(p.getPartie().getUtiliserOuPoser() == 2){
								if(((Croyant)j.getCarteEnMain().get(2)).getOrigine().equals("Jour")){
				    				if(j.getPointActionJour() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(2));
						    			j.getCarteEnMain().remove(2);
						    			j.setPointActionJour(j.getPointActionJour() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(2)).getOrigine().equals("Nuit")){
				    				if(j.getPointActionNuit() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(2));
						    			j.getCarteEnMain().remove(2);
						    			j.setPointActionNuit(j.getPointActionNuit() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(2)).getOrigine().equals("Néant")){
				    				if(j.getPointActionNéant() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(2));
						    			j.getCarteEnMain().remove(2);
						    			j.setPointActionNéant(j.getPointActionNéant() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}
							}else{
								JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
							}
						}
					}
				});
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise2.add(sacrificeGuide);
				utilise2.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeGuide) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserGuide) {
							p.getPartie().setUtiliserOuPoser(2);
						}
					}
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
				ok2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){  
							if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(2), p);
			            		j.getCarteEnMain().remove(2);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(2));
			            		j.getCarteEnMain().remove(2);
			            		p.notifyO();
			            	}
						}
					}
				});
				break;
			case "Deus":
				ok2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(2), p);
						j.getCarteEnMain().remove(2);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(2), p);
						j.getCarteEnMain().remove(2);
			            p.notifyO();
					}
				});
				break;
			}
			}
		}
		this.add(utilise2);
////////////////////////////////////////3333333333333333333333333333333333333333333333333333333333333333333///////////////////////////////////////////////
		numMain = 3;
		
		Panel_carte cc3 = (Panel_carte)carteList.get(numMain);
		this.add(cc3);
		
		JPanel utilise3 = new JPanel();
		utilise3.setLayout(new GridLayout(3,1));
		JButton ok3 = new JButton("OK");
		
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			   if(length >= 4){
				utilise3.add(ok3);
			   }
			}
		
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
			ok3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { 
					if(p.isPeuxChoisirAction()){
						j.defausserCarteP(3);
						p.notifyO();
					}else{
						JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
					}
				}
				});
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){  //utiliser
			p.getPartie().setUtiliserOuPoser(0);
			if(length >= 4){
			switch((String)typeList.get(3)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  //查错要求改成final 不知道会不会有问题
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise3.add(sacrificeCroyant);
				utilise3.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {  
						JRadioButton radio = (JRadioButton) ae.getSource();  
						if (radio == sacrificeCroyant) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserCroyant) {  
							p.getPartie().setUtiliserOuPoser(2);
						} 
					}
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				
				ok3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
							if(p.getPartie().getUtiliserOuPoser() == 1){
								j.utiliserCroyant((Croyant)j.getCarteEnMain().get(3), p);
								j.getCarteEnMain().remove(3);
								p.notifyO();
							}else if(p.getPartie().getUtiliserOuPoser() == 2){
								if(((Croyant)j.getCarteEnMain().get(3)).getOrigine().equals("Jour")){
				    				if(j.getPointActionJour() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(3));
						    			j.getCarteEnMain().remove(3);
						    			j.setPointActionJour(j.getPointActionJour() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(3)).getOrigine().equals("Nuit")){
				    				if(j.getPointActionNuit() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(3));
						    			j.getCarteEnMain().remove(3);
						    			j.setPointActionNuit(j.getPointActionNuit() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(3)).getOrigine().equals("Néant")){
				    				if(j.getPointActionNéant() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(3));
						    			j.getCarteEnMain().remove(3);
						    			j.setPointActionNéant(j.getPointActionNéant() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}
							}else{
								JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
							}
						}
					}
				});
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise3.add(sacrificeGuide);
				utilise3.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeGuide) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserGuide) {
								p.getPartie().setUtiliserOuPoser(2);
						}
					}
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
				
				ok3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
							if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(3), p);
			            		j.getCarteEnMain().remove(3);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(3));
			            		j.getCarteEnMain().remove(3);
			            		p.notifyO();
			            	}
						}
					}
				});
				break;
			case "Deus":
				ok3.addActionListener(new ActionListener() {  
					public void actionPerformed(ActionEvent e) {  
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(3), p);
						j.getCarteEnMain().remove(3);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(3), p);
						j.getCarteEnMain().remove(3);
			            p.notifyO();
					}
				});
				break;
			}
			}
		}
		this.add(utilise3);
//////////////////////444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444///////////////////////////////////
		numMain = 4;
		Panel_carte cc4 = (Panel_carte)carteList.get(numMain);
		this.add(cc4);
		
		JPanel utilise4 = new JPanel();
		utilise4.setLayout(new GridLayout(3,1));
		JButton ok4 = new JButton("OK");
		
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			  if(length >= 5){
				utilise4.add(ok4);
			  }
			}
		
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
			ok4.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) { 
					if(p.isPeuxChoisirAction()){
						j.defausserCarteP(4);
						p.notifyO();
					}else{
						JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
					}
				}
			});
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){  //utiliser
			if(length >= 5){
			p.getPartie().setUtiliserOuPoser(0);
			switch((String)typeList.get(4)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise4.add(sacrificeCroyant);
				utilise4.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeCroyant) {  
							p.getPartie().setUtiliserOuPoser(1);
						}else if (radio == poserCroyant) {
							p.getPartie().setUtiliserOuPoser(2);
						}
					}
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				
				ok4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){
							if(p.getPartie().getUtiliserOuPoser() == 1){
								System.out.println("到达了使用croyant方法的地方");
								j.utiliserCroyant((Croyant)j.getCarteEnMain().get(4), p);
								j.getCarteEnMain().remove(4);
								p.notifyO();
							}else if(p.getPartie().getUtiliserOuPoser() == 2){
								if(((Croyant)j.getCarteEnMain().get(4)).getOrigine().equals("Jour")){
				    				if(j.getPointActionJour() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(4));
						    			j.getCarteEnMain().remove(4);
						    			j.setPointActionJour(j.getPointActionJour() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(4)).getOrigine().equals("Nuit")){
				    				if(j.getPointActionNuit() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(4));
						    			j.getCarteEnMain().remove(4);
						    			j.setPointActionNuit(j.getPointActionNuit() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(4)).getOrigine().equals("Néant")){
				    				if(j.getPointActionNéant() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(4));
						    			j.getCarteEnMain().remove(4);
						    			j.setPointActionNéant(j.getPointActionNéant() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}
							}else{
								JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
							}
						}
					}
				});
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise4.add(sacrificeGuide);
				utilise4.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeGuide) {
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserGuide) {
							p.getPartie().setUtiliserOuPoser(2);
						}
					}
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
				ok4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){
							if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(4), p);
			            		j.getCarteEnMain().remove(4);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(4));
			            		j.getCarteEnMain().remove(4);
			            		p.notifyO();
			            	}
						}
					}
				});
				break;
			case "Deus":
				ok4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(4), p);
						j.getCarteEnMain().remove(4);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(4), p);
						j.getCarteEnMain().remove(4);
			            p.notifyO();
					}
				});
				break;
			}
			}
		}
		this.add(utilise4);
		
////////////////////////////5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555///////////////////////////
		numMain = 5;
		
		Panel_carte cc5 = (Panel_carte)carteList.get(numMain);
		this.add(cc5);
		JPanel utilise5 = new JPanel();
		utilise5.setLayout(new GridLayout(3,1));
		JButton ok5 = new JButton("OK");
		
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			  if(length >= 6){
				utilise5.add(ok5);
			  }
	    }
		
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
			ok5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(p.isPeuxChoisirAction()){
						j.defausserCarteP(5);
						p.notifyO();
					}else{
						JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
					}
				}
			});
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){  //utiliser
			p.getPartie().setUtiliserOuPoser(0);
			if(length >= 6){
			switch((String)typeList.get(5)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  //查错要求改成final 不知道会不会有问题
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise5.add(sacrificeCroyant);
				utilise5.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeCroyant) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserCroyant) {
							p.getPartie().setUtiliserOuPoser(2);
						}
					} 
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				
				ok5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){  //选完出牌方式后可以点击
							if(p.getPartie().getUtiliserOuPoser() == 1){
								j.utiliserCroyant((Croyant)j.getCarteEnMain().get(5), p);
								j.getCarteEnMain().remove(5);
								p.notifyO();
							}else if(p.getPartie().getUtiliserOuPoser() == 2){
								if(((Croyant)j.getCarteEnMain().get(5)).getOrigine().equals("Jour")){
				    				if(j.getPointActionJour() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(5));
						    			j.getCarteEnMain().remove(5);
						    			j.setPointActionJour(j.getPointActionJour() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(5)).getOrigine().equals("Nuit")){
				    				if(j.getPointActionNuit() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(5));
						    			j.getCarteEnMain().remove(5);
						    			j.setPointActionNuit(j.getPointActionNuit() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(5)).getOrigine().equals("Néant")){
				    				if(j.getPointActionNéant() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(5));
						    			j.getCarteEnMain().remove(5);
						    			j.setPointActionNéant(j.getPointActionNéant() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}
							}else{
								JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
							}
						}
					}
				});
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise5.add(sacrificeGuide);
				utilise5.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) { 
						JRadioButton radio = (JRadioButton) ae.getSource();
						if (radio == sacrificeGuide) {
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserGuide) {
							p.getPartie().setUtiliserOuPoser(1);
						}
					}
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
				
				ok5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(p.getPartie().getUtiliserOuPoser() != 0){
							if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(5), p);
			            		j.getCarteEnMain().remove(5);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(5));
			            		j.getCarteEnMain().remove(5);
			            		p.notifyO();
			            	}
						}
					}
				});
				break;
			case "Deus":
				ok5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(5), p);
						j.getCarteEnMain().remove(5);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(5), p);
						j.getCarteEnMain().remove(5);
			            p.notifyO();
					}
				});
				break;
			}
		}
		}
		this.add(utilise5);
							
/////////////////////////////////66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666/////////////////////////////
		numMain = 6;
		Panel_carte cc6 = (Panel_carte)carteList.get(numMain);
		this.add(cc6);
								
		JPanel utilise6 = new JPanel();
		utilise6.setLayout(new GridLayout(3,1));
		JButton ok6 = new JButton("OK");
		utilise6.setVisible(true);
		if(((JoueurPhysique)j).getNumeroAction() != 1){
			  if(length >= 7){
				utilise6.add(ok6);
			  }
		}
		
		if(((JoueurPhysique)j).getNumeroAction() == 0){  //defausser
			ok6.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {  
					if(p.isPeuxChoisirAction()){
						j.defausserCarteP(6);
						p.notifyO();
					}else{
						JOptionPane.showMessageDialog(null, "Vous devez choisir un type de action avant choisir une carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
					}
				}  
			});
		}else if(((JoueurPhysique)j).getNumeroAction() == 2){
			p.getPartie().setUtiliserOuPoser(0);//utiliser
			 if(length >= 7){
			switch((String)typeList.get(6)){
			case "Croyant":
				final JRadioButton sacrificeCroyant = new JRadioButton("Sacri");  //查错要求改成final 不知道会不会有问题
				final JRadioButton poserCroyant = new JRadioButton("Poser");
				utilise6.add(sacrificeCroyant);
				utilise6.add(poserCroyant);
				ButtonGroup group1 = new ButtonGroup();
				group1.add(sacrificeCroyant);
				group1.add(poserCroyant);
				ActionListener a1=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {  
						JRadioButton radio = (JRadioButton) ae.getSource();  
						if (radio == sacrificeCroyant) {  //选择utiliserCarte之后选择牺牲croyant
							p.getPartie().setUtiliserOuPoser(1);
						} else if (radio == poserCroyant) {  
							p.getPartie().setUtiliserOuPoser(2);
						} 
					}  
				};
				sacrificeCroyant.addActionListener(a1);
				poserCroyant.addActionListener(a1);
				
				ok6.addActionListener(new ActionListener() {  
					public void actionPerformed(ActionEvent e) {  
						if(p.getPartie().getUtiliserOuPoser() != 0){
							if(p.getPartie().getUtiliserOuPoser() == 1){
								j.utiliserCroyant((Croyant)j.getCarteEnMain().get(6), p);
								j.getCarteEnMain().remove(6);
								p.notifyO();
							}else if(p.getPartie().getUtiliserOuPoser() == 2){
								if(((Croyant)j.getCarteEnMain().get(6)).getOrigine().equals("Jour")){
				    				if(j.getPointActionJour() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(6));
						    			j.getCarteEnMain().remove(6);
						    			j.setPointActionJour(j.getPointActionJour() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(6)).getOrigine().equals("Nuit")){
				    				if(j.getPointActionNuit() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(6));
						    			j.getCarteEnMain().remove(6);
						    			j.setPointActionNuit(j.getPointActionNuit() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}else if(((Croyant)j.getCarteEnMain().get(6)).getOrigine().equals("Néant")){
				    				if(j.getPointActionNéant() !=0 ){
				    					j.poserCroyant((Croyant)j.getCarteEnMain().get(6));
						    			j.getCarteEnMain().remove(6);
						    			j.setPointActionNéant(j.getPointActionNéant() - 1);
						            	p.notifyO();
				    				}else{
				    					JOptionPane.showMessageDialog(null, "Vous n'avez pas de point d'Action de même type!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
				    				}
				    			}
							}else{
								JOptionPane.showMessageDialog(null, "Vous devez choisir comment utiliser cette carte", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
							}
						}
					}  
				});
				break;
			case "Guide":
				final JRadioButton sacrificeGuide = new JRadioButton("Sacri");
				final JRadioButton poserGuide = new JRadioButton("Poser");
				utilise6.add(sacrificeGuide);
				utilise6.add(poserGuide);
				ButtonGroup group2 = new ButtonGroup();
				group2.add(sacrificeGuide);
				group2.add(poserGuide);
				ActionListener a2=new ActionListener(){
					public void actionPerformed(ActionEvent ae) {  
						JRadioButton radio = (JRadioButton) ae.getSource();  
						if (radio == sacrificeGuide) {
							p.getPartie().setUtiliserOuPoser(1);
						}else if (radio == poserGuide) {  
							p.getPartie().setUtiliserOuPoser(2);
						} 
					}  
				};
				sacrificeGuide.addActionListener(a2);
				poserGuide.addActionListener(a2);
					
				ok6.addActionListener(new ActionListener() {  
					public void actionPerformed(ActionEvent e) {  
						if(p.getPartie().getUtiliserOuPoser() != 0){
							if(p.getPartie().getUtiliserOuPoser() == 1){
			            		j.utiliserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(6), p);
			            		j.getCarteEnMain().remove(6);
			            		p.notifyO();
			            	}else if(p.getPartie().getUtiliserOuPoser() == 2){
			            		j.poserGuideSpirituel((GuideSpirituel)j.getCarteEnMain().get(6));
			            		j.getCarteEnMain().remove(6);
			            		p.notifyO();
			            	}
						}
					}  
				});
				break;	
			case "Deus":
				ok6.addActionListener(new ActionListener() {  
					public void actionPerformed(ActionEvent e) {  
						j.utiliserDeusEx((DeusEx)j.getCarteEnMain().get(6), p);
						j.getCarteEnMain().remove(6);
						p.notifyO();
					}
				});
				break;
			case "Apocalypse":
				ok6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						j.utiliserApocalypse((Apocalypse)j.getCarteEnMain().get(6), p);
						j.getCarteEnMain().remove(6);
			            p.notifyO();
					}
				});
				break;
			}
			 }
		}
		this.add(utilise6);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JButton end = new JButton("end");
		this.add(end);
		
		end.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
            	  if(endClick){
            	         p.setPeutCommencerNouvelTour(false);
            	         p.setJoueurPhysiqueEnTour(false);
            	         p.setPeuxChoisirAction(false);
            	         endClick=false;
            	         ArrayList js=(ArrayList)p.getJoueurs();
            	         java.util.Iterator itJ=js.iterator();
            	         while(itJ.hasNext()){
        			         Joueur j1=(Joueur) itJ.next();
        			         if(j1.getNumeroJoueur()!=1){
        			         TourDuChaqueJoueur tourDuChaqueJoueur=new TourDuChaqueJoueur(j1);
        			         tourDuChaqueJoueur.choisirAction(p);
        			  // f.partie.getPartie().setJoueurEnJeu(j1);
        			         p.notifyO();
        			        }
        		          }
            	
            	         p.setPeutCommencerNouvelTour(true);
            	         p.getPartie().setActionChoisi(-1);
            	  }else{
                	  JOptionPane.showMessageDialog(null, "Vous pouvez click 'end' pour une fois dans ce tour!", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
                  }
            }  
        });
		this.revalidate();		 
	}



	public int getCarteDefausse() {
		return carteDefausse;
	}



	public void setCarteDefausse(int carteDefausse) {
		carteDefausse = carteDefausse;
	}






	public int getVerifier() {
		return verifier;
	}



	public void setVerifier(int verifier) {
		this.verifier = verifier;
	}



	public boolean isEndTour() {
		return endTour;
	}



	public void setEndTour(boolean endTour) {
		this.endTour = endTour;
	}



	public int getCarteUtilise() {
		return carteUtilise;
	}



	public void setCarteUtilise(int carteUtilise) {
		this.carteUtilise = carteUtilise;
	}



	public boolean isEndClick() {
		return endClick;
	}



	public void setEndClick(boolean endClick) {
		this.endClick = endClick;
	}
	
	
	
}
