/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import java.util.ArrayList;

/**
 *
 * @author orlandojose
 */
public class Cliente 
{
    private String nombre;
    private String correo;
    private int celular;
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

    public Cliente(String nombre, String correo, ArrayList<Provincia> provincia) 
    {
        this.nombre = nombre;
        this.correo = correo;
        this.provincia = provincia;
        notificarCorreo = true;
        notificarCelular = false;
    }

    public Cliente(String nombre, int celular, ArrayList<Provincia> provincia) {
        this.nombre = nombre;
        this.celular = celular;
        this.provincia = provincia;
        notificarCelular = true;
        notificarCorreo = false;
    }
    
    public Cliente(String nombre, String correo, int celular, ArrayList<Provincia> provincia, boolean notificarCorreo, boolean notificarCelular) 
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

    public int getCelular()
    {
        return celular;
    }

    public void setCelular(int celular) 
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
        if (notificarCorreo==true)
            this.notificarCorreo = notificarCorreo;
        else if (isNotificarCelular()==true)
            this.notificarCorreo = notificarCorreo;
    }

    public boolean isNotificarCelular()
    {
        return notificarCelular;
    }

    public void setNotificarCelular(boolean notificarCelular) 
    {
        if (notificarCelular==true)
            this.notificarCelular = notificarCelular;
        else if (isNotificarCorreo()==true)
            this.notificarCelular = notificarCelular;
    }
    
}
