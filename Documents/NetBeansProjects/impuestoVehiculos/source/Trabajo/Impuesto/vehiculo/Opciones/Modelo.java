
package Trabajo.Impuesto.vehiculo.Opciones;

public class Modelo
{
    private String anio;
    private double precio;
    public Modelo( String elAnio, double elPrecio )
    {
        anio = elAnio;
        precio = elPrecio;
    }
    public String darAnio( )
    {
        return anio;
    }
    public double darPrecio( )
    {
        return precio;
    }
}