package com.dhinesh.objet;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Objet {

	// Attributs

	private int x;
	private int y;
	private String strImage;
	private Image objImage;
	private ImageIcon icoObj;
	private int hauteur;
	private int largeur;

	// Constructeur

	public Objet(int x, int y, String strImage) {

		// Constructeur d'un objet avec les positions x , y et String StrImage
		// pour le reconverir en Image

		super();
		this.x = x;
		this.y = y;
		this.hauteur = 200;
		this.largeur = 200;
		this.strImage = strImage;
		this.icoObj = new ImageIcon(getClass().getResource(this.strImage));
		this.objImage = this.icoObj.getImage();

	}

	// Getter && Setters

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getObjImage() {
		return objImage;
	}

	public void setObjImage(Image objImage) {
		this.objImage = objImage;
	}

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

}
