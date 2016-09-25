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

    public ArrayList<Cliente> getListaClientes() 
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
            fechas[contador] = sismo.getFecha2();
        }
        return fechas;
    }
    
}
