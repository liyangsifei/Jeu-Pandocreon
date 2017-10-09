package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import control.Partie;

import java.awt.*;

public class Pandocreon_Frame extends JFrame{
	
	public Partie partie=new Partie();
	//private  JLabel label = new JLabel("Frame");
	private Panel_joueurPhysique joueurPhysiqueView;
	private Panel_joueurVirtuel joueurVirtuelView;
	private Panel_information infoView;
	private Panel_centreTable centreTableView=new Panel_centreTable();
	private Panel_cartePile cartePileView=new Panel_cartePile();

	
	private Dimension dimVirtuel = new Dimension(1000,220);
	private Dimension dimInfo = new Dimension(250,200);
	private Dimension dimCentreTable = new Dimension(1000,180);
	private Dimension dimCartePile = new Dimension(200,150);
	private Dimension dimPhysique = new Dimension(1000,300);


	private int Nombre;
	private int mode;
	
	
	//private boolean peutChoisirAction;
	public Pandocreon_Frame(int nombreJV, int mode) {  
		
		
		//this.peutChoisirAction=false;
		this.joueurPhysiqueView=new Panel_joueurPhysique(this);
		this.Nombre=nombreJV;
		this.mode=mode;
		this.partie.getPartie().setNombre(nombreJV);
		this.partie.getPartie().setModeChoisi(mode);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);  
		this.joueurVirtuelView=new Panel_joueurVirtuel(nombreJV,this);
		this.infoView=new Panel_information(this);
		//Dimension dimVirtuel = new Dimension(1600,100);
		//joueurPhysiqueView.setPreferredSize(d);
		partie.getPartie().addObserver(joueurPhysiqueView.getCarteMainView());
		partie.getPartie().addObserver(joueurPhysiqueView.getJoueurPhysiqueView().getEspacePersonnelView());
		partie.getPartie().addObserver(joueurPhysiqueView.getJoueurPhysiqueView().getDiviniteView());
		partie.getPartie().addObserver(infoView);
		partie.getPartie().addObserver(centreTableView);
		partie.getPartie().jouerDebut(this);  //kaishi
		partie.getPartie().notifyO();
		
        /* 使用匿名类添加一个窗口监听器 */ 
        addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.out.println("Exit when Closed event");  
                //退出应用程序  
                System.exit(0);  
            }   
        });  
        
        this.setLayout(new BorderLayout()); 
        joueurVirtuelView.setPreferredSize(dimVirtuel);
        joueurPhysiqueView.setPreferredSize(dimPhysique);
        centreTableView.setPreferredSize(dimCentreTable);
        cartePileView.setPreferredSize(dimCartePile);
        infoView.setPreferredSize(dimInfo);
        this.add("North", joueurVirtuelView); 
        this.add("South", joueurPhysiqueView);
        this.add("Center",centreTableView);
        this.add("East", cartePileView);
        this.add("West", infoView);

        
        // 设置窗口为固定大小  
        setResizable(false);  
        setSize(1300, 800);  
        setTitle("Pandocreon");  
        this.setVisible(true);
      
       
        
    }  
	
 public void refresh(Partie partie){
      	    this.removeAll();
      	    this.validate();
  		    this.partie.setNombre(Nombre);
  		    this.partie.setModeChoisi(mode);
  		
  		
          /* 使用匿名类添加一个窗口监听器 */ 
          addWindowListener(new WindowAdapter() {  
              public void windowClosing(WindowEvent e) {  
                  System.out.println("Exit when Closed event");  
                  //退出应用程序  
                  System.exit(0);  
              }   
          });  
          
          this.setLayout(new BorderLayout()); 
          joueurVirtuelView.setPreferredSize(dimVirtuel);
          joueurPhysiqueView.setPreferredSize(dimPhysique);
          centreTableView.setPreferredSize(dimCentreTable);
          cartePileView.setPreferredSize(dimCartePile);
          infoView.setPreferredSize(dimInfo);
          this.add("North", joueurVirtuelView); 
          this.add("South", joueurPhysiqueView);
          this.add("Center",centreTableView);
          this.add("East", cartePileView);
          this.add("West", infoView);

          
          // 设置窗口为固定大小  
          setResizable(false);  
          setSize(1000, 800);  
          setTitle("Pandocreon");  
          this.setVisible(true);
            this.validate();
            
           
    }
 
 
 public void closeMain(){
	 this.setVisible(false);
 }

	public Panel_joueurPhysique getJoueurPhysiqueView() {
		return joueurPhysiqueView;
	}

	public void setJoueurPhysiqueView(Panel_joueurPhysique joueurPhysiqueView) {
		this.joueurPhysiqueView = joueurPhysiqueView;
	}

	public Panel_joueurVirtuel getJoueurVirtuelView() {
		return joueurVirtuelView;
	}

	public void setJoueurVirtuelView(Panel_joueurVirtuel joueurVirtuelView) {
		this.joueurVirtuelView = joueurVirtuelView;
	}

	public int getNombre() {
		return Nombre;
	}

	public void setNombre(int nombre) {
		Nombre = nombre;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public Panel_information getInfoView() {
		return infoView;
	}

	public void setInfoView(Panel_information infoView) {
		this.infoView = infoView;
	}

	
   
	
	
	
    
    
}
