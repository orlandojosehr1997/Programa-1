/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.programa1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Orlando José Hidalgo Ramírez - 2016106829
 * @author Alejandro Tapia Barboza - 2016167784
 * @author Francisco Loaiza Vallejos - 2016123417
 */
public class Listas 
{
    private static ArrayList<Sismo> listaSismos = new ArrayList<>();;
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();;

    public Listas() 
    {
    }

    public static ArrayList<Sismo> getListaSismos() 
    {
        return listaSismos;
    }

    public static ArrayList<Cliente> getListaClientes() 
    {
        return listaClientes;
    }
    
    public static void agregarSismo(Sismo sismo)
    {
        listaSismos.add(sismo);
    }
    public static void agregarCliente(Cliente cliente)
    {
        listaClientes.add(cliente);
    }
    public static String[] getFechas()
    {
        String fechas[] = new String[listaSismos.size()];
        int contador = 0;
        for (Sismo sismo : listaSismos) 
        {
            fechas[contador++] = sismo.getFecha2();
        }
        return fechas;
    }
    
    public static int getCantidadSismos(Provincia provincia)
    {
        int contador = 0;
        for (Sismo sismo : listaSismos) 
        {
            if (sismo.getProvincia().equals(provincia))
                contador++;
        }
        return contador;
    }
    public static int getCantidadSismos(Origen origen)
    {
        int contador = 0;
        for (Sismo sismo : listaSismos) 
        {
            if (sismo.getOrigen().equals(origen))
                contador++;
        }
        return contador;
    }
    public static int getCantidadSismos(String valorMagnitud)
    {
        int contador = 0;
        for (Sismo sismo : listaSismos) 
        {
            if (sismo.getValorMagnitud().compareTo(valorMagnitud)==0)
                contador++;
        }
        return contador;
    }
    public static int getCantidadSismos(int mes)
    {
        int contador = 0;
        for (Sismo sismo : listaSismos) 
        {
            Date fecha = sismo.getFechaDate();
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);
            int Mes = calendario.get(Calendar.MONTH);
            if (Mes == mes)
                contador++;
        }
        return contador;
    }
}
