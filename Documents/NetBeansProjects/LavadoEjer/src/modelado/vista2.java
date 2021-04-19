/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public class vista2 extends JFrame{
   Date fec=new Date();
    SimpleDateFormat fech=new SimpleDateFormat("dd/MM/yyyy");
public JButton siguiente;
    private final JPanel panelB;
     private final JPanel pane2R;
public JLabel lResultado;
public JTextField empleadoreporte;
public vista2() {
    
getContentPane().setLayout(new BorderLayout());
panelB = new JPanel();
panelB.setLayout(new FlowLayout());
pane2R = new JPanel();
pane2R.setLayout(new FlowLayout());
siguiente = new JButton("siguiente");
lResultado = new JLabel("reporte por fecha 1,reporte por trabajador 2,reporte por tipo de servicio 3:");
empleadoreporte = new JTextField(20);
panelB.add(siguiente);
pane2R.add(lResultado);
pane2R.add(empleadoreporte);
add(panelB, BorderLayout.SOUTH);
add(pane2R, BorderLayout.WEST);
}
}
