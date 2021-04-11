
package Trabajo.Impuesto.vehiculo.GraficaIn;

import java.awt.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;
import javax.swing.border.*;

public class vehiculo extends JPanel implements ActionListener
{
    public final static String BUSCAR = "buscar";

    private vehiculosInterfaz principal;
    private JTextField txtMarca;
    private JTextField txtLinea;
    private JTextField txtModelo;
    private JTextField txtValor;
    private JLabel labMarca;
    private JLabel labLinea;
    private JLabel labModelo;
    private JLabel labValor;
    private JButton butBuscar;
    public vehiculo( vehiculosInterfaz principalP )
    {
        principal = principalP;
        setLayout( new GridLayout( 5, 2 ) );
        setPreferredSize( new Dimension( 0, 130 ) );
        TitledBorder border = BorderFactory.createTitledBorder( "Datos del vehiculo" );
        border.setTitleColor( Color.ORANGE);
        setBorder( border );
        labMarca = new JLabel( "Marca" );
        labLinea = new JLabel( "Linea" );
        labModelo = new JLabel( "Modelo" );
        labValor = new JLabel( "Valor" );
        txtMarca = new JTextField("");
        txtLinea = new JTextField("");
        txtModelo = new JTextField("");
        txtValor = new JTextField( "$ 0" );
        txtValor.setEditable( false );
        txtValor.setForeground( Color.BLUE );
        txtValor.setBackground( Color.LIGHT_GRAY );
        butBuscar = new JButton( "Buscar" );
        butBuscar.setActionCommand( BUSCAR );
        butBuscar.addActionListener( this );
        add( labMarca );
        add( txtMarca );
        add( labLinea );
        add( txtLinea );
        add( labModelo );
        add( txtModelo );
        add( labValor );
        add( txtValor );
        add( new JLabel( "" ) );
        add( butBuscar );
    }
    public void refrescarPrecio( double precio )
    {
        //Despliega el valor del veh�culo
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        txtValor.setText( df.format( precio ) );
    }
    public String darMarca( )
    {
        return txtMarca.getText( );
    }
    public String darLinea( )
    {
        return txtLinea.getText( );
    }
    public String darModelo( )
    {
        return txtModelo.getText( );
    }

    public void limpiar( )
    {
        txtMarca.setText( "" );
        txtLinea.setText( "" );
        txtModelo.setText( "" );
        txtValor.setText( "$ 0" );
    }
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( comando.equals( BUSCAR ) )
        {
            principal.calcularPrecioVehiculo( );
        }
    }
}