package paquete.prueba;

import javax.swing.*;
import java.awt.BorderLayout;
import paquete.clases.PanelDeJuego;

public class Prueba {

	public static void main(String[] args) {
		JFrame MarcoDeJuego;

		MarcoDeJuego = new JFrame("Donkey Kong");
		MarcoDeJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcoDeJuego.setLayout(new BorderLayout());
		MarcoDeJuego.add(new PanelDeJuego(), (BorderLayout.CENTER));
		MarcoDeJuego.setVisible(true);
		MarcoDeJuego.pack();
		MarcoDeJuego.setLocationRelativeTo(null);
		MarcoDeJuego.setResizable(true);

	}

}