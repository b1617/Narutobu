package com.dhinesh.jeu;

import com.dhinesh.personnage.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jump implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

			// Si la touche Espace est appuyée, Naruto saut

			// Main.action.pers.monte();
			if (Main.action.naruto.threadStart) {

				Main.action.naruto.jump = true;

				Main.action.naruto.start = true;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			// Si la touche Entre est appuyée, on commence le jeu

			Main.action.debut = true;

			Main.action.naruto.threadStart = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
