package paquete.clases;
import java.awt.*;
import java.util.*;
//clase para controlar los estados del juego
public class Controlador {
	public static boolean restarted;
	
	public Stack<EstadoAbs> stages;
	public Controlador() { 
		stages = new Stack<EstadoAbs>();
		stages.push(new MenuInicial(this));//añade menu inicial
	}
	
	public void keyPressed(int P) {
		stages.peek().keyPressed(P); 
	}
	public void keyReleased(int R) {
		stages.peek().keyPressed(R);
	}
	public void tick() {
		stages.peek().tick();
	}
	public void draw(Graphics g) {
		stages.peek().dibujar(g);
	}
}