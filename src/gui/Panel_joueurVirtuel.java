package gui;
import java.awt.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import control.Joueur;
import control.Partie;

public class Panel_joueurVirtuel<E> extends JPanel {
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5756225445861926782L;
	//JLabel label = new JLabel("joueurVirtuel");
	//假设有5个虚拟玩家，回头把游戏开始时的输入玩家数与此连接起来
	private ArrayList joueursV;
	//储存从partie里面复制过来的joueurs的list，但是包含了真实玩家
	private ArrayList joueurs;
	 
	 public Panel_joueurVirtuel(int nombreJV,Pandocreon_Frame f){
		 this.setBackground(Color.darkGray);
		 this.joueursV=new ArrayList();
		 this.joueurs=new ArrayList();
		 for(int i=2;i<=nombreJV+1;i++){
			 Panel_sousJoueurVirtuel JoueurVirtuelView=new Panel_sousJoueurVirtuel(i,f);
			 JoueurVirtuelView.setlChangeable(1600 / nombreJV);
			 joueursV.add(JoueurVirtuelView);
			
		 }
		 this.setLayout(new GridLayout(1,nombreJV));
		 
		 Iterator<E> it=joueursV.iterator();
		 while(it.hasNext()){
			 this.add((Component) it.next());
		 }
	 }
    //先不用管第二个参数arg
	
}
