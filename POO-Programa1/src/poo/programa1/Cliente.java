/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import java.util.ArrayList;

/**
 *
 * @author Orlando José Hidalgo Ramírez - 2016106829
 */
public class Cliente 
{
    private String nombre;
    private String correo;
    private String celular;
    private ArrayList<Provincia> provincia;
    private boolean notificarCorreo;
    private boolean notificarCelular;

    public Cliente() {
    }

    public Cliente(String nombre, ArrayList<Provincia> provincia) 
    {
        this.nombre = nombre;
        this.provincia = provincia;
        notificarCorreo = false;
        notificarCelular= false;
    }
/*
    public Cliente(String nombre, String correo, ArrayList<Provincia> provincia) 
    {
        this.nombre = nombre;
        this.correo = correo;
        this.provincia = provincia;
        notificarCorreo = true;
        notificarCelular = false;
    }

    public Cliente(String nombre, String celular, ArrayList<Provincia> provincia) 
    {
        this.nombre = nombre;
        this.celular = celular;
        this.provincia = provincia;
        notificarCelular = true;
        notificarCorreo = false;
    }
 */ 
    public Cliente(String nombre, String correo, String celular, ArrayList<Provincia> provincia, boolean notificarCorreo, boolean notificarCelular) 
    {
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.provincia = provincia;
        this.notificarCorreo = notificarCorreo;
        this.notificarCelular = notificarCelular;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getCorreo() 
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    public String getCelular()
    {
        return celular;
    }

    public void setCelular(String celular) 
    {
        this.celular = celular;
    }
    
    public void agregarProvincia(Provincia provincia)
    {
        if ((this.provincia.contains(provincia))!=true)
            this.provincia.add(provincia);
    }

    public boolean isNotificarCorreo() 
    {
        return notificarCorreo;
    }

    public void setNotificarCorreo(boolean notificarCorreo) 
    {
        if (notificarCorreo)
            this.notificarCorreo = notificarCorreo;
        else if (isNotificarCelular())
            this.notificarCorreo = notificarCorreo;
        else
            this.notificarCorreo = true;
    }

    public boolean isNotificarCelular()
    {
        return notificarCelular;
    }

    public void setNotificarCelular(boolean notificarCelular) 
    {
        if (notificarCelular)
            this.notificarCelular = notificarCelular;
        else if (isNotificarCorreo())
            this.notificarCelular = notificarCelular;
        else
        {
            notificarCorreo = true;
            this.notificarCelular = false;
        }
    }
    
}
