package paquete.clases;
import java.awt.*;

public class Colisión {
    // checks if area on player is inside	
	public static boolean ColisiónJugadorPlataforma(Point puntoJugador, Plataforma plat) 																		// the platform
	{	return plat.contains(puntoJugador);  } // if inside returns true
    // checks if area on player is in ladder
	public static boolean ColisiónJugadorEscalera(Point puntoJugador, Escalera esc) 
	{	return esc.contains(puntoJugador); 	}
	// checks if area on player has reached Pauline
	public static boolean ColisiónJugadorPrincesa(Point puntoJugador, Personajes per) 
	{	return per.contains(puntoJugador); 	}
	//meant to check if area in barrels
	public static boolean ColisiónJugadorBarril(Point puntoJugador, BarrilEnemigo bar) 
	{	return bar.contains(puntoJugador); 	}
}