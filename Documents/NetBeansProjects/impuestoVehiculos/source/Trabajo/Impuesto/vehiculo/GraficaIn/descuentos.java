

package Trabajo.Impuesto.vehiculo.GraficaIn;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class descuentos extends JPanel
{
    private JCheckBox cbPPago;
    private JCheckBox cbSPublico;
    private JCheckBox cbTCuenta;

    public descuentos( )
    {
        setLayout( new GridLayout( 2, 2 ) );
        TitledBorder border = BorderFactory.createTitledBorder( "Descuentos" );
        border.setTitleColor( Color.MAGENTA);
        setBorder( border );
        cbPPago = new JCheckBox( "Pronto pago" );
        cbSPublico = new JCheckBox( "Servicio publico" );
        cbTCuenta = new JCheckBox( "Traslado de cuenta" );
        add( cbPPago );
        add( cbTCuenta );
        add( cbSPublico );
    }
    public boolean hayDescuentoProntoPago( )
    {
        return cbPPago.isSelected( );
    }
    public boolean hayDescuentoServicioPublico( )
    {
        return cbSPublico.isSelected( );
    }
    public boolean hayDescuentoTrasladoCuenta( )
    {
        return cbTCuenta.isSelected( );
    }
    public void limpiar( )
    {
        cbPPago.setSelected( false );
        cbSPublico.setSelected( false );
        cbTCuenta.setSelected( false );
    }
}