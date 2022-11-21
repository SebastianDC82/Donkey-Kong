package paquete.clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Personajes extends Rectangle {
	public Personajes(int x4, int y4) {
		setBounds(x4, y4, 20, 20); 
	}

	
	// draws characters onto stage
	public void dibujar(Graphics g) {
						
		//Chica
		g.setColor(Color.yellow);
		g.fillRect(x+8, y-78, width+12, height*2); //Cabello
		g.fillRect(x+8, y-75, width+10, height*2); //Cabello
		g.fillRect(x+8, y-65, width*2, height*2); //Cabello
		g.setColor(Color.pink);
		g.fillRect(x+15, y-75, width, height*2); //Cabeza
		g.fillRect(x+20, y-65, width/2, height*2); //Cuello
		g.setColor(Color.blue);
		//Ojos Chica
		g.fillRect(x+20, y-68, width/8, height/3);
		g.fillRect(x+28, y-68, width/8, height/3);
		g.setColor(Color.red);
		//Pies
		g.fillRect(x+27, y, width/2, height);
		g.fillRect(x+12, y, width/2, height);
		//Vestido
		g.setColor(Color.magenta);
		g.fillRect(x-5, y-10, width, height);
		g.fillRect(x+15, y-10, width, height);
		g.fillRect(x+35, y-10, width, height);
		g.setColor(Color.white);
		g.fillRect(x, y-20, width, height);
		g.fillRect(x+15, y-20, width, height);
		g.fillRect(x+30, y-20, width, height);
		g.setColor(Color.magenta);
		g.fillRect(x, y-25, width, height);
		g.fillRect(x+15, y-25, width, height);
		g.fillRect(x+30, y-25, width, height);
		g.setColor(Color.white);
		g.fillRect(x+5, y-35, width, height);
		g.fillRect(x+20, y-35, width, height);
		g.fillRect(x+25, y-35, width, height);
		g.setColor(Color.magenta);
		g.fillRect(x+5, y-40, width, height);
		g.fillRect(x+20, y-40, width, height);
		g.fillRect(x+25, y-40, width, height);
		g.setColor(Color.white);
		g.fillRect(x+15, y-50, width, height);
		g.setColor(Color.magenta);
		g.fillRect(x+15, y-50, width/4, height);
		g.fillRect(x+30, y-50, width/4, height);
		g.setColor(Color.pink);
		g.fillRect(x+40, y-40, width/2, height/2); //brazo derecho
		g.fillRect(x, y-40, width/2, height/2); //brazo izquierdo
		
		//Donkey Kong 		
		//pierna izquierda
		g.setColor(Color.orange);
		g.fillOval((int) x-260, (int) y-26, width+8, height+15);
		//pie izquierdo
		g.fillRect((int) x-262, (int) y, width+8, height/2);
		g.fillOval((int) x-262, (int) y-8, width+8, height-5);
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int) x-259, (int) y-2, width+3, height/2-1);
		g.fillOval((int) x-259, (int) y-10, width+3, height-3);
        //cabeza y cuerpo
		g.setColor(Color.orange);
		g.fillOval((int) x-250, (int) y-92, width+30, height+40); 
		g.fillOval((int) x-250, (int) y-62, width+30, height+50); 
		//nariz
		g.fillOval((int) x-260, (int) y-80, width+10, height+8);
		
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-245, (int) y-88, width+20, height+30);
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-245, (int) y-58, width+20, height+40);
		//nariz
		g.fillOval((int) x-255, (int) y-78, width+7, height+5);
		//nariz rosada
		g.setColor(Color.pink);
		g.fillOval((int) x-257, (int) y-79, width+5, height+7);
		//orificios nariz
		g.setColor(Color.black);
		g.fillRect((int) x-254, (int) y-70, width/6, height/6);
		g.fillRect((int) x-249, (int) y-70, width/6, height/6);
		//ojo
		g.setColor(Color.white);
		g.fillOval((int) x-225, (int) y-80, width/2, height/2);
		g.setColor(Color.black);
		g.fillOval((int) x-222, (int) y-76, width/2-5, height/2-5);
		//ojo molesto
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int) x-225, (int) y-81, width/2-5, height/2-5);
		g.fillRect((int) x-225, (int) y-82, width/2-5, height/2-5);
		g.fillRect((int) x-223, (int) y-82, width/2-5, height/2-5);
		//boca
		g.setColor(Color.red);
		g.fillRect((int) x-252, (int) y-60, width/2, height/6);
		g.fillRect((int) x-242, (int) y-58, width/6, height/6);
		//orejas
		g.setColor(Color.ORANGE);
		g.fillOval((int) x-205, (int) y-75, width/2, height/2);
		g.fillOval((int) x-210, (int) y-85, width/2, height/2-3);
		//brazos
		g.setColor(Color.orange);
		g.fillOval((int) x-270, (int) y-40, width+8, height/2);
		g.setColor(Color.orange);
		g.fillOval((int) x-230, (int) y-66, width+8, height+5); 
		g.fillRect((int) x-242, (int) y-52, width+7, height/2); 
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-266, (int) y-38, width+5, height/2-3);
		g.fillOval((int) x-248, (int) y-46, width+2, height*2);
		g.setColor(Color.orange);
		g.fillOval((int) x-238, (int) y-46, width+27, height+1);
		g.setColor(Color.DARK_GRAY);		
		g.fillOval((int) x-240, (int) y-45, width+25, height);
		//torso
		g.setColor(Color.pink);
		g.fillOval((int) x-238, (int) y-46, width+2, height*2);
		//corbata
		g.setColor(Color.red);
		g.fillOval((int) x-232, (int) y-40, width/2, height+5);
		g.fillRect((int) x-246, (int) y-47, width+16, height/5);
		g.fillRect((int) x-213, (int) y-48, width/2, height/5);
		g.fillRect((int) x-233, (int) y-45, width-6, height-10);
		//pierna derecha
		g.setColor(Color.orange);
		g.fillOval((int) x-222, (int) y-28, width+8, height+17); 
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-255, (int) y-26, width+2, height+10); 
		g.fillOval((int) x-223, (int) y-28, width+5, height+14); 
		//pies
		g.setColor(Color.orange);
		g.fillRect((int) x-222, (int) y, width+8, height/2);
		g.fillOval((int) x-222, (int) y-8, width+8, height-5);
		g.setColor(Color.DARK_GRAY);
		g.fillRect((int) x-219, (int) y-2, width+3, height/2-1);
		g.fillOval((int) x-219, (int) y-10, width+3, height-3);
		
		
		//barriles
		g.setColor(Color.orange);
		g.fillOval((int) x-340, (int) y-20, width+10, height+10); 
		g.fillOval((int) x-310, (int) y-20, width+10, height+10); 
		g.fillOval((int) x-280, (int) y-20, width+10, height+10); 
		g.fillOval((int) x-325, (int) y-46, width+10, height+10); 
		g.fillOval((int) x-295, (int) y-46, width+10, height+10); 
		g.fillOval((int) x-310, (int) y-72, width+10, height+10); 
		//medio de los barriles
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-335, (int) y-18, width, height); 
		g.fillOval((int) x-305, (int) y-18, width, height); 
		g.fillOval((int) x-275, (int) y-18, width, height); 
		g.fillOval((int) x-320, (int) y-44, width, height); 
		g.fillOval((int) x-290, (int) y-44, width, height); 
		g.fillOval((int) x-305, (int) y-70, width, height); 
		//centro de los barriles		
		g.setColor(Color.orange);
		g.fillOval((int) x-330, (int) y-16, width/3, height/3); 
		g.fillOval((int) x-300, (int) y-16, width/3, height/3); 
		g.fillOval((int) x-270, (int) y-16, width/3, height/3); 
		g.fillOval((int) x-315, (int) y-42, width/3, height/3); 
		g.fillOval((int) x-285, (int) y-42, width/3, height/3); 
		g.fillOval((int) x-300, (int) y-68, width/3, height/3); 
		
		
		//barriles 2 (segunda plataforma)
		g.setColor(Color.orange);
		g.fillOval((int) x-340+(718), (int) y-20+(300), width+10, height+10); 
		g.fillOval((int) x-310+(718), (int) y-20+(300), width+10, height+10); 
		g.fillOval((int) x-280+(718), (int) y-20+(300), width+10, height+10); 
		g.fillOval((int) x-325+(718), (int) y-46+(300), width+10, height+10); 
		g.fillOval((int) x-295+(718), (int) y-46+(300), width+10, height+10); 
		g.fillOval((int) x-310+(718), (int) y-72+(300), width+10, height+10); 
		//medio de los barriles
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-335+(718), (int) y-18+(300), width, height); 
		g.fillOval((int) x-305+(718), (int) y-18+(300), width, height); 
		g.fillOval((int) x-275+(718), (int) y-18+(300), width, height); 
		g.fillOval((int) x-320+(718), (int) y-44+(300), width, height); 
		g.fillOval((int) x-290+(718), (int) y-44+(300), width, height); 
		g.fillOval((int) x-305+(718), (int) y-70+(300), width, height); 
		//centro de los barriles		
		g.setColor(Color.orange);
		g.fillOval((int) x-330+(718), (int) y-16+(300), width/3, height/3); 
		g.fillOval((int) x-300+(718), (int) y-16+(300), width/3, height/3); 
		g.fillOval((int) x-270+(718), (int) y-16+(300), width/3, height/3); 
		g.fillOval((int) x-315+(718), (int) y-42+(300), width/3, height/3); 
		g.fillOval((int) x-285+(718), (int) y-42+(300), width/3, height/3); 
		g.fillOval((int) x-300+(718), (int) y-68+(300), width/3, height/3); 
		
		//barriles 3 (ultima plataforma)
		g.setColor(Color.orange);
		g.fillOval((int) x-340+(668), (int) y-20+(600), width+10, height+10); 
		g.fillOval((int) x-310+(668), (int) y-20+(600), width+10, height+10); 
		g.fillOval((int) x-280+(668), (int) y-20+(600), width+10, height+10); 
		g.fillOval((int) x-325+(668), (int) y-46+(600), width+10, height+10); 
		g.fillOval((int) x-295+(668), (int) y-46+(600), width+10, height+10); 
		g.fillOval((int) x-310+(668), (int) y-72+(600), width+10, height+10); 
		//mitad de los barriles
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) x-335+(668), (int) y-18+(600), width, height); 
		g.fillOval((int) x-305+(668), (int) y-18+(600), width, height); 
		g.fillOval((int) x-275+(668), (int) y-18+(600), width, height); 
		g.fillOval((int) x-320+(668), (int) y-44+(600), width, height); 
		g.fillOval((int) x-290+(668), (int) y-44+(600), width, height); 
		g.fillOval((int) x-305+(668), (int) y-70+(600), width, height); 
		//centro de los barriles		
		g.setColor(Color.orange);
		g.fillOval((int) x-330+(668), (int) y-16+(600), width/3, height/3); 
		g.fillOval((int) x-300+(668), (int) y-16+(600), width/3, height/3); 
		g.fillOval((int) x-270+(668), (int) y-16+(600), width/3, height/3); 
		g.fillOval((int) x-315+(668), (int) y-42+(600), width/3, height/3); 
		g.fillOval((int) x-285+(668), (int) y-42+(600), width/3, height/3); 
		g.fillOval((int) x-300+(668), (int) y-68+(600), width/3, height/3); 

		//barril de aceite
		g.setColor(Color.blue);
		g.fillRect(x-550, y+550, width*2, height*3);
		g.setColor(Color.LIGHT_GRAY);
		//borde del barril de aceite
		g.fillRect(x-540, y+550, width, height/2);
		g.fillRect(x-545, y+550, width, height/3);
		g.fillRect(x-535, y+550, width, height/3);
		//letras del barril de aceite
		g.fillRect(x-542, y+580, width/2, height/2);
		g.setColor(Color.blue);
		g.fillRect(x-540, y+583, width/4, height/4);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x-529, y+580, width/7, height/7);
		g.fillRect(x-530, y+584, width/5, height/3);
		g.fillRect(x-523, y+586, width/3, height/5);
		g.fillRect(x-523, y+580, width/6, height/2);
	
		if (PanelDeJuego.ContadorDeTicks > 4390) { //cuando los barriles tocan el barril de aceite se prende en fuego
		//fuego
		g.setColor(Color.red);
		g.fillRect(x-540, y+534, width-1, height);
		g.fillRect(x-548, y+540, width, height-10);
		g.fillRect(x-532, y+540, width, height-10);
		g.setColor(Color.orange);
		g.fillRect(x-538, y+540, width-5, height/2);
		g.fillRect(x-548, y+550, width, height/5);
		g.fillRect(x-532, y+550, width, height/5);
		g.setColor(Color.yellow);
		g.fillRect(x-535, y+545, width/2, height/2);
		g.setColor(Color.red);
		g.fillRect(x-532, y+550, width/5, height/4);
		}

	}

}