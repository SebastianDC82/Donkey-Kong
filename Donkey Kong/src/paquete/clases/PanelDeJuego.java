package paquete.clases;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 


public class PanelDeJuego extends JPanel implements KeyListener, Runnable { 
	protected long tTiempo = 1000000 / 60;
	protected Thread t;             
	protected boolean corriendo = false;
	protected static int ContadorDeTicks;
	protected Controlador EstadoJuego; 


	public PanelDeJuego() {
		setPreferredSize(new Dimension(860, 800)); //tamaño de la ventana de juego
		addKeyListener(this);
		setFocusable(true);
		inicio();    }        //llama a inicio


	private void inicio() { // metodo de inicio
		corriendo = true;
		t = new Thread(this);
		t.start(); }            //llamada al metodo de arranque


	public void run() { // metodo de arranque
		EstadoJuego = new Controlador(); 
		long inicio, espera;
		while (corriendo = true) { // cuando el juego este corriendo, este metodo controla lo que pasa
			inicio = System.nanoTime(); //se reevalua en nanosegundos
			ContadorDeTicks = ContadorDeTicks + 1;
			tick();
			repaint(); // responsable de los graficos
			espera = tTiempo - inicio / 1000000;//lo vuelve milisegundos
			if (espera <= 0) {
				espera = 5;
			}
			try {
				Thread.sleep(espera);
			} catch (Exception excep) {
				System.out.println("Error");
			} } }


	public void paintComponent(Graphics g) {
		super.paintComponent(g);  //dibuja los graficos
		g.clearRect(0, 0, 780, 680); // limpia la pantalla
		EstadoJuego.draw(g);     }     //dibuja el nivel
	
	public void tick() { //updates the logic
		EstadoJuego.tick(); } 


	public void keyPressed(KeyEvent k) {
		EstadoJuego.keyPressed(k.getKeyCode()); }


	public void keyReleased(KeyEvent k) {
		EstadoJuego.keyReleased(k.getKeyCode()); }


	@Override
	public void keyTyped(KeyEvent e) {	}
}