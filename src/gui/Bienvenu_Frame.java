package gui;
import control.Joueur;
import java.awt.font.*;
import control.Partie;
import outils.getImages;

import javax.swing.*;

import carteAction.CarteAction;

import java.awt.*;
import java.awt.event.*;

public class Bienvenu_Frame extends JFrame{
	
	public Pandocreon_Frame frame_main;
	
    JPanel buttons_valide=new JPanel();
    JButton button1 = new JButton("Jouer");
    JButton button2 = new JButton("Exit");
    JButton button3 = new JButton("Règle");
    
    JPanel buttons_nombreJoueur=new JPanel();
    ButtonGroup group2 = new ButtonGroup();
    JRadioButton radio1 = new JRadioButton("1 joueur virtuel");
    JRadioButton radio2 = new JRadioButton("2 joueur virtuels");
    JRadioButton radio3 = new JRadioButton("3 joueur virtuels");
    JRadioButton radio4 = new JRadioButton("4 joueur virtuels");
    JRadioButton radio5 = new JRadioButton("5 joueur virtuels");
    JRadioButton radio6 = new JRadioButton("6 joueur virtuels");
    JRadioButton radio7 = new JRadioButton("7 joueur virtuels");
    JRadioButton radio8 = new JRadioButton("8 joueur virtuels");
    JRadioButton radio9 = new JRadioButton("9 joueur virtuels");
    JRadioButton radio10 = new JRadioButton("10 joueur virtuels");
    public int nombreJV=0;
    
    JPanel buttons_mode=new JPanel();
    ButtonGroup group1 = new ButtonGroup();
    JRadioButton radio11 = new JRadioButton("Mode faicle");
    JRadioButton radio12 = new JRadioButton("Mode difficile");
    public int mode=0;
    
    JLabel label1 = new JLabel("                                      Bienvenu sur Pandocreon!");
    JLabel label2 = new JLabel("Tout les cartes dans le pile sont crees et touilles! Tout les divinites dans le pile sont crees et touilles!");
    JLabel label3 = new JLabel("Combien de joueurs virtuels vous voulez jouer avec?");
    JLabel label4 = new JLabel("Saisir le mode du jeu! ");
    JLabel label5 = new JLabel("Mode faicle: Le joueur justement choisir un des deux actions, defausser les cartes ou piocher les cartes!");
    JLabel label6 = new JLabel("Mode difficile: Le joueur peut defausser les cartes, piocher les cartes, et utiliser les cartes!");
    public Bienvenu_Frame(){
    	this.buttons_nombreJoueur.setLayout(new GridLayout(1, 10));
    	this.group2.add(radio1);
    	this.group2.add(radio2);
    	this.group2.add(radio3);
    	this.group2.add(radio4);
    	this.group2.add(radio5);
    	this.group2.add(radio6);
    	this.group2.add(radio7);
    	this.group2.add(radio8);
    	this.group2.add(radio9);
    	this.group2.add(radio10);
    	this.buttons_nombreJoueur.add(radio1);
    	this.buttons_nombreJoueur.add(radio2);
    	this.buttons_nombreJoueur.add(radio3);
    	this.buttons_nombreJoueur.add(radio4);
    	this.buttons_nombreJoueur.add(radio5);
    	this.buttons_nombreJoueur.add(radio6);
    	this.buttons_nombreJoueur.add(radio7);
    	this.buttons_nombreJoueur.add(radio8);
    	this.buttons_nombreJoueur.add(radio9);
    	this.buttons_nombreJoueur.add(radio10);
    	ActionListener al1=new ActionListener(){
    		public void actionPerformed(ActionEvent ae) {  
                JRadioButton radio = (JRadioButton) ae.getSource();  
                if (radio == radio1) {  
                    nombreJV=1;
                } else if (radio == radio2) {  
                    nombreJV=2;
                } else if (radio == radio3) {  
                    nombreJV=3;
                } else if (radio == radio4) {  
                    nombreJV=4;
                } else if (radio == radio5) {  
                    nombreJV=5;
                } else if (radio == radio6) {  
                    nombreJV=6;
                } else if (radio == radio7) {  
                    nombreJV=7;
                } else if (radio == radio8) {  
                    nombreJV=8;
                } else if (radio == radio9) {  
                    nombreJV=9;
                } else if (radio == radio10) {  
                    nombreJV=10;
                } 
            }  
    	};
    	
        // 为各单选按钮添加动作监听器  
        radio1.addActionListener(al1);  
        radio2.addActionListener(al1);  
        radio3.addActionListener(al1);  
        radio4.addActionListener(al1);  
        radio5.addActionListener(al1);  
        radio6.addActionListener(al1);  
        radio7.addActionListener(al1);  
        radio8.addActionListener(al1);  
        radio9.addActionListener(al1);  
        radio10.addActionListener(al1);  
       
    	
    	this.buttons_mode.setLayout(new GridLayout(1,2));
    	this.group1.add(radio11);
    	this.group1.add(radio12);
    	this.buttons_mode.add(radio11);
    	this.buttons_mode.add(radio12);
    	ActionListener al2=new ActionListener(){
    		public void actionPerformed(ActionEvent ae) {  
                JRadioButton radio = (JRadioButton) ae.getSource();  
                if (radio == radio11) {  
                    mode=1;
                } else if (radio == radio12) {  
                    mode=2;
                } 
            }  
    	};
    	radio11.addActionListener(al2);
    	radio12.addActionListener(al2);
    	
    	this.buttons_valide.setLayout(new FlowLayout());
    	this.buttons_valide.add(button1);
    	this.buttons_valide.add(button2);
    	this.buttons_valide.add(button3);
    	
        this.setLayout(new GridLayout(9, 1));
    	this.add(label1);
    	this.add(label2);
    	this.add(label3);
    	label1.setFont(new java.awt.Font("Courier",1,40));
    	label2.setFont(new java.awt.Font("Dialog",1,26));
    	label3.setFont(new java.awt.Font("Dialog",1,20));
    	this.add(buttons_nombreJoueur);
    	buttons_nombreJoueur.setFont(new java.awt.Font("Dialog",1,20));
    	this.add(label4);
    	this.add(label5);
    	this.add(label6);
    	label4.setFont(new java.awt.Font("Dialog",1,20));
    	label5.setFont(new java.awt.Font("Dialog",1,15));
    	label6.setFont(new java.awt.Font("Dialog",1,15));
    	this.add(buttons_mode);
    	
    	this.add(buttons_valide);

    	
    	setResizable(false);  
        setSize(1400, 1000);  
        setTitle("Pandocreon");  
        
        addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                //退出应用程序  
                System.exit(0);  
            }   
        });  
        
        //jouer按钮，通过这个按钮实现点击时关闭欢迎窗口，打开游戏窗口
        this.button1.addActionListener(new ActionListener() {  

			public void actionPerformed(ActionEvent e) {  
            	if(nombreJV!=0 && mode!=0 )  {
            		 setVisible(false);
            		
            			   Pandocreon_Frame frame_main=new Pandocreon_Frame(nombreJV,mode);
            		       frame_main.show();
            		    
            		      //  frame_main.partie.jouer();
            			
            		 //Partie partie=new Partie();
            		// partie.setNombre(nombreJV);
            	   //  partie.setModeChoisi(mode);
            	    // partie.jouerDebut();
            		//this.frame_main=new Pandocreon_Frame(nombreJV,mode);
                   //  partie.jouerDebut();
                  //   frame_main.show();
                     //frame_main.removeAll();
                   //  partie.notifyO();
                    //frame_main.refresh(partie);
                     //frame_main.show();
                     //
                   // frame_main.partie.jouer();
                    // frame_main.refresh(partie);
                    // frame_main.jouer();
                }else{
                	JOptionPane.showMessageDialog(null, "Vous devez choisir le nombre du joueurs virtuels vous voulez jouer avec et le mode du jeu ", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
                }
            	
              
            }  
        });
        
       //exit按钮，通过这个按钮实现点击时退出游戏
        this.button2.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent ae) {  
            	System.exit(0); 
            }  
        });
        
        //regle按钮,点击进入游戏规则界面
        this.button3.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	setVisible(false);
                Regle_Frame frame_regle=new Regle_Frame();
                frame_regle.show();
            }  
        });
        
    }
    
    
      
}
