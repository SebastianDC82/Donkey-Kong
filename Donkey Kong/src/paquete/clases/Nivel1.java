package paquete.clases; 
import java.awt.*; 

import java.awt.event.KeyEvent;
import java.io.*;
//level of game 
public class Nivel1 extends EstadoAbs { 
    public static int ganar = 0; 
    public static int vidas = 3; 
    public static int puntaje = 0; 
    protected Fondo fondo; 
    protected Plataforma[] plataformas; 
    protected Escalera[] escaleras; 
    protected Personajes[] perso; 
    protected Jugador mario;  
    protected BarrilEnemigo[] barriles; 
    
    public Nivel1(Controlador estadoJuego) { 
        super(estadoJuego); 
        PanelDeJuego.ContadorDeTicks = 0; //empieza el contador de ticks despues de que le des a inicio
        if (ganar ==1) { //cuando el jugador toca a la princesa ganar=1
            estadoJuego.stages.push(new PantallaFinDelJuego(estadoJuego)); //si el jugador gana, te lleva a la pantalla de victoria
        }    
    }

    public void tick() { 
        for (int j = 0; plataformas.length > j; j++) { 
            plataformas[j].tick(); 
        } 
        for (int i = 0; escaleras.length > i; i++) { 
            escaleras[i].tick(); 
        } 
        mario.tick(escaleras); 
        mario.tick(perso); 
        mario.tick(barriles); 
        barriles[0].tick(plataformas);  
        
        if (PanelDeJuego.ContadorDeTicks>600) { 
            barriles[1].tick(plataformas);  }     
        if (PanelDeJuego.ContadorDeTicks>1200) { 
            barriles[2].tick(plataformas);   }       
        if (PanelDeJuego.ContadorDeTicks>1800) { 
            barriles[3].tick(plataformas);   }
        if (PanelDeJuego.ContadorDeTicks>2400) { 
            barriles[4].tick(plataformas);   } 
        if (PanelDeJuego.ContadorDeTicks>3000) { 
            barriles[5].tick(plataformas);   } 
        if (PanelDeJuego.ContadorDeTicks>3600) { 
            barriles[6].tick(plataformas);   } 
        if (PanelDeJuego.ContadorDeTicks>4200) { 
            barriles[7].tick(plataformas);   } 
        if (PanelDeJuego.ContadorDeTicks>4800) { 
            barriles[8].tick(plataformas);   }
        if (PanelDeJuego.ContadorDeTicks>5200) { 
            barriles[9].tick(plataformas);   } 
        
       mario.tick(plataformas);
        
      for (int f = 0; barriles.length > f; f++) {
    	  //rectangulo alrededor de los barriles
    	  Rectangle r = new Rectangle((int)barriles[f].x, (int) barriles[f].y, 30, 30);
    	  //si choca con el jugador el jugador pierde una vida y 
    	  if ( r.contains((int)Jugador.x+15, (int)Jugador.y+27) )   {
	     	  System.out.println("Barril chocó punto 1"); 
	     	  Jugador.y = 700; //respawnea al principio del juego
	     	  Jugador.x = 20;
	     	  vidas = vidas -1; 
		  }
    	  //rectangulo de puntaje
    	  Rectangle r2 = new Rectangle((int)barriles[f].x-2, (int)barriles[f].y-70, 35, 90); //rectangulo de puntaje
    	  if   ( r2.contains((int)Jugador.x+15, (int)Jugador.y+15)   )
    	  {  System.out.println("Aumento en el puntaje");     	  
		     puntaje = puntaje + 50; 
		  }
        }
      }
    
    public void inicial() { 
        barriles=new BarrilEnemigo[10]; 
        fondo = new Fondo(0, 0);// posición del fondo
        mario = new Jugador(30, 30); //crea a Mario //tamaño de Mario 
        for (int i=0;i<10;i++) { 
            barriles[i] = new BarrilEnemigo(30, 30); //Crea Barriles //tamaños 
        } 
        perso = new Personajes[1];  
        perso[0] = new Personajes(580, 140); //posición de los personajes y del barril de aceite
        escaleras = new Escalera[4];  
        // posición de escaleras
        escaleras[0] = new Escalera(620, 600); 
        escaleras[1] = new Escalera(300, 450);  
        escaleras[2] = new Escalera(720, 300); 
        escaleras[3] = new Escalera(420, 150); 
         
        plataformas = new Plataforma[9];  
        // posición de plataformas
        plataformas[0] = new Plataforma(-50, 750); // plataforma de abajo
        plataformas[1] = new Plataforma(350, 750); // plataforma de abajo derecha
        plataformas[2] = new Plataforma(150, 600); /// plataforma izquierda 1
        plataformas[3] = new Plataforma(250, 450); // plataforma derecha 1 
        plataformas[4] = new Plataforma(150, 300); // plataforma izquierda 2
        plataformas[5] = new Plataforma(250, 150); // plataforma derecha 2 - plaataforma final (DK y Princesa)
        //plataformas fuera de pantalla
        //las plataformas de abajo tienen que estar mas a los extremos
        plataformas[6] = new Plataforma(-450, 600); /// plataforma izquierda 1  //400 a la izquierda que la plataforma en pantalla
        plataformas[7] = new Plataforma(450, 450); // plataforma derecha 1 //400 a la derecha que la plataforma en pantalla
        plataformas[8] = new Plataforma(-450, 300); // plataforma izquierda 2  //400 a la izquierda que la plataforma en pantalla
        
    } 
 
    public void keyPressed(int k) { 
        mario.keyPressed(k);  
    } 
 
    public void teclaSoltada(int k) { 
        mario.keyReleased(k); 
    } 
 
    protected void dibujar(Graphics g) { 
        fondo.dibujar(g); 
        g.setColor(Color.black); //Llena la pantalla vacia con color negro
		g.fillRect(0, 800, 2500, 2500); //pantalla completa
		g.fillRect(1200, 0, 2500, 2500); //pantalla completa
        for (int j = 0; plataformas.length > j; j++) { // dibuja las plataformas
            plataformas[j].draw(g); } 
        for (int i = 0; escaleras.length > i; i++) { // dibuja las escaleras
            escaleras[i].draw(g); }
        barriles[0].draw(g); // dibuja los barriles   
        if (PanelDeJuego.ContadorDeTicks>600) { 
            barriles[1].draw(g); }// dibuja los barriles 1                  
        if (PanelDeJuego.ContadorDeTicks>1200) { 
            barriles[2].draw(g); } // dibuja los barriles 2
        if (PanelDeJuego.ContadorDeTicks>1800) { 
            barriles[3].draw(g); }// dibuja los barriles 3
        if (PanelDeJuego.ContadorDeTicks>2400) { 
            barriles[4].draw(g); } // dibuja los barriles 4
        if (PanelDeJuego.ContadorDeTicks>3000) { 
            barriles[5].draw(g); }// dibuja los barriles 5
        if (PanelDeJuego.ContadorDeTicks>3600) { 
            barriles[6].draw(g); }// dibuja los barriles 6
        if (PanelDeJuego.ContadorDeTicks>4200) { 
        	barriles[7].draw(g); }//dibuja los barriles 7
        if (PanelDeJuego.ContadorDeTicks>4800) { 
        	barriles[8].draw(g); }//dibuja los barriles 8
        if (PanelDeJuego.ContadorDeTicks>5200) { 
        	barriles[9].draw(g);  } //dibuja los barriles 9
         
        for (int o = 0; perso.length > o; o++) { // dibuja a los personajes
            perso[o].dibujar(g);
            g.setColor(Color.white);//texto para vidas y puntaje
		    g.setFont(new Font("Helvetica", Font.BOLD, 20));
			g.drawString("VIDAS: " + vidas, 780, 20);//texto y numero de vidas
			g.setColor(Color.red);
		    g.setFont(new Font("Helvetica", Font.BOLD, 20));
			g.drawString("PUNTAJE", 10, 25);//texto para puntaje
			g.setColor(Color.white);
			g.drawString("000" + puntaje, 20, 50);//texto mostrando el puntaje
			
			if (ganar ==1) { //mostrar pantalla final
                EstadoJuego.stages.push(new PantallaFinDelJuego(EstadoJuego)); 
            } //si el jugador se queda sin vidas fin del juego
            if (vidas ==0) { 
            	EstadoJuego.stages.push(new PantallaFinDelJuego(EstadoJuego)); 
            } 
        } 
        mario.draw(g); // dibuja al personaje
        
      //para cuando caes de la plataforma
        if (Jugador.y >= 850) {
        	vidas = vidas -1; 
        	Jugador.y = 700;
        	Jugador.x = 20;   }
    } 
} 