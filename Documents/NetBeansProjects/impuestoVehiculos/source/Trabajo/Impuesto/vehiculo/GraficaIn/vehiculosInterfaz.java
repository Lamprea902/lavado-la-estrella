//autores:Erika Johana Sanchez Rodriguez-Juan Esteban Moya Riaño-Andres David Lamprea Gamboa
package Trabajo.Impuesto.vehiculo.GraficaIn;

import Trabajo.Impuesto.vehiculo.Opciones.calculadoraImp;
import java.awt.*;

import javax.swing.*;

public class vehiculosInterfaz extends JFrame
{
    private calculadoraImp calculador;
    private vehiculo panelVehiculo;
    private descuentos panelDescuentos;
    private Resultados panelResultados;
    public vehiculosInterfaz( ) throws Exception
    {
        calculador = new calculadoraImp( );
        setTitle( "Calcular impuestos" );
        setSize( 290, 350 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLayout( new BorderLayout( ) );
        panelVehiculo = new vehiculo( this );
        add( panelVehiculo, BorderLayout.NORTH );
        panelDescuentos = new descuentos( );
        add( panelDescuentos, BorderLayout.CENTER );
        panelResultados = new Resultados( this );
        add( panelResultados, BorderLayout.SOUTH );
    }
    public void calcularPrecioVehiculo( )
    {
        String unaMarca = panelVehiculo.darMarca( );
        String unaLinea = panelVehiculo.darLinea( );
        String unModelo = panelVehiculo.darModelo( );
        if( unaMarca.equals( "" ) || unaLinea.equals( "" ) || unModelo.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "Por favor llene todos los datos", "Calculo de Impuestos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            try
            {
                double precio = calculador.buscarAvaluoVehiculo( unaMarca, unaLinea, unModelo );
                panelVehiculo.refrescarPrecio( precio );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Calculo de Impuestos", JOptionPane.WARNING_MESSAGE );
            }
        }
    }
    public void calcularImpuestos( )
    {
        String unaMarca = panelVehiculo.darMarca( );
        String unaLinea = panelVehiculo.darLinea( );
        String unModelo = panelVehiculo.darModelo( );
        if( unaMarca.equals( "" ) || unaLinea.equals( "" ) || unModelo.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "Por favor llene todos los datos", "Calculo de Impuestos", JOptionPane.ERROR_MESSAGE );
        }
        else
        {
            boolean descProntoPago = panelDescuentos.hayDescuentoProntoPago( );
            boolean descServicioPublico = panelDescuentos.hayDescuentoServicioPublico( );
            boolean descTrasladoCuenta = panelDescuentos.hayDescuentoTrasladoCuenta( );
            try
            {
                double pago = calculador.calcularPago( unaMarca, unaLinea, unModelo, descProntoPago, descServicioPublico, descTrasladoCuenta );
                panelResultados.refrescarPago( pago );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Calculo de Impuestos", JOptionPane.WARNING_MESSAGE );
            }
        }
    }
  
    public void limpiar( )
    {
        panelVehiculo.limpiar( );
        panelDescuentos.limpiar( );
        panelResultados.limpiar( );
    }
   
    public static void main( String[] args )
    {
        try
        {
            vehiculosInterfaz interfaz = new vehiculosInterfaz( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}