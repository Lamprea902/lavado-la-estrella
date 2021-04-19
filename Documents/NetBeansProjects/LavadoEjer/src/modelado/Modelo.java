/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import javax.swing.JLabel;

public class Modelo {
private String empleados;
private String lavado;
private String vehiculo;
private String fecha;
public void setfecha(String fecha){
    this.fecha=fecha;
}
public void setEmpleados(String empleados) {
 this.empleados = empleados;
}
public void setLavado(String lavado) {
 this.lavado = lavado;
}
public void setVehiculo(String vehiculo) {
 this.vehiculo= vehiculo;
}

public String getEmpleado(){
    String emple[]=new String[30];
    int i=0;
        emple[i]=empleados;
    i++;
    return null;
}
public int gettipolavado (){
    if("lavado basico".equals(lavado)){
        
    }
    return 0;
}
public int setcombos (){
    
    return 0;
}

    void setfecha(JLabel fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}