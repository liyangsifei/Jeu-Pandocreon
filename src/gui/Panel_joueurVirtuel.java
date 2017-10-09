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
	//������5��������ң���ͷ����Ϸ��ʼʱ����������������������
	private ArrayList joueursV;
	//�����partie���渴�ƹ�����joueurs��list�����ǰ�������ʵ���
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
    //�Ȳ��ùܵڶ�������arg
	
}
