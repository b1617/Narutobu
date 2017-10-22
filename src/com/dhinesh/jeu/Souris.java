package com.dhinesh.jeu;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Souris implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		// Démarrer le jeu

		int mx = e.getX();
		int my = e.getY();
		if (Main.action.menu == false) {
			if (mx > 645 && mx < 935) {
				if (my > 205 && my < 305) {
					Main.action.debut = true;
					Main.action.floatSouris = true;
					Main.action.naruto.threadStart = true;
				}

			}
			// Quitter le jeu

			if (mx > 648 && mx < 938) {
				if (my > 315 && my < 415) {
					System.exit(1);
					;
				}

			}

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// Démarrer le jeu

		int mx = e.getX();
		int my = e.getY();
		if (Main.action.menu == false) {
			if (mx > 645 && mx < 935) {
				if (my > 205 && my < 305) {
					Main.action.debut = true;
					Main.action.floatSouris = true;
					Main.action.naruto.threadStart = true;
				}

			}
			// Quitter le jeu

			if (mx > 648 && mx < 938) {
				if (my > 315 && my < 415) {
					System.exit(1);
					;
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
