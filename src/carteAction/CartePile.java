package carteAction;
import java.awt.Image;
import java.util.List;

import divinite.Divinite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import outils.getImages;

import control.Partie;
import carteCroyant.Alchimistes1;
import carteCroyant.Alchimistes2;
import carteCroyant.Alchimistes3;
import carteCroyant.Ali¨¦n¨¦s1;
import carteCroyant.Ali¨¦n¨¦s2;
import carteCroyant.Ali¨¦n¨¦s3;
import carteCroyant.Diplomates;
import carteCroyant.D¨¦mons;
import carteCroyant.Ermite;
import carteCroyant.Esprits;
import carteCroyant.GuerriersSaints;
import carteCroyant.Illusionnistes;
import carteCroyant.Int¨¦gristes;
import carteCroyant.Lycanthropes;
import carteCroyant.Moines;
import carteCroyant.Nibillistes;
import carteCroyant.Pillards;
import carteCroyant.Revenant;
import carteCroyant.R¨¦volutionnaires;
import carteCroyant.Travailleurs1;
import carteCroyant.Travailleurs2;
import carteCroyant.Travailleurs3;
import carteCroyant.Vampire;
import carteDeusEx.Bouleversement;
import carteDeusEx.Col¨¨reDivineJour;
import carteDeusEx.Col¨¨reDivineNuit;
import carteDeusEx.Concentration;
import carteDeusEx.Diversion;
import carteDeusEx.Fourberie;
import carteDeusEx.InfluenceJour;
import carteDeusEx.InfluenceNuit;
import carteDeusEx.InfluenceNulle;
import carteDeusEx.InfluenceN¨¦ant;
import carteDeusEx.Inquisition;
import carteDeusEx.Miroir;
import carteDeusEx.OrdreC¨¦leste;
import carteDeusEx.Phoenix;
import carteDeusEx.Stase;
import carteDeusEx.Transe;
import carteDeusEx.TrouNoir;
import carteGuide.Anarchiste;
import carteGuide.Asc¨¨te;
import carteGuide.Clerc;
import carteGuide.Devin;
import carteGuide.Exorciste;
import carteGuide.Martyr;
import carteGuide.Messie;
import carteGuide.Paladin;
import carteGuide.Shaman;
import carteGuide.Sorcier;
import carteGuide.Tyran;

public class CartePile {
	
	public List cartes;
	private static CartePile cartePile = new CartePile();
	
	  //constructeur
	public CartePile(){
		this.cartes=new ArrayList();
		creerLesCartesCroyants();
		creerLesCartesGuideSpirituel();
		creerLesCartesDeusEx();
		creerLesCartesApocalypse();
	}
	
	  //creer tout les cartes croyants
	public void creerLesCartesCroyants(){
		  //creer les cartes croyants qui s'appelle "Moine"
		Moines moines1=new Moines();
		cartes.add(moines1);
		moines1.setDogme("MystiqueHumainChaos");
		//Image image1 = null;
		//image1 = getImages.getPng("image/Moine2");
		moines1.setNom("Moine2");
		
		Moines moines2=new Moines();
		cartes.add(moines2);
		moines2.setDogme("SymbolesMystiqueChaos");
		//Image image2 = null;
		//image2 = getImages.getPng("image/Moine3");
		moines2.setNom("Moine3");
		
		Moines moines3=new Moines();
		cartes.add(moines3);
		moines3.setDogme("MystiqueNatureSymboles");
		//Image image3 = null;
		//image3 = getImages.getPng("image/Moine4");
		moines3.setNom("Moine4");
		
		Moines moines4=new Moines();
		cartes.add(moines4);
		moines4.setDogme("MystiqueNatureChaos");
		//Image image4 = null;
		//image4 = getImages.getPng("image/Moine5");
		moines4.setNom("Moine5");
		
		Moines moines5=new Moines();
		cartes.add(moines5);
		moines5.setDogme("HumainNatureMystique");
		//Image image5 = null;
		//image5 = getImages.getPng("image/Moine1");
		moines5.setNom("Moine1");
		
		
		  //creer les cartes croyants qui s'appelle "D¨¦mon"  
		D¨¦mons d¨¦mons1=new D¨¦mons();
		cartes.add(d¨¦mons1);
		d¨¦mons1.setDogme("MystiqueHumainChaos");
		//Image image6 = null;
		//image6 = getImages.getPng("image/Demons2");
		d¨¦mons1.setNom("Demons2");
		
		D¨¦mons d¨¦mons2=new D¨¦mons();
		cartes.add(d¨¦mons2);
		d¨¦mons2.setDogme("SymbolesMystiqueChaos");
		//Image image7 = null;
		//image7 = getImages.getPng("image/Demons3");
		d¨¦mons2.setNom("Demons3");
		
	   D¨¦mons d¨¦mons3=new D¨¦mons();
	   cartes.add(d¨¦mons3);
	   d¨¦mons3.setDogme("MystiqueNatureSymboles");
	  // Image image8 = null;
		//image8 = getImages.getPng("image/Demons4");
		d¨¦mons3.setNom("Demons4");
		
	   D¨¦mons d¨¦mons4=new D¨¦mons();
	   cartes.add(d¨¦mons4);
	   d¨¦mons4.setDogme("HumainNatureMystique");
	  //	image9 = getImages.getPng("image/Demons1");
		d¨¦mons4.setNom("Demons1");
		
	   D¨¦mons d¨¦mons5=new D¨¦mons();
	   cartes.add(d¨¦mons5);
	   d¨¦mons5.setDogme("MystiqueNatureChaos");
	 //  Image image10 = null;
	 //  image10 = getImages.getPng("image/Demons5");
	   d¨¦mons5.setNom("Demons5");
	   
	   //creer les cartes croyants qui s'appelle "Esprits"
	   Esprits esprits1=new Esprits();
	   cartes.add(esprits1);
	   esprits1.setDogme("SymbolesMystiqueChaos");
	//   Image image11 = null;
	//   image11 = getImages.getPng("image/Esprits3");
	   esprits1.setNom("Esprits3");
		
	   Esprits esprits2=new Esprits();
	   cartes.add(esprits2);
	   esprits2.setDogme("MystiqueNatureChaos");
	//   Image image12 = null;
	//   image12 = getImages.getPng("image/Esprits5");
	   esprits2.setNom("Esprits5");
	   
	   Esprits esprits3=new Esprits();
	   cartes.add(esprits3);
	   esprits3.setDogme("MystiqueNatureSymboles");
	 //  Image image13 = null;
	 //  image13 = getImages.getPng("image/Esprits4");
	   esprits3.setNom("Esprits4");
	   
	   Esprits esprits4=new Esprits();
	   cartes.add(esprits4);
	   esprits4.setDogme("MystiquesHumainChaos");
	//   Image image14 = null;
	//   image14 = getImages.getPng("image/Esprits2");
	   esprits4.setNom("Esprits2");
	   
	   Esprits esprits5=new Esprits();
	   cartes.add(esprits5);
	   esprits5.setDogme("HumainNatureMystique");
	//  Image image15 = null;
	 //  image15 = getImages.getPng("image/Esprits1");
	   esprits5.setNom("Esprits1");
	   
	   
	   //creer les cartes croyants qui s'appelle "Travailleurs"
	   Travailleurs1 travailleurs1=new Travailleurs1();
	   cartes.add(travailleurs1);
	   travailleurs1.setDogme("HumainSysbolesChaos");
	
	   travailleurs1.setNom("Travailleurs1");
	   Travailleurs2 travailleurs2=new Travailleurs2();
	   cartes.add(travailleurs2);
	   travailleurs2.setDogme("HumainNatureSysboles");
	
	   travailleurs2.setNom("Travailleurs2");
	   Travailleurs3 travailleurs3=new Travailleurs3();
	   cartes.add(travailleurs3);
	   travailleurs3.setDogme("HumainMystiqueChaos");
	
	   travailleurs3.setNom("Travailleurs3");
	   //creer les cartes croyants qui s'appelle "Ali¨¦n¨¦"
	   Ali¨¦n¨¦s1 ali¨¦n¨¦s1=new Ali¨¦n¨¦s1();
	   cartes.add(ali¨¦n¨¦s1);
	   ali¨¦n¨¦s1.setDogme("HumainSysbolesChaos");
	//   ali¨¦n¨¦s1.setImage(getImages.getPng("image/Ali¨¦n¨¦s1"));
	   ali¨¦n¨¦s1.setNom("Ali¨¦n¨¦s1");
	   Ali¨¦n¨¦s2 ali¨¦n¨¦s2=new Ali¨¦n¨¦s2();
	   cartes.add(ali¨¦n¨¦s2);
	   ali¨¦n¨¦s2.setDogme("HumainNatureSysboles");
	   ali¨¦n¨¦s2.setNom("Ali¨¦n¨¦s2");
	 //  ali¨¦n¨¦s2.setImage(getImages.getPng("image/Ali¨¦n¨¦s2"));
	   Ali¨¦n¨¦s3 ali¨¦n¨¦s3=new Ali¨¦n¨¦s3();
	   cartes.add(ali¨¦n¨¦s3);
	   ali¨¦n¨¦s3.setDogme("HumainMystiqueChaos");
	   ali¨¦n¨¦s3.setNom("Ali¨¦n¨¦s3");
	 //  ali¨¦n¨¦s3.setImage(getImages.getPng("image/Ali¨¦n¨¦s3"));
		 
	   //creer les cartes croyants qui s'appelle "Alchimistes"
	   Alchimistes1 alchimistes1=new Alchimistes1();
	   cartes.add(alchimistes1);
	   alchimistes1.setDogme("NatureChaosSysboles");
	   alchimistes1.setNom("Alchimistes1");
	 //  alchimistes1.setImage(getImages.getPng("image/Alchimistes1"));
	   Alchimistes2 alchimistes2=new Alchimistes2();
	   cartes.add(alchimistes2);
	   alchimistes2.setDogme("NatureChaosMystique");
	   alchimistes2.setNom("Alchimistes2");
	 //  alchimistes2.setImage(getImages.getPng("image/Alchimistes2"));
	   Alchimistes3 alchimistes3=new Alchimistes3();
	   cartes.add(alchimistes3);
	   alchimistes3.setDogme("NatureChaosSysboles");
	   alchimistes3.setNom("Alchimistes3");
	//   alchimistes3.setImage(getImages.getPng("image/Alchimistes3"));
		
	   //creer les cartes croyants qui s'appelle 'Ermite"
	   Ermite ermite1=new Ermite();
	   cartes.add(ermite1);
	   ermite1.setDogme("MystiqueNatureSymboles");
	   ermite1.setNom("Ermite2");
	 //  Image image29 = null;
	 //  image29 = getImages.getPng("image/Ermite2");
	 //  ermite1.setImage(image29);
	   
	   Ermite ermite2=new Ermite();
	   cartes.add(ermite2);
	   ermite2.setDogme("MystiqueNatureChaos");
	   ermite2.setNom("Ermite1");
	//   Image image30 = null;
	 //  image30 = getImages.getPng("image/Ermite1");
	//   ermite2.setImage(image30);
	   
	   //creer les cartes croyants qui s'appelle "Vampire"
	   Vampire vampire1=new Vampire();
	   cartes.add(vampire1);
	   vampire1.setDogme("HumainNatureSymboles");
	   vampire1.setNom("Vampire1");
	 //  Image image31 = null;
	 //  image31 = getImages.getPng("image/Vampire1");
	 //  vampire1.setImage(image31);
	   
	   Vampire vampire2=new Vampire();
	   cartes.add(vampire2);
	   vampire2.setDogme("MystiqueHumainChaos");
	   vampire2.setNom("Vampire2");
	//   Image image32 = null;
	 //  image32 = getImages.getPng("image/Vampire2");
	//   vampire2.setImage(image32);
		
	   //creer les cartes croyants qui s'appelle "R¨¦volutionnaires"
	   R¨¦volutionnaires r¨¦volutionnaires=new R¨¦volutionnaires();
	   cartes.add(r¨¦volutionnaires);
	   r¨¦volutionnaires.setDogme("HumainChaosSymboles");
	   r¨¦volutionnaires.setNom("Revolutionnaire");
	 //  r¨¦volutionnaires.setImage(getImages.getPng("image/Revolutionnaire"));
	   //creer les cartes croyants qui s'appelle "Int¨¦gristes"
	   
	   Int¨¦gristes int¨¦gristes=new Int¨¦gristes();
	   cartes.add(int¨¦gristes);
	   int¨¦gristes.setDogme("HumainChaosNature");
	   int¨¦gristes.setNom("Integriste");
	 //  int¨¦gristes.setImage(getImages.getPng("image/Integriste"));
	   //creer les cartes croyants qui s'appelle "Guerriers Saints"
		
	   GuerriersSaints guerriersSaints=new GuerriersSaints();
	   cartes.add(guerriersSaints);
	   guerriersSaints.setDogme("MystiqueNatureSysboles");	
	   guerriersSaints.setNom("GurrriersSaints");
	 //  guerriersSaints.setImage(getImages.getPng("image/GuerriersSaints"));
	  ////creer les cartes croyants qui s'appelle "Lycanthropes"
		
	   Lycanthropes lycanthropes=new Lycanthropes();
	   cartes.add(lycanthropes);
	   lycanthropes.setDogme("HumainChaosNature");
	   lycanthropes.setNom("Lycanthropes");
	 //  lycanthropes.setImage(getImages.getPng("image/Lycanthropes"));
	   
	  //creer les cartes croyants qui s'appelle "Diplomates"
	  
	   Diplomates diplomates=new Diplomates();
	   cartes.add(diplomates);
	   diplomates.setDogme("HumainChaosSymboles");  
	   diplomates.setNom("Diplomates");
	//   diplomates.setImage(getImages.getPng("image/Diplomates"));
	  //creer les cartes croyants qui s'appelle "Revenant"
			   
	   Revenant revenant=new Revenant();
	   cartes.add(revenant);   
	   revenant.setDogme("HumainMystiqueNature");
	   revenant.setNom("Revenant");
	//   revenant.setImage(getImages.getPng("image/Revenant"));
	  //creer les cartes croyants qui s'appelle "Pilladrs"
	   
	   Pillards pillards=new Pillards();
	   cartes.add(pillards);
	   pillards.setDogme("SymbolesMystiqueNature");	 
	   pillards.setNom("Pillards");
	//   pillards.setImage(getImages.getPng("image/Pillards"));
	  //creer les cartes croyants qui s'appelle "Illusionnistes"
			   
	   Illusionnistes illusionnistes=new Illusionnistes();
	   cartes.add(illusionnistes);
	   illusionnistes.setDogme("HumainChaosSymboles");
	   illusionnistes.setNom("Illusionnistes");
	//   illusionnistes.setImage(getImages.getPng("image/Illusionnistes"));
	  //creer les cartes croyants qui s'appelle 'Nibillistes"
			   
	   Nibillistes nibillistes=new Nibillistes();
	   cartes.add(nibillistes);
	   nibillistes.setDogme("SymbolesMystiqueChaos");
	   nibillistes.setNom("Nibillistes");
	//   nibillistes.setImage(getImages.getPng("image/Nibillistes"));	   
   } 

	
	  //creer tout les cartes GuideSpirituel
	public void creerLesCartesGuideSpirituel(){
		
		  //creer les cartes GuideSpirituel qui s'appelle "Martyr"
		Martyr martyr1=new Martyr();
		cartes.add(martyr1);
		martyr1.setOrigine("Jour");
		martyr1.setDogme("NatureHumain");
		 martyr1.setNom("Martyr1");
	//	Image image16 = null;
	//	image16 = getImages.getPng("image/Martyr1");
	//	martyr1.setImage(image16);
		
		Martyr martyr2=new Martyr();
		cartes.add(martyr2);
		martyr2.setOrigine("Nuit");
		martyr2.setDogme("HumainSymboles");
		martyr2.setNom("Martyr2");
	//	Image image17 = null;
	//	image17 = getImages.getPng("image/Martyr2");
	//	martyr2.setImage(image17);
		
		Martyr martyr3=new Martyr();
		cartes.add(martyr3);
		martyr3.setOrigine("N¨¦ant");
		martyr3.setDogme("NatureChaos");
		martyr3.setNom("Martyr3");
	//	Image image18 = null;
	//	image18 = getImages.getPng("image/Martyr3");
	//	martyr3.setImage(image18);
		
		
		  //creer les cartes GuideSpirituel qui s'appelle "Clerc"
		Clerc clerc1=new Clerc();
		cartes.add(clerc1);
		clerc1.setOrigine("Jour");
		clerc1.setDogme("NatureChaos");
		clerc1.setNom("Clerc4");
		//Image image19 = null;
		//image19 = getImages.getPng("image/Clerc4");
	//	clerc1.setImage(image19);
		
		Clerc clerc2=new Clerc();
		cartes.add(clerc2);
		clerc2.setOrigine("Jour");
		clerc2.setDogme("MystiqueChaos");
		clerc2.setNom("Clerc7");
		//Image image20 = null;
		//image20 = getImages.getPng("image/Clerc7");
	//	clerc2.setImage(image20);
		
		Clerc clerc3=new Clerc();
		cartes.add(clerc3);
		clerc3.setOrigine("Jour");
		clerc3.setDogme("HumainChaos");
		clerc3.setNom("Clerc1");
		//Image image21 = null;
	//	image21 = getImages.getPng("image/Clerc1");
	//	clerc3.setImage(image21);
		
		Clerc clerc4=new Clerc();
		cartes.add(clerc4);
		clerc4.setOrigine("Nuit");
		clerc4.setDogme("HumainNature");
		clerc4.setNom("Clerc8");
	//	Image image22 = null;
	//	image22 = getImages.getPng("image/Clerc8");
	//	clerc4.setImage(image22);
		
		Clerc clerc5=new Clerc();
		cartes.add(clerc5);
		clerc5.setOrigine("Nuit");
		clerc5.setDogme("NatureSymboles");
		clerc5.setNom("Clerc2");
		//Image image23 = null;
		//image23 = getImages.getPng("image/Clerc2");
	//	clerc5.setImage(image23);
		
		Clerc clerc6=new Clerc();
		cartes.add(clerc6);
		clerc6.setOrigine("Nuit");
		clerc6.setDogme("MystiqueSymboles");
		clerc6.setNom("Clerc5");
	//	Image image24 = null;
	//	image24 = getImages.getPng("image/Clerc5");
	//	clerc6.setImage(image24);
		
		Clerc clerc7=new Clerc();
		cartes.add(clerc7);
		clerc7.setOrigine("N¨¦ant");
		clerc7.setDogme("SymbolesChaos");
		clerc7.setNom("Clerc6");
		//Image image25 = null;
	//	image25 = getImages.getPng("image/Clerc6");
	//	clerc7.setImage(image25);
		
		Clerc clerc8=new Clerc();
		cartes.add(clerc8);
		clerc8.setOrigine("N¨¦ant");
		clerc8.setDogme("NatureMystique");
		clerc8.setNom("Clerc3");
	//	Image image26 = null;
	//	image26 = getImages.getPng("image/Clerc3");
	//	clerc8.setImage(image26);
		
		
		  //creer les cartes GuideSpirituel qui s'appelle "Shaman"
		Shaman shaman=new Shaman();
		cartes.add(shaman);
		shaman.setDogme("SymbolesNature");
		shaman.setNom("Shaman");
		//shaman.setImage(getImages.getPng("image/Shaman"));
		  //creer les cartes GuideSpirituel qui s'appelle "Anarchiste"
		Anarchiste anarchiste=new Anarchiste();
		cartes.add(anarchiste);
		 anarchiste.setDogme("ChaosHumain");
		 anarchiste.setNom("Anarchiste");
		// anarchiste.setImage(getImages.getPng("image/Anarchiste"));
	  //creer les cartes GuideSpirituel qui s'appelle "Paladin"
	   
	   Paladin paladin=new Paladin();
	   cartes.add(paladin);
	   paladin.setDogme("MystiqueHumain");
	   paladin.setNom("Paladin");
	  // paladin.setImage(getImages.getPng("image/Paladin"));
	   //creer les cartes GuideSpirituel qui s'appelle "Asc¨¨te"
	   
	   Asc¨¨te asc¨¨te=new Asc¨¨te();
	   cartes.add(asc¨¨te);
	   asc¨¨te.setDogme("SymbolesHumain");
	   asc¨¨te.setNom("Asc¨¨te");
	  // asc¨¨te.setImage(getImages.getPng("image/Asc¨¨te"));
       //creer les cartes GuideSpirituel qui s'appelle "divin"
	   
	   Devin devin=new Devin();
	   cartes.add(devin);
	   devin.setDogme("MystiqueNature");
	   devin.setNom("Devin");
	  // devin.setImage(getImages.getPng("image/Devin"));
       //creer les cartes GuideSpirituel qui s'appelle "Exorciste"
	   
	   Exorciste exorciste=new Exorciste();
	   cartes.add(exorciste);
	   exorciste.setDogme("MystiqueChaos");
	   exorciste.setNom("Exorciste");
	  // exorciste.setImage(getImages.getPng("image/Exorciste"));
       //creer les cartes GuideSpirituel qui s'appelle "Sorcier"
	   
	   Sorcier sorcier=new Sorcier();
	   cartes.add(sorcier);
	   sorcier.setDogme("MystiqueSymboles");
	   sorcier.setNom("Sorcier");
	  // sorcier.setImage(getImages.getPng("image/Sorcier"));
       //creer les cartes GuideSpirituel qui s'appelle "Tyran"
	   
       Tyran tyran=new Tyran();
	   cartes.add(tyran);
	   tyran.setDogme("ChaosSymboles");
	   tyran.setNom("Tyran");
	//   tyran.setImage(getImages.getPng("image/Tyran"));
       //creer les cartes GuideSpirituel qui s'appelle "Messie"
	   
	   Messie messie=new Messie();
	   cartes.add(messie);
	   messie.setDogme("MystiqueHumain");
	   messie.setNom("Messie");
	 //  messie.setImage(getImages.getPng("image/Messie"));
   }
	
	  //creer tout les cartes DeusEx
	public void  creerLesCartesDeusEx(){
		  //creer les cartes DeusEx qui s'appelle "Col¨¨re Divine"
		Col¨¨reDivineJour col¨¨reDivineJour=new Col¨¨reDivineJour();
		cartes.add(col¨¨reDivineJour);
		col¨¨reDivineJour.setNom("ColereDivine1");
	//	col¨¨reDivineJour.setImage(getImages.getPng("image/ColereDivine1"));
		Col¨¨reDivineNuit col¨¨reDivineNuit=new Col¨¨reDivineNuit();
		cartes.add(col¨¨reDivineNuit);
		col¨¨reDivineNuit.setNom("ColereDivine2");
	//	col¨¨reDivineNuit.setImage(getImages.getPng("image/ColereDivine2"));
	   
	   //creer les cartes DeusEx qui s'appelle "Stase"
	   Stase stase=new Stase();
       cartes.add(stase);
       stase.setNom("Stase");
     //  stase.setImage(getImages.getPng("image/Stase"));
	   
	   //creer les cartes DeusEx qui s'appelle "Ordre C¨¦leste"
	   OrdreC¨¦leste ordreC¨¦leste=new OrdreC¨¦leste();
	   cartes.add(ordreC¨¦leste);
	   ordreC¨¦leste.setNom("OrdreCeleste");
	 //  ordreC¨¦leste.setImage(getImages.getPng("image/OrdreCeleste"));
	   
	   //creer les cartes DeusEx qui s'appelle "Concentration"
	   Concentration concentration=new Concentration();
	   cartes.add(concentration);
	   concentration.setNom("Concentration");
	  // concentration.setImage(getImages.getPng("image/Concentration"));
	   
	   //creer les cartes DeusEx qui s'appelle "Fourberie"
	   Fourberie fourberie=new Fourberie();
	   cartes.add(fourberie);
	   fourberie.setNom("Fourberie");
	 //  fourberie.setImage(getImages.getPng("image/Fourberie"));
	   
	   //creer les cartes DeusEx qui s'appelle "Diversion"
	   Diversion diversion=new Diversion();
	   cartes.add(diversion);
	   diversion.setNom("Diversion");
	//   diversion.setImage(getImages.getPng("image/Diversion"));
	   
       //creer les cartes DeusEx qui s'appelle "Trou Noir"
	   TrouNoir trouNoir=new TrouNoir();
	   cartes.add(trouNoir);
	   trouNoir.setNom("TrouNoir");
	  // trouNoir.setImage(getImages.getPng("image/TrouNoir"));
	   
       //creer les cartes DeusEx qui s'appelle "Phoenix"
	   Phoenix phoenix=new Phoenix();
	   cartes.add(phoenix);
	   phoenix.setNom("Phoenix");
	  // phoenix.setImage(getImages.getPng("image/Phoenix"));
	   
       //creer les cartes DeusEx qui s'appelle "Influence Jour"
	   InfluenceJour influenceJour=new InfluenceJour();
	   cartes.add(influenceJour);
	   influenceJour.setNom("InfluenceJour");
	  // influenceJour.setImage(getImages.getPng("image/InfluenceJour"));
	   
       //creer les cartes DeusEx qui s'appelle "Influence Nuit"
	   InfluenceNuit influenceNuit=new InfluenceNuit();
	   cartes.add(influenceNuit);
	   influenceNuit.setNom("InfluenceNuit");
	 //  influenceNuit.setImage(getImages.getPng("image/InfluenceNuit"));
	   
       //creer les cartes DeusEx qui s'appelle "Influence N¨¦ant"
	   InfluenceN¨¦ant influenceN¨¦ant=new InfluenceN¨¦ant();
	   cartes.add(influenceN¨¦ant);
	   influenceN¨¦ant.setNom("InfluenceN¨¦ant");
	  // influenceN¨¦ant.setImage(getImages.getPng("image/InfluenceN¨¦ant"));
	   
	   //creer les cartes DeusEx qui s'appelle "Influence Nulle"
		   InfluenceNulle influenceNulle1=new InfluenceNulle();
		   cartes.add(influenceNulle1);
		   influenceNulle1.setNom("InfluenceNull1");
		 //  influenceNulle1.setImage(getImages.getPng("image/InfluenceNull1"));
		   InfluenceNulle influenceNulle2=new InfluenceNulle();
		   cartes.add(influenceNulle2);
		   influenceNulle2.setNom("InfluenceNull2");
		  // influenceNulle2.setImage(getImages.getPng("image/InfluenceNull2"));
	   
       //creer les cartes DeusEx qui s'appelle "Transe"
	   Transe transe=new Transe();
	   cartes.add(transe);
	   transe.setNom("Transe");
	  // transe.setImage(getImages.getPng("Transe"));
	   
       //creer les cartes DeusEx qui s'appelle "Miroir"
	   Miroir miroir=new Miroir();
	   cartes.add(miroir);
	   miroir.setNom("Miroir");
	  // miroir.setImage(getImages.getPng("image/Miroir"));
	  
       //creer les cartes DeusEx qui s'appelle "Bouleversement"
	   Bouleversement bouleversement=new Bouleversement();
	   cartes.add(bouleversement);
	   bouleversement.setNom("Bouleversement");
	 //  bouleversement.setImage(getImages.getPng("image/Bouleversement"));
	   
       //creer les cartes DeusEx qui s'appelle "Inquisition"
	   Inquisition inquisition=new Inquisition();
	   cartes.add(inquisition);
	   inquisition.setNom("Inquisition");
	  // inquisition.setImage(getImages.getPng("image/Inquisition"));
   }
	public void creerLesCartesApocalypse(){
		  //creer les cartes Apocalypse 
		Apocalypse apocalypse1=new Apocalypse();
		cartes.add(apocalypse1);
		apocalypse1.setOrigine("Jour");
		apocalypse1.setNom("Apocalypse1");
	//	Image image33 = null;
	//	image33 = getImages.getPng("image/Apocalypse1");
	//	apocalypse1.setImage(image33);
		
		Apocalypse apocalypse2=new Apocalypse();
		cartes.add(apocalypse2);
		apocalypse2.setOrigine("Nuit");
		apocalypse2.setNom("Apocalypse2");
	//	Image image34 = null;
		//image34 = getImages.getPng("image/Apocalypse2");
		//apocalypse2.setImage(image34);
		
		Apocalypse apocalypse3=new Apocalypse();
		cartes.add(apocalypse3);
		apocalypse3.setOrigine("N¨¦ant");
		apocalypse3.setNom("Apocalypse3");
	//	Image image35 = null;
	//image35 = getImages.getPng("image/Apocalypse3");
	//	apocalypse3.setImage(image35);
		
		Apocalypse apocalypse4=new Apocalypse();
		cartes.add(apocalypse4);
		apocalypse4.setOrigine("");
		apocalypse4.setNom("Apocalypse4");
		//Image image36 = null;
	//	image36 = getImages.getPng("image/Apocalypse4");
	//	apocalypse4.setImage(image36);
		
		Apocalypse apocalypse5=new Apocalypse();
		cartes.add(apocalypse5);
		apocalypse5.setOrigine("");
		apocalypse5.setNom("Apocalypse5");
	//	Image image37 = null;
	//	image37 = getImages.getPng("image/Apocalypse5");
	//	apocalypse5.setImage(image37);
		
	}
	  
	
	  //test si tout les cartes sont ajoutes
	public void test(){
		int size =cartes.size();
		for(int i=0;i<size;i++){
			CarteAction test=(CarteAction)cartes.get(i);
			System.out.println(test.nom);
		}
	}
	
	  //Touiller les cartes
	public void touiller() {
		Collections.shuffle(cartes);
	}
	
	public static CartePile renouveaulerCartePile() {
		if(cartePile == null) {
			cartePile = new CartePile();
		}
		return cartePile;
	}
	
	 //imprimer carte pile
	public void printCartePile(){
		Iterator it= cartes.iterator();
		System.out.println("imprimer la carte pile:");
		while (it.hasNext())
		{
			CarteAction ca=(CarteAction)it.next();
			System.out.println("Nom de la carte : " + ca.getNom());
			System.out.println("Origine de la carte" + ca.getOrigine());
			System.out.println("Dogeme de la carte" + ca.getDogme());
		}
	}
	
	
	  //tirer carte du dessus
	public CarteAction tirerCarteDuDessus(){
		int i=cartes.size();
		int j=i-1;
		CarteAction carte=(CarteAction)cartes.get(j);
		cartes.remove(j);
		return carte;
	}
	
	
	public static CartePile getCartePile() {
		return cartePile;
	}
	
	public static void setCartePile(CartePile cartePile) {
		CartePile.cartePile = cartePile;
	}
	
	public List getCartes() {
		return cartes;
	}
	
	public void setCartes(List cartes) {
		this.cartes = cartes;
	}
	
	
}
