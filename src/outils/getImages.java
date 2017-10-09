package outils;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class getImages {
	
	private BufferedImage image;
	JLabel label;
	
	public static BufferedImage getPng(String nom){
		BufferedImage bfimg = null;
		try {
			bfimg = ImageIO.read(ClassLoader.getSystemResourceAsStream("image"+"/"+nom+".PNG"));
		} catch (Exception e) {
			System.out.println("nom erreur:"+nom);
			e.printStackTrace();
		}
		return bfimg;
	}
	

}
