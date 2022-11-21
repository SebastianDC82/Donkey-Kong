package paquete.clases;
import java.awt.*;

public class Fondo extends Rectangle {
	public Fondo(int x2, int y2) { 
		setBounds(x2, y2, 1200, 1200); //tamaño del fondo (1200, 1200)
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.black); //color del fondo
		g.fillRect((int) x, (int) y, width, height);
	}
}