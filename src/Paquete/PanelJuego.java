package Paquete;

import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PanelJuego extends javax.swing.JFrame {
    
    Serpiente panel;
    public static int movimientos =0;
    
    
    
    public PanelJuego() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        panel = new Serpiente(800,10);
        this.add(panel);
        panel.setBounds(10,10,800,800);
        panel.setOpaque(false);
        
        Cuadricula fondo = new Cuadricula(800,10);
        this.add(fondo);
        fondo.setBounds(10,10,800,800);
        
        this.requestFocus(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jButton1.setText("Generar Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton2.setText("Λ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton3.setText("V");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jButton5.setText("<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(809, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(126, 126, 126)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(558, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                panel.cambiarDireccion("iz");
                break;
            case KeyEvent.VK_RIGHT:
                panel.cambiarDireccion("de");
                break;
            case KeyEvent.VK_UP:
                panel.cambiarDireccion("ab");
                break;
            case KeyEvent.VK_DOWN:
                panel.cambiarDireccion("ar");
                break;
            default:
                break;
        }
    }//GEN-LAST:event_formKeyPressed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menu menu = new menu();
        
        int puntos = panel.snake.size();
        
        String nombre = "Sergio Andrés Larios Fajardo";
        int puntacion = puntos;
        String dificultad = menu.dificultad;
        int moves = movimientos;
        long tiempo = System.currentTimeMillis()/100000000;
        
        File archivo = new File("reports\\snake.html");
        
        FileWriter write;

        PrintWriter newLine;

        if(!archivo.exists()){
            try {
                archivo.createNewFile();
                write = new FileWriter(archivo,true);
                newLine = new PrintWriter(write);
                newLine.println("<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "    <meta charset=\"UTF-8\">\n" +
                                    "    <title>Document</title>\n" +
                                    "</head>\n" +
                                    "<body>");

                newLine.println("<h1>Sergio Andrés Larios Fajardo</h1>");
                newLine.println("<table>");

                    newLine.println("<tr>");
                        newLine.println("<th> Jugador </th>");
                        newLine.println("<th> Dificultad</th>");
                        newLine.println("<th> Tiempo</th>");
                        newLine.println("<th> Puntuación</th>");
                        newLine.println("<th> Movimientos </th>");
                    newLine.println("</tr>");


                    newLine.println("<tr>");
                        newLine.println("<td>" + nombre + "</td>");
                        newLine.println("<td>" + dificultad + "</td>");
                        newLine.println("<td>" + tiempo + " ms</td>");;
                        newLine.println("<td>" + puntacion + "</td>");
                        newLine.println("<td>" + moves + "</td>");
                    newLine.println("</tr>");


                newLine.println("</table>");

                // ---------------------------
                newLine.println("</body>\n" +
                                   "</html>");
                write.close();


            } catch (Exception e) {

            }
        }else{
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("reports\\snake.html"));
                bw.write("");


                write = new FileWriter(archivo,true);
                newLine = new PrintWriter(write);
                newLine.println("<!DOCTYPE html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "    <meta charset=\"UTF-8\">\n" +
                                    "    <title>Document</title>\n" +
                                    "</head>\n" +
                                    "<body>");

                newLine.println("<h1>Sergio Andrés Larios Fajardo</h1>");
                newLine.println("<table>");

                    newLine.println("<tr>");
                        newLine.println("<th> Jugador </th>");
                        newLine.println("<th> Dificultad</th>");
                        newLine.println("<th> Tiempo</th>");
                        newLine.println("<th> Puntuación</th>");
                        newLine.println("<th> Movimientos </th>");
                    newLine.println("</tr>");


                    newLine.println("<tr>");
                        newLine.println("<td>" + nombre + "</td>");
                        newLine.println("<td>" + dificultad + "</td>");
                        newLine.println("<td>" + tiempo + " ms</td>");;
                        newLine.println("<td>" + puntacion + "</td>");
                        newLine.println("<td>" + moves + "</td>");
                    newLine.println("</tr>");


                newLine.println("</table>");

                // ---------------------------
                newLine.println("</body>\n" +
                                   "</html>");
                write.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panel.cambiarDireccion("ab");
        movimientos = movimientos + 1;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        panel.cambiarDireccion("ar");
        movimientos = movimientos + 1;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        panel.cambiarDireccion("de");
        movimientos = movimientos + 1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        panel.cambiarDireccion("iz");
        movimientos = movimientos + 1;
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
}