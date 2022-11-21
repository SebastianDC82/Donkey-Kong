package paquete.clases;
import java.awt.*;

public class Plataforma extends Rectangle {
	public Plataforma(int x, int y) {
		setBounds(x, y, 665, 40); // tamaño de plataforma
	}

	public void tick() {	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);//color plataformas
		g.fillRect(x, y, width, height); //rectangulo lleno 
		g.setColor(Color.black);//color de los triangulos en las plataformas
		for (int i = 0; i < 616; i=i+100) {
		    g.fillRect(x+15+i, y+10, (width/20)+1, height/5); } 
		for (int j = 0; j < 616; j=j+50) {
			g.fillRect(x+20+j, y+15, width/28, height/5); } 
		for (int i = 0; i < 626; i=i+100) {
			g.fillRect(x+25+i, y+20, width/50, height/5);  }
		for (int j = 0; j < 576; j=j+100) {
			g.fillRect(x+75+j, y+10, width/50, height/5); }
		for (int i = 0; i < 566; i=i+100) {
		    g.fillRect(x+65+i, y+20, (width/20)+1, height/5); } 
	 }
 }