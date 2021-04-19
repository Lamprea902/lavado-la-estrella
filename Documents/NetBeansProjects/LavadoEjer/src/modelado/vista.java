/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Date;
import java.text.SimpleDateFormat;
public class vista extends JFrame{
    Date fec=new Date();
    SimpleDateFormat fech=new SimpleDateFormat("dd/MM/yyyy");
public JButton siguiente, total;
    private final JPanel panelB;
    private final JPanel panelR;
     private final JPanel pane2R;
     private final JPanel pane3R;
public JLabel lResultado;
public JTextField empleado;
public JTextField servicio;
public JTextField tipoVeh;
public JLabel fecha;
public JLabel Resultado;
public JLabel Resultado2;
public JLabel Resultado3;
public vista() {
    
getContentPane().setLayout(new BorderLayout());
panelB = new JPanel();
panelB.setLayout(new FlowLayout());
panelR = new JPanel();
panelR.setLayout(new FlowLayout());
pane3R = new JPanel();
pane3R.setLayout(new FlowLayout());
pane2R = new JPanel();
pane2R.setLayout(new FlowLayout());
siguiente = new JButton("siguiente vehiculo");
total = new JButton("reporte");
lResultado = new JLabel("trabajador:");
Resultado2 = new JLabel("tipo vehiculo:");
Resultado=new JLabel("servicio:");
Resultado3=new JLabel("fecha");
empleado = new JTextField(20);
servicio=new JTextField(20);
tipoVeh=new JTextField(20);
fecha=new JLabel(fech.format(fec));
panelB.add(siguiente);
panelB.add(total);
pane3R.add(Resultado3);
pane3R.add(fecha);
pane2R.add(lResultado);
pane2R.add(empleado);
panelR.add(Resultado);
panelR.add(servicio);
panelR.add(Resultado2);
panelR.add(tipoVeh);

add(panelB, BorderLayout.SOUTH);
add(panelR, BorderLayout.CENTER);
add(pane3R, BorderLayout.NORTH);
add(pane2R, BorderLayout.WEST);
}
}