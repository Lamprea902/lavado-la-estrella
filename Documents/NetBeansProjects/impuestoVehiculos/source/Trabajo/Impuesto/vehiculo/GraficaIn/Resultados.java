
package Trabajo.Impuesto.vehiculo.GraficaIn;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.border.*;

public class Resultados extends JPanel implements ActionListener
{

    public final static String LIMPIAR = "limpiar";
    public final static String CALCULAR = "calcular";
    private vehiculosInterfaz principal;
    private JLabel labTotal;
    private JTextField txtTotal;
    private JButton butLimpiar;
    private JButton butCalcular;
   
    public Resultados( vehiculosInterfaz principalP )
    {
        principal = principalP;
        setLayout( new GridLayout( 4, 3 ) );
        setPreferredSize( new Dimension( 0, 105 ) );
        TitledBorder border = BorderFactory.createTitledBorder( "Resultados" );
        border.setTitleColor( Color.GREEN );
        setBorder( border );
        labTotal = new JLabel( "Total a pagar" );
        txtTotal = new JTextField( "$ 0" );
        txtTotal.setEditable( false );
        txtTotal.setForeground( Color.BLUE );
        txtTotal.setBackground( Color.LIGHT_GRAY );
        butLimpiar = new JButton( "Limpiar" );
        butLimpiar.setActionCommand( LIMPIAR );
        butLimpiar.addActionListener( this );
        butCalcular = new JButton( "Calcular" );
        butCalcular.setActionCommand( CALCULAR );
        butCalcular.addActionListener( this );
       
        add( new JLabel( "" ) );
        add( new JLabel( "" ) );
        add( butLimpiar );
        add( labTotal );
        add( txtTotal );
        add( butCalcular );
        add( new JLabel( "" ) );
        add( new JLabel( "" ) );
        add( new JLabel( "" ) );
        add( new JLabel( "" ) );
        
    }
    public void refrescarPago( double pago )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        txtTotal.setText( df.format( pago ) );
    }
    public void limpiar( )
    {
        txtTotal.setText( "$ 0" );
    }
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );
        if( comando.equals( LIMPIAR ) )
        {
            principal.limpiar( );
        }
        else if( comando.equals( CALCULAR ) )
        {
            principal.calcularImpuestos( );
        }
    }
}