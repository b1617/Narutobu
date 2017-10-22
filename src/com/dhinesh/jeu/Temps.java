package com.dhinesh.jeu;

public class Temps implements Runnable {

	private int vitesse = 0;

	@Override
	public void run() {

		// Tant que le jeu n'est pas fini

		while (Main.action.finDuJeu == false) {

			// Déplacement de fond seulement si on commence le jeu

			if (Main.action.debut) {
				Main.action.xFond--;

			}

			// Repaint au niveau de la vitesse de jeu

			Main.action.repaint();

			// Vitesse de déplacement de fond par rapport au score

			try {
				if (Main.action.getScore() < 10) {
					vitesse = 5;

				} else if (Main.action.getScore() < 20) {
					vitesse = 4;

				} else if (Main.action.getScore() < 40) {
					vitesse = 3;

				} else if (Main.action.getScore() < 50) {
					vitesse = 4;

				} else if (Main.action.getScore() < 99) {
					vitesse = 5;
				} else {
					vitesse = 1;
				}

				Thread.sleep(vitesse);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
