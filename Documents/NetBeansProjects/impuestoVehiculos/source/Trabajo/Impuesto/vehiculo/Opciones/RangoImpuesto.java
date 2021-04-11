
package Trabajo.Impuesto.vehiculo.Opciones;

public class RangoImpuesto
{
    private double inicio;
    private double fin;
    private double porcentaje;

    public RangoImpuesto( double unInicio, double unFin, double unPorcentaje )
    {
        inicio = unInicio;
        fin = unFin;
        porcentaje = unPorcentaje;
    }
    public boolean contieneA( double valor )
    {
        return ( valor >= inicio && valor < fin );
    }
    public double darPorcentaje( )
    {
        return porcentaje;
    }
}