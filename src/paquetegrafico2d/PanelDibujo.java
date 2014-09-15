/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetegrafico2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class PanelDibujo extends JPanel implements KeyListener{
    public int minH = 0;
    public int maxH; 
    public int maxW;
    public Transformaciones transformaciones;    
    public int [][] CoordenadasCasa = {{400,150}, {500,150}, {400,150},
        {400,100},{500,150},{500,100}, {500,100}, {450,50}, {400,100}, {450,50}};
    public Graphics2D g2d;
    public PanelDibujo( ){
            this.setBackground(Color.BLACK);
            this.setFocusable(true);
            this.requestFocus();
            this.requestFocusInWindow();
            this.addKeyListener(this);
    }
    @Override
     public void paintComponent( Graphics g){
        maxH = this.getHeight();
        maxW = this.getWidth();
      transformaciones = new Transformaciones(this);
          
      super.paintComponent(g);
      g2d = (Graphics2D) g;
      g2d.setColor(Color.green);
      g2d.setStroke(new BasicStroke(4));
      this.drawHouse(g2d);
      
    }
     
    public void resetHouse(){
     int [][] matrizDefeto = {{400,150}, {500,150}, {400,150},
        {400,100},{500,150},{500,100}, {500,100}, {450,50}, {400,100}, {450,50}};
     this.CoordenadasCasa = matrizDefeto;
    }
    
     public void drawHouse(Graphics g){
        for(int f = 0; f < CoordenadasCasa.length-1; f += 2){
            for(int c = 0; c < CoordenadasCasa[f].length-1; c++){
                  g.drawLine(CoordenadasCasa[f][c], CoordenadasCasa[f][c+1], 
                             CoordenadasCasa[f+1][c], CoordenadasCasa[f+1][c+1]);}
                }
             }
     

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                transformaciones.Traslacion(0, -15);
                break;
            case KeyEvent.VK_DOWN:
                transformaciones.Traslacion(0, 15);
                break;
            case KeyEvent.VK_LEFT:
                transformaciones.Traslacion(-15, 0);
                break;
            case KeyEvent.VK_RIGHT :
                transformaciones.Traslacion(15, 0);
                break;
     }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}    
}