package Paquete;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Cuadricula extends JPanel{
    
    Color colorFondo = Color.gray;
    int tamanoMax, tam, can,res;
    
    public Cuadricula(int tamanoMax, int can){
        this.tamanoMax=tamanoMax;
        this.can=10;
        this.tam=tamanoMax/can;
        this.res=tamanoMax%can;
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorFondo);
        
        for(int i=0; i<can; i++){
            for(int j=0; j<can; j++){
                pintor.fillRect(i*tam, j*tam, tam-1, tam-1);
            }
        }
    }
}