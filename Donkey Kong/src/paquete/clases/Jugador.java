package paquete.clases;
import java.awt.*;
import java.awt.event.*;

public class Jugador {
	public static boolean salto; 
	public static boolean caida; 
	protected int direccion = 1;
	protected int intizquierda = 0;
	public boolean enEscalera; 
	protected static double x;
	protected static double y;
	protected static int ancho;
	protected int alto;
	protected double vm = 5; // velocidad de movimiento
	protected double xvel = vm;
	protected double vs = 6; // velocidad de salto
	protected double yvel = vs; 
	protected double velocidadcaida = 5; // control de caida
	protected double velocidadcaidaactual = 1; 
	
	public void keyPressed(int k) { //hace que vaya mas fluido
		if (k == KeyEvent.VK_LEFT) {
			if (salto) {
				x = x - 30;
			}
			x = x - 6;
			direccion = -1;
			intizquierda = 1;
		}
		
		if (k == KeyEvent.VK_RIGHT) {
			if (salto) {
				x = x + 30;
			}
			x = x + 6; // velocidad de movimiento derecha
			direccion = 1; 
			intizquierda = 0;
		}

		if (k == KeyEvent.VK_UP) {
			salto = true;
		}
	}

	public void keyReleased(int k) {	}

	public Jugador(int ancho, int alto) {  //Posicion de mario
		x = 100; // donde comienza horizontalmente
		y = 700; // donde comienza verticalmente
		this.ancho = ancho;
		this.alto = alto;
	}

	public void draw(Graphics g) { //dibuja los graficos de manera opuesta si va hacia la izquierda
		g.setColor(Color.blue);//zapatos
		g.fillRect((int) x+(intizquierda*2), (int) y+13, ancho/3, alto/2); 
		g.fillRect((int) x+20-(intizquierda*2), (int) y+13, ancho/3, alto/2); 
		g.setColor(Color.red);
		g.fillRect((int) x-2+(intizquierda*4), (int) y+10, ancho/4, alto/2); 
		g.fillRect((int) x+10+(intizquierda*4), (int) y+10, ancho/4, alto/2); 
		g.fillRect((int) x+20+(intizquierda*4), (int) y+10, ancho/4, alto/2); 
		g.fillRect((int) x, (int) y+5, ancho, alto/2); 
		g.setColor(Color.pink);//cabeza
		g.fillRect((int) x+8-(intizquierda*2), (int) y-15, ancho-10, alto-10);
		g.setColor(Color.red);//gorro
		g.fillRect((int) x+6-(intizquierda*5), (int) y-15, ancho-2, alto/2-12);
		g.fillRect((int) x+6+(intizquierda*10), (int) y-17, ancho/2, alto/2-10);
		g.setColor(Color.blue);//brazo
		g.fillRect((int) x+(8*direccion)+(intizquierda*22), (int) y+10, ancho/4, alto/4);
		g.fillRect((int) x+(6*direccion)+(intizquierda*22), (int) y+8, ancho/4, alto/4);
		g.fillRect((int) x+(4*direccion)+(intizquierda*22), (int) y+6, ancho/4, alto/4);
		g.fillRect((int) x+(2*direccion)+(intizquierda*22), (int) y+4, ancho/4, alto/4);
		g.fillRect((int) x, (int) y, ancho, alto/4);
		g.setColor(Color.pink);//mano
		g.fillRect((int) x+(12*direccion)+(intizquierda*24), (int) y+12, ancho/4, alto/4);
		g.setColor(Color.black);//ojos
		g.fillRect((int) x+(12*direccion)+(intizquierda*29), (int) y-10, ancho/10, alto/10);
		g.fillRect((int) x+(20*direccion)+(intizquierda*29), (int) y-10, ancho/10, alto/10);

	}

	public void tick(Plataforma[] plataformas) {
		int intx = (int) x; // cambia x de double a int
		int inty = (int) y; // cambia y de double a int
		for (int j = 0; plataformas.length > j; j++) {
			// abajo,derecha e izquierda hace colisión con el jugador
			if ((Colisión.ColisiónJugadorPlataforma(new Point(intx + (int) EstadoAbs.yOffset, inty + alto + (int) EstadoAbs.yOffset), plataformas[j])
					|| Colisión.ColisiónJugadorPlataforma(new Point(intx + ancho + (int) EstadoAbs.yOffset, inty + (int) EstadoAbs.yOffset),
							plataformas[j])
					|| Colisión.ColisiónJugadorPlataforma(new Point(intx + ancho + (int) EstadoAbs.yOffset, inty + alto + (int) EstadoAbs.yOffset),
							plataformas[j]))) { 
				caida = false;
				enEscalera = false;
				break;
			} else {
				caida = true;	
			}
		}

		if (salto) {
			y = y - yvel / 1.3; // altura salto
			yvel = yvel - 0.15;
			if (0 >= yvel) { // si la velocidad de salto es 0, deja de saltar
				salto = false;
				caida = true;
				yvel = vs;
			}
		}
				
		if (caida == true) {
			y = y + velocidadcaidaactual / 2; // velocidad caida
			if (velocidadcaida > velocidadcaidaactual) {
				velocidadcaidaactual = velocidadcaidaactual + 0.1; // mientras mas tiempo esta cayendo, mas rapido cae									
			}
		}
		if (caida == false) {
			velocidadcaidaactual = 0.2;
		}
	}
	
	//si se acerca a la princesa gana
	public void tick(Personajes[] perso) {
		int inty2 = (int) y; 
		int intx2 = (int) x; 
		for (int i = 0; perso.length > i; i++) {
			// cuerpo del jugador colisiona con princesa
			if ( Colisión.ColisiónJugadorPrincesa(new Point(intx2 + (int) EstadoAbs.yOffset + ancho, 
						inty2 + alto + (int) EstadoAbs.yOffset),
							perso[i])) {
				Nivel1.ganar = 1;
				break;
			} else {
			}
		}
	}
	
	public void tick(Escalera[] escaleras) {
		int inty2 = (int) y; 
		int intx2 = (int) x; 
		for (int i = 0; escaleras.length > i; i++) {
			// jugador colisiona
			if ((Colisión.ColisiónJugadorEscalera(new Point(intx2 + (int) EstadoAbs.yOffset, inty2 + (int) EstadoAbs.yOffset), escaleras[i])
					|| Colisión.ColisiónJugadorEscalera(new Point(intx2 + (int) EstadoAbs.yOffset + ancho, inty2 + alto + (int) EstadoAbs.yOffset),
							escaleras[i]))) { 
                            
				y -= 1; //deja al jugador subir la escalera
				enEscalera = true;
				break;

			} else {
				caida = true;
				EstadoAbs.yOffset = 0; 
			}
		}
	}
	
	Rectangle playerRect = new Rectangle((int)Jugador.x, (int)Jugador.y, 30, 30);
	Rectangle r2 = new Rectangle(700, 700, 30, 30);
	
	public void tick(BarrilEnemigo[] barriles) {
		for (int f = 0; barriles.length > f; f++) {
			// cuando el barril choca lo imprime
			if ((Colisión.ColisiónJugadorBarril(new Point(  ((int)Jugador.x+30), ((int)Jugador.y+30) ), barriles[f])
					|| (Colisión.ColisiónJugadorBarril(new Point(  ((int)Jugador.x+30), ((int)Jugador.y) ), barriles[f]))))	
					{
				Nivel1.vidas = Nivel1.vidas - 1;
				System.out.print("Choque de Barril");
				break;
			} else {
			}
		}
	}
}