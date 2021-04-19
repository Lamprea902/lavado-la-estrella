/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class controlador implements ActionListener {
private final Modelo modelo;
private final vista vista;
private final vista2 vista2;
private String cantidad;
public controlador(Modelo modelo, vista vista,vista2 vista2) {
  this.vista2 = vista2;
 this.modelo = modelo;
 this.vista = vista;
 this.vista.siguiente.addActionListener(this);
 this.vista.total.addActionListener(this);
}
public void iniciarVista() {
vista.setTitle("Lavados de Autos La Estrella");
vista.pack();
vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
vista.setLocationRelativeTo(null);
vista.setVisible(true);
}
public void iniciarVista2() {
vista2.setTitle("Lavados de Autos La Estrella");
vista2.pack();
vista2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
vista2.setLocationRelativeTo(null);
vista2.setVisible(true);
}
@Override
public void actionPerformed(ActionEvent evento) {
 if(vista. siguiente== evento.getSource()) {
if(!"".equals(vista.empleado.getText())&&!"".equals(vista.servicio.getText())&&!"".equals(vista.tipoVeh.getText())) {
 try{
     
modelo.setfecha(vista.fecha.getText());
cantidad = vista.empleado.getText();
modelo.setEmpleados(cantidad);
cantidad=vista.servicio.getText();
modelo.setLavado(cantidad);
cantidad=vista.tipoVeh.getText();
modelo.setVehiculo(cantidad);

     JOptionPane.showMessageDialog(null, "informacion guardada");
     vista.empleado.setText("");
     vista.servicio.setText("");
     vista.tipoVeh.setText("");

 }catch(NumberFormatException e) {
vista.lResultado.setText("Introduzca una cantidad valida...");
 }
}
 }
 else {if(vista.total == evento.getSource()) {
iniciarVista2();
if(vista2.siguiente==evento.getSource()){
    if(!"".equals(vista2.empleadoreporte.getText())){
        switch(Integer.parseInt(vista2.empleadoreporte.getText())){
            case 1:
                ;
            case 2:
                ;
            case 3:
                ;
                        }
        
                        }
}
}
}
}
}