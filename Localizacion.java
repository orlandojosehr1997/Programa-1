/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

/**
 *
 * @author orlandojose
 */
public class Localizacion 
{
    private double latitud;
    private double longitud;
    private String descripcion;
    private Provincia provincia;

    public Localizacion() 
    {
        provincia = Provincia.SinAsignar;
    }

    public Localizacion(double latitud, double longitud, Provincia provincia)
    {
        this.latitud = latitud;
        this.longitud = longitud;
        this.provincia = provincia;
    }

    public Localizacion(double latitud, double longitud, String descripcion, Provincia provincia) 
    {
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.provincia = provincia;
    }

    public double getLatitud() 
    {
        return latitud;
    }

    public void setLatitud(double latitud) 
    {
        this.latitud = latitud;
    }

    public double getLongitud() 
    {
        return longitud;
    }

    public void setLongitud(double longitud) 
    {
        this.longitud = longitud;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() 
    {
        return provincia;
    }

    public void setProvincia(Provincia provincia) 
    {
        this.provincia = provincia;
    }
}
