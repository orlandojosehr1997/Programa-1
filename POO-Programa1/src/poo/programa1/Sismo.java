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
 * La clase Sismo representa un sismo con los siguientes atributos:
 * <ul>
 *  <li>Fecha</li>
 *  <li>Profundidad</li>
 *  <li>Tipo de Origen</li>
 *  <li>Magnitud</li>
 *  <li>Valor de Magnitud</li>
 *  <li>Provincia</li>
 *  <li>Descripción exacta del epicentro</li>
 *  <li>Latitud</li>
 *  <li>Longitud</li>
 * </ul>
 * @author Orlando José Hidalgo Ramírez - 2016106829
 * @author Alejandro Tapia Barboza - 2016167784
 * @author Francisco Loaiza Vallejos - 2016123417
 * @version 1.2
 */
public class Sismo 
{
    private Date fecha;
    private String profundidad;
    private Origen origen;
    private String magnitud;
    private String latitud;
    private String longitud;
    private String descripcion;
    private Provincia provincia;
    private String valorMagnitud;
    /**
     * Metodo Constructor. Crea un objeto de la clase Sismo. 
     * @param convertirFecha - En formato dd/MM/yyyy HH:mm:ss.
     * @param magnitud
     * @param profundidad
     * @param origen
     * @param provincia
     * @param latitud
     * @param longitud
     * @param descripcion 
     * 
     */
    public Sismo(String convertirFecha, String magnitud, String profundidad, Origen origen, Provincia provincia, String latitud, String longitud, String descripcion) {
        String formatoFecha = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formatoFecha);
        try 
        {
            fecha = format.parse(convertirFecha);
        }
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        
        this.profundidad = profundidad;
        this.origen = origen;
        this.magnitud = magnitud;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.provincia = provincia;
        
        actualizarValorMagnitud();
    }
    /**
     * Este método es retorna un string que contiene la fecha en formato:
     * día_del_mes mes día hh:mm:ss zona_horaria año.
     * @return String - Fecha en formato dd/MM/yyyy HH:mm:ss
     * @see #getFecha2() 
     */
    public String getFecha() 
    {
        return fecha.toString();
    }
    /**
     * Este método es retorna un string que contiene la fecha en formato
     * dd/MM/yyyy HH:mm:ss.
     * @return String - Fecha en formato dd/MM/yyyy HH:mm:ss
     * @see #getFecha() 
     */
    public String getFecha2()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaFormatoNuevo = formatter.format(fecha);
        return fechaFormatoNuevo;
    }
    /**
     * Este método recibe una fecha en formato dd/MM/yyyy HH:mm:ss, y la cambia
     * a ser un dato de tipo Date.
     * 
     * @param fecha String - Fecha en formato dd/MM/yyyy HH:mm:ss
     */
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
    public Date getFechaDate()
    {
        return fecha;
    }
    /**
     * Getter. Retorna la profundidad del sismo.
     * @return String - Profundidad del sismo.
     */
    public String getProfundidad() {
        return profundidad;
    }
    /**
     * Setter. Cambia la profundidad del sismo a la indicada en el parámetro.
     * @param profundidad String - Profundidad nueva en kilómetros.
     */
    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }
    /**
     * Getter. Retorna el origen del sismo, como un tipo de la clase Origen.
     * @return Origen - Origen del sismo, como elemento de la clase enum Origen.
     */
    public Origen getOrigen() {
        return origen;
    }
    /**
     * ToString. Retorna el origen del sismo como string, para poder imprimiro con mayor facilidad.
     * @return String - Origen del sismo.
     */
    public String getOrigenStr(){
        return "" + origen;
    }
    /**
     * Setter. Cambia el origen del sismo al indicado en el parámetro.
     * @param origen Origen - Recibe el nuevo origen de tipo Origen (que es una clase enum en el codigo)
     */
    public void setOrigen(Origen origen) {
        this.origen = origen;
    }
    /**
     * Getter. Retorna la magnitud del sismo.
     * @return String - Magnitud del sismo.
     */
    public String getMagnitud() {
        return magnitud;
    }
    /**
     * Setter. Cambia la magnitud del sismo a la indicada en el parametro. 
     * Además utiliza el método actualizarValorMagnitud() para actualizar el valor de
     * la magnitud del sismo.
     * @param magnitud String - Recibe la nueva magnitud del sismo.
     * @see #actualizarValorMagnitud() 
     */
    public void setMagnitud(String magnitud) {
        this.magnitud = magnitud;
        actualizarValorMagnitud();
    }
    /**
     * Gettet. Retorna el valor de la magnitud del sismo.
     * @return String - Valor de la magnitud del sismo (Micro, Menor, Ligero, Moderado, Fuerte, Mayor, Gran,Épico).
     */
    public String getValorMagnitud() 
    {
        return valorMagnitud;
    }
    /**
     * Setter. Este método actua como un setter, pero en vez de permitirle al usuario 
     * determinar el valor, lo determina con rangos de la magnitud. 
     * <p>
     * Los rangos son: 
     * <ul>
     *  <li>Micro</li>
     *  <li>Ligero</li>
     *  <li>Moderado</li>
     *  <li>Fuerte</li>
     *  <li>Mayor</li>
     *  <li>Gran</li>
     *  <li>Épico</li>
     * </ul>
     */
    public void actualizarValorMagnitud() 
    {
        float mag = Float.parseFloat(magnitud);
        if (mag<2)
            valorMagnitud = "Micro";
        else if (mag<4)
            valorMagnitud = "Menor";
        else if (mag<5)
            valorMagnitud = "Ligero";
        else if (mag<6)
            valorMagnitud = "Moderado";
        else if (mag<7)
            valorMagnitud = "Fuerte";
        else if (mag<8)
            valorMagnitud = "Mayor";
        else if (mag<10)
            valorMagnitud = "Gran";
        else
            valorMagnitud = "Épico";
    }
    /**
     * Getter. Retorna la latitud del epicentro el sismo.
     * @return String - Latitud del epicentro del sismo.
     */
    public String getLatitud() {
        return latitud;
    }
    /**
     * Setter. Cambia la latitud del epicentro a la indicada en el parámetro.
     * @param latitud String - Latitud del epicentro.
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    /**
     * Getter. Retorna la longitud del epicentro el sismo.
     * @return String - Longitud del epicentro del sismo.
     */
    public String getLongitud() {
        return longitud;
    }
    /**
     * Setter. Cambia la longitud del epicentro a la indicada en el parámetro.
     * @param longitud String - Longitudo del epicentro del sismo.
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    /**
     * Getter. Retorna la descripción detallada del epicentro dada para este sismo.
     * @return String - Descripción del sismo.
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Setter. Cambia la descripción detallada del epicentro del sismo a la indicada en el parametro.
     * @param descripcion String - Descripción del sismo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Getter. Retorna la Provincia en la que ocurrió el epicentro del sismo.
     * @return Provincia - Provincia como elemento de la clase enum Provincia.
     */
    public Provincia getProvincia() {
        return provincia;
    }
    /**
     * ToString. Retorna un string de la Provincia en la que ocurrió el sismo.
     * @return String - Provincia en la que ocurrió el sismo. 
     */
    public String getProvinciaStr() {
        return "" + provincia;
    }
    /**
     * Setter. Cambia la provincia en donde se ocurrió el sismo.
     * @param provincia Provincia - Provincia en la que ocurrió el sismo, como elemento de la clase enum Provincia.
     */
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    /**
     * ToString. Sobreescritura. Retorna todos los argumentos de la clase Sismo como un String.
     * @return String - Todos los argumentos del objeto que pertenece a la clase Sismo.
     */
    @Override
    public String toString() {
        return "Sismo{" + "fecha=" + fecha + ", profundidad=" + profundidad + ", origen=" + origen + ", magnitud=" + magnitud + ", latitud=" + latitud + ", longitud=" + longitud + ", descripcion=" + descripcion + ", provincia=" + provincia + '}';
    }
    
}
