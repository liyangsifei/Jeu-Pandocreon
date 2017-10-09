package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import outils.getImages;


public class Panel_cartePile extends JPanel{
	
	Image bgCartePile = getImages.getPng("bg");
private Dimension dimPile = new Dimension(150,200);
	 public Panel_cartePile(){
		 this.setBackground(Color.darkGray);
		// this.setOpaque(false);
		 JLabel label = new JLabel(new ImageIcon(bgCartePile));
		 label.setPreferredSize(dimPile);
		 label.setBackground(Color.BLACK);
		 this.add(label);
		// this.setBorder(BorderFactory.createTitledBorder("pile"));
		// this.setBorder(BorderFactory.createLineBorder(Color.PINK));
		 
	 }
}