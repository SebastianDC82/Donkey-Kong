package paquete.clases;
import java.awt.*;
public abstract class EstadoAbs {// abstract class
	public Controlador EstadoJuego; 
	public static double yOffset, xOffset;
	public EstadoAbs(Controlador EstadoJuego) {//constructor
		this.EstadoJuego = EstadoJuego;
		inicial();
	}
	// stages will extend these :
	public abstract void inicial();
	public abstract void tick(); 
	protected abstract void dibujar(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void teclaSoltada(int k);
}