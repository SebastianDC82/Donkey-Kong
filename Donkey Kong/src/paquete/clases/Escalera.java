package paquete.clases;
import java.awt.*;
public class Escalera extends Rectangle {
	public Escalera(int x3, int y3) {
		setBounds(x3, y3, 60, 110); // tamaño escalera
	}


	public void tick() {
	}


	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, y+40, width, height);
		g.setColor(Color.black);
		for (int i = 0; i < 101; i=i+20) {
			//huecos entre las escaleras
			g.fillRect((x+15), (y+40+i), width/2, height/10); } 
		g.setColor(Color.cyan);
	}
}