package com.dhinesh.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.dhinesh.jeu.Jump;
import com.dhinesh.jeu.Main;
import com.dhinesh.jeu.Temps;
import com.dhinesh.objet.Objet;

public class Personnage implements Runnable {

	// Attributs

	private int x;
	private int y;
	private int dy;
	private int largeur = 50;
	private int hauteur = 140;
	private String strImage;
	private ImageIcon icoPers;
	private Image imgPers;
	public int ct = 1;
	public boolean debutSaut;
	// public boolean saut = false;
	public boolean jump;
	public boolean jumpover;
	public boolean start;
	public boolean threadStart;
	public int vitesse;

	// Construction
	public Personnage(int x, int y, String strImage) {
		this.x = x;
		this.y = y;
		this.strImage = strImage;
		this.icoPers = new ImageIcon(getClass().getResource(this.strImage));
		this.imgPers = this.icoPers.getImage();
		this.jump = false;
		this.jumpover = false;
		this.debutSaut = false;
		this.start = false;

		Thread jumper = new Thread(this);
		jumper.start();

	}

	// Méthodes

	public void sauter() {
		if (jump && debutSaut == false) {
			y--;

		}
		if (this.y == 70) {

			debutSaut = true;

		}
		if (debutSaut && y <= 300) {
			this.y++;

		}
		if (y == 300) {

			jumpover = true;
		}
		if (jumpover) {
			this.jump = false;
			this.jumpover = false;
			this.debutSaut = false;

		}

	}

	public boolean collision(Objet objet) {
		// Verification si le pied de naruto touche l'objet lors du saut && si
		// le devant de
		// naruto touche l'objet && si le dos de naruto touche l'objet

		if (this.y + this.getHauteur() >= objet.getY() && this.x + this.getLargeur() - 25 > objet.getX()
				&& this.x < objet.getX() + objet.getLargeur() - 90)

		{
			return true;
		} else {
			return false;
		}

	}

	// Getters & Setters

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
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

	public String getStrImage() {
		return strImage;
	}

	public void setStrImage(String strImage) {
		this.strImage = strImage;
	}

	public ImageIcon getIcoPers() {
		return icoPers;
	}

	public void setIcoPers(ImageIcon icoPers) {
		this.icoPers = icoPers;
	}

	public Image getImgPers() {
		return imgPers;
	}

	public void setImgPers(Image imgPers) {
		this.imgPers = imgPers;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		while (jumpover == false) {

			if (jump && threadStart) {
				sauter();
				// System.out.println(Main.action.getScore());
				if(Main.action.getScore() < 40){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			try {
				 	Thread.sleep(1);
				

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
