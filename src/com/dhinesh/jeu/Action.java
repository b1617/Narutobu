package com.dhinesh.jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.dhinesh.objet.Objet;
import com.dhinesh.personnage.Personnage;

public class Action extends JPanel {
	// Variables
	private ImageIcon icoFond;
	private Image imgFond;
	private ImageIcon icoMenu;
	private Image imgMenu;
	public Personnage naruto;

	private final int LARGEUR_FOND = 600;
	private final int DISTANCE_OBJET = 800;

	public int xFond;

	private Image imgSaut;
	private ImageIcon icoSaut;

	private Image imgNaruto2;
	private ImageIcon icoNaruto2;
	private Image imgNaruto3;
	private ImageIcon icoNaruto3;

	public Objet objet1;
	public Objet objet2;
	public Objet objet3;
	public int score;
	public int highscore;
	private Thread defilementEcran;

	private int xObjet;
	private int dxObjet;

	public boolean finDuJeu;
	public boolean debut;
	public boolean menu;
	public boolean floatSouris;
	public int compteur;
	public int ct;

	// Constructeur
	public Action() {
		super();
		
		this.icoFond = new ImageIcon(getClass().getResource("/image/fond1.png"));
		this.imgFond = this.icoFond.getImage();
		this.icoMenu = new ImageIcon(getClass().getResource("/image/wallpaper.jpg"));
		this.imgMenu = this.icoMenu.getImage();
		this.icoNaruto2 = new ImageIcon(getClass().getResource("/image/naruto2.png"));
		this.imgNaruto2 = this.icoNaruto2.getImage();
		this.icoNaruto3 = new ImageIcon(getClass().getResource("/image/naruto3.png"));
		this.imgNaruto3 = this.icoNaruto3.getImage();

		this.debut = false;
		this.menu = false;

		this.icoSaut = new ImageIcon(getClass().getResource("/image/narutoSaut.png"));
		this.imgSaut = this.icoSaut.getImage();
		this.compteur = 0;
		this.xFond = 0;
		this.xObjet = 1000;
		this.dxObjet = 0;
		this.score = 0;
		this.highscore = 0;
		this.ct = 0;
		this.naruto = new Personnage(250, 300, "/image/naruto1.png");

		this.objet1 = new Objet(this.xObjet, 350, "/image/dia.png");
		this.objet2 = new Objet(this.xObjet + this.DISTANCE_OBJET, 350, "/image/dia2.png");
		this.objet3 = new Objet(this.xObjet + this.DISTANCE_OBJET * 2, 350, "/image/dia4.png");

		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.addKeyListener(new Jump());
		this.addMouseListener(new Souris());

		defilementEcran = new Thread(new Temps());
		defilementEcran.start();
	}

	// Methodes
	public void deplacementFond(Graphics g) {
		if (this.xFond == -this.LARGEUR_FOND) {
			this.xFond = 0;

		}
		g.drawImage(this.imgFond, this.xFond, 0, null);

		g.drawImage(this.imgFond, this.xFond + this.LARGEUR_FOND, 0, null);
		g.drawImage(this.imgFond, this.xFond + this.LARGEUR_FOND * 2, 0, null);

	}

	public void deplacementPersonnage(Graphics g) {

		if (naruto.getY() == 300) {
			if (compteur == 0) {
				g.drawImage(this.naruto.getImgPers(), this.naruto.getX(), this.naruto.getY(), null);
				compteur++;

			} else if (compteur == 1) {
				g.drawImage(this.imgNaruto3, this.naruto.getX(), this.naruto.getY(), null);
				compteur++;

			}

			else if (compteur == 2) {
				g.drawImage(this.imgNaruto2, this.naruto.getX(), this.naruto.getY(), null);
				compteur = 0;

			}
		}

		else {

			if (this.naruto.getY() > 180 && this.naruto.getY() < 300) {
				g.drawImage(this.naruto.getImgPers(), this.naruto.getX(), this.naruto.getY(), null);
			}

			else {
				g.drawImage(this.imgSaut, this.naruto.getX(), this.naruto.getY(), null);
			}

			// this.naruto.tombe();

		}

	}

	public void deplacementObjet(Graphics g) {
		this.objet1.setX(this.objet1.getX() - 2);

		if (this.objet1.getX() == -150) {
			this.objet1.setX(this.objet3.getX() + this.DISTANCE_OBJET);
		}
		g.drawImage(this.objet1.getObjImage(), this.objet1.getX(), this.objet1.getY(), null);

		this.objet2.setX(this.objet2.getX() - 2);
		if (this.objet2.getX() == -150) {
			this.objet2.setX(this.objet1.getX() + this.DISTANCE_OBJET);
		}
		g.drawImage(this.objet2.getObjImage(), this.objet2.getX(), this.objet2.getY(), null);

		this.objet3.setX(this.objet3.getX() - 2);
		if (this.objet3.getX() == -150) {
			this.objet3.setX(this.objet1.getX() + this.DISTANCE_OBJET * 2);
		}
		g.drawImage(this.objet3.getObjImage(), this.objet3.getX(), this.objet3.getY(), null);
	}

	private boolean collisionPersonnage() {
		boolean finDuJeu = false;
		if (naruto.getX() + naruto.getLargeur() > objet1.getX() - 20
				&& naruto.getX() < objet1.getX() + objet1.getLargeur() + 20) {
			finDuJeu = this.naruto.collision(objet1);
		} else if (naruto.getX() + naruto.getLargeur() > objet2.getX() - 20
				&& naruto.getX() < objet2.getX() + objet2.getLargeur() + 20) {
			finDuJeu = this.naruto.collision(objet2);
		} else if (naruto.getX() + naruto.getLargeur() > objet3.getX() - 20
				&& naruto.getX() < objet3.getX() + objet3.getLargeur() + 20) {
			finDuJeu = this.naruto.collision(objet3);
		}
		return finDuJeu;
	}

	private void score() {
		if (this.objet1.getX() + this.objet1.getLargeur() == 180 || this.objet2.getX() + this.objet2.getLargeur() == 180
				|| this.objet3.getX() + this.objet3.getLargeur() == 180) {
			this.score++;
			Audio.playSound("/audio/sonnerie.wav");
		}

	}

	public int getScore() {
		return score;
	}

	public synchronized void restart() {
		try {
			defilementEcran.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.icoFond = new ImageIcon(getClass().getResource("/image/fond1.png"));
		this.imgFond = this.icoFond.getImage();
		this.score = 0;
		this.xFond = 0;
		this.xObjet = 1000;
		this.dxObjet = 0;
		this.debut = false;
		this.finDuJeu = false;
		this.naruto = new Personnage(250, 300, "/image/naruto1.png");
		this.objet1 = new Objet(this.xObjet, 350, "/image/dia.png");
		this.objet2 = new Objet(this.xObjet + this.DISTANCE_OBJET, 350, "/image/dia2.png");
		this.objet3 = new Objet(this.xObjet + this.DISTANCE_OBJET * 2, 350, "/image/dia4.png");
		this.paintComponent(getGraphics());
		this.setFocusable(true);
		this.requestFocusInWindow(true);
		this.addKeyListener(new Jump());

		defilementEcran = new Thread(new Temps());
		defilementEcran.start();
		repaint();

	}

	public void paintComponent(Graphics g) {

		// System.out.println(compteur);
		if (this.debut) {
			this.deplacementFond(g);
			this.deplacementPersonnage(g);
			this.deplacementObjet(g);
			this.score();

			// System.out.println(this.naruto.getY());
			g.setFont(new Font("garamond", Font.PLAIN, 30));

			g.drawString("" + score, 1140, 80);

			if (this.highscore > 0) {
				g.drawString("Highscore : " + this.highscore, 1000, 50);
			}

			this.finDuJeu = this.collisionPersonnage();
			if (this.finDuJeu) {
				Audio.playSound("/Audio/boum.wav");
				this.menu = true;
				g.setFont(new Font("arial", Font.ITALIC, 85));

				g.setColor(Color.WHITE);
				g.drawRect(275, 170, 700, 150);

				g.setColor(Color.red);
				g.drawString("G A M E O V E R", 300, 260);
				g.setFont(new Font("arial", Font.ITALIC, 25 ));
				g.setColor(Color.DARK_GRAY);
				g.drawString("PRESS ENTER TO RESTART", 460, 290);

				

				if (this.score > 0 && this.score > this.highscore) {
					this.highscore = this.score;
					g.setFont(new Font("arial", Font.ITALIC, 25 ));
					g.setColor(Color.black);
					g.drawString("NEW RECORD : " + this.score, 550, 318);
				} else {
					g.setFont(new Font("arial", Font.ITALIC, 25 ));
					g.setColor(Color.black);
					g.drawString("SCORE : " + this.score, 600, 318);
				}
				
				
				this.restart();
				// System.out.println(this.finDuJeu);

			}
		} else if (this.menu == false) {

			g.drawImage(this.imgMenu, 0, 0, null);

			g.setColor(Color.red);
			g.drawRect(645, 205, 290, 100);
			g.drawRect(648, 318, 290, 100);
			g.setFont(new Font("garamond", Font.ITALIC, 40));
			g.setColor(Color.BLACK);
			g.drawString("Click enter to start", 910, 490);

		}

	}

}
