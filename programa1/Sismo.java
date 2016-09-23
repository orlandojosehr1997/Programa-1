/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author orlandojose
 */
public class Sismo 
{
    /*private int dia;
    private int mes;
    private int año;
    private int horas;
    private int minutos;
    private int segundos;
    private Date fecha;
    private float kilometros;
    private Origen origen;
    private float magnitud;
    private Localizacion localizacion;
    private String valorMagnitud;*/
    
    private Date fecha;
    private String profundidad;
    private Origen origen;
    private String magnitud;
    private String latitud;
    private String longitud;
    private String descripcion;
    private Provincia provincia;
    //private String valorMagnitud;
    
    /*public Sismo(int dia, int mes, int año, int horas, int minutos, int segundos, float kilometros, Origen origen, float magnitud, Localizacion localizacion, String valorMagnitud) {
        setFecha(dia,mes,año,horas,minutos,segundos);
        this.kilometros = kilometros;
        this.origen = origen;
        this.magnitud = magnitud;
        this.localizacion = localizacion;
        this.valorMagnitud = valorMagnitud;
    }*/
    public Sismo(String convertirFecha, String profundidad, Origen origen, String magnitud, String latitud, String longitud, String descripcion, Provincia provincia) {
        String formatoFecha = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
        try 
        {
          Date fecha = format.parse(convertirFecha);
        } 
        catch (ParseException e) 
        {
          e.printStackTrace();
        }
        // formatting
        //System.out.println(format.format(new Date()));
        
        this.profundidad = profundidad;
        this.origen = origen;
        this.magnitud = magnitud;
        //this.localizacion = localizacion;
        //this.valorMagnitud = valorMagnitud;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.provincia = provincia;
    }
    /*public String getFecha()
    {
        return dia + "/" + mes + "/" + año + " " + horas + ":" + minutos + ":" + segundos;
    }
    public void setFecha(int dia, int mes, int año, int horas, int minutos, int segundos) 
    {
        if(dia>0 && dia<=31 && mes<=31 && mes>0 && horas>0 && minutos>0 && segundos>0)
        {
            switch(mes)
            {
                case 2:
                    if(dia<=28)
                        this.dia = dia;
                    else if(año%4 == 0 && dia == 29)
                        this.dia = dia;
                    else
                        System.out.println("Error: Dia no existe");
                    break;
                case 4:
                    if (dia<=30)
                        this.dia = dia;
                    else 
                        System.out.println("Error: Dia no existe");
                    break;
                case 6:
                    if (dia<=30)
                        this.dia = dia;
                    else 
                        System.out.println("Error: Dia no existe");
                    break;
                case 9:
                    if (dia<=30)
                        this.dia = dia;
                    else 
                        System.out.println("Error: Dia no existe");
                    break;
                case 11:
                    if (dia<=30)
                        this.dia = dia;
                    else 
                        System.out.println("Error: Dia no existe");
                    break;
                default:
                    this.dia = dia;
                    break;
            }
            this.mes = mes;
            this.año = año;
            if (horas<=24 && minutos<=60 && segundos<=60)
            {
                this.horas = horas;
                this.minutos = minutos;
                this.segundos = segundos;
            }
        }
    }

    public int getDia() 
    {
        return dia;
    }

    public void setDia(int dia) 
    {
        this.dia = dia;
    }

    public int getMes() 
    {
        return mes;
    }

    public void setMes(int mes) 
    {
        this.mes = mes;
    }

    public int getAño() 
    {
        return año;
    }

    public void setAño(int año) 
    {
        this.año = año;
    }

    public int getHoras() 
    {
        return horas;
    }

    public void setHoras(int horas) 
    {
        this.horas = horas;
    }

    public int getMinutos() 
    {
        return minutos;
    }

    public void setMinutos(int minutos) 
    {
        this.minutos = minutos;
    }

    public int getSegundos() 
    {
        return segundos;
    }

    public void setSegundos(int segundos) 
    {
        this.segundos = segundos;
    }
*/
    /*
    public float getKilometros() 
    {
        return kilometros;
    }

    public void setKilometros(float kilometros) 
    {
        this.kilometros = kilometros;
    }

    public Origen getOrigen() 
    {
        return origen;
    }

    public void setOrigen(Origen origen) 
    {
        this.origen = origen;
    }

    public float getMagnitud() 
    {
        return magnitud;
    }

    public void setMagnitud(float magnitud) 
    {
        this.magnitud = magnitud;
    }
*/

    public String getFecha() {
        return fecha.toString();
    }

    public void setFecha(String fecha) {
        String formatoFecha = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
        try 
        {
          this.fecha = format.parse(fecha);
        } 
        catch (ParseException e) 
        {
          e.printStackTrace();
        }
    }

    public String getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
    }
    /*
    public Localizacion getLocalizacion() 
    {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) 
    {
        this.localizacion = localizacion;
    }

    public String getValorMagnitud() 
    {
        return valorMagnitud;
    }

    public void setValorMagnitud(String valorMagnitud) 
    {
        this.valorMagnitud = valorMagnitud;
    }
    */

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
}
