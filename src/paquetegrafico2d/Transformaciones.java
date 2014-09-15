/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetegrafico2d;

import java.awt.Toolkit;

/**
 *
 * @author Usuario
 */
public class Transformaciones{
 
        //P' = P+T
    /*
     * [X1']    [X1]          [Tx]
     *      =             +
     * [X2']    [X2]          [Ty]
     */
    public PanelDibujo pD;
    public Transformaciones(PanelDibujo p){
    this.pD = p;
    }
    
    public void Traslacion(int tx, int  ty){  
        if(tx != 0){
            //X mayor o menor al sumarle el dy se sale de la pantalla?     
            if(pD.CoordenadasCasa[0][0]+tx < 5 || pD.CoordenadasCasa[1][0]+tx > pD.maxW-5){
                Toolkit.getDefaultToolkit().beep();
            }else{
                for(int f = 0; f < pD.CoordenadasCasa.length; f++){
                    for(int c = 0; c < pD.CoordenadasCasa[f].length-1; c++){
                    pD.CoordenadasCasa[f][c] += tx;
                    }
                }
            }
        }else{
        if(ty != 0 ){
            //Y mayor Casa al sumarle el dy se sale de la pantalla?
            int yMax = ty+pD.CoordenadasCasa[0][1];
            int alturaCasa = pD.CoordenadasCasa[0][1]-pD.CoordenadasCasa[7][1];
              if( yMax > pD.maxH-5 || yMax <= alturaCasa){
                Toolkit.getDefaultToolkit().beep();
                }else{
                for(int f = 0; f < pD.CoordenadasCasa.length; f++){
                   for(int c = 1; c < pD.CoordenadasCasa[f].length; c++){
                         pD.CoordenadasCasa[f][c] += ty;
                   }
                }}
            
                       }
        }
       pD.repaint();
    }
    
        //P' = S*P
    /*
     * [X']    [Sx  0]          [X]
     *      =             *
     * [Y']    [0  Sy]          [Y]
     */
    public void Escalar(float sx, float sy){
    float yMax = sy*pD.CoordenadasCasa[0][1];
    if((pD.CoordenadasCasa[0][0]*sx < 5 || pD.CoordenadasCasa[1][0]*sx > pD.maxW-5) || (yMax > pD.maxH-5 || yMax <= 100)){
    Toolkit.getDefaultToolkit().beep();
    }else{
    int fil = 0;
    float [][] escalamiento = {{sx,0},{0, sy}};
           for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               fil = 0;
                for(int c = 0; c < pD.CoordenadasCasa[f].length; c++){
                   pD.CoordenadasCasa[f][c] *= escalamiento[fil][c];
                   fil = 1;
                   }
                }

           pD.repaint();
    }
    }
    
    public void Rotacion(double angulo){
        angulo = Math.toRadians(angulo);
        double [][] rotacion = {{Math.cos(angulo),-Math.sin(angulo)},
                               {Math.sin(angulo),Math.cos(angulo)}};

        //System.err.println(rotacion[1][0]);
        //System.err.println(rotacion[0][0]);
           for(int f = 0; f < pD.CoordenadasCasa.length; f++){
               
               //x*cos(a) + y*(-sen(a))
                   int x1 = (int) (pD.CoordenadasCasa[f][0] * rotacion[0][0]);
                   x1 += pD.CoordenadasCasa[f][1] * rotacion[0][1];
               //x*sen(a) + y*cos(a)    
                   int y1 = (int) (pD.CoordenadasCasa[f][0] * rotacion[1][0]);
                   y1 += pD.CoordenadasCasa[f][1] * rotacion[1][1];
                  //X0 -> X1; Y0 -> Y1;
                  pD.CoordenadasCasa[f][0] = x1;
                  pD.CoordenadasCasa[f][1] = y1;
                }
           pD.repaint();
    }
   
}
