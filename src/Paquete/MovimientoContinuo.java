package Paquete;

import java.util.logging.Level;

public class MovimientoContinuo implements Runnable {

    Serpiente panel;
    boolean estado = true;
    
    menu menu = new menu();
    double inter = menu.intervalo;
    double a =  833*inter;
    int b = (int) a;

    
    public MovimientoContinuo(Serpiente panel){
        this.panel = panel;
    }
    
    @Override
    public void run() {
        while(estado){
            panel.avanzar();
            panel.repaint();
            try {
                Thread.sleep(b);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(MovimientoContinuo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void parar(){
        this.estado = false;
    }
}