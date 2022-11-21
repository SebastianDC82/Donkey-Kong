package paquete.clases;


import java.awt.*;
import java.awt.event.KeyEvent;
//also add you ganar
public class PantallaFinDelJuego extends EstadoAbs {
	boolean mostrarPuntaje = false;
	public PantallaFinDelJuego(Controlador gamestates) {
		super(gamestates);
	}


	String[] opciones2 = { "REINICIAR", " ", "SALIR DEL JUEGO" }; 
	protected int selec = 0;
	protected Personajes pers; //personaje (Princesa)
	protected Personajes pers2; //personaje (DK)
	
	public void inicial() {
		pers = new Personajes(120, 700); //Personaje en la pantalla final
		pers2 = new Personajes(680, 700); //Personaje en la pantalla final	
	}
	
	public void keyPressed(int kp) {
		if (kp == KeyEvent.VK_DOWN) { //si presionas la flecha abajo
			selec = selec + 1; //se mueve por las opciones
			if (selec >= 3) {
				selec = 2;
			}
		} else if (kp == KeyEvent.VK_UP) { //si presionas flecha arriba
			selec = selec - 1; //se mueve por las opciones
			if (2 > selec) {
				selec = 0;
			}
		}
		if (kp == KeyEvent.VK_ENTER) { //si presionas la tecla enter
			if (selec == 0) { //reiniciar
				EstadoJuego.stages.push(new Nivel1(EstadoJuego));
				Nivel1.vidas = 3; 
				Nivel1.ganar = 0; 
				Nivel1.puntaje = 0; 
			} else if (selec == 2) { // salir del juego
				System.exit(0);
			}
		}
	}


	public void teclaSoltada(int kr) {	}


	protected void dibujar(Graphics g) {
		// fondo
		g.setColor(Color.black);
		g.fillRect(0, 0, 1900, 800); //tamaño del fondo
					
	    g.setFont(new Font("Helvetica", Font.BOLD, 55));
		g.setColor(Color.blue);
		g.drawString("PUNTAJE FINAL:", 85, 220);
		g.setColor(Color.white);
		g.drawString("" + Nivel1.puntaje, 505, 220);
		
		
		if (Nivel1.ganar == 1) {
			g.setFont(new Font("Helvetica", Font.BOLD, 120));
			g.setColor(Color.yellow);
		    g.drawString("GANASTE", 85, 150);
		    pers.dibujar(g); // dibuja los personajes
		    
		    int xpoint4[] = {(400/2)-110, (360/2)-110, (375/2)-110, (400/2)-110, (425/2)-110, (440/2)-110}; // punto extremo izquierdo y punto extremo abajo
		    int xpoint3[] = {400/2, 360/2, 375/2, 400/2, 425/2, 440/2}; // punto extremo izquierdo y punto extremo abajo
		    int ypoint3[] = {680, 650, 630, 650, 630, 650};
		    g.setColor(Color.pink); 
		    g.fillPolygon(xpoint3, ypoint3, 6);
		    g.fillPolygon(xpoint4, ypoint3, 6);
		    g.setColor(Color.white);
		    g.setFont(new Font("Helvetica", Font.BOLD, 30));
		    g.drawString("GRACIAS POR SALVARME!", 230, 700);
		    g.setColor(Color.black);
			g.fillRect(0, 800, 2500, 2500); //pantalla completa
			g.fillRect(900, 0, 2500, 2500); //pantalla completa  
		}
		if (Nivel1.vidas == 0) {
			g.setFont(new Font("Helvetica", Font.BOLD, 120));
			g.setColor(Color.yellow);
			g.drawString("FIN DEL JUEGO", 80, 150);
			pers2.dibujar(g);
			//Sonrisa de DK en pantalla final
			g.setColor(Color.pink);
			g.fillRect(438, 640, 4, 5);
			g.setColor(Color.red);
			g.fillRect(437, 638, 4, 3);
			g.fillRect(440, 636, 4, 3);
			//Lagrima princesa en pantalla final
			g.setColor(Color.cyan);
			g.fillRect(700, 638, 2, 4);
			g.setColor(Color.black);
			g.fillRect(0, 800, 2500, 2500); //pantalla completa
			g.fillRect(900, 0, 2500, 2500); //pantalla completa		
		}
		// opciones del menu y colores
		for (int j = 0; 3 > j; j++) {
			int xpoint[] = {605, 625, 580, 625}; ////coordenadas de x para ambas flechas
		    int ypoint[] = {300, 290, 300, 310};//coordenadas de y para la flecha de reiniciar
			int ypoint2[] = {470, 460, 470, 480};//coordenadas de y para salir del juego
					
			if (selec == j) {
				g.setColor(Color.white); 
                g.fillPolygon(xpoint, ypoint2, 4);
				g.setColor(Color.black); 
			    g.fillPolygon(xpoint, ypoint, 4);
				g.setColor(Color.cyan);
				
			} else {
				g.setColor(Color.white); 
			    g.fillPolygon(xpoint, ypoint, 4);
				g.setColor(Color.black); 
                g.fillPolygon(xpoint, ypoint2, 4);
				g.setColor(Color.red);
			}
			g.setFont(new Font("Helvetica", Font.BOLD, 60));


			g.drawString(opciones2[j], 768 / 3, j * 80 + 320);
			
		}
		
	}
	
	@Override
	public void tick() {	}


}