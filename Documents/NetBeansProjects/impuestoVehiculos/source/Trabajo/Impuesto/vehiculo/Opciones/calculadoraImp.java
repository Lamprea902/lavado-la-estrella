
package Trabajo.Impuesto.vehiculo.Opciones;

import java.io.*;
import java.util.*;

public class calculadoraImp
{
    public static final double PORC_DESC_PRONTO_PAGO = 10.0;
    public static final double VALOR_DESC_SERVICIO_PUBLICO = 50000.0;
    public static final double PORC_DESC_TRASLADO_CUENTA = 5.0;
    private ArrayList marcas;
    private ArrayList rangosImpuesto;
    public calculadoraImp( ) throws Exception
    {
        marcas = new ArrayList( );
        rangosImpuesto = new ArrayList( );
        cargarVehiculos( "data/vehiculos.txt" );
        cargarTablaImpuestos( "data/impuestos.properties" );
    }
    private Marca buscarMarca( String nombre )
    {
        Marca marca = null;
        for( int i = 0; i < marcas.size( ) && marca == null; i++ )
        {
            Marca marcaAux = ( Marca )marcas.get( i );
            if( marcaAux.darNombre( ).equalsIgnoreCase( nombre ) )
                marca = marcaAux;
        }
        return marca;
    }
    private void adicionarMarca( Marca unaMarca )
    {
        if( buscarMarca( unaMarca.darNombre( ) ) == null )
            marcas.add( unaMarca );
    }
    private void cargarVehiculos( String archivo ) throws Exception
    {
        Marca marca;
        Linea linea;
        Modelo modelo;
        String texto, valores[], sMarca, sLinea, sModelo;
        double precio;
        BufferedReader lector;
        try
        {
            File datos = new File( archivo );
            lector = new BufferedReader( new FileReader( datos ) );
            texto = lector.readLine( );
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los datos almacenados de veh�culos" );
        }

        while( texto != null )
        {
            if( !texto.startsWith( "#" ) && !texto.equals( "" ) )
            {
                valores = texto.split( "," );

                if( valores.length < 3 )
                    throw new Exception( "Faltan datos l�nea: " + texto );

                sMarca = valores[ 0 ];
                sLinea = valores[ 1 ];
                sModelo = valores[ 2 ];
                try
                {
                    precio = Double.parseDouble( valores[ 3 ] );
                }
                catch( Exception e )
                {
                    throw new Exception( "El valor de precio debe ser num�rico: " + valores[ 3 ] );
                }
                marca = buscarMarca( sMarca );
                if( marca == null )
                {
                    marca = new Marca( sMarca );
                    adicionarMarca( marca );
                }
                linea = marca.buscarLinea( sLinea );
                if( linea == null )
                {
                    linea = new Linea( sLinea );
                    marca.adicionarLinea( linea );
                }
                modelo = linea.buscarModelo( sModelo );
                if( modelo == null )
                {
                    modelo = new Modelo( sModelo, precio );
                    linea.adicionarModelo( modelo );
                }
            }
            try
            {
                texto = lector.readLine( );
            }
            catch( Exception e )
            {
                throw new Exception( "Error al cargar los datos almacenados de veh�culos" );
            }
        }
    }
    private void cargarTablaImpuestos( String archivo ) throws Exception
    {
        Properties datos = new Properties( );
        int rangos = 0;
        String texto, valores[];
        double inicio, fin, porcentaje;
        RangoImpuesto rango;
        try
        {
            FileInputStream input = new FileInputStream( archivo );
            datos.load( input );
        }
        catch( Exception e )
        {
            throw new Exception( "Error al cargar los rangos de impuestos" );
        }

        try
        {
            rangos = Integer.parseInt( datos.getProperty( "numero.rangos" ) );
        }
        catch( Exception e )
        {
            throw new Exception( "El n�mero de rangos de impuestos es inv�lido" );
        }

        for( int i = 1; i <= rangos; i++ )
        {
            texto = datos.getProperty( "rango" + i );
            if( texto == null )
                throw new Exception( "Falta la definici�n de rango" + i );
            valores = texto.split( "," );
            try
            {
                inicio = Double.parseDouble( valores[ 0 ] );
                fin = Double.parseDouble( valores[ 1 ] );
                porcentaje = Double.parseDouble( valores[ 2 ] );
            }
            catch( Exception e )
            {
                throw new Exception( "Error en la definici�n de rango" + i );
            }

            rango = new RangoImpuesto( inicio, fin, porcentaje );
            rangosImpuesto.ensureCapacity( 1 );
            rangosImpuesto.add( i - 1, rango );
        }
    }
    private RangoImpuesto buscarRangoImpuesto( double valor )
    {
        RangoImpuesto rango = null;
        for( int i = 0; i < rangosImpuesto.size( ) && rango == null; i++ )
        {
            RangoImpuesto rangoAux = ( RangoImpuesto )rangosImpuesto.get( i );
            if( rangoAux.contieneA( valor ) )
                rango = rangoAux;
        }
        return rango;
    }
    public double buscarAvaluoVehiculo( String unaMarca, String unaLinea, String unModelo ) throws Exception
    {
        Marca marca = buscarMarca( unaMarca );
        if( marca == null )
            throw new Exception( "La marca " + unaMarca + " no est� registrada" );
        Linea linea = marca.buscarLinea( unaLinea );
        if( linea == null )
            throw new Exception( "La l�nea " + unaLinea + " no est� registrada" );
        Modelo modelo = linea.buscarModelo( unModelo );
        if( modelo == null )
            throw new Exception( "El modelo " + unModelo + " no est� registrado" );
        return modelo.darPrecio( );
    }
    public double calcularPago( String unaMarca, String unaLinea, String unModelo, boolean descProntoPago, boolean descServicioPublico, boolean descTrasladoCuenta ) throws Exception
    {
        double pago = 0.0;
        double precio = buscarAvaluoVehiculo( unaMarca, unaLinea, unModelo );
        RangoImpuesto rango = buscarRangoImpuesto( precio );
        if( rango != null )
            pago = precio * ( rango.darPorcentaje( ) / 100.0 );
        if( descProntoPago )
            pago -= pago * ( PORC_DESC_PRONTO_PAGO / 100 );
        if( descServicioPublico )
            pago -= VALOR_DESC_SERVICIO_PUBLICO;
        if( descTrasladoCuenta )
            pago -= pago * ( PORC_DESC_TRASLADO_CUENTA / 100 );
        if( pago < 0 )
            pago = 0;
        return pago;
    }
    public String metodo1( )
    {
        return "Respuesta 1";
    }
    public String metodo2( )
    {
        return "Respuesta 2";
    }
}