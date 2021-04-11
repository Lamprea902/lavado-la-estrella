
package Trabajo.Impuesto.vehiculo.Opciones;

import java.util.*;
public class Linea
{
    private String nombre;
    private ArrayList modelos;
    public Linea( String elNombre )
    {
        nombre = elNombre;
        modelos = new ArrayList( );
    }
    public String darNombre( )
    {
        return nombre;
    }
    public ArrayList darModelos( )
    {
        return modelos;
    }
    public Modelo buscarModelo( String anio )
    {
        Modelo modelo = null;
        for( int i = 0; i < modelos.size( ) && modelo == null; i++ )
        {
            Modelo modeloAux = ( Modelo )modelos.get( i );
            if( modeloAux.darAnio( ).equals( anio ) )
                modelo = modeloAux;
        }
        return modelo;
    }

    public void adicionarModelo( Modelo unModelo )
    {
        modelos.add( unModelo );
    }
}