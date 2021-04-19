/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavadoejer;
import modelado.Modelo;
import modelado.controlador;
import modelado.vista;
import modelado.vista2;


/**
 *
 * @author Andres
 */
public class LavadoEjer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

Modelo modelo = new Modelo();
vista vista = new vista();
vista2 vista2 = new vista2();
controlador controlador = new controlador(modelo, vista,vista2);
controlador.iniciarVista();
    }
    
}

