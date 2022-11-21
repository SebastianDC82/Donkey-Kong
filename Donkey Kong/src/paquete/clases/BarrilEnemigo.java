package paquete.clases;
import java.awt.*;
import java.awt.event.*;

public class BarrilEnemigo {
	protected int alturaplataforma = 0;
	protected boolean izquierda = false; 
	protected boolean derecha = false;
	protected boolean caidabarril;
	protected double x, y;
	protected static int ancho;
	protected static int alto;
	protected double velocidadcaida = 6; 
	protected double velocidadcaidaactual = 0.2; 
	Rectangle r1 = new Rectangle((int) x, (int) y, ancho, alto); 
	
    public void draw(Graphics g) {
    	g.setColor(Color.orange);//color barril
		g.fillOval((int) x, (int) y, ancho, alto); 
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x+8, (int) y+8, ancho-12, alto-12); 
		g.setColor(Color.orange);
		g.fillOval((int) x+12, (int) y+12, ancho-25, alto-25); 
		g.setColor(Color.white);
	}

	public BarrilEnemigo(int ancho, int alto) {
		x = 240;//donde inicia el barril horizontalmente
		y = 120; //donde inicia el barril verticalmente
		this.ancho = ancho;
		this.alto = alto;
	}

	public void tick(Plataforma[] platforms) {
		Rectangle r1 = new Rectangle((int) x, (int) y, ancho, alto); 
		int intx = (int) x; // cambiar x de double a int
		int inty = (int) y; // cambiar y de double a int
		
		for (int j = 0; platforms.length > j; j++) {
        //barril usa la misma caida que el jugador
			if ((Colisión.ColisiónJugadorPlataforma(new Point(intx + (int) EstadoAbs.yOffset, inty + alto + (int) EstadoAbs.yOffset),platforms[j])
				|| Colisión.ColisiónJugadorPlataforma(new Point(intx + ancho + (int) EstadoAbs.yOffset, inty + (int) EstadoAbs.yOffset),platforms[j])
				|| Colisión.ColisiónJugadorPlataforma(new Point(intx + ancho + (int) EstadoAbs.yOffset, inty + alto + (int) EstadoAbs.yOffset),
				platforms[j]))) { 
				caidabarril = false;
				alturaplataforma = alturaplataforma +1;
				break;

			} else {
				caidabarril = true;
			}
		}
		
		//cambiar dirección del barril a la derecha cuando cae
		if ((alturaplataforma > 260) && (1240 > alturaplataforma)) {
			x = x + 2; //velocidad del barril (derecha)
		}		
		if ((2238 < alturaplataforma) && (3185 > alturaplataforma)) {
			x = x + 2;
		}
		if (alturaplataforma == 4050) { //respawnear cuando lleguen al barril de aceite
			x = 240;
			y = 90;
			alturaplataforma = 0;
		}
		
		//cambiar direccion del barril a la izquierda cuando cae
		if ((Jugador.salto == true) || (Jugador.caida == true)) {
			x = x - 1; //velocidad del barril izquierda
		}

		//caida del barril
		if (caidabarril == true) {
			y = y + velocidadcaidaactual / 2; // velocidad caida
			if (velocidadcaida > velocidadcaidaactual) {
				velocidadcaidaactual = velocidadcaidaactual + 0.1;
		}
		}
		if (caidabarril == false) {
			velocidadcaidaactual = 0.2;
		}
	}

	public boolean contains(Point puntoJugador) {
		return false;
	}

}