package com.dhinesh.jeu;

import java.applet.Applet;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class Main  extends Applet{

	public static JFrame fenetre;
	public static Action action;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fenetre = new JFrame("Narutobu");
		action = new Action();

		fenetre.setAlwaysOnTop(true);
		fenetre.setLocation(150, 150);
		fenetre.setSize(1200, 530);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
		fenetre.setContentPane(action);
		fenetre.setVisible(true);
	}

}
