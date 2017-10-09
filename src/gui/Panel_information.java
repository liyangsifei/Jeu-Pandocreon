package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.*;

import control.Joueur;
import control.Partie;
import control.Tour;

public class Panel_information extends JPanel implements Observer{
	 JLabel label = new JLabel("information");
	 JButton button=new JButton("Lancer D®¶");
     public JLabel labelDe=new JLabel("Resultat du de");
	 JTextArea info = new JTextArea();
	 String textTitle="Le point d'actions:";
	 JLabel title=new JLabel(textTitle);
	
	 
	 public Panel_information(final Pandocreon_Frame f){
		 
		 this.setBackground(Color.lightGray);
		 this.add(label);
		 this.setBorder(BorderFactory.createTitledBorder("info"));
		// this.setBorder(BorderFactory.createLineBorder(Color.green));
		 this.add(button);
		 this.add(labelDe);
		 this.add(title);
		 
	     this.button.addActionListener(new ActionListener() {  
              public void actionPerformed(ActionEvent e) {  
        	       if(Partie.getPartie().isEtatDuJeu() )  {
        	    	  
            	    	   if(f.partie.getPartie().isPeutCommencerNouvelTour()){
            	    		  f.partie.getPartie().setPeuxGagnePointAction(true); 
            	    		  Tour tour=new Tour((ArrayList<Joueur>)f.partie.getPartie().getJoueurs());
            	    		  System.out.println("Nouvel tour! Joueur1 lance du de!");
            	    		  Random r=new Random();
            	    		  int resultat = r.nextInt(3);
            	    		  int resultatDe=(int)Math.floor(resultat);
            	    		  //distribuer point d'action
            	    		  tour.distribuerPointAction(resultatDe);
            	    		  
            	    		  if(resultatDe==0){
            	    				labelDe.setText("Face Jour!");
            	    		  }else if(resultat==1){
            	    			    labelDe.setText("Face Nuit!");
            	    		  }else if(resultat==2){
            	    			    labelDe.setText("Face N®¶ant!");
            	    		  }
            	    		  
            	    		  f.partie.getPartie().setPeutCommencerNouvelTour(false);
            	    		  f.partie.getPartie().setJoueurPhysiqueEnTour(true);
            	    		  f.partie.getPartie().notifyO();
            	    	   }else{
                           	JOptionPane.showMessageDialog(null, " Tour dernier n'est pas fini! Vous ne pouvez pas commencer un nouvel tour! ", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
                           }
                        
                   }else{
                    	JOptionPane.showMessageDialog(null, " Vous pouvez pas commencer un nouvel tour! ", "Pandocreon",JOptionPane.WARNING_MESSAGE); 
                   }
       	  }  
          });
	 }
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		/////////////////////’‚”–µ„π÷
		     this.removeAll();
		     this.revalidate();
		     Partie p=(Partie)o;
		
			 if(p.getPartie().etatDuJeu == false){
				 EndGame_Frame endOfGame_Frame = new EndGame_Frame();
			 }
		
			 this.add(label);
			 this.add(button);
			 this.add(labelDe);
			 this.add(title);
		    
			List js=(List)p.getJoueurs();
		    Iterator it =js.iterator();
			while(it.hasNext()){
				Joueur jj=(Joueur)it.next();
				String text="J:Nu:Ne " + " joueur" +jj.getNumeroJoueur() + " " + jj.getPointActionJour() + ":"+jj.getPointActionNuit()+ ":"+ jj.getPointActionN®¶ant();
			    JLabel point=new JLabel(text);
			    this.add(point);
			}
			
			this.revalidate();
	}
	
	
}
