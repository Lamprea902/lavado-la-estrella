
package Trabajo.Impuesto.vehiculo.Opciones;

import java.util.*;

public class Marca
{
    private String nombre;
    private ArrayList lineas;

    public Marca( String elNombre )
    {
        nombre = elNombre;
        lineas = new ArrayList( );
    }
    public String darNombre( )
    {
        return nombre;
    }
    public ArrayList darLineas( )
    {
        return lineas;
    }
    public Linea buscarLinea( String nombreLinea )
    {
        Linea linea = null;
        for( int i = 0; i < lineas.size( ) && linea == null; i++ )
        {
            Linea lineaAux = ( Linea )lineas.get( i );
            if( lineaAux.darNombre( ).equalsIgnoreCase( nombreLinea ) )
                linea = lineaAux;
        }
        return linea;
    }
    public void adicionarLinea( Linea unaLinea )
    {
        if( buscarLinea( unaLinea.darNombre( ) ) == null )
        {
            lineas.add( unaLinea );
        }
    }
}