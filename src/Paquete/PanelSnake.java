package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelSnake extends JPanel{
    
    Color colorSnake = Color.green;
    Color colorComida = Color.red;
    int tamanoMax, tam, can,res;
    
    List<int[]> snake = new ArrayList<>();
    int[] comida = new int[2];
    
    String direccion="de";
    
    String direccionProxima = "";
    
    Thread hilo;
    Caminante camino;
    
    public PanelSnake(int tamanoMax, int can){
        this.tamanoMax=tamanoMax;
        this.can=10;
        this.tam=tamanoMax/can;
        this.res=tamanoMax%can;
        
        int[] a = {can/2-1, can/2-1};
        int[] b = {can/2, can/2-1};
        
        snake.add(a);
        snake.add(b);
        generarComida();
       
        
        camino = new Caminante(this);
        hilo = new Thread(camino);
        hilo.start();
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorSnake);
        
        //Pintando serpiente
        for(int[] par:snake){
            pintor.fillRect(par[0]*tam, par[1]*tam, tam-1, tam-1);
        }
        
        //Pintando comida
        pintor.setColor(colorComida);
        pintor.fillRect(comida[0]*tam, comida[1]*tam, tam-1, tam-1);

    }
    
    public void avanzar(){
        compararDireccion();
        
        int[] ultimo = snake.get(snake.size()-1);
        int agregarX = 0;
        int agregarY = 0;
        switch(direccion){
            case "de" -> agregarX=1;
            case "iz" -> agregarX=-1;
            case "ar" -> agregarY=1;
            case "ab" -> agregarY=-1;
        }
        
        int[] nuevo={Math.floorMod(ultimo[0]+agregarX, can), Math.floorMod(ultimo[1]+agregarY, can)};
        
        boolean existe = false;
        
        for(int i = 2; i<snake.size(); i++){
            if(nuevo[0] == snake.get(i)[0] && nuevo[1] == snake.get(i)[1]){
                existe = true;
                break;
            }
        }
        if(existe){
            JOptionPane.showMessageDialog(this, "Has perdido");
            hilo.stop();
            System.exit(0);
        } else {
            if(nuevo[0] == comida[0] && nuevo[1] == comida[1]){
                snake.add(nuevo);
                generarComida();
            } else {
                snake.add(nuevo);
                snake.remove(0);
            }
        }
    }
    
    public void generarComida(){
        int a = (int) (Math.random()*can);
        int b = (int) (Math.random()*can);
        
        boolean existe = false;
        
        for(int[] par:snake){
            if(par[0]==a && par[1]==b){
                existe = true;
                generarComida();
                break;
            }
        }
        if(!existe){
            this.comida[0]=a;
            this.comida[1]=b;
        }
    }
    
    public void cambiarDireccion(String dir){
        this.direccionProxima = dir;
    }
    
    public void compararDireccion(){
        this.direccion = this.direccionProxima;
    }
}