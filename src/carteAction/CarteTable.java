package carteAction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarteTable {
	private static CarteTable carteTable=new CarteTable();
	private ArrayList<CarteAction> cartesEnTable=new ArrayList();
	
	public void ajouterCarte(CarteAction objet){
		cartesEnTable.add(objet);
	}
	
	  //imprimer carte table
	public void printCarteTable(){
		Iterator it= cartesEnTable.iterator();
		System.out.println("Maintenant les carte sur table sont:");
		while (it.hasNext())
		{
			CarteAction cr=(CarteAction)it.next();
			System.out.println("Nom de la carte:" + cr.getNom());
		}
	}

	
	 //Getters & Setters
	public ArrayList<CarteAction> getCartesEnTable() {
		return cartesEnTable;
	}

	public void setCartesEnTable(ArrayList<CarteAction> cartesEnTable) {
		this.cartesEnTable = cartesEnTable;
	}
	
	public static CarteTable getCarteTable() {
		return carteTable;
	}
	
}
